package roots.core.gui;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.FlowLayout;

import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JPasswordField;
import java.awt.Font;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

import roots.GUILayout;
import roots.core.SystemResourceIcons;
import roots.translation.ITranslation;
import roots.translation.TPForfedre;

import java.awt.Insets;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import java.awt.ComponentOrientation;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;

import javax.swing.JTextPane;

public class GUIRepositoryLogin extends JPanel
{
	private static final long serialVersionUID = 1L;

	protected static final String BTN_DB_CONNECT1 = "BTN_DB_CONNECT1";
	protected static final String BTN_DB_CONNECT2 = "BTN_DB_CONNECT2";
	protected static final String BTN_REP_CHOOSE1 = "BTN_REP_CHOOSE1";
	protected static final String BTN_REP_CHOOSE2 = "BTN_REP_CHOOSE2";
	private static final String TAB_TITLE_PROPERTY = "TAB_TITLE_DB_LOGIN";

	private GUICRepositoryLogin guireplogincontroller;
	private Font font;

	private JPanel panel_repmain;
	private JTextField txf_account_username;
	private JPasswordField txf_account_password;
	private JLabel lbl_account_username;
	private JLabel lbl_account_password;
	private JComboBox cbx_database;
	private JLabel lbl_database;
	private JTextField txf_db_location;
	private JLabel lbl_db_location;
	private JTextField txf_db_name;
	private JLabel lbl_db_name;
	private JPanel panel_repdb;
	private JPanel panel_repaccount;
	private JCheckBox cbx_account_spass;
	private JPanel panel_rep;
	private JComboBox cbx_repname;
	private JLabel lbl_repname;
	private JButton btn_db_connect;
	private JButton btn_rep_choose;
	private JPanel panel_repinfo;
	private JLabel lbl_repversion;
	private JLabel lbl_repcreationdate;
	private JLabel lbl_repdescription;
	private JLabel lbl_repversion_dat;
	private JLabel lbl_repcreationdate_dat;
	private JTextPane txp_repdescription_dat;
	private JButton btn_repnew;
	private JLabel lbl_repcreator;
	private JTextField txt_repcreator;

	/**
	 * Create the panel.
	 */
	public GUIRepositoryLogin(GUICRepositoryLogin p_guireplogincontroller)
	{
		this.guireplogincontroller = p_guireplogincontroller;

		// -- set Font
		// this.font = GUILayout.font_tahoma_bold_12;

		setBorder(null);
		setLayout(new FlowLayout(FlowLayout.CENTER, 0, 50));

		add(getPanel_1_1());
	}

	private JPanel getPanel_1_1()
	{
		if (panel_repmain == null)
		{
			panel_repmain = new JPanel();
			panel_repmain.setBorder(null);
			GroupLayout gl_panel_repmain = new GroupLayout(panel_repmain);
			gl_panel_repmain.setHorizontalGroup(gl_panel_repmain.createParallelGroup(Alignment.TRAILING).addGroup(gl_panel_repmain.createSequentialGroup().addGroup(gl_panel_repmain.createParallelGroup(Alignment.TRAILING).addGroup(gl_panel_repmain.createSequentialGroup().addContainerGap().addComponent(getBtn_db_connect())).addGroup(gl_panel_repmain.createParallelGroup(Alignment.TRAILING).addGroup(gl_panel_repmain.createSequentialGroup().addContainerGap().addComponent(getBtn_rep_choose())).addGroup(gl_panel_repmain.createSequentialGroup().addGap(4).addGroup(gl_panel_repmain.createParallelGroup(Alignment.LEADING).addComponent(getPanel_1(), GroupLayout.DEFAULT_SIZE, 381, Short.MAX_VALUE).addComponent(getPanel_repdb(), GroupLayout.DEFAULT_SIZE, 381, Short.MAX_VALUE).addComponent(getPanel_rep(), GroupLayout.DEFAULT_SIZE, 381, Short.MAX_VALUE))))).addGap(86)));
			gl_panel_repmain.setVerticalGroup(gl_panel_repmain.createParallelGroup(Alignment.LEADING).addGroup(gl_panel_repmain.createSequentialGroup().addGap(11).addComponent(getPanel_repdb(), GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE).addGap(18).addComponent(getPanel_1(), GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE).addPreferredGap(ComponentPlacement.RELATED).addComponent(getBtn_db_connect()).addGap(46).addComponent(getPanel_rep(), GroupLayout.PREFERRED_SIZE, 227, GroupLayout.PREFERRED_SIZE).addPreferredGap(ComponentPlacement.RELATED).addComponent(getBtn_rep_choose()).addContainerGap(99, Short.MAX_VALUE)));
			gl_panel_repmain.setAutoCreateContainerGaps(true);
			gl_panel_repmain.setAutoCreateGaps(true);
			panel_repmain.setLayout(gl_panel_repmain);
		}
		return panel_repmain;
	}

