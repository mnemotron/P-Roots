package roots.gui;

import roots.core.hibernate.HibernateController;

public class ComboBoxKey
{
	private HibernateController.databases database;
	private String description;

	public ComboBoxKey(HibernateController.databases p_database, String p_desc)
	{
		this.database = p_database;
		this.description = p_desc;
	}

	public HibernateController.databases getDatabase()
	{
		return database;
	}

	public String getDescription()
	{
		return description;
	}
}
