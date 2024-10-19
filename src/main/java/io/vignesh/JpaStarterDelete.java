package io.vignesh;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaStarterDelete {
	
	public static void main(String[] args) {
		
		EntityManagerFactory entityMangerFactory = Persistence.createEntityManagerFactory("myApp");
		EntityManager entityManager = entityMangerFactory.createEntityManager();
		Employee employee = entityManager.find(Employee.class, 1);
		//System.out.println(employee);
		
		EntityTransaction transaction = entityManager.getTransaction();

		transaction.begin();

		entityManager.remove(employee);


		transaction.commit();
	}

}
