package roots.plugin.programs.edit.person.gui;

import java.awt.BorderLayout;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.ScrollPaneConstants;

import org.jdesktop.swingx.JXPanel;
import org.jdesktop.swingx.JXTree;

import roots.plugin.programs.edit.person.translation.TPEditPerson;

public class GUIEditPerson extends JPanel
{
	private static final long serialVersionUID = -4533535591153212858L;

	private static final String TAB_TITLE_TAG = "TAB_TITLE_EDIT_PERSON";

	private JSplitPane spl_main;
	private JScrollPane scrollp_tree;
	private JXTree tree;
	private JXPanel p_dummy;
	private GUICEditPerson guieditpersoncontroller;

	public GUIEditPerson(GUICEditPerson p_guieditpersoncontroller)
	{
		this.guieditpersoncontroller = p_guieditpersoncontroller;

		setBorder(null);
		setLayout(new BorderLayout(0, 0));
		add(getSpl_main(), BorderLayout.CENTER);
	}

	private JSplitPane getSpl_main()
	{
		if (spl_main == null)
		{
			spl_main = new JSplitPane();
			spl_main.setRightComponent(getP_dummy());
			spl_main.setLeftComponent(getScrollp_tree());
			spl_main.setAutoscrolls(false);
		}
		return spl_main;
	}

	private JXPanel getP_dummy()
	{
		if (p_dummy == null)
		{
			p_dummy = new JXPanel();
			p_dummy.setBorder(null);
		}
		return p_dummy;
	}

	private JScrollPane getScrollp_tree()
	{
		if (scrollp_tree == null)
		{
			scrollp_tree = new JScrollPane(getTree(), ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
			scrollp_tree.setBorder(BorderFactory.createEmptyBorder());
		}

		return scrollp_tree;
	}

	protected JXTree getTree()
	{
		if (tree == null)
		{
			tree = new JXTree();
		}
		return tree;
	}

	public void do_translation(TPEditPerson tp) throws IOException
	{
		// change tab title
		this.guieditpersoncontroller.changeTabTitle(tp.getLanguagePropertie(GUIEditPerson.TAB_TITLE_TAG));
	}

}
