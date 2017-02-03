package roots.plugin.info.about.gui;

import javax.swing.JPanel;
import javax.swing.border.MatteBorder;
import java.awt.Color;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import roots.GUILayout;
import roots.gui.component.JLinkLabel;
import roots.plugin.info.about.translation.TPAbout;

import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JLayeredPane;
import javax.swing.SwingConstants;

public class GUIAbout extends JPanel
{
	private static final long serialVersionUID = -5083292513381756205L;
	private static final String TAB_TITLE_TAG = "TAB_TITLE_ABOUT";

	private final JPanel contentPanel = new JPanel();

	private GUIAboutController guiaboutcontroller;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLinkLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;
	private JLinkLabel lblNewLabel_8;
	private JLinkLabel lblNewLabel_9;
	private JLayeredPane layeredPane;
	private JLabel lblNewLabel_10;
	private JLabel lblNotiziaLogosCreated;
	private JLabel lblNewLabel_11;
	private JLinkLabel lblNewLabel_12;
	private JLabel lblNewLabel_13;
	private JLinkLabel lblNewLabel_14;
	private JLabel lblNewLabel_15;
	private JLabel lblNewLabel_16;
	private JLinkLabel lblNewLabel_17;
	private JLinkLabel lblNewLabel_18;
	private JLabel lblNewLabel_19;
	private JLabel lblNewLabel_20;
	private JLabel lblGplv;
	private JLinkLabel lblNewLabel_21;
	private JLinkLabel lblNewLabel_22;
	private JLabel lblNewLabel_23;
	private JLinkLabel lblNewLabel_24;
	private JLabel lblNewLabel_25;
	private JLinkLabel lblNewLabel_26;

