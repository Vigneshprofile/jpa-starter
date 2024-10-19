package io.vignesh;



import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class JpaStarterRead {

	public static void main(String[] args) {

		EntityManagerFactory entityMangerFactory = Persistence.createEntityManagerFactory("myApp");
		EntityManager entityManager = entityMangerFactory.createEntityManager();
		PaySlip paySlip = entityManager.find(PaySlip.class, 5);
		System.out.println(paySlip);

		//		AccessCard card = entityManager.find(AccessCard.class, 4);
		//		System.out.println(card);
	}

}
