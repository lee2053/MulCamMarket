package service;

import java.net.Socket;
import protocol.*;
import dao.MyPage02;

public class MyPage02Service extends Service{

	public MyPage02Service(Socket socket) {
		super(socket);
		// TODO Auto-generated constructor stub
	}
	public void service(Protocol p, String userid) {
		ArraySList asl = (ArraySList) p;
		MyPage02 m02 = new MyPage02();
		ArraySList rasl = m02.query(userid);
		send.send(rasl);
	}
}
