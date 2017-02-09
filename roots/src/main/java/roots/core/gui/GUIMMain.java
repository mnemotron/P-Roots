package roots.core.gui;

import java.io.IOException;
import java.util.List;
import org.hibernate.Query;
import roots.entities.Repinfo;
import roots.config.CConfig;
import roots.config.ConfigEntity;
import roots.core.gui.GUICMain;
import roots.core.hibernate.CHibernate;
import roots.logger.CLog;
import roots.plugin.IPlugin;
import roots.plugin.CPlugin;
import roots.plugin.config.gui.CConfigPlugin;
import roots.translation.ITranslation;
import roots.translation.TranslationListener;

public class GUIMMain
{
    public static enum dbconnectionstatus
    {
	INIT, TRYTOCONNECT, FAILURE, CONNECTED
    }

    private GUIMMain.dbconnectionstatus dbconstatus;

    private GUICMain guimaincontroller;

    private TranslationListener translationlistener;
    private CConfig configcontroller;
    private CPlugin plugincontroller;
    private CHibernate hibernatecontroller;

    private Repinfo repinfo;

    public GUIMMain(GUIMMain.dbconnectionstatus p_dbconstatus, GUICMain p_guimaincontroller)
    {
	this.dbconstatus = p_dbconstatus;
	this.guimaincontroller = p_guimaincontroller;

	// -- read configuration
	try
	{
	    this.configcontroller = CConfig.getConfigControllerInstance();
	} catch (Exception e)
	{
	    this.guimaincontroller.logStackTrace(e.getStackTrace());
	}

	// -- init plugins
	this.plugincontroller = CPlugin.getPluginControllerInstance();

	// -- init translation with selected language
	this.translationlistener = TranslationListener.getTranslationControllerInstance();

	// set look and feel
	setGUILookAndFeel();

	// logging or not
	CLog.setLog(configcontroller.getConfigentity().isLog());
    }

    public void loadInternalPlugins() throws IOException
    {
	// configuration
	CConfigPlugin configplugincontroller = new CConfigPlugin();
	this.plugincontroller.loadPlugin(this.guimaincontroller, configplugincontroller);
    }

    public void loadExternalPlugins() throws IOException
    {
	this.plugincontroller.loadExternalPlugins(guimaincontroller);
    }

    public void fireProgramClosed(IPlugin p_iplugin)
    {
	this.plugincontroller.fireSingleClosed(p_iplugin);
    }

    private void dbConnectionFailure()
    {
	guimaincontroller.dbConnectionFailure();
    }

    private void dbConnected(CHibernate.databases p_database, String p_dblocation, String p_dbname,
	    String p_username, String p_password, boolean p_keeppassword)

    {
	// succesfully connected
	dbconstatus = GUIMMain.dbconnectionstatus.CONNECTED;

	// save dbconnection to config
	configcontroller.getConfigentity().setDatabase(p_database);
	configcontroller.getConfigentity().setDblocation(p_dblocation);
	configcontroller.getConfigentity().setDbname(p_dbname);
	configcontroller.getConfigentity().setKeeppassword(p_keeppassword);

	if (p_keeppassword)
	{
	    configcontroller.getConfigentity().setDbusername(p_username);
	    configcontroller.getConfigentity().setDbpassword(p_password);
	}

	try
	{
	    configcontroller.saveConfig();
	} catch (Exception e)
	{
	    this.guimaincontroller.logStackTrace(e.getStackTrace());
	}

	// select repositories

	// hibernatecontroller.openSession();
	hibernatecontroller.beginTransaction();
	Query query = hibernatecontroller.createQuery("from Repinfo");
	hibernatecontroller.commitTransaction();
	// hibernatecontroller.closeSession();

	List<?> list_repinfo = query.list();

	guimaincontroller.dbConnected(list_repinfo);
    }

    public void disconnectDatabase()
    {
	if (hibernatecontroller != null)
	{
	    dbconstatus = GUIMMain.dbconnectionstatus.INIT;

	    hibernatecontroller.closeSessionFactory();

	    hibernatecontroller = null;
	}
    }

