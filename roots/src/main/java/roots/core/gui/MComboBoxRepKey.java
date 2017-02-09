package roots.core.gui;

import java.util.ArrayList;

import javax.swing.MutableComboBoxModel;
import javax.swing.event.ListDataListener;

import roots.entities.Repinfo;

public class MComboBoxRepKey implements MutableComboBoxModel
{
	public static ArrayList<ComboBoxRepKey> entries = new ArrayList<ComboBoxRepKey>();
	private static int sel_index = -1;

	public static ComboBoxRepKey getSelectedComboBoxKeyItem()
	{
		if (sel_index < 0)
		{
			return null;
		}

		return entries.get(sel_index);
	}

	public static void setSelectedRepinfoItem(Repinfo p_repinfo)
	{
		int size = entries.size();

		for (int i = 0; i < size; i++)
		{
			if (entries.get(i).getRepinfo().getId() == p_repinfo.getId())
			{
				sel_index = i;
				break;
			}
		}
	}

	@Override
	public Object getSelectedItem()
	{
		int i  = entries.size();
		
		if (sel_index < 0 || i == 0)
		{
			return null;
		}

		if (entries.get(sel_index).getNewrepname() != null)
		{
			return entries.get(sel_index).getNewrepname();
		}

		return entries.get(sel_index).getRepDesc();
	}

	@Override
	public void setSelectedItem(Object anItem)
	{
		int size = entries.size();

		for (int i = 0; i < size; i++)
		{
			
			String tmp = ((ComboBoxRepKey) entries.get(i)).getRepDesc();
			if (tmp.compareTo((String)anItem) == 0)
			{
				sel_index = i;
				return;
			}
		}
		
		if (anItem instanceof String)
		{
			entries.clear();

			ComboBoxRepKey ck = new ComboBoxRepKey((String) anItem);
			entries.add(ck);
			sel_index = entries.indexOf(ck);

			return;
		}
	}

	@Override
	public void addListDataListener(ListDataListener arg0)
	{}

	@Override
	public Object getElementAt(int arg0)
	{
		if (entries.get(arg0).getNewrepname() != null)
		{
			return (entries.get(arg0).getNewrepname());
		} else
		{
			return (entries.get(arg0).getRepDesc());
		}

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
			entries.add((ComboBoxRepKey) arg0);
		}

	}

	@Override
	public void insertElementAt(Object arg0, int arg1)
	{
		entries.add(arg1, (ComboBoxRepKey) arg0);
	}

	@Override
	public void removeElement(Object arg0)
	{
		int size = entries.size();

		for (int i = 0; i < size; i++)
		{
			ComboBoxRepKey ck = (ComboBoxRepKey) entries.get(i);
			String tmp = ck.getRepDesc();
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
