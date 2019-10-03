package server;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import protocol.*;

public class Sender {
	
	private Socket socket;
	private ObjectOutputStream out;
	
	public Sender(Socket socket) {
		this.socket = socket;
		try {
			out = new ObjectOutputStream(new BufferedOutputStream(this.socket.getOutputStream()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void send(Protocol p) {
		try {
			out.writeObject(p);
			out.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
