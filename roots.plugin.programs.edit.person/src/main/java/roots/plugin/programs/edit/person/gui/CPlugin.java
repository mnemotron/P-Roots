package roots.plugin.programs.edit.person.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JMenuItem;

import roots.plugin.IPlugin;
import roots.plugin.IPluginManager;
import roots.translation.ITranslation.enum_language;
import roots.plugin.programs.edit.person.icon.SystemResourceIcons;
import roots.plugin.programs.edit.person.translation.TPEditPerson;

public class CPlugin implements IPlugin
{
	private IPluginManager pluginmanager;
	private GUICEditPerson guieditpersoncontroller;
	private JMenuItem mi_programs_edit_person;
	private TPEditPerson tp;

	public CPlugin()
	{
		pluginmanager = null;
		guieditpersoncontroller = null;
		tp = null;

		this.mi_programs_edit_person = getMi_programs_edit_person();
	}

	public JMenuItem getMi_programs_edit_person()
	{
		if (mi_programs_edit_person == null)
		{
			mi_programs_edit_person = new JMenuItem("");
			mi_programs_edit_person.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent arg0)
				{
					startProgram();
				}
			});
			mi_programs_edit_person.setIcon(new ImageIcon(this.getClass().getResource(SystemResourceIcons.ICON_PROGRAM)));
			mi_programs_edit_person.setName("MI_PROGRAMS_EDIT_PERSON");
		}
		return mi_programs_edit_person;
	}

	private void startProgram()
	{
		this.mi_programs_edit_person.setEnabled(false);

		this.guieditpersoncontroller = new GUICEditPerson(this.pluginmanager, this);

		this.guieditpersoncontroller.doTranslation(tp);
	}

	@Override
	public void setPluginManager(IPluginManager pluginManager)
	{
		this.pluginmanager = pluginManager;

		this.pluginmanager.setMenuItem(this.mi_programs_edit_person, IPluginManager.menuposition.PROGRAMS_EDIT);
	}

	@Override
	public void doTranslation(enum_language language)
	{
		try
		{
			this.tp = new TPEditPerson(language, TPEditPerson.LANGUAGE_FILE_LOCATION);

			if (this.guieditpersoncontroller != null)
			{
				this.guieditpersoncontroller.doTranslation(tp);
			}

			this.mi_programs_edit_person.setText(tp.getLanguagePropertie(this.mi_programs_edit_person.getName()));

		} catch (IOException e)
		{
			this.pluginmanager.logStackTrace(e.getStackTrace());
			this.pluginmanager.logError(e.getMessage());
		}
	}

	@Override
	public void closeProgram()
	{
		this.mi_programs_edit_person.setEnabled(true);
		this.guieditpersoncontroller.stopProgram();
		this.guieditpersoncontroller = null;
	}

}
