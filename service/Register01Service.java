package service;

import java.net.Socket;
import protocol.*;
import dao.Register01;;

public class Register01Service extends Service{

	public Register01Service(Socket socket) {
		super(socket);
		// TODO Auto-generated constructor stub
	}

	public void service(Protocol p) {
		UserInfo u = (UserInfo) p;
		String userid = u.getUserId();
		Register01 r1 = new Register01();
		UserInfo r = r1.query(userid);
		send.send(r);
	}
}
