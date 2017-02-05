package roots.config.gui;

import javax.swing.ImageIcon;

import roots.config.GUIConfigModel;
import roots.plugin.IPlugin;
import roots.plugin.IPluginManager;

public class GUIConfigController
{
	private GUIConfig guiconfig;
	private GUIConfigModel guiconfigmodel;

	public GUIConfigController(IPluginManager p_pluginmanager, IPlugin p_iplugin)
	{
		this.guiconfigmodel = new GUIConfigModel();
		this.guiconfigmodel.setPluginmanager(p_pluginmanager);
		this.guiconfig = new GUIConfig(this);
		startProgram(p_iplugin);
	}

	protected void startProgram(IPlugin p_iplugin)
	{
		this.guiconfigmodel.getPluginmanager().startProgram(this.guiconfig,
				new ImageIcon(this.getClass().getResource("/roots/icons/config.png")), true, true, p_iplugin);
	}

	protected void stopProgram()
	{
		this.guiconfigmodel.setPluginmanager(null);
		this.guiconfigmodel = null;
		this.guiconfig = null;
	}

}
