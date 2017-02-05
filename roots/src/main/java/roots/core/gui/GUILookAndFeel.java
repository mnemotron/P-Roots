package roots.core.gui;

import javax.swing.*;

public class GUILookAndFeel
{

	public enum Lookandfeel
	{
		NATIVE, JAVA, MOTIF
	}

	public static void setLookAndFeel(Lookandfeel p_lookandfeel)
	{
		switch (p_lookandfeel)
		{
		case NATIVE:
			GUILookAndFeel.setNativeLookAndFeel();
			break;
		case JAVA:
			GUILookAndFeel.setJavaLookAndFeel();
			break;
		case MOTIF:
			GUILookAndFeel.setMotifLookAndFeel();
			break;
		}
	}

	private static void setNativeLookAndFeel()
	{
		try
		{
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e)
		{
			System.out.println("Error setting native LAF: " + e);
		}
	}

	private static void setJavaLookAndFeel()
	{
		try
		{
			UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
		} catch (Exception e)
		{
			System.out.println("Error setting Java LAF: " + e);
		}
	}

	private static void setMotifLookAndFeel()
	{
		try
		{
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
		} catch (Exception e)
		{
			System.out.println("Error setting Motif LAF: " + e);
		}
	}
}
