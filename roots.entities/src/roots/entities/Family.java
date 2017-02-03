package roots.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "T_FAMILY")
public class Family
{

	@Id
	@GeneratedValue
	private long id;
	@OneToOne
	private Person person1;
	@OneToOne
	private Repinfo repository;
	@OneToOne
	private Names familynamep1;
	@OneToOne
	private Names familynamep2;
	@OneToOne
	private Person person2;
	
	public long getId()
	{
		return id;
	}

	public void setId(long id)
	{
		this.id = id;
	}

	public Person getPerson1()
	{
		return person1;
	}

	public void setPerson1(Person param)
	{
		this.person1 = param;
	}

	public Repinfo getRepository()
	{
		return repository;
	}

	public void setRepository(Repinfo param)
	{
		this.repository = param;
	}

	public Names getFamilynamep1() {
	    return familynamep1;
	}

	public void setFamilynamep1(Names param) {
	    this.familynamep1 = param;
	}

	public Names getFamilynamep2() {
	    return familynamep2;
	}

	public void setFamilynamep2(Names param) {
	    this.familynamep2 = param;
	}

	public Person getPerson2() {
	    return person2;
	}

	public void setPerson2(Person param) {
	    this.person2 = param;
	}

}