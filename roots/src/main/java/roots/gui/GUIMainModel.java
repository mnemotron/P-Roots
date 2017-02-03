package roots.gui;

import java.io.IOException;
import java.util.List;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import org.hibernate.Query;
import roots.entities.Repinfo;

import roots.config.ConfigController;
import roots.config.ConfigEntity;
import roots.core.hibernate.HibernateController;
import roots.gui.GUIMainController;
import roots.logger.LogController;
import roots.plugin.IPlugin;
import roots.plugin.PluginController;
import roots.translation.ITranslation;
import roots.translation.TranslationListener;

public class GUIMainModel
{
	public static enum dbconnectionstatus
	{
		INIT, TRYTOCONNECT, FAILURE, CONNECTED
	}

	private GUIMainModel.dbconnectionstatus dbconstatus;

	private GUIMainController guimaincontroller;

	private TranslationListener translationlistener;
	private ConfigController configcontroller;
	private PluginController plugincontroller;
	private HibernateController hibernatecontroller;

	private Repinfo repinfo;

	public GUIMainModel(GUIMainModel.dbconnectionstatus p_dbconstatus, GUIMainController p_guimaincontroller)
	{
		this.dbconstatus = p_dbconstatus;
		this.guimaincontroller = p_guimaincontroller;

		// -- read configuration
		this.configcontroller = ConfigController.getConfigControllerInstance();

		// -- init plugins
		this.plugincontroller = PluginController.getPluginControllerInstance();

		// -- init translation with selected language
		this.translationlistener = TranslationListener.getTranslationControllerInstance();

		// set look and feel
		setGUILookAndFeel();

		// logging or not
		LogController.setLog(configcontroller.getConfigentity().isLog());
	}

	public void loadPlugins() throws IOException
	{
		this.plugincontroller.loadPlugins(guimaincontroller);
	}
	
	public void fireProgramClosed(IPlugin p_iplugin)
	{
		this.plugincontroller.fireSingleClosed(p_iplugin);
	}

	private void dbConnectionFailure()
	{
		guimaincontroller.dbConnectionFailure();
	}

	private void dbConnected(HibernateController.databases p_database, String p_dblocation, String p_dbname, String p_username, String p_password, boolean p_keeppassword)

	{
		// succesfully connected
		dbconstatus = GUIMainModel.dbconnectionstatus.CONNECTED;

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

		configcontroller.saveConfig();

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
			dbconstatus = GUIMainModel.dbconnectionstatus.INIT;

			hibernatecontroller.closeSessionFactory();

			hibernatecontroller = null;
		}
	}

	public void loginDatabase(final HibernateController.databases p_database, final String p_dblocation, final String p_dbname, final String p_username, final String p_password, final boolean p_keeppassword)
	{
		dbconstatus = GUIMainModel.dbconnectionstatus.TRYTOCONNECT;

		Runnable run = new Runnable()
		{
			public void run()
			{

				try
				{
					hibernatecontroller = new HibernateController(p_database, p_dblocation, p_dbname, p_username, p_password);

					hibernatecontroller.buildSessionFactory();

					hibernatecontroller.openSession();

					hibernatecontroller.beginTransaction();

					hibernatecontroller.commitTransaction();

					// hibernatecontroller.closeSession();

					dbConnected(p_database, p_dblocation, p_dbname, p_username, p_password, p_keeppassword);

				} catch (Exception e)
				{
					// database connection failure
					dbconstatus = GUIMainModel.dbconnectionstatus.FAILURE;

					// TODO failure log
					LogController.printStackTrace(e.getStackTrace());
					LogController.error(e.getMessage());

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
		this.configcontroller.saveConfig();
		this.translationlistener.setLanguage(p_language);
		this.translationlistener.runTranslationListener();
	}

	public GUIMainModel.dbconnectionstatus getDbconstatus()
	{
		return dbconstatus;
	}

	public void setDbconstatus(GUIMainModel.dbconnectionstatus dbconstatus)
	{
		this.dbconstatus = dbconstatus;
	}

	public GUIMainController getGuimaincontroller()
	{
		return guimaincontroller;
	}

	public TranslationListener getTranslationlistener()
	{
		return translationlistener;
	}

	public ConfigController getConfigcontroller()
	{
		return configcontroller;
	}

	public PluginController getPlugincontroller()
	{
		return plugincontroller;
	}

	public HibernateController getHibernatecontroller()
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
		repinfo.setRepversion(HibernateController.c_repository_version);
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
		// TODO LOOK AND FEEL
		try
		{

			UIManager.setLookAndFeel("com.pagosoft.plaf.PgsLookAndFeel");
			 
//			UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
//			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
//			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel");
//			UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
			
		} catch (ClassNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		if (configcontroller.getConfigentity().getLookandfeel() != null)
//		{
//			GUILookAndFeel.setLookAndFeel(configcontroller.getConfigentity().getLookandfeel());
//		}
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
