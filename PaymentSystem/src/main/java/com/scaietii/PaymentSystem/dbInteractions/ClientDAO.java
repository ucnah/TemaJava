package com.scaietii.PaymentSystem.dbInteractions;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.scaietii.PaymentSystem.entities.Client;

public class ClientDAO {
	
	 private static final String PERSISTENCE_UNIT_NAME = "TemaJava";
	 private static EntityManagerFactory factory;
	 
	/*public void createClient()
	{
		factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		EntityManager emClient = factory.createEntityManager();
		emClient.getTransaction().begin();
	    Client c = new Client();
	    todo.setSummary("This is a test");
	    todo.setDescription("This is a test");
	    emClient.persist(todo);
	    emClient.getTransaction().commit();

	    emClient.close();
		
	}*/

}
