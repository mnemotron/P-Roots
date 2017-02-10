package roots.core.gui;

import java.io.IOException;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import roots.entities.Repinfo;

import roots.config.ConfigEntity;
import roots.core.hibernate.CHibernate;
import roots.core.hibernate.CHibernate.databases;
import roots.misc.DateTimeFormat;
import roots.translation.ITranslation;

public class GUICRepositoryLogin implements ITranslation
{
	private static final String ROOTSDB_DESCRIPTION = "Roots DB";
	private static final String MYSQL_DESCRIPTION = "MySQL 3.23, 4.0, 4.1, 5.0";

	private GUIRepositoryLogin guireplogin;
	private GUICMain guimaincontroller;

	public GUICRepositoryLogin(GUICMain p_guimaincontroller)
	{
		this.guimaincontroller = p_guimaincontroller;

		// init GUI Repository Login
		guireplogin = new GUIRepositoryLogin(this);

		// init GUI
		initCbxDatabases();

		setStatusInit();

		if (this.guimaincontroller.getGuimainmodel().isConnected())
		{
			List<Repinfo> list_repinfo = this.guimaincontroller.getGuimainmodel().selectAllRepinfo();
			this.dbConnected(list_repinfo);
			this.setStatusChooseRep(list_repinfo);
			this.chooseRepository(this.guimaincontroller.getGuimainmodel().getRepinfo());
			this.showSelectedRepository();
		}
	}

	private void setStatusNewRep()
	{
		guireplogin.getCbx_database().setEnabled(false);
		guireplogin.getTxf_db_location().setEnabled(false);
		guireplogin.getTxf_db_name().setEnabled(false);
		guireplogin.getTextField_1().setEnabled(false);
		guireplogin.getTextField_1_1().setEnabled(false);
		guireplogin.getCbx_account_spass().setEnabled(false);

		guireplogin.getCbx_repname().setEnabled(true);
		guireplogin.getCbx_repname().setEditable(true);
		guireplogin.getBtn_repnew().setEnabled(false);
		guireplogin.getTxp_repdescription_dat().setEnabled(true);
		guireplogin.getTxp_repdescription_dat().setEditable(true);
		guireplogin.getBtn_rep_choose().setEnabled(true);

		guireplogin.getCbx_repname().removeAllItems();
		guireplogin.getLbl_repcreationdate_dat().setText(DateTimeFormat.getCurrentDate(DateTimeFormat.c_dd_MM_yyyy_point));
		guireplogin.getLbl_repversion_dat().setText(CHibernate.REPOSITORY_VERSION);
		guireplogin.getTxt_repcreator().setEditable(true);
		guireplogin.getTxt_repcreator().setText(null);
		guireplogin.getTxp_repdescription_dat().setText(null);

		guireplogin.getBtn_rep_choose().setName(GUIRepositoryLogin.BTN_REP_CHOOSE2);
		do_translation(guimaincontroller.getConfigEntity().getLanguage());

	}

	private void setStatusChooseRep(List<Repinfo> p_listrepo)
	{
		// set accessibility
		guireplogin.getCbx_database().setEnabled(false);
		guireplogin.getTxf_db_location().setEnabled(false);
		guireplogin.getTxf_db_name().setEnabled(false);
		guireplogin.getTextField_1().setEnabled(false);
		guireplogin.getTextField_1_1().setEnabled(false);
		guireplogin.getCbx_account_spass().setEnabled(false);

		guireplogin.getCbx_repname().setEnabled(true);
		guireplogin.getCbx_repname().setEditable(false);
		guireplogin.getBtn_repnew().setEnabled(true);
		guireplogin.getTxp_repdescription_dat().setEnabled(true);
		guireplogin.getTxp_repdescription_dat().setEditable(false);
		guireplogin.getBtn_rep_choose().setEnabled(false);

		guireplogin.getBtn_rep_choose().setName(GUIRepositoryLogin.BTN_REP_CHOOSE1);
		do_translation(guimaincontroller.getConfigEntity().getLanguage());

		// set selected repositories
		guireplogin.getCbx_repname().removeAllItems();

		Iterator<?> iterator = p_listrepo.iterator();

		while (iterator.hasNext())
		{
			Repinfo repinfo = (Repinfo) iterator.next();

			ComboBoxRepKey crepk = new ComboBoxRepKey(repinfo);

			guireplogin.getCbx_repname().addItem(crepk);
		}

	}

	private void initCbxDatabases()
	{
		// init database combobox
		guireplogin.getCbx_database().removeAllItems();

		for (CHibernate.databases db : CHibernate.databases.values())
		{
			ComboBoxKey key = null;

			switch (db)
			{
				case FORFEDREDB:
					key = new ComboBoxKey(db, GUICRepositoryLogin.ROOTSDB_DESCRIPTION);
					break;

				case MYSQL:
					key = new ComboBoxKey(db, GUICRepositoryLogin.MYSQL_DESCRIPTION);
					break;
			}

			guireplogin.getCbx_database().addItem(key);
		}
	}

