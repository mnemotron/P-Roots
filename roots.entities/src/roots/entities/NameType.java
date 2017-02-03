package roots.entities;

import javax.persistence.*;
import java.lang.String;

@Entity(name = "NameType")
@Table(name = "T_NAMETYPE")
public class NameType
{

//	@Id
//	@GeneratedValue
//	private long id;
	@Id
	private String nametype;
	@Basic
	private String description;
	@OneToOne
	private Repinfo repository;

//	public long getId()
//	{
//		return id;
//	}
//
//	public void setId(long id)
//	{
//		this.id = id;
//	}

	public void setNametype(String param)
	{
		this.nametype = param;
	}

	public String getNametype()
	{
		return nametype;
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