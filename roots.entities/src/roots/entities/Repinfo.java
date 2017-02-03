package roots.entities;

import static javax.persistence.TemporalType.TIMESTAMP;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import java.lang.String;

@Entity(name = "Repinfo")
@Table(name = "T_REPINFO")
public class Repinfo implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private long id;

	@Basic
	private String repversion;

	@Basic
	@Temporal(TIMESTAMP)
	private Date repcreationdate;

	@Basic
	private String repname;

	@Basic
	@Lob
	private String repdescription;

	@Basic
	@Temporal(TIMESTAMP)
	private Date repchangedate;

	@Basic
	private String repcreator;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setRepversion(String param) {
		this.repversion = param;
	}

	public String getRepversion() {
		return repversion;
	}

	public void setRepcreationdate(Date param) {
		this.repcreationdate = param;
	}

	public Date getRepcreationdate() {
		return repcreationdate;
	}

	public void setRepname(String param) {
		this.repname = param;
	}

	public String getRepname() {
		return repname;
	}

	public void setRepdescription(String param) {
		this.repdescription = param;
	}

	public String getRepdescription() {
		return repdescription;
	}

	public void setRepchangedate(Date param) {
		this.repchangedate = param;
	}

	public Date getRepchangedate() {
		return repchangedate;
	}

	public void setRepcreator(String param) {
		this.repcreator = param;
	}

	public String getRepcreator() {
		return repcreator;
	}

}