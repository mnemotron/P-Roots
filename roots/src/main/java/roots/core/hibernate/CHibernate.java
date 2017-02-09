package roots.core.hibernate;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class CHibernate
{

	public static enum databases
	{
		FORFEDREDB, // Embedded HypersonicSQL
		// ORACLE, //Oracle 8i, 9i, 10g
		// DB2, //DB2 7.1, 7.2, 8.1, 9.1
		// MSQLS, //Microsoft SQL Server 2000
		// SYBASE, //Sybase 12.5 (JConnect 5.5)
		MYSQL
		// MySQL 3.23, 4.0, 4.1, 5.0
		// POSTGESQL, //PostgreSQL 7.1.2, 7.2, 7.3, 7.4, 8.0, 8.1
		// HYPERSONICSQL, //HypersonicSQL 1.61, 1.7.0, 1.7.2, 1.7.3, 1.8
		// APACHEDERBY
	}

	public final static String REPOSITORY_VERSION = "1.0";

	public final static String ROOTS_DB_CURL = "rootsdb";
	public final static String ROOTS_DB_LOC = "./rootsdb/";

	// -- Embedded Apache Derby
	// public final static String c_hd_derby =
	// "org.hibernate.dialect.DerbyDialect";
	// public final static String c_dc_embedded_derby =
	// "org.apache.derby.jdbc.EmbeddedDriver";
	// public final static String c_curl_protocol_jdbc_derby = "jdbc:derby:";
	// public final static String c_curl_derbydb_create = ";create=true";

	// Embedded HypersonicSQL
	public final static String HSQLDB_DIALECT_DRIVER_CLASS = "org.hibernate.dialect.HSQLDialect";
	public final static String HSQLDB_JDBC_EMBEDDED_DRIVER_CLASS = "org.hsqldb.jdbcDriver";
	public final static String HSQLDB_JDBC_PROTOCOL_CURL = "jdbc:hsqldb:";
	public final static String HSQLDB_CREATE_CURL = ";create=true";
	public final static String HSQLDB_USER = "rootsdb";
	public final static String HSQLDB_PASSWORD = "rootsdb";

	// MySQL
	public final static String MYSQL_HD = "org.hibernate.dialect.MySQLDialect";
	public final static String MYSQL_DC = "com.mysql.jdbc.Driver";
	public final static String MYSQL_JDBC_PROTOCOL_CURL = "jdbc:mysql:";
	public final static String MYSQL_CREATE_CURL = ";create=true";

	// -- Hibernate properties
	private final static String HIBERNATE_PROPERTY_DIALECT = "hibernate.dialect";
	private final static String HIBERNATE_PROPERTY_CONNECTION_URL = "hibernate.connection.url";
	private final static String HIBERNATE_PROPERTY_CONNECTION_USERNAME = "hibernate.connection.username";
	private final static String HIBERNATE_PROPERTY_CONNECTION_PASSWORD = "hibernate.connection.password";
	private final static String HIBERNATE_PROPERTY_CONNECTION_DRIVER_CLASS = "hibernate.connection.driver_class";
	private final static String HIBERNATE_PROPERTY_TRANSACTION_FACTORY_CLASS = "hibernate.transaction.factory_class";
	private final static String HIBERNATE_PROPERTY_HBM2DDL_AUTO = "hibernate.hbm2ddl.auto";
	private final static String HIBERNATE_PROPERTY_CURRENT_SESSION_CONTEXT_CLASS = "hibernate.current_session_context_class";
	// private final static String c_prop_hibernate_connection_datasource_name =
	// "hibernate.connection.datasource";
	private final static String HIBERNATE_PROPERTY_TEST_ON_BORROW = "hibernate.connection.testOnBorrow";

	// private static HibernateController hibernatecontroller;

	private SessionFactory sessionFactory;
	private Configuration configuration;
	private Session session;
	private Transaction transaction;

	// public static HibernateController
	// getHibernateControllerInstance(HibernateController.databases p_database,
	// String p_dblocation, String p_dbname, String p_dbusername, String
	// p_dbpassword) throws Exception
	// {
	// if (HibernateController.hibernatecontroller == null)
	// {
	// HibernateController.hibernatecontroller = new
	// HibernateController(p_database, p_dblocation, p_dbname, p_dbusername,
	// p_dbpassword);
	// }
	//
	// return HibernateController.hibernatecontroller;
	// }

	public CHibernate(CHibernate.databases p_database, String p_dblocation, String p_dbname, String p_dbusername, String p_dbpassword) throws Exception
	{

		this.configuration = new Configuration();

		switch (p_database)
		{
			case FORFEDREDB:
				this.setConfigEmbeddedForfedreDB();
				break;
			case MYSQL:
				this.setConfigEmbeddedMySQL(p_database, p_dblocation, p_dbname, p_dbusername, p_dbpassword);
				break;
		}

		configuration.setProperty(HIBERNATE_PROPERTY_TRANSACTION_FACTORY_CLASS, "org.hibernate.transaction.JDBCTransactionFactory");
		configuration.setProperty(HIBERNATE_PROPERTY_HBM2DDL_AUTO, "update");
		configuration.setProperty(HIBERNATE_PROPERTY_CURRENT_SESSION_CONTEXT_CLASS, "thread");

		// configuration.setProperty(c_prop_hibernate_connection_datasource_name,
		// c_curl_forfedredb);
		configuration.setProperty(HIBERNATE_PROPERTY_TEST_ON_BORROW, "true");

		configuration.setProperty("hibernate.archive.autodetection", "class");

		configuration.addAnnotatedClass(roots.entities.Repinfo.class);
		configuration.addAnnotatedClass(roots.entities.Address.class);
		configuration.addAnnotatedClass(roots.entities.EventAttribute.class);
		configuration.addAnnotatedClass(roots.entities.Family.class);
		configuration.addAnnotatedClass(roots.entities.Person.class);
		configuration.addAnnotatedClass(roots.entities.EventValueType.class);
		configuration.addAnnotatedClass(roots.entities.EventTypeData.class);
		configuration.addAnnotatedClass(roots.entities.EventType.class);
		configuration.addAnnotatedClass(roots.entities.MediaSubType.class);
		configuration.addAnnotatedClass(roots.entities.MediaType.class);
		configuration.addAnnotatedClass(roots.entities.NameType.class);
		configuration.addAnnotatedClass(roots.entities.Names.class);
		configuration.addAnnotatedClass(roots.entities.Media.class);
		configuration.addAnnotatedClass(roots.entities.Event.class);

	}

	private void setConfigEmbeddedMySQL(CHibernate.databases p_database, String p_dblocation, String p_dbname, String p_dbusername, String p_dbpassword)
	{
		this.setHibernateDriverClass(CHibernate.MYSQL_DC);
		this.setHibernateDialect(CHibernate.MYSQL_HD);
		this.setHibernateConnectionUrl(CHibernate.MYSQL_JDBC_PROTOCOL_CURL + p_dblocation + p_dbname);
		this.setHibernateConnectionUsername(p_dbusername);
		this.setHibernateConnectionPasswort(p_dbpassword);
	}

	private void setConfigEmbeddedForfedreDB()
	{
		this.setHibernateDriverClass(CHibernate.HSQLDB_JDBC_EMBEDDED_DRIVER_CLASS);
		this.setHibernateDialect(CHibernate.HSQLDB_DIALECT_DRIVER_CLASS);
		this.setHibernateConnectionUrl(CHibernate.HSQLDB_JDBC_PROTOCOL_CURL + CHibernate.ROOTS_DB_LOC + CHibernate.ROOTS_DB_CURL + CHibernate.HSQLDB_CREATE_CURL);
		this.setHibernateConnectionUsername(CHibernate.HSQLDB_USER);
		this.setHibernateConnectionPasswort(CHibernate.HSQLDB_PASSWORD);
	}

	private void setHibernateDriverClass(String p_hdriverclass)
	{
		this.setConfProperty(HIBERNATE_PROPERTY_CONNECTION_DRIVER_CLASS, p_hdriverclass);
	}

	private void setHibernateConnectionPasswort(String p_hconnectionpassword)
	{
		this.setConfProperty(HIBERNATE_PROPERTY_CONNECTION_PASSWORD, p_hconnectionpassword);
	}

	private void setHibernateConnectionUsername(String p_hconnectionusername)
	{
		this.setConfProperty(HIBERNATE_PROPERTY_CONNECTION_USERNAME, p_hconnectionusername);
	}

	private void setHibernateConnectionUrl(String p_hconnectionurl)
	{
		this.setConfProperty(HIBERNATE_PROPERTY_CONNECTION_URL, p_hconnectionurl);
	}

	private void setHibernateDialect(String p_hdialect)
	{
		this.setConfProperty(HIBERNATE_PROPERTY_DIALECT, p_hdialect);
	}

	private void setConfProperty(String p_property, String p_value)
	{
		this.configuration.setProperty(p_property, p_value);
	}

	public Query createQuery(String p_string)
	{
		return session.createQuery(p_string);
	}

	public void saveOrUpdate(Object p_object)
	{
		session.saveOrUpdate(p_object);
	}

	public void beginTransaction()
	{
		transaction = null;
		transaction = session.beginTransaction();
	}

	public void rollbackTransaction()
	{
		transaction.rollback();
	}

	public void commitTransaction()
	{
		transaction.commit();
	}

	public void openSession()
	{
		session = sessionFactory.openSession();
	}

	public void closeSession()
	{
		session.close();

		session = null;
	}

	public void closeSessionFactory()
	{
		sessionFactory.close();

		sessionFactory = null;
	}

	public void buildSessionFactory()
	{
		sessionFactory = this.configuration.buildSessionFactory();
	}

	public boolean isConnected()
	{
		return session.isConnected();
	}
}
