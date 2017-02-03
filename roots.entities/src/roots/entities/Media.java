package roots.entities;

import static javax.persistence.FetchType.LAZY;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity(name = "Media")
@Table(name = "T_MEDIA")
public class Media {

	@Id
	@GeneratedValue
	private long id;
	@Basic
	@Lob
	private String mediadescription;
	@Basic
	@Lob
	private String mediareference;
	@Basic
	private String mediadate;
	@OneToOne
	private Repinfo repository;
	@Basic(fetch = LAZY)
	@Lob
	private byte[] mediadata;
	@Basic
	private String mediatitle;
	@ManyToOne
	private Event event;
	@OneToOne
	private MediaType mediaType;
	@OneToOne
	private MediaSubType mediaSubType;

	@ManyToMany
	private Collection<Person> person = new ArrayList<Person>();

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setMediadescription(String param) {
		this.mediadescription = param;
	}

	public String getMediadescription() {
		return mediadescription;
	}

	public void setMediareference(String param) {
		this.mediareference = param;
	}

	public String getMediareference() {
		return mediareference;
	}

	public void setMediadate(String param) {
		this.mediadate = param;
	}

	public String getMediadate() {
		return mediadate;
	}

	public Repinfo getRepository() {
		return repository;
	}

	public void setRepository(Repinfo param) {
		this.repository = param;
	}

	public void setMediadata(byte[] param) {
		this.mediadata = param;
	}

	public byte[] getMediadata() {
		return mediadata;
	}

	public void setMediatitle(String param) {
		this.mediatitle = param;
	}

	public String getMediatitle() {
		return mediatitle;
	}

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event param) {
		this.event = param;
	}

	public MediaType getMediaType() {
		return mediaType;
	}

	public void setMediaType(MediaType param) {
		this.mediaType = param;
	}

	public MediaSubType getMediaSubType() {
		return mediaSubType;
	}

	public void setMediaSubType(MediaSubType param) {
		this.mediaSubType = param;
	}

	public Collection<Person> getPerson() {
		return person;
	}

	public void setMedia(Collection<Person> param) {
		this.person = param;
	}

}