    public void loginDatabase(final CHibernate.databases p_database, final String p_dblocation,
	    final String p_dbname, final String p_username, final String p_password, final boolean p_keeppassword)
    {
	dbconstatus = GUIMMain.dbconnectionstatus.TRYTOCONNECT;

	Runnable run = new Runnable()
	{
	    public void run()
	    {

		try
		{
		    hibernatecontroller = new CHibernate(p_database, p_dblocation, p_dbname, p_username,
			    p_password);

		    hibernatecontroller.buildSessionFactory();

		    hibernatecontroller.openSession();

		    hibernatecontroller.beginTransaction();

		    hibernatecontroller.commitTransaction();

		    // hibernatecontroller.closeSession();

		    dbConnected(p_database, p_dblocation, p_dbname, p_username, p_password, p_keeppassword);

		} catch (Exception e)
		{
		    hibernatecontroller = null;

		    // database connection failure
		    dbconstatus = GUIMMain.dbconnectionstatus.FAILURE;

		    // TODO failure log
		    CLog.printStackTrace(e.getStackTrace());
		    CLog.error(e.getMessage());

		    dbConnectionFailure();
		}
	    }
	};

	Thread t = new Thread(run);

	t.start();
    }

    public void setLanguage(ITranslation.enum_language p_language)
    {
	this.configcontroller.getConfigentity().setLanguage(p_language);

	try
	{
	    this.configcontroller.saveConfig();
	} catch (Exception e)
	{
	    this.guimaincontroller.logStackTrace(e.getStackTrace());
	}

	this.translationlistener.setLanguage(p_language);
	this.translationlistener.runTranslationListener();
    }

    public GUIMMain.dbconnectionstatus getDbconstatus()
    {
	return dbconstatus;
    }

    public void setDbconstatus(GUIMMain.dbconnectionstatus dbconstatus)
    {
	this.dbconstatus = dbconstatus;
    }

    public GUICMain getGuimaincontroller()
    {
	return guimaincontroller;
    }

    public TranslationListener getTranslationlistener()
    {
	return translationlistener;
    }

    public CConfig getConfigcontroller()
    {
	return configcontroller;
    }

    public CPlugin getPlugincontroller()
    {
	return plugincontroller;
    }

    public CHibernate getHibernatecontroller()
    {
	return hibernatecontroller;
    }

    public ConfigEntity getConfigEntity()
    {
	return configcontroller.getConfigentity();
    }

    public boolean createRepository(String p_repname, String p_description, String p_creator)
    {
	repinfo = new Repinfo();

	repinfo.setRepname(p_repname);
	repinfo.setRepdescription(p_description);
	repinfo.setRepcreator(p_creator);
	repinfo.setRepversion(CHibernate.c_repository_version);
	repinfo.setRepcreationdate(roots.misc.DateTimeFormat.getCurrentDate());

	// hibernatecontroller.openSession();
	hibernatecontroller.beginTransaction();
	hibernatecontroller.saveOrUpdate(repinfo);
	hibernatecontroller.commitTransaction();
	// hibernatecontroller.closeSession();

	return true;
    }

    public boolean chooseRepository(Repinfo p_repinfo)
    {
	this.repinfo = p_repinfo;

	return true;
    }

    protected void setGUILookAndFeel()
    {
	if (configcontroller.getConfigentity().getLookandfeel() != null)
	{
	    GUILookAndFeel.setLookAndFeel(configcontroller.getConfigentity().getLookandfeel());
	}
    }

    public void saveOrUpdate(Object p_object)
    {
	this.hibernatecontroller.saveOrUpdate(p_object);
    }

    public void beginTransaction()
    {
	this.hibernatecontroller.beginTransaction();
    }

    public void commitTransaction()
    {
	this.hibernatecontroller.commitTransaction();
    }

    public Repinfo getRepinfo()
    {
	return repinfo;
    }

    public void setRepinfo(Repinfo repinfo)
    {
	this.repinfo = repinfo;
    }

    public Query createQuery(String p_query)
    {
	return this.hibernatecontroller.createQuery(p_query);
    }
}
