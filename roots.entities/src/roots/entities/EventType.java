package roots.entities;

import javax.persistence.*;
import java.util.Collection;
import java.util.ArrayList;
import java.lang.String;
import java.lang.Boolean;

@Entity(name = "EventType")
@Table(name = "T_EVENTTYPE")
public class EventType
{

	@Id
	@GeneratedValue
	private long id;
	@OneToMany
	private Collection<EventTypeData> eventTypeData = new ArrayList<EventTypeData>();
	@Basic
	private String eventtype;
	@Basic
	private Boolean changeable;
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

	public Collection<EventTypeData> getEventTypeData()
	{
		return eventTypeData;
	}

	public void setEventTypeData(Collection<EventTypeData> param)
	{
		this.eventTypeData = param;
	}

	public void setEventtype(String param)
	{
		this.eventtype = param;
	}

	public String getEventtype()
	{
		return eventtype;
	}

	public void setChangeable(Boolean param)
	{
		this.changeable = param;
	}

	public Boolean getChangeable()
	{
		return changeable;
	}

	public Repinfo getRepository() {
	    return repository;
	}

	public void setRepository(Repinfo param) {
	    this.repository = param;
	}

}