	protected JTextField getTextField_1()
	{
		if (txf_account_username == null)
		{
			txf_account_username = new JTextField();
			txf_account_username.setBorder(new LineBorder(GUILayout.color_dark_green));
			txf_account_username.setFont(this.font);
			txf_account_username.setColumns(10);
		}
		return txf_account_username;
	}

	protected JPasswordField getTextField_1_1()
	{
		if (txf_account_password == null)
		{
			txf_account_password = new JPasswordField();
			txf_account_password.setBorder(new LineBorder(GUILayout.color_dark_green));
			txf_account_password.setFont(this.font);
			txf_account_password.setColumns(10);
		}
		return txf_account_password;
	}

	private JLabel getLbl_account_username()
	{
		if (lbl_account_username == null)
		{
			lbl_account_username = new JLabel("Username:");
			lbl_account_username.setName("LBL_ACCOUNT_USERNAME");
			lbl_account_username.setFont(this.font);
		}
		return lbl_account_username;
	}

	private JLabel getLbl_account_password()
	{
		if (lbl_account_password == null)
		{
			lbl_account_password = new JLabel("Password:");
			lbl_account_password.setName("LBL_ACCOUNT_PASSWORD");
			lbl_account_password.setFont(this.font);
		}
		return lbl_account_password;
	}

	public void do_translation(ITranslation.enum_language p_language) throws IOException
	{
		TPForfedre tp = new TPForfedre(p_language, TPForfedre.LANGUAGE_FILE_LOCATION);

		this.guireplogincontroller.changeTabTitle(tp.getLanguagePropertie(TAB_TITLE_PROPERTY));

		this.lbl_account_username.setText(tp.getLanguagePropertie(this.lbl_account_username.getName()));
		this.lbl_account_password.setText(tp.getLanguagePropertie(this.lbl_account_password.getName()));
		this.lbl_database.setText(tp.getLanguagePropertie(this.lbl_database.getName()));
		this.lbl_db_location.setText(tp.getLanguagePropertie(this.lbl_db_location.getName()));
		this.lbl_db_name.setText(tp.getLanguagePropertie(this.lbl_db_name.getName()));
		this.cbx_account_spass.setText(tp.getLanguagePropertie(this.cbx_account_spass.getName()));
		this.lbl_repversion.setText(tp.getLanguagePropertie(this.lbl_repversion.getName()));
		this.lbl_repcreationdate.setText(tp.getLanguagePropertie(this.lbl_repcreationdate.getName()));
		this.lbl_repdescription.setText(tp.getLanguagePropertie(this.lbl_repdescription.getName()));
		this.lbl_repname.setText(tp.getLanguagePropertie(this.lbl_repname.getName()));
		this.lbl_repcreator.setText(tp.getLanguagePropertie(this.lbl_repcreator.getName()));

		if (this.btn_db_connect.getName().compareTo(GUIRepositoryLogin.BTN_DB_CONNECT1) == 0)
		{
			this.btn_db_connect.setText(tp.getLanguagePropertie(GUIRepositoryLogin.BTN_DB_CONNECT1));
		}
		else if (this.btn_db_connect.getName().compareTo(GUIRepositoryLogin.BTN_DB_CONNECT2) == 0)
		{
			this.btn_db_connect.setText(tp.getLanguagePropertie(GUIRepositoryLogin.BTN_DB_CONNECT2));
		}

		if (this.btn_rep_choose.getName().compareTo(GUIRepositoryLogin.BTN_REP_CHOOSE1) == 0)
		{
			this.btn_rep_choose.setText(tp.getLanguagePropertie(GUIRepositoryLogin.BTN_REP_CHOOSE1));
		}
		else if (this.btn_rep_choose.getName().compareTo(GUIRepositoryLogin.BTN_REP_CHOOSE2) == 0)
		{
			this.btn_rep_choose.setText(tp.getLanguagePropertie(GUIRepositoryLogin.BTN_REP_CHOOSE2));
		}
	}

