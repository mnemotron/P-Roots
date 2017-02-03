package roots.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import roots.entities.Event;

@Entity(name = "Person")
@Table(name = "T_PERSON")
public class Person implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private long id;
	@Basic
	@Lob
	private String note;
	@OneToOne
	private Repinfo repository;
	@OneToMany(mappedBy = "person")
	private Collection<Names> names = new ArrayList<Names>();
	@OneToMany
	private Collection<Family> parents = new ArrayList<Family>();

	@ManyToMany
	private Collection<Media> media = new ArrayList<Media>();

	@ManyToMany
	private Collection<Event> event = new ArrayList<Event>();

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setNote(String param) {
		this.note = param;
	}

	public String getNote() {
		return note;
	}

	public Repinfo getRepository() {
		return repository;
	}

	public void setRepository(Repinfo param) {
		this.repository = param;
	}

	public Collection<Names> getNames() {
		return names;
	}

	public void setNames(Collection<Names> param) {
		this.names = param;
	}

	public Collection<Family> getParents() {
		return parents;
	}

	public void setParents(Collection<Family> param) {
		this.parents = param;
	}

	public Collection<Media> getMedia() {
	    return media;
	}

	public void setMedia(Collection<Media> param) {
	    this.media = param;
	}

	public Collection<Event> getEvent() {
	    return event;
	}

	public void setEvent(Collection<Event> param) {
	    this.event = param;
	}

}