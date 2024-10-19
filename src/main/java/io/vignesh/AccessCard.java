package io.vignesh;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "Access_card")
public class AccessCard {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Temporal(TemporalType.DATE)
	private Date issueDate;
	
	@Column
	private boolean isActive;
	
	@Column(length = 10)
	private String frimwareNumber;
	
	@OneToOne(mappedBy = "card")
	private Employee owner;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public String getFrimwareNumber() {
		return frimwareNumber;
	}

	public void setFrimwareNumber(String frimwareNumber) {
		this.frimwareNumber = frimwareNumber;
	}


	public Employee getOwner() {
		return owner;
	}

	public void setOwner(Employee owner) {
		this.owner = owner;
	}

	@Override
	public String toString() {
		return "AccessCard [id=" + id + ", issueDate=" + issueDate + ", isActive=" + isActive + ", frimwareNumber="
				+ frimwareNumber + ", owner=" + owner + "]";
	}

	
	
	


	
}
