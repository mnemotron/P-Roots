package roots.plugin.programs.edit.person.gui.events.birth;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.border.TitledBorder;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JRadioButton;

public class GUIEventBirth extends JPanel
{
	private static final long serialVersionUID = 1L;
	private JPanel panel_parents;
	private JPanel panel_birth;
	private JTextField txt_givenNames;
	private JTextField txt_birthName;
	private JLabel lbl_givenNames;
	private JLabel lbl_birthName;
	private JLabel lbl_sex;
	private JRadioButton rbtn_female;
	private JRadioButton rbtn_male;
	private JRadioButton rbtn_unknown;
	private JLabel lbl_birthDate;
	private JLabel lbl_birthTime;
	private JLabel lbl_birthPlace;

	public GUIEventBirth()
	{
		setLayout(new GridLayout(2, 1, 0, 10));
		add(getPanel_parents());
		add(getPanel_birth());

	}

	private JPanel getPanel_parents()
	{
		if (panel_parents == null)
		{
			panel_parents = new JPanel();
			panel_parents.setBorder(new TitledBorder(new MatteBorder(15, 1, 1, 1, (Color) new Color(0, 0, 0)), "Parents", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			GroupLayout gl_panel_parents = new GroupLayout(panel_parents);
			gl_panel_parents.setHorizontalGroup(gl_panel_parents.createParallelGroup(Alignment.LEADING).addGap(0, 1054, Short.MAX_VALUE));
			gl_panel_parents.setVerticalGroup(gl_panel_parents.createParallelGroup(Alignment.LEADING).addGap(0, 339, Short.MAX_VALUE));
			panel_parents.setLayout(gl_panel_parents);
		}
		return panel_parents;
	}

	private JPanel getPanel_birth()
	{
		if (panel_birth == null)
		{
			panel_birth = new JPanel();
			panel_birth.setBorder(new TitledBorder(new MatteBorder(15, 1, 1, 1, (Color) new Color(0, 0, 0)), "Birth", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			GroupLayout gl_panel_birth = new GroupLayout(panel_birth);
			gl_panel_birth.setHorizontalGroup(
				gl_panel_birth.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_panel_birth.createSequentialGroup()
						.addContainerGap()
						.addGroup(gl_panel_birth.createParallelGroup(Alignment.LEADING)
							.addComponent(getLbl_birthPlace(), GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
							.addGroup(gl_panel_birth.createSequentialGroup()
								.addGroup(gl_panel_birth.createParallelGroup(Alignment.LEADING)
									.addGroup(gl_panel_birth.createSequentialGroup()
										.addGroup(gl_panel_birth.createParallelGroup(Alignment.LEADING)
											.addComponent(getLbl_givenNames(), GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE)
											.addComponent(getLbl_birthName(), GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE)
											.addComponent(getLbl_birthDate(), GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
											.addComponent(getLbl_birthTime(), GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
										.addPreferredGap(ComponentPlacement.RELATED))
									.addGroup(gl_panel_birth.createSequentialGroup()
										.addComponent(getLbl_sex())
										.addGap(78)))
								.addGroup(gl_panel_birth.createParallelGroup(Alignment.LEADING)
									.addGroup(gl_panel_birth.createSequentialGroup()
										.addComponent(getRbtn_male(), GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE)
										.addGap(18)
										.addComponent(getRbtn_female(), GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE)
										.addGap(18)
										.addComponent(getRbtn_unknown(), GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addGap(662))
									.addGroup(Alignment.TRAILING, gl_panel_birth.createSequentialGroup()
										.addGroup(gl_panel_birth.createParallelGroup(Alignment.TRAILING, false)
											.addComponent(getTxt_birthName(), Alignment.LEADING)
											.addComponent(getTxt_givenNames(), Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 463, Short.MAX_VALUE))
										.addGap(461))))))
			);
			gl_panel_birth.setVerticalGroup(
				gl_panel_birth.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_panel_birth.createSequentialGroup()
						.addGap(27)
						.addGroup(gl_panel_birth.createParallelGroup(Alignment.BASELINE)
							.addComponent(getLbl_sex())
							.addComponent(getRbtn_unknown())
							.addComponent(getRbtn_male())
							.addComponent(getRbtn_female()))
						.addGap(52)
						.addGroup(gl_panel_birth.createParallelGroup(Alignment.BASELINE)
							.addComponent(getLbl_birthName())
							.addComponent(getTxt_birthName(), GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
						.addGap(27)
						.addGroup(gl_panel_birth.createParallelGroup(Alignment.BASELINE)
							.addComponent(getLbl_givenNames())
							.addComponent(getTxt_givenNames(), GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
						.addGap(18)
						.addComponent(getLbl_birthDate())
						.addGap(18)
						.addComponent(getLbl_birthTime())
						.addGap(18)
						.addComponent(getLbl_birthPlace())
						.addContainerGap(32, Short.MAX_VALUE))
			);
			panel_birth.setLayout(gl_panel_birth);
		}
		return panel_birth;
	}

	private JTextField getTxt_givenNames()
	{
		if (txt_givenNames == null)
		{
			txt_givenNames = new JTextField();
			txt_givenNames.setBorder(new LineBorder(new Color(0, 0, 0)));
			txt_givenNames.setColumns(10);
		}
		return txt_givenNames;
	}

	private JTextField getTxt_birthName()
	{
		if (txt_birthName == null)
		{
			txt_birthName = new JTextField();
			txt_birthName.setBorder(new LineBorder(new Color(0, 0, 0)));
			txt_birthName.setColumns(10);
		}
		return txt_birthName;
	}
	private JLabel getLbl_givenNames() {
		if (lbl_givenNames == null) {
			lbl_givenNames = new JLabel("Given Names:");
			lbl_givenNames.setLabelFor(getTxt_givenNames());
		}
		return lbl_givenNames;
	}
	private JLabel getLbl_birthName() {
		if (lbl_birthName == null) {
			lbl_birthName = new JLabel("Birth Name:");
			lbl_birthName.setLabelFor(getTxt_birthName());
		}
		return lbl_birthName;
	}
	private JLabel getLbl_sex() {
		if (lbl_sex == null) {
			lbl_sex = new JLabel("Sex:");
		}
		return lbl_sex;
	}
	private JRadioButton getRbtn_female() {
		if (rbtn_female == null) {
			rbtn_female = new JRadioButton("Female");
		}
		return rbtn_female;
	}
	private JRadioButton getRbtn_male() {
		if (rbtn_male == null) {
			rbtn_male = new JRadioButton("Male");
		}
		return rbtn_male;
	}
	private JRadioButton getRbtn_unknown() {
		if (rbtn_unknown == null) {
			rbtn_unknown = new JRadioButton("Unknown");
		}
		return rbtn_unknown;
	}
	private JLabel getLbl_birthDate() {
		if (lbl_birthDate == null) {
			lbl_birthDate = new JLabel("Birth Date:");
		}
		return lbl_birthDate;
	}
	private JLabel getLbl_birthTime() {
		if (lbl_birthTime == null) {
			lbl_birthTime = new JLabel("Birth Time:");
		}
		return lbl_birthTime;
	}
	private JLabel getLbl_birthPlace() {
		if (lbl_birthPlace == null) {
			lbl_birthPlace = new JLabel("Birth Place:");
		}
		return lbl_birthPlace;
	}
}
