package roots.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity(name = "Address")
@Table(name = "T_ADDRESS")
public class Address implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private long id;
	@Basic
	private String place;
	@Basic
	private String postcode;
	@Basic
	private String street;
	@Basic
	private String housenumber;
	@Basic
	private String country;
	@Basic
	private String region;
	@Basic
	private String description;
	@Basic
	private String phonenumber;
	@Basic
	private String mobilenumber;
	@Basic
	private String faxnumber;
	@OneToOne
	private Repinfo repository;
	@Basic
	private String email;
	@OneToOne(mappedBy = "address")
	private Event event;
	@Basic
	private String title;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setPlace(String param) {
		this.place = param;
	}

	public String getPlace() {
		return place;
	}

	public void setPostcode(String param) {
		this.postcode = param;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setStreet(String param) {
		this.street = param;
	}

	public String getStreet() {
		return street;
	}

	public void setHousenumber(String param) {
		this.housenumber = param;
	}

	public String getHousenumber() {
		return housenumber;
	}

	public void setCountry(String param) {
		this.country = param;
	}

	public String getCountry() {
		return country;
	}

	public void setRegion(String param) {
		this.region = param;
	}

	public String getRegion() {
		return region;
	}

	public void setDescription(String param) {
		this.description = param;
	}

	public String getDescription() {
		return description;
	}

	public void setPhonenumber(String param) {
		this.phonenumber = param;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setMobilenumber(String param) {
		this.mobilenumber = param;
	}

	public String getMobilenumber() {
		return mobilenumber;
	}

	public void setFaxnumber(String param) {
		this.faxnumber = param;
	}

	public String getFaxnumber() {
		return faxnumber;
	}

	public Repinfo getRepository() {
		return repository;
	}

	public void setRepository(Repinfo param) {
		this.repository = param;
	}

	public void setEmail(String param) {
		this.email = param;
	}

	public String getEmail() {
		return email;
	}

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event param) {
		this.event = param;
	}

	public void setTitle(String param) {
		this.title = param;
	}

	public String getTitle() {
		return title;
	}

}