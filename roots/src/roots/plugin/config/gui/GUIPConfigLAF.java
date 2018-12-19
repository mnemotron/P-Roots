package roots.plugin.config.gui;

import javax.swing.JPanel;
import javax.swing.UIManager.LookAndFeelInfo;
import org.jdesktop.swingx.JXButton;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIPConfigLAF extends JPanel
{
	private static final long serialVersionUID = 1L;

	private GUICConfig guicconfig;

	public GUIPConfigLAF(GUICConfig guicconfig)
	{
		this.guicconfig = guicconfig;

		initialize();
	}

	private void initialize()
	{
		setLayout(new GridLayout(2, 2, 10, 10));

		// set default look and feel
		JXButton btn_dlaf = new JXButton(this.guicconfig.getDefaultLookAndFeelName());
		btn_dlaf.setName(this.guicconfig.getDefaultLookAndFeelClassName());
		btn_dlaf.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				guicconfig.setLookAndFeel(btn_dlaf.getName());
				guicconfig.saveLookAndFeel(btn_dlaf.getName());
				guicconfig.updateGUI();
			}
		});
		add(btn_dlaf);

		// set installed look and feels
		LookAndFeelInfo ilaf[] = this.guicconfig.getInstalledLookAndFeels();

		for (int i = 0; i < ilaf.length; i++)
		{
			JXButton btn_laf = new JXButton(ilaf[i].getName());
			btn_laf.setName(ilaf[i].getClassName());
			btn_laf.addActionListener(new ActionListener()
			{
				@Override
				public void actionPerformed(ActionEvent e)
				{
					guicconfig.setLookAndFeel(btn_laf.getName());
					guicconfig.saveLookAndFeel(btn_laf.getName());
					guicconfig.updateGUI();
				}
			});

			add(btn_laf);
		}

	}
}
