package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import protocol.*;

public class Server {
	public static void main(String[] args) {
		try {
			ServerSocket serverSocket = new ServerSocket(5010);
			while(true) {
				Socket socket = serverSocket.accept();
				Thread receive = new Thread(new Receiver(socket));
				receive.start();
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
