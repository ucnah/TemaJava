package com.scaietii.PaymentSystem.main;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.scaietii.PaymentSystem.entities.Client;
import com.scaietii.PaymentSystem.entities.Provider;
import com.scaietii.PaymentSystem.entities.*;


public class App 
{
	private static final String PERSISTENCE_UNIT_NAME = "TemaJava";
	  private static EntityManagerFactory factory;
    public static void main( String[] args )
    {
    	factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = factory.createEntityManager();
        // read the existing entries and write to console
        Query q = em.createQuery("select t from Client t");
        List<Client> clientList = q.getResultList();
        for (Client client : clientList) {
          System.out.println(client);
        }
        System.out.println("Size: " + clientList.size());
        
        Query p=em.createQuery("select t from Provider t");
        List<Provider> providerList = p.getResultList();
        for (Provider provider : providerList) {
          System.out.println(provider);
        }
        System.out.println("Size: " + providerList.size());
        em.close();
    }
}
