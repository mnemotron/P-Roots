package roots.logger;

import org.apache.log4j.DailyRollingFileAppender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.apache.log4j.lf5.LF5Appender;
import org.apache.log4j.lf5.LogLevel;
import org.apache.log4j.lf5.viewer.LogBrokerMonitor;

import roots.core.SystemProperties;
import roots.misc.DateTimeFormat;

public class CLog
{

	private Logger logger;
	private PatternLayout patternlayout;
	private DailyRollingFileAppender fileappender;
	private boolean log;

	private static CLog logcontroller;

	private static LogBrokerMonitor logbrokermonitor;

	private final static String c_patternlayout = "%d{ISO8601} %-5p [%t] %c: %m%n";

	public static CLog getLogControllerInstance() throws Exception
	{
		if (CLog.logcontroller == null)
		{
			CLog.logcontroller = new CLog();
		}

		return CLog.logcontroller;
	}

	public CLog() throws Exception
	{
		this.log = true;

		this.ConfigureLogger();
	}

	public void ConfigureLogger() throws Exception
	{
		String l_path = new String();
		String l_userdir = SystemProperties.getCurrentUserDir();
		String l_fileseparator = SystemProperties.getFileSeparator();
		String l_currentdate = DateTimeFormat.getCurrentDate(DateTimeFormat.c_dd_MM_yyyy_underline);

		this.logger = Logger.getRootLogger();

		this.patternlayout = new PatternLayout(c_patternlayout);

		l_path = l_userdir + l_fileseparator + SystemProperties.c_defaultlogdir + l_fileseparator + l_currentdate + SystemProperties.c_log_fileextension;

		fileappender = new DailyRollingFileAppender(this.patternlayout, l_path, DateTimeFormat.c_dd_MM_yyyy_underline);

		logbrokermonitor = new LogBrokerMonitor(LogLevel.getLog4JLevels());
		// remove File-Menu
		logbrokermonitor.getBaseFrame().getJMenuBar().remove(0);
		
		LF5Appender lf5a = new LF5Appender(logbrokermonitor);
		logger.addAppender(lf5a);

		this.logger.addAppender(fileappender);

		this.logger.setLevel(Level.ALL);
	}

	public static LogBrokerMonitor getLogbrokermonitor()
	{
		try
		{
			CLog.getLogControllerInstance();
		
		} catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return CLog.logbrokermonitor;
	}

	public static void info(Object p_info)
	{
		try
		{
			CLog logc = CLog.getLogControllerInstance();

			if (logc.log)
			{
				logc.logger.info(p_info);
			}

		} catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void printStackTrace(StackTraceElement[] p_stacktrace)
	{
		try
		{

			CLog logc = CLog.getLogControllerInstance();

			if (logc.log)
			{

				StringBuffer sb = new StringBuffer();

				sb.append("Stack Trace:" + '\n');

				for (StackTraceElement st : p_stacktrace)
				{
					sb.append(st.toString() + '\n');
				}

				logc.logger.error(sb.toString());

			}

		} catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void error(Object p_error)
	{
		try
		{
			CLog logc = CLog.getLogControllerInstance();

			if (logc.log)
			{
				logc.logger.error(p_error);
			}

		} catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void setLog(boolean p_log)
	{
		try
		{
			CLog.getLogControllerInstance().log = p_log;
		} catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
