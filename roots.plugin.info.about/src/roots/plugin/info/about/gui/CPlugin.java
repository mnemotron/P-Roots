package roots.plugin.info.about.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JMenuItem;

import roots.plugin.plugin.IPlugin;
import roots.plugin.plugin.IPluginManager;
import roots.plugin.translation.ITranslation.enum_language;
import roots.plugin.info.about.translation.TPAbout;

public class CPlugin implements IPlugin
{
	private IPluginManager pluginmanager;
	private GUIAboutController guiaboutcontroller;

	private JMenuItem mi_info_about;
	
	private TPAbout tp;

	public CPlugin()
	{
		pluginmanager = null;
		guiaboutcontroller = null;
		tp = null;

		this.mi_info_about = getMi_info_about();
	}

	public JMenuItem getMi_info_about()
	{
		if (mi_info_about == null)
		{
			mi_info_about = new JMenuItem("");
			mi_info_about.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent arg0)
				{
					startProgram();
				}
			});
			mi_info_about.setIcon(new ImageIcon(this.getClass().getResource("/roots/plugin/info/about/icons/about.png")));
			mi_info_about.setName("MI_INFO_ABOUT");
		}
		return mi_info_about;
	}

	private void startProgram()
	{
		this.mi_info_about.setEnabled(false);
		
		this.guiaboutcontroller = new GUIAboutController(this.pluginmanager, this);
	
		this.guiaboutcontroller.doTranslation(tp);
	}

	@Override
	public void setPluginManager(IPluginManager p_pluginmanager)
	{
		this.pluginmanager = p_pluginmanager;

		this.pluginmanager.setMenuItem(this.mi_info_about, IPluginManager.menuposition.INFO);
	}

	@Override
	public void doTranslation(enum_language p_language)
	{
		try
		{
			this.tp = new TPAbout(p_language, TPAbout.LANGUAGE_FILE_LOCATION);

			if (this.guiaboutcontroller != null)
			{
				this.guiaboutcontroller.doTranslation(tp);
			}

			this.mi_info_about.setText(tp.getLanguagePropertie(this.mi_info_about.getName()));

		} catch (IOException e)
		{
			this.pluginmanager.logStackTrace(e.getStackTrace());
			this.pluginmanager.logError(e.getMessage());
		}
	}

	@Override
	public void closeProgram()
	{
		this.mi_info_about.setEnabled(true);
		this.guiaboutcontroller.stopProgram();
		this.guiaboutcontroller = null;
	}

}
