package roots.core.gui;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.plaf.basic.BasicButtonUI;

import roots.GUILayout;
import roots.plugin.IPlugin;

public class TabButtonComponent extends JPanel
{
	private static final long serialVersionUID = 6707757649800174730L;

	private final GUICMain guimaincontroller;
	private final JPanel panel;
	private final IPlugin iplugin;
	private final JTabbedPane main_tab;

	public TabButtonComponent(final GUICMain guimaincontroller, final JTabbedPane p_main_tab, ImageIcon ico, final JPanel panel, final IPlugin p_iplugin)
	{

		super(new FlowLayout(FlowLayout.LEFT, 0, 0));

		this.guimaincontroller = guimaincontroller;
		this.main_tab = p_main_tab;
		this.panel = panel;
		this.iplugin = p_iplugin;

		this.setOpaque(false);

		JLabel label = new JLabel(ico)
		{
			private static final long serialVersionUID = 7278426170651786591L;

			public String getText()
			{
				int i = main_tab.indexOfTabComponent(TabButtonComponent.this);
				if (i != -1)
				{
					return main_tab.getTitleAt(i);
				}
				return null;
			}
		};

		this.add(label);

		label.setBorder(BorderFactory.createEmptyBorder(2, 0, 0, 2));

		JButton button = new TabButton();

		this.add(button);

		this.setBorder(BorderFactory.createEmptyBorder(2, 0, 0, 0));
	}

	private class TabButton extends JButton implements ActionListener
	{
		private static final long serialVersionUID = 6561792430958688796L;

		public TabButton()
		{
			int size = 18;

			setPreferredSize(new Dimension(size, size));

			setUI(new BasicButtonUI());

			setContentAreaFilled(false);

			setFocusable(false);

			setBorder(BorderFactory.createEmptyBorder());

			setBorderPainted(false);

			addMouseListener(buttonMouseListener);

			setRolloverEnabled(true);

			addActionListener(this);
		}

		public void actionPerformed(ActionEvent e)
		{
			int i = main_tab.indexOfTabComponent(TabButtonComponent.this);

			if (i != -1)
			{
				guimaincontroller.closeProgram(panel, iplugin);
			}
		}

		public void updateUI()
		{
		}

		protected void paintComponent(Graphics g)
		{
			super.paintComponent(g);

			Graphics2D g2 = (Graphics2D) g.create();

			if (getModel().isPressed())
			{
				g2.translate(1, 1);
			}
			g2.setStroke(new BasicStroke(2));
			g2.setColor(Color.BLACK);
			if (getModel().isRollover())
			{
				g2.setColor(GUILayout.color_dark_green);
			}
			int delta = 6;
			g2.drawLine(delta, delta+1, getWidth() - delta, getHeight() - delta+1 );
			g2.drawLine(getWidth() - delta, delta+1, delta, getHeight() - delta+1);
			g2.dispose();
		}
	}

	private final static MouseListener buttonMouseListener = new MouseAdapter()
	{
		public void mouseEntered(MouseEvent e)
		{
			Component component = e.getComponent();
			if (component instanceof AbstractButton)
			{
				AbstractButton button = (AbstractButton) component;
				button.setBorderPainted(true);
			}
		}

		public void mouseExited(MouseEvent e)
		{
			Component component = e.getComponent();
			if (component instanceof AbstractButton)
			{
				AbstractButton button = (AbstractButton) component;
				button.setBorderPainted(false);
			}
		}
	};
}
