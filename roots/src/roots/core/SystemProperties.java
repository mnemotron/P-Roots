package roots.core;

public class SystemProperties
{
	public final static String DEFAULT_LOG_DIR = "logs";
	public final static String PLUGIN_DIR = "plugins";
	
	public final static String LOG_FILE_EXTENSION = ".log";
	
	public static final String CONFIG_FILE = "config.xml";

	public static String getFileSeparator()
	{
		return System.getProperty("file.separator");
	}

	public static String getCurrentUserDir()
	{
		return System.getProperty("user.dir");
	}

}
