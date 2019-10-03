package Client;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.sql.Timestamp;

import protocol.Protocol;

public class ClientReciver implements Runnable {
	Socket thissocket;
	ObjectInputStream in;
	public ClientReciver(Socket s) {
		thissocket = s;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			while(true) {
			in = new ObjectInputStream(
					new BufferedInputStream(thissocket.getInputStream()));
			Protocol p = (Protocol)in.readObject();
			// 패널로 프로토콜을 보내
			}
		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
