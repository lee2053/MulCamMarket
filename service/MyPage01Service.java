package service;

import java.net.Socket;
import protocol.*;
import dao.MyPage01;
import dao.MyPage02;

public class MyPage01Service extends Service{

	public MyPage01Service(Socket socket) {
		super(socket);
		// TODO Auto-generated constructor stub
	}

	public void service(Protocol p, String userid) {
		ArraySList asl = (ArraySList) p;
		MyPage01 m01 = new MyPage01();
		ArraySList rasl = m01.query(userid);
		send.send(rasl);
	}
}
