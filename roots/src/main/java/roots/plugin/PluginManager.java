package roots.plugin;

import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import org.hibernate.Query;

import roots.core.gui.GUICMain;
import roots.entities.Repinfo;
import roots.translation.ITranslation.enum_language;

public class PluginManager implements IPluginManager
{
	private GUICMain guimaincontroller;

	public PluginManager(GUICMain p_guimaincontroller)
	{
		this.guimaincontroller = p_guimaincontroller;
	}

	@Override
	public void startProgram(JPanel p_panel, ImageIcon p_ico, boolean p_selected, boolean p_closeable, IPlugin p_iplugin)
	{
		this.guimaincontroller.startProgram(p_panel, p_ico, p_selected, p_closeable, p_iplugin);
	}

	@Override
	public void closeProgram(JPanel p_panel)
	{
		this.guimaincontroller.closeProgram(p_panel);
	}

	@Override
	public void setMenu(JMenu p_menu, menuposition p_menupos)
	{
		this.guimaincontroller.setMenu(p_menu, p_menupos);
	}

	@Override
	public void setMenuItem(JMenuItem p_menuitem, menuposition p_menupos)
	{
		this.guimaincontroller.setMenuItem(p_menuitem, p_menupos);
	}

	@Override
	public void logError(String p_error)
	{
		this.guimaincontroller.logError(p_error);
	}

	@Override
	public void logInfo(String p_info)
	{
		this.guimaincontroller.logInfo(p_info);
	}

	@Override
	public void logStackTrace(StackTraceElement[] p_stacktrace)
	{
		this.guimaincontroller.logStackTrace(p_stacktrace);

	}

	@Override
	public void changeTitle(JPanel p_panel, String p_title)
	{
		this.guimaincontroller.changeTabTitle(p_panel, p_title);
	}

	@Override
	public enum_language getActualLanguage()
	{
		return this.guimaincontroller.getConfigEntity().getLanguage();
	}

	@Override
	public void saveOrUpdate(Object p_object)
	{
		this.guimaincontroller.getGuimainmodel().saveOrUpdate(p_object);
	}

	@Override
	public Repinfo getRepositoryInfo()
	{
		return this.guimaincontroller.getGuimainmodel().getRepinfo();
	}

	@Override
	public void beginTransaction()
	{
		this.guimaincontroller.getGuimainmodel().beginTransaction();

	}

	@Override
	public void commitTransaction()
	{
		this.guimaincontroller.getGuimainmodel().commitTransaction();

	}

	@Override
	public Query createQuery(String p_query)
	{
		return this.guimaincontroller.createQuery(p_query);
	}

	@Override
	public void refreshMainFrame()
	{
		this.guimaincontroller.refreshMainFrame();

	}

	@Override
	public String getForfedreTitle()
	{
		return this.guimaincontroller.getConfigEntity().getForfedreTitle();
	}

	@Override
	public String getForfedreVersion()
	{
		return this.guimaincontroller.getConfigEntity().getForfedreVersion();
	}

	@Override
	public void startProgramInExternalWindow(JPanel p_panel)
	{
		this.guimaincontroller.startProgramInExternalWindow(p_panel);
	}
}
