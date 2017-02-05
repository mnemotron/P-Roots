package roots.plugin.config.gui;

import javax.swing.JPanel;

import roots.plugin.IPluginManager;

public class GUIConfigModel
{
	private IPluginManager pluginmanager;
	
	public GUIConfigModel()
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

}
