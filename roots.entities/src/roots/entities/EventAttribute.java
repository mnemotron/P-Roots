package roots.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.lang.String;

@Entity
public class EventAttribute implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private long id;
	@OneToOne
	private Repinfo repository;
	@Basic
	private String attribute;
	@Basic
	private String description;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Repinfo getRepository() {
		return repository;
	}

	public void setRepository(Repinfo param) {
		this.repository = param;
	}

	public void setAttribute(String param) {
		this.attribute = param;
	}

	public String getAttribute() {
		return attribute;
	}

	public void setDescription(String param) {
		this.description = param;
	}

	public String getDescription() {
		return description;
	}

}