package roots.plugin.config.gui;

import java.io.IOException;

import javax.swing.ImageIcon;

import roots.plugin.IPlugin;
import roots.plugin.IPluginManager;
import roots.translation.TPForfedre;

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
	
	public void doTranslation(TPForfedre tp)
	{
		try
		{
			this.guiconfig.do_translation(tp);
		} catch (IOException e)
		{
			this.guiconfigmodel.getPluginmanager().logStackTrace(e.getStackTrace());
			this.guiconfigmodel.getPluginmanager().logError(e.getMessage());
		}
	}
	
	protected void changeTabTitle(String title)
	{
		this.guiconfigmodel.changeTabTitle(this.guiconfig, title);
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
