package roots.core;

public class SystemProperties
{
	public final static String c_defaultlogdir = "logs";
	public final static String c_plugindir = "plugins";
	
	public final static String c_log_fileextension = ".log";
	
	public static final String c_config_file = "config.db";

	public static String getFileSeparator()
	{
		return System.getProperty("file.separator");
	}

	public static String getCurrentUserDir()
	{
		return System.getProperty("user.dir");
	}

}
