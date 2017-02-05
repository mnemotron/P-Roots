package roots.config.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JMenuItem;

import roots.plugin.IPlugin;
import roots.plugin.IPluginManager;
import roots.translation.ITranslation.enum_language;

public class ConfigPluginController implements IPlugin
{
	private IPluginManager pluginmanager;
	private GUIConfigController guiconfigcontroller;

	private JMenuItem mi_roots_config;

	public ConfigPluginController()
	{
		pluginmanager = null;
		guiconfigcontroller = null;
		
		this.mi_roots_config = getMi_roots_config();
	}
	
	public JMenuItem getMi_roots_config()
	{
		if (mi_roots_config == null)
		{
			mi_roots_config = new JMenuItem("");
			mi_roots_config.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent arg0)
				{
					startProgram();
				}
			});
			mi_roots_config.setIcon(new ImageIcon(this.getClass().getResource("/roots/icons/config.png")));
			mi_roots_config.setName("MI_FORFEDRE_CONFIG");
		}
		return mi_roots_config;
	}

	private void startProgram()
	{
		this.mi_roots_config.setEnabled(false);
		
		this.guiconfigcontroller = new GUIConfigController(this.pluginmanager, this);
	
		//this.guiconfigcontroller.doTranslation(tp);
	}

	@Override
	public void setPluginManager(IPluginManager p_pluginmanager)
	{
		this.pluginmanager = p_pluginmanager;

		this.pluginmanager.setMenuItem(this.mi_roots_config, IPluginManager.menuposition.ROOTS);
	}

	@Override
	public void doTranslation(enum_language p_language)
	{
		/*
		try
		{
			this.tp = new TPAbout(p_language, TPAbout.LANGUAGE_FILE_LOCATION);

			if (this.guiconfigcontroller != null)
			{
				this.guiconfigcontroller.doTranslation(tp);
			}

			this.mi_config.setText(tp.getLanguagePropertie(this.mi_config.getName()));

		} catch (IOException e)
		{
			this.pluginmanager.logStackTrace(e.getStackTrace());
			this.pluginmanager.logError(e.getMessage());
		}
		*/
	}

	@Override
	public void closeProgram()
	{
		this.mi_roots_config.setEnabled(true);
		this.guiconfigcontroller.stopProgram();
		this.guiconfigcontroller = null;
	}

}
