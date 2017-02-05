package roots.core.gui;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import javax.swing.ImageIcon;
import javax.swing.JCheckBoxMenuItem;

import roots.plugin.IPlugin;
import roots.translation.ITranslation;
import roots.translation.TPForfedre;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

public class GUIMain
{
	private GUIMainController guimaincontroller;

	private JFrame main_frame;
	private JPanel main_panel;
	private JMenuBar menubar_main;
	private JTabbedPane main_tab;
	private JMenu menu_forfedre;
	private JSeparator sep_forfedre1;
	private JMenuItem mi_forfedre_exit;
	private JMenu menu_programs;
	private JMenu menu_programs_edit;
	private JMenu menu_repository;
	private JMenuItem mi_repository_info;
	private JMenuItem mi_repository_change;
	private JMenu menu_language;
	private JCheckBoxMenuItem mi_language_german;
	private JCheckBoxMenuItem mi_language_english;
	private JMenu menu_info;
	private JMenuItem mi_info_help;
	private JLabel lbl_repository_status;
	private JPanel menu_panel;
	private JMenuItem mi_info_errordisplay;
	private JMenu menu_repimport;
	private JMenu menu_repexport;

	public GUIMain(GUIMainController p_guimaincontroller)
	{
		this.guimaincontroller = p_guimaincontroller;

		// -- init GUI
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize()
	{
		// Rectangle maxBounds =
		// GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds();

		main_frame = new JFrame();
		main_frame.addWindowListener(new WindowAdapter()
		{
			@Override
			public void windowClosing(WindowEvent arg0)
			{
				guimaincontroller.stopGUI();
			}
		});
		main_frame.setBounds(10, 10, 700, 700);
		main_frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		main_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		main_frame.getContentPane().add(getMain_panel(), BorderLayout.SOUTH);
		main_frame.getContentPane().add(getMain_tab(), BorderLayout.CENTER);
	}

	private JPanel getMain_panel()
	{
		if (main_panel == null)
		{
			main_panel = new JPanel();
			main_panel.setBorder(null);
			main_panel.setLayout(new GridLayout(0, 1, 0, 0));
			main_panel.add(getMenu_panel());
		}
		return main_panel;
	}

	private JMenuBar getMenubar_main()
	{
		if (menubar_main == null)
		{
			menubar_main = new JMenuBar();
			menubar_main.setBorder(null);
			menubar_main.add(getMenu_forfedre());
			menubar_main.add(getMenu_programs());
			menubar_main.add(getMenu_repository());
			menubar_main.add(getMenu_language());
			menubar_main.add(getMenu_info());
		}
		return menubar_main;
	}

	private JTabbedPane getMain_tab()
	{
		if (main_tab == null)
		{
			main_tab = new JTabbedPane(JTabbedPane.TOP);
			main_tab.setBorder(null);
		}
		return main_tab;
	}

	private JMenu getMenu_forfedre()
	{
		if (menu_forfedre == null)
		{
			menu_forfedre = new JMenu("");
			menu_forfedre.setName("MENU_FORFEDRE");
			menu_forfedre.add(getSep_forfedre1());
			menu_forfedre.add(getMi_forfedre_exit());
		}
		return menu_forfedre;
	}

	private JSeparator getSep_forfedre1()
	{
		if (sep_forfedre1 == null)
		{
			sep_forfedre1 = new JSeparator();
		}
		return sep_forfedre1;
	}

	private JMenuItem getMi_forfedre_exit()
	{
		if (mi_forfedre_exit == null)
		{
			mi_forfedre_exit = new JMenuItem("Exit");
			mi_forfedre_exit.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent arg0)
				{
					guimaincontroller.stopGUI();
				}
			});
			mi_forfedre_exit.setIcon(new ImageIcon(GUIMain.class.getResource("/roots/icons/exit.png")));
			mi_forfedre_exit.setName("MI_FORFEDRE_EXIT");
		}
		return mi_forfedre_exit;
	}

	protected JMenu getMenu_programs()
	{
		if (menu_programs == null)
		{
			menu_programs = new JMenu("");
			menu_programs.setIcon(new ImageIcon(GUIMain.class.getResource("/roots/icons/programs.png")));
			menu_programs.setBorder(null);
			menu_programs.setName("MENU_PROGRAMS");
		}
		return menu_programs;
	}

	private JMenu getMenu_programs_edit()
	{
		if (menu_programs_edit == null)
		{
			menu_programs_edit = new JMenu("");
			menu_programs_edit.setIcon(new ImageIcon(GUIMain.class.getResource("/roots/icons/programs.png")));
			menu_programs_edit.setBorder(null);
			menu_programs_edit.setName("MENU_PROGRAMS_EDIT");
		}
		return menu_programs_edit;
	}

	protected JMenu getMenu_repository()
	{
		if (menu_repository == null)
		{
			menu_repository = new JMenu("");
			menu_repository.setIcon(new ImageIcon(GUIMain.class.getResource("/roots/icons/repository.png")));
			menu_repository.setBorder(null);
			menu_repository.setName("MENU_REPOSITORY");
			menu_repository.add(getMi_repository_info());
			menu_repository.add(getMi_repository_change());
			menu_repository.add(getMenu_repimport());
			menu_repository.add(getMenu_repexport());
		}
		return menu_repository;
	}

	private JMenuItem getMi_repository_info()
	{
		if (mi_repository_info == null)
		{
			mi_repository_info = new JMenuItem("");
			mi_repository_info.setIcon(new ImageIcon(GUIMain.class.getResource("/roots/icons/repinfo.png")));
			mi_repository_info.setName("MI_REPOSITORY_INFO");
		}
		return mi_repository_info;
	}

	private JMenuItem getMi_repository_change()
	{
		if (mi_repository_change == null)
		{
			mi_repository_change = new JMenuItem("");
			mi_repository_change.setIcon(new ImageIcon(GUIMain.class.getResource("/roots/icons/repchange.png")));
			mi_repository_change.setName("MI_REPOSITORY_CHANGE");
		}
		return mi_repository_change;
	}

	private JMenu getMenu_language()
	{
		if (menu_language == null)
		{
			menu_language = new JMenu("");
			menu_language.setBorder(null);
			menu_language.setName("MENU_LANGUAGE");
			menu_language.add(getMi_language_german());
			menu_language.add(getMi_language_english());
		}
		return menu_language;
	}

	private JCheckBoxMenuItem getMi_language_german()
	{
		if (mi_language_german == null)
		{
			mi_language_german = new JCheckBoxMenuItem("");
			mi_language_german.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent arg0)
				{
					guimaincontroller.setLanguage(ITranslation.enum_language.de);
					select_Language(ITranslation.enum_language.de);
				}
			});
			mi_language_german.setIcon(new ImageIcon(GUIMain.class.getResource("/roots/icons/de.png")));
			mi_language_german.setName("MI_LANGUAGE_GERMAN");
		}
		return mi_language_german;
	}

	private JCheckBoxMenuItem getMi_language_english()
	{
		if (mi_language_english == null)
		{
			mi_language_english = new JCheckBoxMenuItem("");
			mi_language_english.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent arg0)
				{
					guimaincontroller.setLanguage(ITranslation.enum_language.en);
					select_Language(ITranslation.enum_language.en);
				}
			});
			mi_language_english.setIcon(new ImageIcon(GUIMain.class.getResource("/roots/icons/en.png")));
			mi_language_english.setName("MI_LANGUAGE_ENGLISH");
		}
		return mi_language_english;
	}

	private JMenu getMenu_info()
	{
		if (menu_info == null)
		{
			menu_info = new JMenu("");
			menu_info.setIcon(new ImageIcon(GUIMain.class.getResource("/roots/icons/info.png")));
			menu_info.setBorder(null);
			menu_info.setName("MENU_INFO");
			menu_info.add(getMi_info_help());
			menu_info.add(getMi_info_errordisplay());
		}
		return menu_info;
	}

	private JMenuItem getMi_info_help()
	{
		if (mi_info_help == null)
		{
			mi_info_help = new JMenuItem("");
			mi_info_help.setIcon(new ImageIcon(GUIMain.class.getResource("/roots/icons/help.png")));
			mi_info_help.setName("MI_INFO_HELP");
		}
		return mi_info_help;
	}

	protected void select_Language(ITranslation.enum_language p_language)
	{

		mi_language_english.setSelected(false);
		mi_language_german.setSelected(false);

		switch (p_language)
		{
		case de:
			mi_language_german.setSelected(true);
			this.getMenu_language().setIcon(new ImageIcon(GUIMain.class.getResource("/roots/icons/de.png")));
			break;
		case en:
			mi_language_english.setSelected(true);
			this.getMenu_language().setIcon(new ImageIcon(GUIMain.class.getResource("/roots/icons/en.png")));
			break;
		}
	}

	public void do_translation(ITranslation.enum_language p_language) throws IOException
	{
		TPForfedre tp = new TPForfedre(p_language, TPForfedre.LANGUAGE_FILE_LOCATION);

		// -- Menu Language
		this.menu_language.setText(tp.getLanguagePropertie(this.menu_language.getName()));
		this.mi_language_german.setText(tp.getLanguagePropertie(this.mi_language_german.getName()));
		this.mi_language_english.setText(tp.getLanguagePropertie(this.mi_language_english.getName()));

		// -- Menu Programs
		this.menu_programs.setText(tp.getLanguagePropertie(this.menu_programs.getName()));
		if (this.menu_programs_edit != null)
		{
			this.menu_programs_edit.setText(tp.getLanguagePropertie(this.menu_programs_edit.getName()));
		}

		// -- Menu Repository
		this.menu_repository.setText(tp.getLanguagePropertie(this.menu_repository.getName()));
		this.mi_repository_info.setText(tp.getLanguagePropertie(this.mi_repository_info.getName()));
		this.mi_repository_change.setText(tp.getLanguagePropertie(this.mi_repository_change.getName()));
		this.menu_repimport.setText(tp.getLanguagePropertie(this.menu_repimport.getName()));
		this.menu_repexport.setText(tp.getLanguagePropertie(this.menu_repexport.getName()));

		// -- Menu Forfedre
		this.menu_forfedre.setText(tp.getLanguagePropertie(this.menu_forfedre.getName()));
		this.mi_forfedre_exit.setText(tp.getLanguagePropertie(this.mi_forfedre_exit.getName()));

		// -- Menu Info
		this.menu_info.setText(tp.getLanguagePropertie(this.menu_info.getName()));
		this.mi_info_help.setText(tp.getLanguagePropertie(this.mi_info_help.getName()));
		this.mi_info_errordisplay.setText(tp.getLanguagePropertie(this.mi_info_errordisplay.getName()));
	}

	protected JLabel getLbl_repository_status()
	{
		if (lbl_repository_status == null)
		{
			lbl_repository_status = new JLabel("");
			lbl_repository_status.setIcon(new ImageIcon(GUIMain.class.getResource("/roots/icons/dbnative.png")));
			lbl_repository_status.setHorizontalTextPosition(SwingConstants.CENTER);
			lbl_repository_status.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lbl_repository_status;
	}

	protected JPanel getMenu_panel()
	{
		if (menu_panel == null)
		{
			menu_panel = new JPanel();
			menu_panel.setLayout(new BorderLayout(0, 0));
			menu_panel.add(getMenubar_main(), BorderLayout.WEST);
			menu_panel.add(getLbl_repository_status(), BorderLayout.EAST);
		}
		return menu_panel;
	}

	protected void addJMenuItemRoots(JMenuItem p_menuitem)
	{
		this.menu_forfedre.add(p_menuitem);
	}

	protected void addJMenuItemInfo(JMenuItem p_menuitem)
	{
		this.menu_info.add(p_menuitem);
	}

	protected void addJMenuPrograms(JMenu p_jmenu)
	{
		this.menu_programs.add(p_jmenu);
	}

	protected void addJMenuItemPrograms(JMenuItem p_menuitem)
	{
		this.menu_programs.add(p_menuitem);
	}

	protected void addJMenuItemProgramsEdit(JMenuItem p_menuitem)
	{
		if (this.menu_programs_edit == null)
		{
			this.menu_programs.add(this.getMenu_programs_edit());
		}

		this.menu_programs_edit.add(p_menuitem);
	}

	protected void addJMenuProgramsEdit(JMenu p_menu)
	{
		if (this.menu_programs_edit == null)
		{
			this.menu_programs.add(this.getMenu_programs_edit());
		}

		this.menu_programs_edit.add(p_menu);
	}

	protected void addJMenuExport(JMenu p_jmenu)
	{
		this.menu_repexport.add(p_jmenu);
	}

	protected void addJMenuItemExport(JMenuItem p_menuitem)
	{
		this.menu_repexport.add(p_menuitem);
	}

	protected void addJMenuImport(JMenu p_jmenu)
	{
		this.menu_repimport.add(p_jmenu);
	}

	protected void addJMenuItemImport(JMenuItem p_menuitem)
	{
		this.menu_repimport.add(p_menuitem);
	}

	public JFrame getMain_frame()
	{
		return main_frame;
	}

	public JTabbedPane getMaintab()
	{
		return this.main_tab;
	}

	public void removeTabProgram(JPanel p_panel)
	{
		main_tab.remove(p_panel);
	}

	protected void addJTabProgram(JPanel p_panel, ImageIcon p_ico, boolean p_selected, boolean p_closeable,
			IPlugin p_iplugin)
	{
		this.main_tab.addTab("", p_ico, p_panel);

		if (p_closeable && p_iplugin != null)
		{
			int index = this.main_tab.indexOfComponent(p_panel);

			this.main_tab.setTabComponentAt(index,
					new TabButtonComponent(guimaincontroller, main_tab, p_ico, p_panel, p_iplugin));
		}

		if (p_selected)
		{
			this.main_tab.setSelectedComponent(p_panel);
		}
	}

	protected void changeTabTitle(JPanel p_panel, String p_title)
	{
		int i = main_tab.indexOfComponent(p_panel);
		if (i >= 0)
		{
			main_tab.setTitleAt(i, p_title);
		}
	}

	private JMenuItem getMi_info_errordisplay()
	{
		if (mi_info_errordisplay == null)
		{
			mi_info_errordisplay = new JMenuItem("");
			mi_info_errordisplay.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent arg0)
				{
					guimaincontroller.showLogScreen();
				}
			});
			mi_info_errordisplay.setIcon(new ImageIcon(GUIMain.class.getResource("/roots/icons/log.png")));
			mi_info_errordisplay.setName("MI_INFO_ERRORDISPLAY");
		}
		return mi_info_errordisplay;
	}

	private JMenu getMenu_repimport()
	{
		if (menu_repimport == null)
		{
			menu_repimport = new JMenu("");
			menu_repimport.setIcon(new ImageIcon(GUIMain.class.getResource("/roots/icons/repimport.png")));
			menu_repimport.setName("MENU_REPIMPORT");
		}
		return menu_repimport;
	}

	private JMenu getMenu_repexport()
	{
		if (menu_repexport == null)
		{
			menu_repexport = new JMenu("");
			menu_repexport.setIcon(new ImageIcon(GUIMain.class.getResource("/roots/icons/repexport.png")));
			menu_repexport.setName("MENU_REPEXPORT");
		}
		return menu_repexport;
	}
}
