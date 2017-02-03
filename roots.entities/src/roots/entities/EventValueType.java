package roots.entities;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.OneToOne;

@Entity(name = "EventValueType")
@Table(name = "T_EVENTVALUETYPE")
public class EventValueType
{

	@Id
	@GeneratedValue
	private long id;
	@Basic
	private String valuetype;
	@Basic
	private String description;
	@OneToOne
	private Repinfo repository;
	public long getId()
	{
		return id;
	}

	public void setId(long id)
	{
		this.id = id;
	}

	public void setValuetype(String param)
	{
		this.valuetype = param;
	}

	public String getValuetype()
	{
		return valuetype;
	}

	public void setDescription(String param)
	{
		this.description = param;
	}

	public String getDescription()
	{
		return description;
	}

	public Repinfo getRepository() {
	    return repository;
	}

	public void setRepository(Repinfo param) {
	    this.repository = param;
	}

}