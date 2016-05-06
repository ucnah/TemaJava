package com.scaietii.PaymentSystem.Server;

import java.net.*;
import java.io.*;
import java.util.concurrent.*;

public class MyServer
{
	static final int NTHREADS = 100;
	static ExecutorService exec = Executors.newFixedThreadPool(NTHREADS);

	public static void main(String[] args) throws IOException
	{

		int port = 7999;
		boolean listening = true;
		ServerSocket serverSocket = null;
		try
		{
			serverSocket = new ServerSocket(port);
			System.out.println("Server started, listening on port: " + port);
		} 
		catch (IOException e)
		{
			System.err.println("Could not listen on port: " + port);
			System.err.println(e.getMessage());
			System.exit(1);
		}

		while (listening)
		{
			AppThread obj = new AppThread(serverSocket.accept());
			exec.execute(obj);
		}
		serverSocket.close();
	}
}
