package roots.gui;

import java.util.ArrayList;

import javax.swing.MutableComboBoxModel;
import javax.swing.event.ListDataListener;

import roots.core.hibernate.HibernateController;

public class ComboBoxKeyModel implements MutableComboBoxModel
{
	public static ArrayList<ComboBoxKey> entries = new ArrayList<ComboBoxKey>();
	private static int sel_index = -1;

	public static ComboBoxKey getSelectedComboBoxKeyItem()
	{
		if (sel_index < 0)
		{
			return null;
		}

		return entries.get(sel_index);
	}

	public static void setSelectedDatabaseItem(HibernateController.databases p_database)
	{
		int size = entries.size();

		for (int i = 0; i < size; i++)
		{
			if (((ComboBoxKey) entries.get(i)).getDatabase() == p_database)
			{
				sel_index = i;
				break;
			}
		}
	}

	@Override
	public Object getSelectedItem()
	{
		if (sel_index < 0)
		{
			return null;
		}
		return entries.get(sel_index).getDescription();
	}

	@Override
	public void setSelectedItem(Object anItem)
	{
		int size = entries.size();

		for (int i = 0; i < size; i++)
		{
			if (((ComboBoxKey) entries.get(i)).getDescription().compareTo((String)anItem) == 0)
			{
				sel_index = i;
				break;
			}
		}
	}

	@Override
	public void addListDataListener(ListDataListener arg0)
	{}

	@Override
	public Object getElementAt(int arg0)
	{
		return (entries.get(arg0).getDescription());
	}

	@Override
	public int getSize()
	{
		return entries.size();
	}

	@Override
	public void removeListDataListener(ListDataListener arg0)
	{}

	@Override
	public void addElement(Object arg0)
	{
		if (!entries.contains(arg0))
		{
			entries.add((ComboBoxKey) arg0);
		}

	}

	@Override
	public void insertElementAt(Object arg0, int arg1)
	{
		entries.add(arg1, (ComboBoxKey) arg0);
	}

	@Override
	public void removeElement(Object arg0)
	{
		int size = entries.size();

		for (int i = 0; i < size; i++)
		{
			ComboBoxKey ck = (ComboBoxKey) entries.get(i);
			String tmp = ck.getDescription();
			if (tmp.compareTo((String)arg0) == 0)
			{
				entries.remove(ck);
				
				if ((size - 1) < 1)
				{
					sel_index = -1;
				}
				
				return;
			}
		}
	}

	@Override
	public void removeElementAt(int arg0)
	{
		entries.remove(arg0);
	}
}
