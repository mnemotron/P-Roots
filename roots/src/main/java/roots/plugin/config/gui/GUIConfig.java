package roots.plugin.config.gui;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.io.IOException;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreeSelectionModel;

import org.jdesktop.swingx.JXTree;
import org.jdesktop.swingx.tree.DefaultXTreeCellRenderer;

import roots.core.SystemResourceIcons;
import roots.translation.TPForfedre;

import javax.swing.JSplitPane;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.JScrollPane;

public class GUIConfig extends JPanel
{
    private static final long serialVersionUID = 1L;
    private static final String C_TAB_TITLE_TAG = "TAB_TITLE_CONFIG";
    private static final String C_MI_ROOTS_CONFIG_TREE_ITEM_LAF = "MI_ROOTS_CONFIG_TREE_ITEM_LAF";
    private GUICConfig guiconfigcontroller;
    private JXTree tree;
    private JSplitPane splitPane;

    public GUIConfig(GUICConfig p_guiconfigcontroller)
    {
	this.guiconfigcontroller = p_guiconfigcontroller;

	setLayout(new BorderLayout(0, 0));

	this.splitPane = new JSplitPane();
	add(splitPane, BorderLayout.CENTER);

	JScrollPane scrollPaneTree = new JScrollPane(this.getTree());

	splitPane.setLeftComponent(scrollPaneTree);
    }

    public void do_translation(TPForfedre tp) throws IOException
    {
	// change tab title
	this.guiconfigcontroller.changeTabTitle(tp.getLanguagePropertie(GUIConfig.C_TAB_TITLE_TAG));

	// change tree item text
	TreeModel tm = tree.getModel();
	int count = tm.getChildCount(tm.getRoot());

	for (int i = 0; i < count; i++)
	{
	    DefaultMutableTreeNode treeNode = (DefaultMutableTreeNode) tm.getChild(tm.getRoot(), i);

	    TreeEntity treeEntity = (TreeEntity) treeNode.getUserObject();

	    treeEntity.setNodeDescription(tp.getLanguagePropertie(GUIConfig.C_MI_ROOTS_CONFIG_TREE_ITEM_LAF));
	}

	// change pane text
	
	tree.updateUI();
    }

    private JXTree getTree()
    {
	if (tree == null)
	{
	    this.tree = new JXTree(this.buildTree());
	    this.tree.setMinimumSize(new Dimension());
	    this.tree.setRootVisible(false);
	    this.tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);

	    this.tree.addTreeSelectionListener(new TreeSelectionListener()
	    {
		@Override
		public void valueChanged(TreeSelectionEvent e)
		{

		    DefaultMutableTreeNode node = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();

		    if (node == null)
		    {
			return;
		    }

		    Object nodeObject = node.getUserObject();

		    if (node.isLeaf())
		    {
			TreeEntity treeEntity = (TreeEntity) nodeObject;
			openPane(treeEntity);
		    }
		}
	    });

	    this.tree.setCellRenderer(new DefaultXTreeCellRenderer()
	    {
		private static final long serialVersionUID = 1L;

		@Override
		public Component getTreeCellRendererComponent(JTree tree, Object value, boolean selected,
			boolean expanded, boolean isLeaf, int row, boolean focused)
		{
		    Component c = super.getTreeCellRendererComponent(tree, value, selected, expanded, isLeaf, row,
			    focused);

		    DefaultMutableTreeNode treeNode = (DefaultMutableTreeNode) value;

		    Object obj = treeNode.getUserObject();

		    TreeEntity treeEntity = (TreeEntity) obj;

		    if (treeNode.isLeaf())
		    {
			setLeafIcon(new ImageIcon(this.getClass().getResource(treeEntity.getIcoLeaf())));
		    }

		    return c;
		}
	    });
	}

	return this.tree;
    }

    private DefaultMutableTreeNode buildTree()
    {
	// root
	DefaultMutableTreeNode root = new DefaultMutableTreeNode();

	// children
	DefaultMutableTreeNode leaf_lookandfeel = new DefaultMutableTreeNode(this.getTreeItemLookAndFeel());

	root.add(leaf_lookandfeel);

	return root;
    }

    private TreeEntity getTreeItemLookAndFeel()
    {
	TreeEntity te = new TreeEntity("Look And Feel", TreeEntity.NodeID.CONFIG_LOOK_AND_FEEL,
		SystemResourceIcons.ICON_CONFIG_TREE_LEAF_LOOKANDFEEL);

	return te;
    }

    private void openPane(TreeEntity treeEntity)
    {
	switch (treeEntity.getNodeID())
	{
	case CONFIG_LOOK_AND_FEEL:
	    GUIPConfigLAF pane = new GUIPConfigLAF(this.guiconfigcontroller);
	    splitPane.setRightComponent(pane);
	    break;
	}
    }
}
