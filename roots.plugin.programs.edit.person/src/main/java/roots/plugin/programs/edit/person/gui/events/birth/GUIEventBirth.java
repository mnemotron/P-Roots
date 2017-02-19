package roots.plugin.programs.edit.person.gui.events.birth;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.border.TitledBorder;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class GUIEventBirth extends JPanel
{
	private static final long serialVersionUID = 1L;
	private JPanel panel_parents;
	private JPanel panel_birth;

	public GUIEventBirth()
	{
		setLayout(new GridLayout(2, 1, 0, 10));
		add(getPanel_parents());
		add(getPanel_birth());

	}
	private JPanel getPanel_parents() {
		if (panel_parents == null) {
			panel_parents = new JPanel();
			panel_parents.setBorder(new TitledBorder(new MatteBorder(15, 1, 1, 1, (Color) new Color(0, 0, 0)), "Parents", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			GroupLayout gl_panel_parents = new GroupLayout(panel_parents);
			gl_panel_parents.setHorizontalGroup(
				gl_panel_parents.createParallelGroup(Alignment.LEADING)
					.addGap(0, 1054, Short.MAX_VALUE)
			);
			gl_panel_parents.setVerticalGroup(
				gl_panel_parents.createParallelGroup(Alignment.LEADING)
					.addGap(0, 339, Short.MAX_VALUE)
			);
			panel_parents.setLayout(gl_panel_parents);
		}
		return panel_parents;
	}
	private JPanel getPanel_birth() {
		if (panel_birth == null) {
			panel_birth = new JPanel();
			panel_birth.setBorder(new TitledBorder(new MatteBorder(15, 1, 1, 1, (Color) new Color(0, 0, 0)), "Birth", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			GroupLayout gl_panel_birth = new GroupLayout(panel_birth);
			gl_panel_birth.setHorizontalGroup(
				gl_panel_birth.createParallelGroup(Alignment.LEADING)
					.addGap(0, 1054, Short.MAX_VALUE)
			);
			gl_panel_birth.setVerticalGroup(
				gl_panel_birth.createParallelGroup(Alignment.LEADING)
					.addGap(0, 339, Short.MAX_VALUE)
			);
			panel_birth.setLayout(gl_panel_birth);
		}
		return panel_birth;
	}
}
