package roots.entities;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.ManyToOne;
import java.lang.String;

@Entity
@Table(name = "T_NAMES")
public class Names
{

	@Id
	@GeneratedValue
	private long id;
	@Basic
	private String name;
	@OneToOne
	private Repinfo repository;
	@ManyToOne
	private Person person;
	@OneToOne
	private NameType nameType;
	@Basic
	private int index;

	public long getId()
	{
		return id;
	}

	public void setId(long id)
	{
		this.id = id;
	}

	public void setName(String param)
	{
		this.name = param;
	}

	public String getName()
	{
		return name;
	}

	public Repinfo getRepository()
	{
		return repository;
	}

	public void setRepository(Repinfo param)
	{
		this.repository = param;
	}

	public Person getPerson()
	{
		return person;
	}

	public void setPerson(Person param)
	{
		this.person = param;
	}

	public NameType getNameType()
	{
		return nameType;
	}

	public void setNameType(NameType param)
	{
		this.nameType = param;
	}

	public void setIndex(int param)
	{
		this.index = param;
	}

	public int getIndex()
	{
		return index;
	}

}