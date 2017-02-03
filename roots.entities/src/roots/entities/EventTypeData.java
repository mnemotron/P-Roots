package roots.entities;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.lang.String;
import java.lang.Boolean;
import javax.persistence.OneToOne;

@Entity(name = "EventTypeData")
@Table(name = "T_EVENTTYPEDATA")
public class EventTypeData
{

	@Id
	@GeneratedValue
	private long id;
	@Basic
	private String objstring;
	@Basic
	private Boolean changeable;
	@OneToOne
	private Repinfo repository;
	@OneToOne
	private EventValueType eventValueType;
	@OneToOne
	private EventAttribute eventAttribute;
	@OneToOne
	private Family objfamily;
	@OneToOne
	private Person objperson;
	public long getId()
	{
		return id;
	}

	public void setId(long id)
	{
		this.id = id;
	}

	public void setObjstring(String param)
	{
		this.objstring = param;
	}

	public String getObjstring()
	{
		return objstring;
	}

	public void setChangeable(Boolean param)
	{
		this.changeable = param;
	}

	public Boolean getChangeable()
	{
		return changeable;
	}

	public Repinfo getRepository()
	{
		return repository;
	}

	public void setRepository(Repinfo param)
	{
		this.repository = param;
	}

	public EventValueType getEventValueType() {
	    return eventValueType;
	}

	public void setEventValueType(EventValueType param) {
	    this.eventValueType = param;
	}

	public EventAttribute getEventAttribute() {
	    return eventAttribute;
	}

	public void setEventAttribute(EventAttribute param) {
	    this.eventAttribute = param;
	}

	public Family getObjfamily() {
	    return objfamily;
	}

	public void setObjfamily(Family param) {
	    this.objfamily = param;
	}

	public Person getObjperson() {
	    return objperson;
	}

	public void setObjperson(Person param) {
	    this.objperson = param;
	}

}