	protected JComboBox getCbx_database()
	{
		if (cbx_database == null)
		{
			cbx_database = new JComboBox(new MComboBoxKey());
			cbx_database.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent arg0)
				{
					guireplogincontroller.actionSelectedDatabase();
				}
			});
			cbx_database.setFont(this.font);
			cbx_database.setBorder(new LineBorder(GUILayout.color_dark_green));
		}
		return cbx_database;
	}

	private JLabel getLbl_database()
	{
		if (lbl_database == null)
		{
			lbl_database = new JLabel("");
			lbl_database.setName("LBL_DATABASE");
			lbl_database.setFont(this.font);
		}
		return lbl_database;
	}

	protected JTextField getTxf_db_location()
	{
		if (txf_db_location == null)
		{
			txf_db_location = new JTextField();
			txf_db_location.setBorder(new LineBorder(GUILayout.color_dark_green));
			txf_db_location.setFont(this.font);
			txf_db_location.setColumns(10);
		}
		return txf_db_location;
	}

	private JLabel getLbl_db_location()
	{
		if (lbl_db_location == null)
		{
			lbl_db_location = new JLabel("");
			lbl_db_location.setName("LBL_DB_LOCATION");
			lbl_db_location.setFont(this.font);
		}
		return lbl_db_location;
	}

	protected JTextField getTxf_db_name()
	{
		if (txf_db_name == null)
		{
			txf_db_name = new JTextField();
			txf_db_name.setBorder(new LineBorder(GUILayout.color_dark_green));
			txf_db_name.setColumns(10);
			txf_db_name.setFont(this.font);
		}
		return txf_db_name;
	}

	private JLabel getLbl_db_name()
	{
		if (lbl_db_name == null)
		{
			lbl_db_name = new JLabel("");
			lbl_db_name.setName("LBL_DB_NAME");
			lbl_db_name.setFont(this.font);
		}
		return lbl_db_name;
	}

	private JPanel getPanel_repdb()
	{
		if (panel_repdb == null)
		{
			panel_repdb = new JPanel();
			panel_repdb.setBorder(new MatteBorder(1, 25, 1, 1, (Color) GUILayout.color_dark_green));
			GroupLayout gl_panel_repdb = new GroupLayout(panel_repdb);
			gl_panel_repdb.setHorizontalGroup(gl_panel_repdb.createParallelGroup(Alignment.TRAILING).addGroup(gl_panel_repdb.createSequentialGroup().addContainerGap().addGroup(gl_panel_repdb.createParallelGroup(Alignment.LEADING).addComponent(getLbl_db_location()).addComponent(getLbl_db_name()).addComponent(getLbl_database())).addPreferredGap(ComponentPlacement.RELATED).addGroup(gl_panel_repdb.createParallelGroup(Alignment.TRAILING).addComponent(getTxf_db_location(), GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE).addComponent(getTxf_db_name(), Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE).addComponent(getCbx_database(), Alignment.LEADING, 0, 193, Short.MAX_VALUE)).addContainerGap()));
			gl_panel_repdb.setVerticalGroup(gl_panel_repdb.createParallelGroup(Alignment.LEADING).addGroup(gl_panel_repdb.createSequentialGroup().addContainerGap().addGroup(gl_panel_repdb.createParallelGroup(Alignment.BASELINE).addComponent(getCbx_database(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE).addComponent(getLbl_database())).addGap(11).addGroup(gl_panel_repdb.createParallelGroup(Alignment.BASELINE).addComponent(getTxf_db_location(), GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE).addComponent(getLbl_db_location())).addPreferredGap(ComponentPlacement.UNRELATED).addGroup(gl_panel_repdb.createParallelGroup(Alignment.BASELINE).addComponent(getTxf_db_name(), GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE).addComponent(getLbl_db_name())).addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
			gl_panel_repdb.setAutoCreateContainerGaps(true);
			gl_panel_repdb.setAutoCreateGaps(true);
			panel_repdb.setLayout(gl_panel_repdb);
		}
		return panel_repdb;
	}

	private JPanel getPanel_1()
	{
		if (panel_repaccount == null)
		{
			panel_repaccount = new JPanel();
			panel_repaccount.setBorder(new MatteBorder(1, 25, 1, 1, (Color) GUILayout.color_dark_green));
			GroupLayout gl_panel_repaccount = new GroupLayout(panel_repaccount);
			gl_panel_repaccount.setHorizontalGroup(gl_panel_repaccount.createParallelGroup(Alignment.TRAILING).addGroup(Alignment.LEADING, gl_panel_repaccount.createSequentialGroup().addContainerGap().addGroup(gl_panel_repaccount.createParallelGroup(Alignment.LEADING, false).addComponent(getLbl_account_username()).addComponent(getLbl_account_password())).addPreferredGap(ComponentPlacement.RELATED).addGroup(gl_panel_repaccount.createParallelGroup(Alignment.LEADING).addComponent(getCbx_account_spass()).addComponent(getTextField_1_1(), Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE).addComponent(getTextField_1(), Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)).addContainerGap()));
			gl_panel_repaccount.setVerticalGroup(gl_panel_repaccount.createParallelGroup(Alignment.LEADING).addGroup(gl_panel_repaccount.createSequentialGroup().addContainerGap().addGroup(gl_panel_repaccount.createParallelGroup(Alignment.BASELINE).addComponent(getTextField_1(), GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE).addComponent(getLbl_account_username())).addGap(14).addGroup(gl_panel_repaccount.createParallelGroup(Alignment.BASELINE).addComponent(getTextField_1_1(), GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE).addComponent(getLbl_account_password())).addPreferredGap(ComponentPlacement.UNRELATED).addComponent(getCbx_account_spass()).addContainerGap(16, Short.MAX_VALUE)));
			gl_panel_repaccount.setAutoCreateGaps(true);
			gl_panel_repaccount.setAutoCreateContainerGaps(true);
			panel_repaccount.setLayout(gl_panel_repaccount);
		}
		return panel_repaccount;
	}

	protected JCheckBox getCbx_account_spass()
	{
		if (cbx_account_spass == null)
		{
			cbx_account_spass = new JCheckBox("");
			cbx_account_spass.setFont(this.font);
			cbx_account_spass.setName("CBX_ACCOUNT_SPASS");
			cbx_account_spass.setMargin(new Insets(0, 0, 0, 0));
			cbx_account_spass.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
			cbx_account_spass.setContentAreaFilled(false);
			cbx_account_spass.setIconTextGap(5);
		}
		return cbx_account_spass;
	}

	private JPanel getPanel_rep()
	{
		if (panel_rep == null)
		{
			panel_rep = new JPanel();
			panel_rep.setBorder(new MatteBorder(1, 25, 1, 1, (Color) GUILayout.color_dark_green));
			GroupLayout gl_panel_rep = new GroupLayout(panel_rep);
			gl_panel_rep.setHorizontalGroup(gl_panel_rep.createParallelGroup(Alignment.TRAILING).addGroup(gl_panel_rep.createSequentialGroup().addContainerGap().addComponent(getLbl_repname()).addGap(14).addGroup(gl_panel_rep.createParallelGroup(Alignment.LEADING).addComponent(getPanel_1_2(), GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE).addGroup(Alignment.TRAILING, gl_panel_rep.createSequentialGroup().addComponent(getCbx_repname(), 0, 238, Short.MAX_VALUE).addPreferredGap(ComponentPlacement.RELATED).addComponent(getBtn_repnew(), GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))).addContainerGap()));
			gl_panel_rep.setVerticalGroup(gl_panel_rep.createParallelGroup(Alignment.LEADING).addGroup(gl_panel_rep.createSequentialGroup().addContainerGap().addGroup(gl_panel_rep.createParallelGroup(Alignment.LEADING).addGroup(gl_panel_rep.createParallelGroup(Alignment.BASELINE).addComponent(getCbx_repname(), GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE).addComponent(getLbl_repname(), GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)).addComponent(getBtn_repnew(), GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)).addPreferredGap(ComponentPlacement.UNRELATED).addComponent(getPanel_1_2(), GroupLayout.PREFERRED_SIZE, 158, Short.MAX_VALUE).addContainerGap()));
			gl_panel_rep.setAutoCreateGaps(true);
			gl_panel_rep.setAutoCreateContainerGaps(true);
			panel_rep.setLayout(gl_panel_rep);
		}
		return panel_rep;
	}

	protected JComboBox getCbx_repname()
	{
		if (cbx_repname == null)
		{
			cbx_repname = new JComboBox(new MComboBoxRepKey());
			cbx_repname.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent arg0)
				{
					guireplogincontroller.showSelectedRepository();
				}
			});
			cbx_repname.setBorder(new LineBorder(GUILayout.color_dark_green));
		}
		return cbx_repname;
	}

	private JLabel getLbl_repname()
	{
		if (lbl_repname == null)
		{
			lbl_repname = new JLabel("Repository");
			lbl_repname.setFont(this.font);
			lbl_repname.setName("LBL_REPNAME");
		}
		return lbl_repname;
	}

	protected JButton getBtn_db_connect()
	{
		if (btn_db_connect == null)
		{
			btn_db_connect = new JButton("");
			btn_db_connect.setName("BTN_DB_CONNECT1");
			btn_db_connect.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent arg0)
				{
					if (btn_db_connect.getName().compareTo(GUIRepositoryLogin.BTN_DB_CONNECT1) == 0)
					{
						guireplogincontroller.loginDatabase();
					}
					else if (btn_db_connect.getName().compareTo(GUIRepositoryLogin.BTN_DB_CONNECT2) == 0)
					{
						guireplogincontroller.disconnectDatabase();
					}

				}
			});
		}
		return btn_db_connect;
	}

	protected JButton getBtn_rep_choose()
	{
		if (btn_rep_choose == null)
		{
			btn_rep_choose = new JButton();
			btn_rep_choose.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent arg0)
				{
					if (btn_rep_choose.getName().compareTo(GUIRepositoryLogin.BTN_REP_CHOOSE1) == 0)
					{
						// choose
						guireplogincontroller.chooseRepository();

					}
					else if (btn_rep_choose.getName().compareTo(GUIRepositoryLogin.BTN_REP_CHOOSE2) == 0)
					{
						// create
						guireplogincontroller.createRepository();
					}
				}
			});
			btn_rep_choose.setName("BTN_REP_CHOOSE1");
		}
		return btn_rep_choose;
	}

	private JPanel getPanel_1_2()
	{
		if (panel_repinfo == null)
		{
			panel_repinfo = new JPanel();
			panel_repinfo.setBorder(new MatteBorder(0, 1, 0, 0, (Color) GUILayout.color_dark_green));
			GroupLayout gl_panel_repinfo = new GroupLayout(panel_repinfo);
			gl_panel_repinfo.setHorizontalGroup(gl_panel_repinfo.createParallelGroup(Alignment.LEADING).addGroup(gl_panel_repinfo.createSequentialGroup().addContainerGap().addGroup(gl_panel_repinfo.createParallelGroup(Alignment.LEADING, false).addComponent(getLbl_repcreationdate(), GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addComponent(getLbl_repversion()).addComponent(getLbl_repcreator()).addComponent(getLbl_repdescription(), GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)).addPreferredGap(ComponentPlacement.UNRELATED).addGroup(gl_panel_repinfo.createParallelGroup(Alignment.LEADING).addComponent(getTxp_repdescription_dat(), GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE).addComponent(getLbl_repcreationdate_dat()).addComponent(getLbl_repversion_dat(), GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE).addComponent(getTxt_repcreator(), GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)).addContainerGap()));
			gl_panel_repinfo.setVerticalGroup(gl_panel_repinfo.createParallelGroup(Alignment.LEADING).addGroup(gl_panel_repinfo.createSequentialGroup().addGroup(gl_panel_repinfo.createParallelGroup(Alignment.BASELINE).addComponent(getLbl_repversion_dat()).addComponent(getLbl_repversion())).addPreferredGap(ComponentPlacement.UNRELATED).addGroup(gl_panel_repinfo.createParallelGroup(Alignment.BASELINE).addComponent(getLbl_repcreationdate_dat()).addComponent(getLbl_repcreationdate())).addPreferredGap(ComponentPlacement.UNRELATED).addGroup(gl_panel_repinfo.createParallelGroup(Alignment.BASELINE).addComponent(getLbl_repcreator()).addComponent(getTxt_repcreator(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)).addPreferredGap(ComponentPlacement.UNRELATED).addGroup(gl_panel_repinfo.createParallelGroup(Alignment.LEADING).addGroup(gl_panel_repinfo.createSequentialGroup().addComponent(getLbl_repdescription()).addContainerGap(90, Short.MAX_VALUE)).addComponent(getTxp_repdescription_dat(), GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE))));
			panel_repinfo.setLayout(gl_panel_repinfo);
		}
		return panel_repinfo;
	}

	private JLabel getLbl_repversion()
	{
		if (lbl_repversion == null)
		{
			lbl_repversion = new JLabel("");
			lbl_repversion.setName("LBL_REPVERSION");
		}
		return lbl_repversion;
	}

	private JLabel getLbl_repcreationdate()
	{
		if (lbl_repcreationdate == null)
		{
			lbl_repcreationdate = new JLabel("ccccccccccc");
			lbl_repcreationdate.setName("LBL_REPCREATIONDATE");
		}
		return lbl_repcreationdate;
	}

	private JLabel getLbl_repdescription()
	{
		if (lbl_repdescription == null)
		{
			lbl_repdescription = new JLabel("ccccccccccc");
			lbl_repdescription.setName("LBL_REPDESCRIPTION");
		}
		return lbl_repdescription;
	}

	protected JLabel getLbl_repversion_dat()
	{
		if (lbl_repversion_dat == null)
		{
			lbl_repversion_dat = new JLabel("");
		}
		return lbl_repversion_dat;
	}

	protected JLabel getLbl_repcreationdate_dat()
	{
		if (lbl_repcreationdate_dat == null)
		{
			lbl_repcreationdate_dat = new JLabel("ccccccccccc");
		}
		return lbl_repcreationdate_dat;
	}

	protected JTextPane getTxp_repdescription_dat()
	{
		if (txp_repdescription_dat == null)
		{
			txp_repdescription_dat = new JTextPane();
			txp_repdescription_dat.setEditable(false);
			txp_repdescription_dat.setBorder(new LineBorder(GUILayout.color_dark_green));
		}
		return txp_repdescription_dat;
	}

	protected JButton getBtn_repnew()
	{
		if (btn_repnew == null)
		{
			btn_repnew = new JButton("");
			btn_repnew.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent arg0)
				{
					guireplogincontroller.setNewRepository();
				}
			});
			btn_repnew.setIcon(new ImageIcon(GUIRepositoryLogin.class.getResource(SystemResourceIcons.ICON_REPOSITORY_CREATE)));
		}
		return btn_repnew;
	}

	private JLabel getLbl_repcreator()
	{
		if (lbl_repcreator == null)
		{
			lbl_repcreator = new JLabel("New label");
			lbl_repcreator.setName("LBL_REPCREATOR");
		}
		return lbl_repcreator;
	}

	protected JTextField getTxt_repcreator()
	{
		if (txt_repcreator == null)
		{
			txt_repcreator = new JTextField();
			txt_repcreator.setEditable(false);
			txt_repcreator.setBorder(new LineBorder(GUILayout.color_dark_green));
		}
		return txt_repcreator;
	}
}
