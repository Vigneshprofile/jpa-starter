package io.vignesh;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name = "EMPLOYEE_DATA")
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name = "employeeName", length = 100)
	private String name;
	
	private int age;
	
	@Temporal(TemporalType.DATE)
	private Date dob;
	
	@Column(unique = true, nullable = false, length = 10)
	private String ssn;
	
	@Transient
	private String debugString;
	
	@Enumerated(EnumType.STRING)
	private EmployeeType type;
	
	@OneToOne
	private AccessCard card;
	
	@OneToMany(mappedBy = "employee", cascade = CascadeType.REMOVE)
	private List<PaySlip> paySlips = new ArrayList<>();
	
	@ManyToMany
	@JoinTable(name = "Employee_EmailGroup", joinColumns = @JoinColumn(name = "employee_id"),
	inverseJoinColumns = @JoinColumn(name = "email_group_id"))
	private List<EmailGroup> groups = new ArrayList<>();
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getSsn() {
		return ssn;
	}
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	public EmployeeType getType() {
		return type;
	}
	public void setType(EmployeeType type) {
		this.type = type;
	}
	
	public AccessCard getCard() {
		return card;
	}
	public void setCard(AccessCard card) {
		this.card = card;
	}
	
	
	public List<PaySlip> getPaySlips() {
		return paySlips;
	}
	public void setPaySlips(List<PaySlip> paySlips) {
		this.paySlips = paySlips;
	}
	
	public void addPaySlips(PaySlip paySlip) {
		this.paySlips.add(paySlip);
	}
	
	public void addGroups(EmailGroup group) {
		this.groups.add(group);
	}
	
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", age=" + age + ", dob=" + dob + ", ssn=" + ssn + ", type="
				+ type + ", card=" + card + "]";
	}
	
	
	
	
	

}
