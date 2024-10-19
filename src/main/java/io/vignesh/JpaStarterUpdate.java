package io.vignesh;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaStarterUpdate {

	public static void main(String[] args) {

		EntityManagerFactory entityMangerFactory = Persistence.createEntityManagerFactory("myApp");
		EntityManager entityManager = entityMangerFactory.createEntityManager();
		Employee employee = entityManager.find(Employee.class, 2);
		EmailGroup group = entityManager.find(EmailGroup.class, 8);
		employee.addGroups(group);
		group.addMembers(employee);
		
//		employee.setAge(30);
//		employee.setType(EmployeeType.CONTRACTOR);

		EntityTransaction transaction = entityManager.getTransaction();

		transaction.begin();

		entityManager.persist(employee);
		entityManager.persist(group);

		transaction.commit();
	}
}
