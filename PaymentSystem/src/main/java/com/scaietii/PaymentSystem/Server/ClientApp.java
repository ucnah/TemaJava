package com.scaietii.PaymentSystem.Server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.scaietii.PaymentSystem.entities.Client;

public class ClientApp
{
	private static final String PERSISTENCE_UNIT_NAME = "TemaJava";
	private static EntityManagerFactory factory;
	private Boolean connected = false;
	private EntityManager conn = null;
	
	private void connectToDd() throws ClassNotFoundException, SQLException
	{
		factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        conn = factory.createEntityManager();
		if(conn != null)
		{
			System.out.println("Connected to DB");
			connected = true;
		}
		else
		{
			System.out.println("Could not connec to DB");
			connected = false;
		}
	}
	
	/*public String getClientNameById(int id) throws SQLException, ClassNotFoundException
	{
		factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        em = factory.createEntityManager();
		String name = "Client with id " + id + " doesn't exist !";
		
		Statement s = null;
		
		// conectare la baza de date
		connectToDd();
		
		if (connected)
		{
			
			 Query q = (Query) em.createQuery("select t from Client t where id = :id");
			    List<Client> ClientList = ((javax.persistence.Query) q).getResultList();
			    for (Todo todo : todoList) {
			      System.out.println(todo);
			// statement pentru a putea executa query-uri pe baza de date
			s = em.createStatement();
			
			//pentru stocarea rezultatelor query-urilor
			ResultSet rs;

			//verificare daca fisierul a mai fost incarcat
			rs = s.executeQuery("select nameuser from user_table where iduser = " + id);
			
			while(rs.next())
			{
				name = rs.getString("nameuser");
				System.out.println("Result sent to client");
			}
		}
		
		System.out.println("Disconnected from DB");
		return name;
	}*/
	
	public String addClient(String name, String username, String password, int deposit) throws ClassNotFoundException
	{
		String result = "Not Ok";
		try {
			connectToDd();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		/* EntityManager em = factory.createEntityManager();
		 // Begin a new local transaction so that we can persist a new entity
		 em.getTransaction().begin();
		 Query q = em.createQuery("SELECT c FROM Client c WHERE p.firstName = :firstName AND p.lastName = :lastName");
		*/
		
		conn.getTransaction().begin();
	    Client todo = new Client();
	  //  s.executeUpdate("insert into Client(name, username, password) values(" + id + ", '" + name + "' + "+username)");
	  //  todo.setName("This is a test");
	    todo.setName(name);
	    todo.setUsername(username);
	    todo.setPassword(password);
	    todo.setDeposit(deposit);
	    conn.persist(todo);
	    conn.getTransaction().commit();
	    System.out.println("User added to Db");
		result = "User added to Db";
	    conn.close();
		System.out.println("Disconnected from DB");
		return result;
	}
}
