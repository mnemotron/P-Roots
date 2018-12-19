package roots.core.gui;

import java.awt.Dialog;
import java.io.IOException;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import org.apache.log4j.lf5.viewer.LogBrokerMonitor;
import org.hibernate.Query;
import roots.entities.Repinfo;

import roots.config.ConfigEntity;
import roots.core.SystemResourceIcons;
import roots.core.hibernate.CHibernate;
import roots.logger.CLog;
import roots.plugin.plugin.IPlugin;
import roots.plugin.plugin.IPluginManager;
import roots.plugin.translation.ITranslation;

public class GUICMain implements ITranslation
{

	private GUIMain guimain;

	private GUIMMain guimainmodel;
	private GUICRepositoryLogin guireplogincontroller;

	public GUICMain() throws Exception
	{
		// build model
		this.guimainmodel = new GUIMMain(GUIMMain.dbconnectionstatus.INIT, this);

		// init GUI
		this.guimain = new GUIMain(this);

		// set GUI title, language
		this.guimain.getMain_frame().setTitle(guimainmodel.getConfigcontroller().getConfigentity().getForfedreVersionTitle());
		this.guimain.select_Language(guimainmodel.getConfigcontroller().getConfigentity().getLanguage());

		// load plugins
		try
		{
			// internal plugins
			this.guimainmodel.loadInternalPlugins();

			// external plugins
			this.guimainmodel.loadExternalPlugins();
		} catch (Exception e)
		{
			this.logStackTrace(e.getStackTrace());
		}

		// open login program
		this.openGUIRepositoryLogin(false, false);

		guimainmodel.getTranslationlistener().setLanguage(guimainmodel.getConfigcontroller().getConfigentity().getLanguage());

		guimainmodel.getTranslationlistener().addTranslationListener(this);
		guimainmodel.getTranslationlistener().addTranslationListener(guimainmodel.getPlugincontroller());

		this.runTranslationListener();

		setStatusInit();

		this.startGUI();
	}

	private void runTranslationListener()
	{
		guimainmodel.getTranslationlistener().runTranslationListener();
	}

	private void setStatusInit()
	{
		guimain.getMenu_programs().setEnabled(false);
		guimain.getMenu_repository().setEnabled(false);
	}

	private void setStatusRepositoryChoosed()
	{
		guimain.getMenu_programs().setEnabled(true);
		guimain.getMenu_repository().setEnabled(true);
	}

	public void setLanguage(ITranslation.enum_language p_language)
	{
		guimainmodel.setLanguage(p_language);
	}

	public void startGUI()
	{
		this.guimain.getMain_frame().setVisible(true);
		// this.guimain.getMain_frame().pack();
	}

	public void stopGUI()
	{
		this.guimainmodel.disconnectDatabase();

		this.guimain.getMain_frame().setVisible(false);
		System.exit(0);
	}

	public void dbConnectionFailure()
	{
		this.guimain.getLbl_repository_status().setIcon(new ImageIcon(GUICMain.class.getResource(SystemResourceIcons.ICON_REPO_DB_STATUS_RED)));

		guireplogincontroller.dbConnectionFailure();
	}

	public void dbConnected(List<Repinfo> p_replist)
	{
		guireplogincontroller.dbConnected(p_replist);

		this.guimain.getLbl_repository_status().setIcon(new ImageIcon(GUICMain.class.getResource(SystemResourceIcons.ICON_REPO_DB_STATUS_GREEN)));
	}

	public void disconnectDatabase()
	{
		guimainmodel.disconnectDatabase();

		guimain.getLbl_repository_status().setIcon(new ImageIcon(GUICMain.class.getResource(SystemResourceIcons.ICON_REPO_DB_STATUS_NATIVE)));
	}

	public void loginDatabase(CHibernate.databases p_database, String p_dblocation, String p_dbname, String p_username, String p_password, boolean p_keeppassword)
	{
		guimain.getLbl_repository_status().setIcon(new ImageIcon(GUICMain.class.getResource(SystemResourceIcons.ICON_REPO_DB_STATUS_YELLOW)));

		guimainmodel.loginDatabase(p_database, p_dblocation, p_dbname, p_username, p_password, p_keeppassword);
	}

	public void startProgramInExternalWindow(JPanel p_panel)
	{
		JDialog jdialog = new JDialog(this.guimain.getMain_frame(), Dialog.ModalityType.APPLICATION_MODAL);
		jdialog.setContentPane(p_panel);
		jdialog.setResizable(true);
		jdialog.pack();
		jdialog.setVisible(true);

		// this.guimain.getMain_frame().setEnabled(false);
		//
		// JFrame jframe= new JFrame();
		// jframe.setContentPane(p_panel);
		// jframe.setResizable(true);
		// jframe.pack();
		// jframe.setVisible(true);
	}

