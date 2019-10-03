package service;

import java.net.Socket;
import protocol.*;
import dao.Admin01;

public class Admin01Service extends Service{

	public Admin01Service(Socket socket) {
		super(socket);
		// TODO Auto-generated constructor stub
	}

	public void service(Protocol p, String userid) {
		ArraySList asl = (ArraySList) p;
		int sNum = asl.getsNum();
		Admin01 a01 = new Admin01();
		ArraySList rasl = a01.query(userid, sNum);
		send.send(rasl);
	}
}
