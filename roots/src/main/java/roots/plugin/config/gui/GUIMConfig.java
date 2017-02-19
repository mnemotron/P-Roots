package roots.plugin.config.gui;

import javax.swing.JPanel;
import javax.swing.UIManager.LookAndFeelInfo;

import roots.config.CConfig;
import roots.core.gui.GUILookAndFeel;
import roots.plugin.IPluginManager;

public class GUIMConfig
{
	private IPluginManager pluginmanager;

	public GUIMConfig()
	{
		this.pluginmanager = null;
	}

	public void changeTabTitle(JPanel panel, String title)
	{
		this.pluginmanager.changeTitle(panel, title);
	}

	public IPluginManager getPluginmanager()
	{
		return pluginmanager;
	}

	public void setPluginmanager(IPluginManager pluginmanager)
	{
		this.pluginmanager = pluginmanager;
	}

	public String getDefaultLookAndFeelName()
	{
		return GUILookAndFeel.getDefaultLookAndFeelName();
	}

	public String getDefaultLookAndFeelClassName()
	{
		return GUILookAndFeel.getDefaultLookAndFeelClassName();
	}

	public LookAndFeelInfo[] getInstalledLookAndFeels()
	{
		return GUILookAndFeel.getInstalledLookAndFeels();
	}

	public void setLookAndFeel(String className)
	{
		GUILookAndFeel.setLookAndFeel(className);
	}

	public void saveConfigLookAndFeel(String className)
	{
		try
		{
			CConfig c = CConfig.getConfigControllerInstance();
			c.getConfigentity().setLookandfeel(className);
			c.saveConfig();

		} catch (Exception e)
		{
			this.pluginmanager.logStackTrace(e.getStackTrace());
			this.pluginmanager.logError(e.getMessage());
		}
	}

}