	public void startProgram(JPanel p_panel, ImageIcon p_ico, boolean p_selected, boolean p_closeable, IPlugin p_iplugin)
	{
		guimain.addJTabProgram(p_panel, p_ico, p_selected, p_closeable, p_iplugin);
	}

	public void closeProgram(JPanel p_panel)
	{
		guimain.removeTabProgram(p_panel);
	}

	public void closeProgram(JPanel p_panel, IPlugin p_iplugin)
	{
		this.closeProgram(p_panel);

		if (p_iplugin != null)
		{
			this.guimainmodel.fireProgramClosed(p_iplugin);
		}
	}

	@Override
	public void do_translation(enum_language p_language)
	{
		try
		{
			this.guimain.do_translation(p_language);
		} catch (IOException e)
		{
			this.logStackTrace(e.getStackTrace());
			this.logError(e.getMessage());
		}
	}

	public ConfigEntity getConfigEntity()
	{
		return guimainmodel.getConfigEntity();
	}

	public GUIMMain.dbconnectionstatus getdbConnectionStatus()
	{
		return guimainmodel.getDbconstatus();
	}

	public void createRepository(String p_repname, String p_description, String p_creator)
	{
		guimainmodel.createRepository(p_repname, p_description, p_creator);

		setStatusRepositoryChoosed();
	}

	public void chooseRepository(Repinfo p_repinfo)
	{
		guimainmodel.chooseRepository(p_repinfo);

		setStatusRepositoryChoosed();
	}

	public void changeTabTitle(JPanel p_panel, String p_title)
	{
		guimain.changeTabTitle(p_panel, p_title);
	}

	protected void showLogScreen()
	{
		Runnable run = new Runnable()
		{
			public void run()
			{
				LogBrokerMonitor lbm = CLog.getLogbrokermonitor();
				lbm.show();
			}
		};

		Thread t = new Thread(run);
		t.run();
	}

	public void setMenu(JMenu p_menu, IPluginManager.menuposition p_menupos)
	{
		switch (p_menupos)
		{
			case PROGRAMS:
				this.guimain.addJMenuPrograms(p_menu);
				break;
			case PROGRAMS_EDIT:
				this.guimain.addJMenuProgramsEdit(p_menu);
				break;
			case REPOSITORY_IMPORT:
				this.guimain.addJMenuImport(p_menu);
				break;
			case REPOSITORY_EXPORT:
				this.guimain.addJMenuExport(p_menu);
				break;
		}
	}

	public void setMenuItem(JMenuItem p_menuitem, IPluginManager.menuposition p_menupos)
	{
		switch (p_menupos)
		{
			case INFO:
				this.guimain.addJMenuItemInfo(p_menuitem);
				break;
			case PROGRAMS:
				this.guimain.addJMenuItemPrograms(p_menuitem);
				break;
			case PROGRAMS_EDIT:
				this.guimain.addJMenuItemProgramsEdit(p_menuitem);
				break;
			case REPOSITORY_IMPORT:
				this.guimain.addJMenuItemImport(p_menuitem);
				break;
			case REPOSITORY_EXPORT:
				this.guimain.addJMenuItemExport(p_menuitem);
				break;
			case ROOTS:
				this.guimain.addJMenuItemRoots(p_menuitem);
				break;
		}
	}

	public void logError(String p_error)
	{
		CLog.error(p_error);
	}

	public void logInfo(String p_info)
	{
		CLog.info(p_info);
	}

	public void logStackTrace(StackTraceElement[] p_stacktrace)
	{
		CLog.printStackTrace(p_stacktrace);
	}

	public GUIMMain getGuimainmodel()
	{
		return guimainmodel;
	}

	public Query createQuery(String p_query)
	{
		return this.guimainmodel.createQuery(p_query);
	}

	public void refreshMainFrame()
	{
		this.guimain.getMain_frame().repaint();
	}

	public void openGUIRepositoryLogin(boolean p_runtranslation, boolean p_closeable)
	{
		this.guireplogincontroller = new GUICRepositoryLogin(this);
		guimainmodel.getTranslationlistener().addTranslationListener(guireplogincontroller);
		startProgram(this.guireplogincontroller.getProgram(), new ImageIcon(), true, p_closeable, null);

		if (p_runtranslation)
		{
			this.runTranslationListener();
		}
	}

	public void closeGUIRepositoryLogin()
	{
		closeProgram(guireplogincontroller.getProgram());
		guimainmodel.getTranslationlistener().removeTranslationListener(guireplogincontroller);
		guireplogincontroller = null;
	}
}
