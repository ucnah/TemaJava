package testmain;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class MyClient
{
	public static void main(String[] args) throws IOException
	{
		String host = "localhost";
		int port = 7999;

		Socket serverSocket = null;
		DataInputStream in = null;
		DataOutputStream out = null;
		
		try
		{
			serverSocket = new Socket(host, port);
			out = new DataOutputStream(serverSocket.getOutputStream());
			in = new DataInputStream(serverSocket.getInputStream());
			
			System.out.println("Connected to server");
		} 
		catch (Exception e)
		{
			System.err.println("Connection Error : " + e.getMessage());
			System.exit(1);
		}

		Scanner scanner = new Scanner(System.in);
		String command;
		String result;
		
		System.out.print("Command = ");
		command = scanner.nextLine();
		
		switch (command)
		{
			case "getNameById" : 
				System.out.print("Id = ");
				String id = scanner.nextLine();
				
				try
				{
					out.writeUTF(command + "-" + id);
	
					result = in.readUTF();
	
					System.out.println("Name = " + result);
				} 
				catch (IOException e)
				{
					System.err.println("Client comunication error : " + e.getMessage());
				}
				break;
				
			case "addClient" : 
				
				System.out.print("Name = ");
				String name = scanner.nextLine();
				
				System.out.print("Username = ");
				String username = scanner.nextLine();
				
				System.out.print("Password = ");
				String password = scanner.nextLine();
				
				System.out.println("Deposit = ");
				int deposit = scanner.nextInt();
				
				try
				{
					out.writeUTF(command + "-" + name + "-" + username + "-" + password + "-" + deposit);
	
					result = in.readUTF();
	
					System.out.println(result);
				} 
				catch (IOException e)
				{
					System.err.println("Client comunication error : " + e.getMessage());
				}
				break;
				
			default : 
				try
				{
					out.writeUTF("default");
				
					result = in.readUTF();
				
					System.out.println("Result = " + result);
				} 
				catch (IOException e)
				{
					System.err.println("Client comunication error : " + e.getMessage());
				}
				break;
		}

		scanner.close();
		
		out.close();
		in.close();
		serverSocket.close();
		
		System.out.println("Disconnected from server");
	}
}
