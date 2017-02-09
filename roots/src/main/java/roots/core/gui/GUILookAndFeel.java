package roots.core.gui;

import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

import roots.logger.CLog;

public class GUILookAndFeel
{
	private final static String C_DEFAULT_LOOKANDFEEL_CLASSNAME = "com.pagosoft.plaf.PgsLookAndFeel";
	private final static String C_DEFAULT_LOOKANDFEEL_NAME = "PgsLookAndFeel";
	
	public static LookAndFeelInfo[] getInstalledLookAndFeels()
	{
		LookAndFeelInfo laf[] = UIManager.getInstalledLookAndFeels();
		
		return laf;
	}
	
	public static void setDefaultLookAndFeel()
	{
		GUILookAndFeel.setLookAndFeel(C_DEFAULT_LOOKANDFEEL_CLASSNAME);
	}
	
	public static String getDefaultLookAndFeelClassName()
	{
		return C_DEFAULT_LOOKANDFEEL_CLASSNAME;
	}
	
	public static String getDefaultLookAndFeelName()
	{
	    return C_DEFAULT_LOOKANDFEEL_NAME;
	}

	public static void setLookAndFeel(String p_classname)
	{
		try
		{
			UIManager.setLookAndFeel(p_classname);
		} catch (Exception e)
		{
			CLog.error("Error setting look and feel: " + e);
		}
	}
	
}
