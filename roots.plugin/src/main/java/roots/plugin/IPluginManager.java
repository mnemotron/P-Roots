package roots.plugin;

import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import org.hibernate.Query;
import roots.entities.Repinfo;

import roots.translation.ITranslation;

public interface IPluginManager
{
	public static enum menuposition
	{
		INFO,
		PROGRAMS,
		PROGRAMS_EDIT,
		REPOSITORY_IMPORT,
		REPOSITORY_EXPORT
	}
	
	public void startProgram(JPanel p_panel, ImageIcon p_ico, boolean p_selected, boolean p_closeable, IPlugin p_iplugin);
	public void startProgramInExternalWindow(JPanel p_panel);
	public void closeProgram(JPanel p_panel);
	public void setMenu(JMenu p_menu, menuposition p_menupos);
	public void setMenuItem(JMenuItem p_menuitem, menuposition p_menupos);
	public void changeTitle(JPanel p_panel, String p_title);
	public void refreshMainFrame();

// Repository Handling
	public Repinfo getRepositoryInfo();
	public void beginTransaction();
	public void commitTransaction();
	public void saveOrUpdate(Object p_object);
	public Query createQuery(String p_query);
	
// Configuration Data
	public ITranslation.enum_language getActualLanguage();
	public String getForfedreTitle();
	public String getForfedreVersion();
	
// Error Handling
	public void logError(String p_error);
	public void logInfo(String p_info);
	public void logStackTrace(StackTraceElement[] p_stacktrace);

}
