package roots.plugin.info.about.gui;

import java.io.IOException;

import javax.swing.ImageIcon;

import roots.plugin.IPlugin;
import roots.plugin.IPluginManager;
import roots.plugin.info.about.translation.TPAbout;

public class GUIAboutController
{
	private GUIAbout guiabout;
	private GUIAboutModel guiaboutmodel;

	public GUIAboutController(IPluginManager p_pluginmanager, IPlugin p_iplugin)
	{
	
		this.guiaboutmodel = new GUIAboutModel();
		this.guiaboutmodel.setPluginmanager(p_pluginmanager);
		this.guiabout = new GUIAbout(this);
		startProgram(p_iplugin);
	}

	public void doTranslation(TPAbout tp)
	{
		try
		{
			this.guiabout.do_translation(tp);
		} catch (IOException e)
		{
			this.guiaboutmodel.getPluginmanager().logStackTrace(e.getStackTrace());
			this.guiaboutmodel.getPluginmanager().logError(e.getMessage());
		}
	}

	protected void changeTabTitle(String title)
	{
		this.guiaboutmodel.changeTabTitle(this.guiabout, title);
	}

	protected void startProgram(IPlugin p_iplugin)
	{
		this.guiaboutmodel.getPluginmanager().startProgram(this.guiabout,new ImageIcon(this.getClass().getResource("/roots/plugin/info/about/icons/about.png")), true, true, p_iplugin);
	}
	
	protected void stopProgram()
	{
		this.guiaboutmodel.setPluginmanager(null);
		this.guiaboutmodel = null;
		this.guiabout = null;
	}

	protected String getForfedreVersion()
	{
		return this.guiaboutmodel.getForfedreVersion();
	}

	protected String getForfedreTitle()
	{
		return this.guiaboutmodel.getForfedreTitle();
	}
}
