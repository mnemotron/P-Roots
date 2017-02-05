package roots.plugin.config.gui;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.io.IOException;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

import roots.translation.TPForfedre;

import javax.swing.JSplitPane;
import javax.swing.JScrollPane;

public class GUIConfig extends JPanel
{
	private static final long serialVersionUID = 1L;
	private static final String TAB_TITLE_TAG = "TAB_TITLE_CONFIG";
	private GUIConfigController guiconfigcontroller;
	private JTree tree;

	public GUIConfig(GUIConfigController p_guiconfigcontroller)
	{
		this.guiconfigcontroller = p_guiconfigcontroller;
		
		setLayout(new BorderLayout(0, 0));

		JSplitPane splitPane = new JSplitPane();
		add(splitPane, BorderLayout.CENTER);

		JScrollPane scrollPaneTree = new JScrollPane(this.get_Tree());
		
		splitPane.setLeftComponent(scrollPaneTree);

		JScrollPane scrollPane = new JScrollPane();
		splitPane.setRightComponent(scrollPane);

	}
	
	public void do_translation(TPForfedre tp) throws IOException
	{
		// change tab title
		this.guiconfigcontroller.changeTabTitle(tp.getLanguagePropertie(GUIConfig.TAB_TITLE_TAG));
	}
	
	private DefaultMutableTreeNode buildTree()
	{
		//root
		DefaultMutableTreeNode root = new DefaultMutableTreeNode();
		
		return root;
	}

	private JTree get_Tree()
	{
		if (tree == null)
		{
			this.tree = new JTree();
			this.tree.setMinimumSize(new Dimension());
		}

		return this.tree;
	}

}
