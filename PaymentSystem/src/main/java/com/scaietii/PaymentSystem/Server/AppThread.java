package com.scaietii.PaymentSystem.Server;

import java.net.*;
import java.sql.SQLException;

import java.io.*;

public class AppThread extends Thread
{
	Socket socket = null;

	public AppThread(Socket socket)
	{
		this.socket = socket;
		System.out.println("New thread created");
	}

	public void run()
	{
		System.out.println("Thread started");
		
		try
		{
			DataOutputStream out = new DataOutputStream(socket.getOutputStream());
			DataInputStream in = new DataInputStream(socket.getInputStream());

			int id = 0;
			String result = null;
			ClientApp app = new ClientApp();

			String query = in.readUTF();
			
			String[] components = query.split("-");
			
			switch (components[0])
			{
				/*case "getNameById" :
					id = Integer.parseInt(components[1]);

					result = app.getClientNameById(id);
					break;
					*/
				case "addClient" :
					String name = components[1];
					String username = components[2];
					String password = components[3];
					int deposit = Integer.parseInt(components[4]);

					result = app.addClient(name, username, password,deposit);
					break;
					
				default : 
					result = "Default result";
					break;
			}
			
			out.writeUTF(result);
			out.close();
			in.close();
			socket.close();
			
			System.out.println("Thread ended");
		} 
		catch (IOException | ClassNotFoundException e)
		{
			System.err.println("Server comunication error : " + e.getMessage());
		}
	}
}
