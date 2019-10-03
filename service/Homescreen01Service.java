package service;

import java.net.Socket;
import protocol.*;
import dao.Homescreen01;

public class Homescreen01Service extends Service{
	
	public Homescreen01Service(Socket socket) {
		super(socket);
		// TODO Auto-generated constructor stub
	}
	
	public void service(Protocol p) {
		ArraySList asl = (ArraySList) p;
		Homescreen01 h01 = new Homescreen01();
		ArraySList rasl = h01.query();
		send.send(rasl);
	}
}
