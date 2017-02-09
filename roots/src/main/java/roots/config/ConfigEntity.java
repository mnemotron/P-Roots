package roots.config;

import javax.xml.bind.annotation.XmlRootElement;

import roots.core.gui.GUILookAndFeel;
import roots.core.hibernate.CHibernate;
import roots.translation.ITranslation;

@XmlRootElement
public class ConfigEntity
{

	private static final String c_forfedre_version = "1.0.0-alpha";
	private static final String c_forfedre_title = "Roots";

	private String forfedre_version;
	private ITranslation.enum_language language;
	private String LAFClassName;

	private CHibernate.databases database;
	private String dbname;
	private String dblocation;
	private String dbusername;
	private String dbpassword;
	private boolean keeppassword;
	
	private boolean log;

	public ConfigEntity()
	{
		this.forfedre_version = ConfigEntity.c_forfedre_version;
		this.language = ITranslation.enum_language.en;
		this.LAFClassName = GUILookAndFeel.getDefaultLookAndFeelClassName();

		this.database = CHibernate.databases.FORFEDREDB;
		this.dbname = CHibernate.c_curl_forfedredb;
		this.dblocation = "";
		this.dbusername = "";
		this.dbpassword = "";
		keeppassword = false;
		
		log = true;
	}

	public String getForfedreVersionTitle()
	{
		return ConfigEntity.c_forfedre_title + " " + ConfigEntity.c_forfedre_version;
	}
	
	public String getForfedreTitle()
	{
		return ConfigEntity.c_forfedre_title;
	}

	public String getForfedreVersion()
	{
		return forfedre_version;
	}

	public ITranslation.enum_language getLanguage()
	{
		return language;
	}

	public void setLanguage(ITranslation.enum_language language)
	{
		this.language = language;
	}

	public String getLookandfeel()
	{
		return this.LAFClassName;
	}

	public void setLookandfeel(String LAFClassName)
	{
		this.LAFClassName = LAFClassName;
	}

	public CHibernate.databases getDatabase()
	{
		return database;
	}

	public void setDatabase(CHibernate.databases database)
	{
		this.database = database;
	}

	public String getDbusername()
	{
		return dbusername;
	}

	public void setDbusername(String dbusername)
	{
		this.dbusername = dbusername;
	}

	public String getDbpassword()
	{
		return dbpassword;
	}

	public void setDbpassword(String dbpassword)
	{
		this.dbpassword = dbpassword;
	}

	public boolean isKeeppassword()
	{
		return keeppassword;
	}

	public void setKeeppassword(boolean keeppassword)
	{
		this.keeppassword = keeppassword;
	}

	public String getDbname()
	{
		return dbname;
	}

	public void setDbname(String dbname)
	{
		this.dbname = dbname;
	}

	public String getDblocation()
	{
		return dblocation;
	}

	public void setDblocation(String dblocation)
	{
		this.dblocation = dblocation;
	}

	public void setLog(boolean log)
	{
		this.log = log;
	}
	
	public boolean isLog()
	{
		return log;
	}
}
