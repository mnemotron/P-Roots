package roots;

import java.awt.EventQueue;
import roots.core.gui.GUIMainController;

public class StartRoots
{

	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				GUIMainController guimaincontroller = null;
				
				try
				{
				    guimaincontroller = new GUIMainController();
					
					guimaincontroller.startGUI();
					
				} catch (Exception e)
				{
					guimaincontroller.logStackTrace(e.getStackTrace());
					guimaincontroller.logError(e.getMessage());
				}
			}
		});
	}

}
