package roots.core.gui;

import roots.entities.Repinfo;

public class ComboBoxRepKey
{
	private Repinfo repinfo;
	private String newrepname;
	
	public ComboBoxRepKey(String p_newrepname)
	{
		this.newrepname = p_newrepname;
	}

	public String getNewrepname()
	{
		return newrepname;
	}

	public void setNewrepname(String newrepname)
	{
		this.newrepname = newrepname;
		this.newrepname = null;
	}

	public ComboBoxRepKey(Repinfo p_repinfo)
	{
		this.repinfo = p_repinfo;
	}
	
	public String getRepDesc()
	{
		return this.repinfo.getId() + " | " + this.repinfo.getRepname();
	}

	public Repinfo getRepinfo()
	{
		return repinfo;
	}
}
