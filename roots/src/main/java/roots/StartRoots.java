package roots;

import java.awt.EventQueue;
import roots.core.gui.GUICMain;

public class StartRoots
{

    public static void main(String[] args)
    {
	EventQueue.invokeLater(new Runnable()
	{
	    public void run()
	    {
		GUICMain guimaincontroller = null;

		try
		{
		    guimaincontroller = new GUICMain();

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
