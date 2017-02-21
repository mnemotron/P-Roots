package roots.plugin.programs.edit.person.gui.event;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import roots.plugin.programs.edit.person.gui.event.birth.GUIEventBirth;

import java.awt.BorderLayout;

public class GUIEvent extends JPanel
{
	private static final long serialVersionUID = 1L;
	private JTabbedPane tab_main;
	private JPanel pane_doc;
	private JPanel pane_media;

	public GUIEvent()
	{
		setLayout(new BorderLayout(0, 0));
		add(getTab_main(), BorderLayout.CENTER);

	}

	private JTabbedPane getTab_main()
	{
		if (tab_main == null)
		{
			tab_main = new JTabbedPane(JTabbedPane.TOP);
			tab_main.addTab("", null, getPane_document());
			tab_main.addTab("", null, getPane_media());
		}
		return tab_main;
	}

	private JPanel getPane_document()
	{
		if (pane_doc == null)
		{
			pane_doc = new GUIDocument();
		}
		return pane_doc;
	}

	private JPanel getPane_media()
	{
		if (pane_media == null)
		{
			pane_media = new GUIMedia();
		}
		return pane_media;
	}
}
