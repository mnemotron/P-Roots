package roots.entities;
import javax.persistence.*;
import java.lang.String;

@Entity(name = "MediaType")
@Table(name = "T_MEDIATYPE")
public class MediaType
{

	@Id
	@GeneratedValue
	private long id;
	@Basic
	private String mediatype;
	@OneToOne
	private Repinfo repository;
	@Basic
	private String description;

	public long getId()
	{
		return id;
	}

	public void setId(long id)
	{
		this.id = id;
	}

	public void setMediatype(String param)
	{
		this.mediatype = param;
	}

	public String getMediatype()
	{
		return mediatype;
	}

	public Repinfo getRepository()
	{
		return repository;
	}

	public void setRepository(Repinfo param)
	{
		this.repository = param;
	}

	public void setDescription(String param)
	{
		this.description = param;
	}

	public String getDescription()
	{
		return description;
	}

}