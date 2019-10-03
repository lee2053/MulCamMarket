package service;
import protocol.*;

import java.net.Socket;

import dao.Buy02;

public class Buy02Service extends Service{

	public Buy02Service(Socket socket) {
		super(socket);
		// TODO Auto-generated constructor stub
	}
	
	public void service(Protocol p) {
		ArraySList asl = (ArraySList) p;
		String category = asl.getCategory();
		Buy02 b02 = new Buy02();
		ArraySList rasl = b02.query(category);
		send.send(rasl);
	}
}
