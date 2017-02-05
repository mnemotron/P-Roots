package roots.config.gui;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTree;
import javax.swing.JSplitPane;
import javax.swing.JScrollPane;

public class GUIConfig extends JPanel
{
	private static final long serialVersionUID = 1L;
	private GUIConfigController guiconfigcontroller;
	private JTree tree;

	public GUIConfig(GUIConfigController p_guiconfigcontroller)
	{
		this.guiconfigcontroller = p_guiconfigcontroller;
		
		setLayout(new BorderLayout(0, 0));

		JSplitPane splitPane = new JSplitPane();
		add(splitPane, BorderLayout.CENTER);

		splitPane.setLeftComponent(this.get_Tree());

		JScrollPane scrollPane = new JScrollPane();
		splitPane.setRightComponent(scrollPane);

	}

	private JTree get_Tree()
	{
		if (tree == null)
		{
			this.tree = new JTree();
		}

		return this.tree;
	}

}
