package roots.core.gui;

import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

import roots.logger.LogController;

public class GUILookAndFeel
{
	private final static String c_default_lookandfeel = "com.pagosoft.plaf.PgsLookAndFeel";
	
	public static LookAndFeelInfo[] getInstalledLookAndFeels()
	{
		LookAndFeelInfo laf[] = UIManager.getInstalledLookAndFeels();
		
		return laf;
	}
	
	public static void setDefaultLookAndFeel()
	{
		GUILookAndFeel.setLookAndFeel(c_default_lookandfeel);
	}
	
	public static String getDefaultLookAndFeel()
	{
		return c_default_lookandfeel;
	}

	public static void setLookAndFeel(String p_classname)
	{
		try
		{
			UIManager.setLookAndFeel(p_classname);
		} catch (Exception e)
		{
			LogController.error("Error setting look and feel: " + e);
		}
	}
	
}
