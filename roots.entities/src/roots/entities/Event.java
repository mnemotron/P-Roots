package roots.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import roots.entities.Person;

import javax.persistence.ManyToMany;

@Entity(name = "Event")
@Table(name = "T_EVENT")
public class Event implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private long id;
	@Basic
	@Lob
	private String eventdescription;
	@OneToOne
	private Repinfo repository;
	@Basic
	private String eventdate;
	@Basic
	private String eventtime;
	@Basic
	private String eventtitle;
	@OneToMany(mappedBy = "event")
	private Collection<Media> media = new ArrayList<Media>();
	@OneToOne
	private Address address;
	@OneToOne
	private EventType eventType;

	@ManyToMany
	private Collection<Person> person = new ArrayList<Person>();

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setEventdescription(String param) {
		this.eventdescription = param;
	}

	public String getEventdescription() {
		return eventdescription;
	}

	public Repinfo getRepository() {
		return repository;
	}

	public void setRepository(Repinfo param) {
		this.repository = param;
	}

	public void setEventdate(String param) {
		this.eventdate = param;
	}

	public String getEventdate() {
		return eventdate;
	}

	public void setEventtitle(String param) {
		this.eventtitle = param;
	}

	public String getEventtitle() {
		return eventtitle;
	}

	public void setEventtime(String param) {
		this.eventtime = param;
	}

	public String getEventtime() {
		return eventtime;
	}

	public Collection<Media> getMedia() {
		return media;
	}

	public void setMedia(Collection<Media> param) {
		this.media = param;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address param) {
		this.address = param;
	}

	public EventType getEventType() {
		return eventType;
	}

	public void setEventType(EventType param) {
		this.eventType = param;
	}

	public Collection<Person> getPerson() {
	    return person;
	}

	public void setPerson(Collection<Person> param) {
	    this.person = param;
	}

}