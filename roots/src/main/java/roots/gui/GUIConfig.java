package roots.gui;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTree;
import javax.swing.JSplitPane;
import javax.swing.JScrollPane;

public class GUIConfig extends JPanel
{
	private static final long serialVersionUID = 1L;

	public GUIConfig()
	{
		setLayout(new BorderLayout(0, 0));
		
		JSplitPane splitPane = new JSplitPane();
		add(splitPane, BorderLayout.CENTER);
		
		JTree tree = new JTree();
		splitPane.setLeftComponent(tree);
		
		JScrollPane scrollPane = new JScrollPane();
		splitPane.setRightComponent(scrollPane);

	}

}
