package roots.plugin.programs.edit.person.gui;

import javax.swing.JPanel;

import roots.plugin.IPluginManager;

public class GUIMEditPerson
{
	private IPluginManager pluginManager;

	public GUIMEditPerson()
	{
		this.pluginManager = null;
	}
	public void changeTabTitle(JPanel panel, String title)
	{
		this.pluginManager.changeTitle(panel, title);
	}

	public IPluginManager getPluginmanager()
	{
		return pluginManager;
	}

	public void setPluginmanager(IPluginManager pluginManager)
	{
		this.pluginManager = pluginManager;
	}
}
