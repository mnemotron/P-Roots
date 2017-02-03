package roots.plugin.info.about.gui;

import javax.swing.JPanel;

import roots.plugin.IPluginManager;

public class GUIAboutModel
{
	private IPluginManager pluginmanager;

	public GUIAboutModel()
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
	
	public String getForfedreVersion()
	{
		return this.pluginmanager.getForfedreVersion();
	}
	
	public String getForfedreTitle()
	{
		return this.pluginmanager.getForfedreTitle();
	}
}
