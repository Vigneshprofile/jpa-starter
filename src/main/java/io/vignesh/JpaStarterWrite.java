package io.vignesh;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaStarterWrite {
	
	public static void main(String[] args) {
		
		
		Employee employee = new Employee();
		//employee.setId(1);
		employee.setName("Shiva");
		employee.setDob(new Date());
		employee.setAge(22);
		employee.setSsn("12345");
		employee.setType(EmployeeType.FULL_TIME);
		
		Employee employee2 = new Employee();
		//employee2.setId(2);
		employee2.setName("Vijay");
		employee2.setDob(new Date());
		employee2.setAge(25);
		employee2.setSsn("123456");
		employee2.setType(EmployeeType.CONTRACTOR);
		
		AccessCard card1 = new AccessCard();
		card1.setActive(true);
		card1.setIssueDate(new Date());
		card1.setFrimwareNumber("1.0.0");
		
		card1.setOwner(employee);
		employee.setCard(card1);
		
		
		AccessCard card2 = new AccessCard();
		card2.setActive(false);
		card2.setIssueDate(new Date());
		card2.setFrimwareNumber("1.2.0");
		
		card2.setOwner(employee2);
		employee2.setCard(card2);
		
		PaySlip paySlip = new PaySlip();
		paySlip.setPayEndDate(new Date());
		paySlip.setPayStartDate(new Date());
		paySlip.setSalary(100000);
		paySlip.setEmployee(employee);
		employee.addPaySlips(paySlip);
		
		
		PaySlip paySlip1 = new PaySlip();
		paySlip1.setPayEndDate(new Date());
		paySlip1.setPayStartDate(new Date());
		paySlip1.setSalary(200000);
		paySlip1.setEmployee(employee);
		employee.addPaySlips(paySlip1);
		
		EmailGroup group1 = new EmailGroup();
		group1.setName("Fun Fridaysss");
		group1.addMembers(employee);
		employee.addGroups(group1);
		employee2.addGroups(group1);
		
		
		EmailGroup group2 = new EmailGroup();
		group2.setName("Engineering");
		group2.addMembers(employee2);
		group2.addMembers(employee);
		employee.addGroups(group2);
		
		
		
		
		EntityManagerFactory entityMangerFactory = Persistence.createEntityManagerFactory("myApp");
		EntityManager entityManager = entityMangerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		
		transaction.begin();
		
		entityManager.persist(employee);
		entityManager.persist(employee2);
		
		entityManager.persist(card1);
		entityManager.persist(card2);
		
		entityManager.persist(paySlip);
		entityManager.persist(paySlip1);
		
		entityManager.persist(group1);
		entityManager.persist(group2);
		
		transaction.commit();
		//entityManager.close();
	}

}
