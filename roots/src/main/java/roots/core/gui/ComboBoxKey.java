package roots.core.gui;

import roots.core.hibernate.CHibernate;

public class ComboBoxKey
{
	private CHibernate.databases database;
	private String description;

	public ComboBoxKey(CHibernate.databases p_database, String p_desc)
	{
		this.database = p_database;
		this.description = p_desc;
	}

	public CHibernate.databases getDatabase()
	{
		return database;
	}

	public String getDescription()
	{
		return description;
	}
}
