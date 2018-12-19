package roots.plugin.config.gui;

import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.UIManager.LookAndFeelInfo;

import org.jdesktop.swingx.SwingXUtilities;

import roots.plugin.plugin.IPlugin;
import roots.plugin.plugin.IPluginManager;
import roots.translation.TPForfedre;

public class GUICConfig
{
	private GUIConfig guiconfig;
	private GUIMConfig guiconfigmodel;

	public GUICConfig(IPluginManager p_pluginmanager, IPlugin p_iplugin)
	{
		this.guiconfigmodel = new GUIMConfig();
		this.guiconfigmodel.setPluginmanager(p_pluginmanager);
		this.guiconfig = new GUIConfig(this);
		startProgram(p_iplugin);
	}

	public LookAndFeelInfo[] getInstalledLookAndFeels()
	{
		return this.guiconfigmodel.getInstalledLookAndFeels();
	}

	public void setLookAndFeel(String classname)
	{
		this.guiconfigmodel.setLookAndFeel(classname);
	}

	public String getDefaultLookAndFeelName()
	{
		return this.guiconfigmodel.getDefaultLookAndFeelName();
	}

	public String getDefaultLookAndFeelClassName()
	{
		return this.guiconfigmodel.getDefaultLookAndFeelClassName();
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
		this.guiconfigmodel.getPluginmanager().startProgram(this.guiconfig, new ImageIcon(this.getClass().getResource("/roots/icons/config.png")), true, true, p_iplugin);
	}

	protected void stopProgram()
	{
		this.guiconfigmodel.setPluginmanager(null);
		this.guiconfigmodel = null;
		this.guiconfig = null;
	}

	protected void updateGUI()
	{
		SwingXUtilities.updateAllComponentTreeUIs();
	}

	protected void saveLookAndFeel(String className)
	{
		this.guiconfigmodel.saveConfigLookAndFeel(className);
	}

}
