package roots.plugin.programs.edit.person.gui;

import java.io.IOException;

import javax.swing.ImageIcon;

import roots.plugin.IPlugin;
import roots.plugin.IPluginManager;
import roots.plugin.programs.edit.person.icon.SystemResourceIcons;
import roots.plugin.programs.edit.person.translation.TPEditPerson;

public class GUICEditPerson
{
	private GUIEditPerson guiEditPerson;
	private GUIMEditPerson guiEditPersonModel;

	public GUICEditPerson(IPluginManager pluginManager, IPlugin iPlugin)
	{
	
		this.guiEditPersonModel = new GUIMEditPerson();
		this.guiEditPersonModel.setPluginmanager(pluginManager);
		this.guiEditPerson = new GUIEditPerson(this);
		this.startProgram(iPlugin);
	}

	public void doTranslation(TPEditPerson tp)
	{
		try
		{
			this.guiEditPerson.do_translation(tp);
		} catch (IOException e)
		{
			this.guiEditPersonModel.getPluginmanager().logStackTrace(e.getStackTrace());
			this.guiEditPersonModel.getPluginmanager().logError(e.getMessage());
		}
	}

	protected void changeTabTitle(String title)
	{
		this.guiEditPersonModel.changeTabTitle(this.guiEditPerson, title);
	}

	protected void startProgram(IPlugin iPlugin)
	{
		this.guiEditPersonModel.getPluginmanager().startProgram(this.guiEditPerson,new ImageIcon(this.getClass().getResource(SystemResourceIcons.ICON_PROGRAM)), true, true, iPlugin);
	}
	
	protected void stopProgram()
	{
		this.guiEditPersonModel.setPluginmanager(null);
		this.guiEditPersonModel = null;
		this.guiEditPerson = null;
	}
}