	private void setStatusInit()
	{
		// set accessibility
		guireplogin.getCbx_database().setEnabled(true);
		guireplogin.getTxf_db_location().setEnabled(true);
		guireplogin.getTxf_db_name().setEnabled(true);
		guireplogin.getTextField_1().setEnabled(true);
		guireplogin.getTextField_1_1().setEnabled(true);
		guireplogin.getCbx_account_spass().setEnabled(true);
		guireplogin.getBtn_db_connect().setEnabled(true);

		guireplogin.getCbx_repname().setEnabled(false);
		guireplogin.getCbx_repname().setEditable(false);
		guireplogin.getBtn_repnew().setEnabled(false);
		guireplogin.getTxt_repcreator().setEditable(false);
		guireplogin.getTxp_repdescription_dat().setEnabled(false);
		guireplogin.getTxp_repdescription_dat().setEditable(false);
		guireplogin.getBtn_rep_choose().setEnabled(false);

		ConfigEntity config = guimaincontroller.getConfigEntity();

		if (config != null)
		{

			MComboBoxKey.setSelectedDatabaseItem(config.getDatabase());
			guireplogin.getTxf_db_location().setText(config.getDblocation());
			guireplogin.getTxf_db_name().setText(config.getDbname());
			guireplogin.getCbx_account_spass().setSelected(config.isKeeppassword());
			if (config.isKeeppassword())
			{
				guireplogin.getTextField_1().setText(config.getDbusername());
				guireplogin.getTextField_1_1().setText(config.getDbpassword());
			}

			if (config.getDatabase() == databases.FORFEDREDB)
			{
				guireplogin.getTxf_db_location().setEnabled(false);
				guireplogin.getTxf_db_name().setEnabled(false);
				guireplogin.getTextField_1().setEnabled(false);
				guireplogin.getTextField_1_1().setEnabled(false);
				guireplogin.getCbx_account_spass().setEnabled(false);

				guireplogin.getTxf_db_location().setText(CHibernate.ROOTS_DB_LOC);
				guireplogin.getTxf_db_name().setText(CHibernate.ROOTS_DB_CURL);
				guireplogin.getTextField_1().setText(CHibernate.HSQLDB_USER);
				guireplogin.getTextField_1_1().setText(CHibernate.HSQLDB_PASSWORD);
				guireplogin.getCbx_account_spass().setSelected(false);
			}

		}
		else
		{
			guireplogin.getTxf_db_location().setText(null);
			guireplogin.getTxf_db_name().setText(null);
			guireplogin.getTextField_1().setText(null);
			guireplogin.getTextField_1_1().setText(null);
			guireplogin.getCbx_account_spass().setSelected(false);
		}

		guireplogin.getBtn_db_connect().setName(GUIRepositoryLogin.BTN_DB_CONNECT1);
		guireplogin.getBtn_rep_choose().setName(GUIRepositoryLogin.BTN_REP_CHOOSE1);

		guireplogin.getCbx_repname().removeAllItems();
		guireplogin.getLbl_repversion_dat().setText(null);
		guireplogin.getLbl_repcreationdate_dat().setText(null);
		guireplogin.getTxt_repcreator().setText(null);
		guireplogin.getTxp_repdescription_dat().setText(null);

		do_translation(guimaincontroller.getConfigEntity().getLanguage());
	}

	public void dbConnected(List<Repinfo> p_replist)
	{
		if (p_replist.isEmpty())
		{
			setStatusNewRep();
		}
		else
		{
			setStatusChooseRep(p_replist);
		}

		guireplogin.getBtn_db_connect().setEnabled(true);

		guireplogin.getBtn_db_connect().setName(GUIRepositoryLogin.BTN_DB_CONNECT2);

		do_translation(guimaincontroller.getConfigEntity().getLanguage());
	}

	public void dbConnectionFailure()
	{
		guireplogin.getBtn_db_connect().setEnabled(true);

		do_translation(guimaincontroller.getConfigEntity().getLanguage());
	}

	public void disconnectDatabase()
	{
		this.setStatusInit();

		this.guimaincontroller.disconnectDatabase();

		do_translation(guimaincontroller.getConfigEntity().getLanguage());
	}

	public void loginDatabase()
	{
		// get login data
		ComboBoxKey comboboxkey = MComboBoxKey.getSelectedComboBoxKeyItem();
		String dblocation = guireplogin.getTxf_db_location().getText();
		String dbname = guireplogin.getTxf_db_name().getText();
		String username = guireplogin.getTextField_1().getText();
		String password = guireplogin.getTextField_1_1().getText();
		boolean keeppassword = guireplogin.getCbx_account_spass().isSelected();

		// TODO check parameter

		// login database
		this.guimaincontroller.loginDatabase(comboboxkey.getDatabase(), dblocation, dbname, username, password, keeppassword);

		guireplogin.getBtn_db_connect().setEnabled(false);
	}

