package roots.config;

import roots.plugin.IPluginManager;

public class GUIConfigModel
{
	private IPluginManager pluginmanager;
	
	public GUIConfigModel()
	{
		this.pluginmanager = null;
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