	public GUIAbout(GUIAboutController guiaboutcontroller)
	{
		this.guiaboutcontroller = guiaboutcontroller;
		
		setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		contentPanel.setBorder(new MatteBorder(1, 20, 1, 1, (Color) GUILayout.color_dark_green));
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(getLblNewLabel_19(), GroupLayout.PREFERRED_SIZE, 830, Short.MAX_VALUE)
						.addComponent(getLblNewLabel_3())
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(getLblNewLabel())
								.addComponent(getLblNewLabel_1(), GroupLayout.PREFERRED_SIZE, 223, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPanel.createSequentialGroup()
									.addComponent(getLblNewLabel_2(), GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(getLblNewLabel_8(), GroupLayout.DEFAULT_SIZE, 491, Short.MAX_VALUE))
								.addComponent(getLblForfedreLogosCreated(), GroupLayout.DEFAULT_SIZE, 611, Short.MAX_VALUE))
							.addGap(219))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(10)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPanel.createSequentialGroup()
									.addComponent(getLblNewLabel_25())
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(getLblNewLabel_26(), GroupLayout.DEFAULT_SIZE, 527, Short.MAX_VALUE))
								.addGroup(gl_contentPanel.createSequentialGroup()
									.addComponent(getLblNewLabel_15())
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(getLblNewLabel_18(), GroupLayout.DEFAULT_SIZE, 518, Short.MAX_VALUE))
								.addGroup(gl_contentPanel.createSequentialGroup()
									.addComponent(getLblNewLabel_16())
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(getLblNewLabel_17(), GroupLayout.DEFAULT_SIZE, 745, Short.MAX_VALUE))
								.addGroup(gl_contentPanel.createSequentialGroup()
									.addComponent(getLblNewLabel_20())
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(getLblNewLabel_21(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPanel.createSequentialGroup()
									.addComponent(getLblNewLabel_13())
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(getLblNewLabel_14(), GroupLayout.DEFAULT_SIZE, 615, Short.MAX_VALUE))
								.addGroup(gl_contentPanel.createSequentialGroup()
									.addComponent(getLblNewLabel_4())
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(getLblNewLabel_9(), GroupLayout.DEFAULT_SIZE, 497, Short.MAX_VALUE))
								.addGroup(gl_contentPanel.createSequentialGroup()
									.addComponent(getLblNewLabel_11())
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(getLblNewLabel_12(), GroupLayout.DEFAULT_SIZE, 494, Short.MAX_VALUE))
								.addGroup(gl_contentPanel.createSequentialGroup()
									.addComponent(getLblNewLabel_5())
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(getLblNewLabel_6(), GroupLayout.DEFAULT_SIZE, 519, Short.MAX_VALUE))
								.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
									.addComponent(getLayeredPane(), GroupLayout.PREFERRED_SIZE, 215, GroupLayout.PREFERRED_SIZE)
									.addGroup(gl_contentPanel.createSequentialGroup()
										.addComponent(getLblGplv())
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(getLabel_1(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(getLabel_2())
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(getLabel_3(), GroupLayout.PREFERRED_SIZE, 359, GroupLayout.PREFERRED_SIZE)))))
						.addComponent(getLblNewLabel_7()))
					.addContainerGap())
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addComponent(getLayeredPane(), GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)
							.addGap(351))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addComponent(getLblNewLabel())
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(getLblNewLabel_1())
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(getLblNewLabel_2(), GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
								.addComponent(getLblNewLabel_8(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addComponent(getLblForfedreLogosCreated())
							.addGap(34)
							.addComponent(getLblNewLabel_3())
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(getLblNewLabel_4())
								.addComponent(getLblNewLabel_9(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(getLblNewLabel_5())
								.addComponent(getLblNewLabel_6(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(getLblNewLabel_11())
								.addComponent(getLblNewLabel_12(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(getLblNewLabel_25())
								.addComponent(getLblNewLabel_26(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(getLblNewLabel_13())
								.addComponent(getLblNewLabel_14(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(getLblNewLabel_15())
								.addComponent(getLblNewLabel_18(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(getLblNewLabel_16())
								.addComponent(getLblNewLabel_17(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(getLblNewLabel_21(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(getLblNewLabel_20()))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(getLblGplv())
								.addComponent(getLabel_1(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(getLabel_2())
								.addComponent(getLabel_3(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
							.addComponent(getLblNewLabel_7())
							.addGap(18)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(getLblNewLabel_19())
					.addContainerGap())
		);
		contentPanel.setLayout(gl_contentPanel);
		add(contentPanel);
	}

	public void do_translation(TPAbout tp) throws IOException
	{
		// change tab title
		this.guiaboutcontroller.changeTabTitle(tp.getLanguagePropertie(GUIAbout.TAB_TITLE_TAG));
	}

	private JLabel getLblNewLabel()
	{
		if (lblNewLabel == null)
		{
			lblNewLabel = new JLabel(this.guiaboutcontroller.getForfedreTitle());
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		}
		return lblNewLabel;
	}

	private JLabel getLblNewLabel_1()
	{
		if (lblNewLabel_1 == null)
		{
			lblNewLabel_1 = new JLabel("Version: " + this.guiaboutcontroller.getForfedreVersion());
		}
		return lblNewLabel_1;
	}

	private JLabel getLblNewLabel_2()
	{
		if (lblNewLabel_2 == null)
		{
			lblNewLabel_2 = new JLabel("License: GPLv3");
		}
		return lblNewLabel_2;
	}

	private JLabel getLblNewLabel_3()
	{
		if (lblNewLabel_3 == null)
		{
			lblNewLabel_3 = new JLabel("This product uses:");
		}
		return lblNewLabel_3;
	}

	private JLabel getLblNewLabel_4()
	{
		if (lblNewLabel_4 == null)
		{
			lblNewLabel_4 = new JLabel("Fugue Icons 3.3.3 - 2012 Yusuke Kamiyamane");
		}
		return lblNewLabel_4;
	}

	private JLabel getLblNewLabel_5()
	{
		if (lblNewLabel_5 == null)
		{
			lblNewLabel_5 = new JLabel("Creative Commons Attribution 3.0 License");
		}
		return lblNewLabel_5;
	}

	private JLabel getLblNewLabel_6()
	{
		if (lblNewLabel_6 == null)
		{
			lblNewLabel_6 = new JLinkLabel("http://creativecommons.org/licenses/by/3.0/");
		}
		return lblNewLabel_6;
	}

	private JLabel getLblNewLabel_7()
	{
		if (lblNewLabel_7 == null)
		{
			lblNewLabel_7 = new JLabel("");
			lblNewLabel_7.setIcon(new ImageIcon(GUIAbout.class.getResource("/roots/plugin/info/about/icons/gplv3.png")));
		}
		return lblNewLabel_7;
	}

	private JLabel getLblNewLabel_8()
	{
		if (lblNewLabel_8 == null)
		{
			lblNewLabel_8 = new JLinkLabel("http://www.gnu.org/licenses");
		}
		return lblNewLabel_8;
	}

	private JLabel getLblNewLabel_9()
	{
		if (lblNewLabel_9 == null)
		{
			lblNewLabel_9 = new JLinkLabel("http://p.yusukekamiyamane.com");
		}
		return lblNewLabel_9;
	}

	private JLayeredPane getLayeredPane()
	{
		if (layeredPane == null)
		{
			layeredPane = new JLayeredPane();
			layeredPane.add(getLblNewLabel_10());
		}
		return layeredPane;
	}

	private JLabel getLblNewLabel_10()
	{
		if (lblNewLabel_10 == null)
		{
			lblNewLabel_10 = new JLabel("");
			lblNewLabel_10.setHorizontalAlignment(SwingConstants.RIGHT);
			// lblNewLabel_10.setIcon(new
			// ImageIcon(GUIAbout.class.getResource("/forfedre/icons/???.png")));
			lblNewLabel_10.setBounds(56, 0, 159, 118);
		}
		return lblNewLabel_10;
	}

	private JLabel getLblForfedreLogosCreated()
	{
		if (lblNotiziaLogosCreated == null)
		{
			lblNotiziaLogosCreated = new JLabel("Roots logo by mnemotron");
		}
		return lblNotiziaLogosCreated;
	}

	private JLabel getLblNewLabel_11()
	{
		if (lblNewLabel_11 == null)
		{
			lblNewLabel_11 = new JLabel("Apache Commons\u2122 - commons validator 1.4.0");
		}
		return lblNewLabel_11;
	}

	private JLabel getLblNewLabel_12()
	{
		if (lblNewLabel_12 == null)
		{
			lblNewLabel_12 = new JLinkLabel("http://commons.apache.org/validator/");
		}
		return lblNewLabel_12;
	}

	private JLabel getLblNewLabel_13()
	{
		if (lblNewLabel_13 == null)
		{
			lblNewLabel_13 = new JLabel("Apache License Version 2.0");
		}
		return lblNewLabel_13;
	}

	private JLabel getLblNewLabel_14()
	{
		if (lblNewLabel_14 == null)
		{
			lblNewLabel_14 = new JLinkLabel("http://commons.apache.org/validator/license.html");
		}
		return lblNewLabel_14;
	}

	private JLabel getLblNewLabel_15()
	{
		if (lblNewLabel_15 == null)
		{
			lblNewLabel_15 = new JLabel("ORACLE\u00A9 - Sun - SwingLabs SwingX 1.6.3");
		}
		return lblNewLabel_15;
	}

	private JLabel getLblNewLabel_16()
	{
		if (lblNewLabel_16 == null)
		{
			lblNewLabel_16 = new JLabel("LGPLv2.1");
		}
		return lblNewLabel_16;
	}

	private JLabel getLblNewLabel_17()
	{
		if (lblNewLabel_17 == null)
		{
			lblNewLabel_17 = new JLinkLabel("http://www.opensource.org/licenses/lgpl-2.1.php");
		}
		return lblNewLabel_17;
	}

	private JLabel getLblNewLabel_18()
	{
		if (lblNewLabel_18 == null)
		{
			lblNewLabel_18 = new JLinkLabel("http://swingx.java.net/");
		}
		return lblNewLabel_18;
	}

	private JLabel getLblNewLabel_19()
	{
		if (lblNewLabel_19 == null)
		{
			lblNewLabel_19 = new JLabel("All logos and trademarks contained in this product are and remain the property of their respective owners.");
		}
		return lblNewLabel_19;
	}

	private JLabel getLblNewLabel_20()
	{
		if (lblNewLabel_20 == null)
		{
			lblNewLabel_20 = new JLabel("JIDE Software, Inc. - JIDE Common Layer 3.1.1");
		}
		return lblNewLabel_20;
	}

	private JLabel getLblGplv()
	{
		if (lblGplv == null)
		{
			lblGplv = new JLabel("GPLv3");
		}
		return lblGplv;
	}

	private JLabel getLblNewLabel_21()
	{
		if (lblNewLabel_21 == null)
		{
			lblNewLabel_21 = new JLinkLabel("http://java.net/projects/jide-oss/");
		}
		return lblNewLabel_21;
	}

	private JLabel getLabel_1()
	{
		if (lblNewLabel_22 == null)
		{
			lblNewLabel_22 = new JLinkLabel("http://www.gnu.org/licenses/");
		}
		return lblNewLabel_22;
	}

	private JLabel getLabel_2()
	{
		if (lblNewLabel_23 == null)
		{
			lblNewLabel_23 = new JLabel("- free commercial license");
		}
		return lblNewLabel_23;
	}

	private JLabel getLabel_3()
	{
		if (lblNewLabel_24 == null)
		{
			lblNewLabel_24 = new JLinkLabel("http://www.jidesoft.com/purchase/SLA.htm");
		}
		return lblNewLabel_24;
	}

	private JLabel getLblNewLabel_25()
	{
		if (lblNewLabel_25 == null)
		{
			lblNewLabel_25 = new JLabel("Apache Commons\u2122 - commons lang\u2122 3.1");
		}
		return lblNewLabel_25;
	}

	private JLabel getLblNewLabel_26()
	{
		if (lblNewLabel_26 == null)
		{
			lblNewLabel_26 = new JLinkLabel("http://commons.apache.org/lang/");
		}
		return lblNewLabel_26;
	}
}