	public GUIRepositoryLogin getProgram()
	{
		return this.guireplogin;
	}

	protected void actionSelectedDatabase()
	{
		ComboBoxKey comboboxkey = MComboBoxKey.getSelectedComboBoxKeyItem();

		if (comboboxkey == null)
		{
			guireplogin.getTxf_db_location().setText(null);
			guireplogin.getTxf_db_name().setText(null);
			guireplogin.getTextField_1().setText(null);
			guireplogin.getTextField_1_1().setText(null);
			guireplogin.getCbx_account_spass().setSelected(false);
			return;
		}

		switch (comboboxkey.getDatabase())
		{
			case FORFEDREDB:
				guireplogin.getTxf_db_location().setEnabled(false);
				guireplogin.getTxf_db_name().setEnabled(false);
				guireplogin.getTextField_1().setEnabled(false);
				guireplogin.getTextField_1_1().setEnabled(false);
				guireplogin.getCbx_account_spass().setEnabled(false);

				guireplogin.getTxf_db_location().setText(CHibernate.ROOTS_DB_LOC);
				guireplogin.getTxf_db_name().setText(CHibernate.ROOTS_DB_CURL);
				guireplogin.getTextField_1().setText(CHibernate.HSQLDB_USER);
				guireplogin.getTextField_1_1().setText(null);
				guireplogin.getCbx_account_spass().setSelected(false);
				break;
			default:

				guireplogin.getTxf_db_location().setEnabled(true);
				guireplogin.getTxf_db_name().setEnabled(true);
				guireplogin.getTextField_1().setEnabled(true);
				guireplogin.getTextField_1_1().setEnabled(true);
				guireplogin.getCbx_account_spass().setEnabled(true);

				guireplogin.getTxf_db_location().setText(null);
				guireplogin.getTxf_db_name().setText(null);
				guireplogin.getTextField_1().setText(null);
				guireplogin.getTextField_1_1().setText(null);
				guireplogin.getCbx_account_spass().setSelected(false);

				break;
		}
	}

	protected void chooseRepository(Repinfo repinfo)
	{
		MComboBoxRepKey model_cbrk = (MComboBoxRepKey) this.guireplogin.getCbx_repname().getModel();
		model_cbrk.setSelectedRepinfoItem(repinfo);
		guimaincontroller.chooseRepository(repinfo);
	}

	protected void chooseRepository()
	{
		MComboBoxRepKey model_cbrk = (MComboBoxRepKey) this.guireplogin.getCbx_repname().getModel();
		ComboBoxRepKey ck =  model_cbrk.getSelectedComboBoxKeyItem();

		guimaincontroller.chooseRepository(ck.getRepinfo());

		guimaincontroller.closeGUIRepositoryLogin();
	}

	protected void createRepository()
	{

		String newrepname = (String) guireplogin.getCbx_repname().getSelectedItem();
		String repdesc = guireplogin.getTxp_repdescription_dat().getText();
		String repcreator = guireplogin.getTxt_repcreator().getText();

		guimaincontroller.createRepository(newrepname, repdesc, repcreator);

		guimaincontroller.closeGUIRepositoryLogin();
	}

	protected void setNewRepository()
	{
		setStatusNewRep();
	}

	protected void showSelectedRepository()
	{
		MComboBoxRepKey model_cbrk = (MComboBoxRepKey) this.guireplogin.getCbx_repname().getModel();
		ComboBoxRepKey ck =  model_cbrk.getSelectedComboBoxKeyItem();

		if (ck.getNewrepname() == null)
		{
			guireplogin.getLbl_repversion_dat().setText(ck.getRepinfo().getRepversion());

			Date date = ck.getRepinfo().getRepcreationdate();
			String strdate = DateTimeFormat.formatDate(date, DateTimeFormat.c_yyyy_MM_dd_HH_mm_ss_point);
			guireplogin.getLbl_repcreationdate_dat().setText(strdate);

			guireplogin.getTxp_repdescription_dat().setText(ck.getRepinfo().getRepdescription());
			guireplogin.getTxt_repcreator().setText(ck.getRepinfo().getRepcreator());
			guireplogin.getBtn_rep_choose().setEnabled(true);
		}
	}

	@Override
	public void do_translation(ITranslation.enum_language p_language)
	{
		try
		{
			this.guireplogin.do_translation(p_language);
		} catch (IOException e)
		{
			this.guimaincontroller.logStackTrace(e.getStackTrace());
			this.guimaincontroller.logError(e.getMessage());
		}
	}

	protected void changeTabTitle(String p_title)
	{
		this.guimaincontroller.changeTabTitle(this.guireplogin, p_title);
	}
}
