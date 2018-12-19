package roots.plugin.misc;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateTimeFormat
{

	public final static String c_dd_MM_yyyy_point = "dd.MM.yyyy";
	public final static String c_dd_MM_yyyy_underline = "dd_MM_yyyy";
	public final static String c_yyyy_MM_dd_HH_mm_ss_point = "dd.MM.yyyy HH:mm:ss";
	public final static String c_yyyy_MM_dd_HH_mm_ss_S = "yyyy-MM-dd HH:mm:ss.S";
	public final static String c_dd_MMM_yyyy = "dd MMM yyyy";

	public static Date getCurrentDate()
	{
		return new Date();
	}

	public static String getCurrentDate(String p_datepattern)
	{
		Date l_date = new Date();

		SimpleDateFormat l_simpledateformat = new SimpleDateFormat(p_datepattern);

		return l_simpledateformat.format(l_date);
	}

	// TODO Vorsicht es wird nur Deutsch, Englisch, French unterst�tzt
	public static String parseAndFormatDate(String p_date, String p_sourcepattern, String p_destpattern)
	{
		SimpleDateFormat sdfdest = new SimpleDateFormat(p_destpattern);
		Date date = null;

		p_date.trim();

		try
		{
			SimpleDateFormat sdfsource = new SimpleDateFormat(p_sourcepattern);
			date = sdfsource.parse(p_date);
		} catch (ParseException e)
		{
			try
			{
				SimpleDateFormat sdfsource = new SimpleDateFormat(p_sourcepattern, Locale.ENGLISH);
				date = sdfsource.parse(p_date);
			} catch (ParseException e1)
			{
				try
				{
					SimpleDateFormat sdfsource = new SimpleDateFormat(p_sourcepattern, Locale.FRENCH);
					date = sdfsource.parse(p_date);
				} catch (ParseException e2)
				{
					return p_date;
				}
			}
		}
		return sdfdest.format(date);

	}

	public static String formatDate(Date p_date, String p_datepattern)
	{
		SimpleDateFormat l_simpledateformat = new SimpleDateFormat(p_datepattern);

		return l_simpledateformat.format(p_date);
	}

}
