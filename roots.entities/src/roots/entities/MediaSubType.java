package roots.entities;

import javax.persistence.*;
import java.lang.String;

@Entity(name = "MediaSubType")
@Table(name = "T_MEDIASUBTYPE")
public class MediaSubType
{

	@Id
	@GeneratedValue
	private long id;
	@Basic
	private String mediasubtype;
	@OneToOne
	private Repinfo repository;
	@Basic
	private String decription;

	public long getId()
	{
		return id;
	}

	public void setId(long id)
	{
		this.id = id;
	}

	public void setMediasubtype(String param)
	{
		this.mediasubtype = param;
	}

	public String getMediasubtype()
	{
		return mediasubtype;
	}

	public Repinfo getRepository()
	{
		return repository;
	}

	public void setRepository(Repinfo param)
	{
		this.repository = param;
	}

	public void setDecription(String param)
	{
		this.decription = param;
	}

	public String getDecription()
	{
		return decription;
	}

}