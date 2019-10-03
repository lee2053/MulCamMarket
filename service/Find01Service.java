package service;

import java.net.Socket;
import protocol.*;
import dao.Find01;

public class Find01Service extends Service{

	public Find01Service(Socket socket) {
		super(socket);
		// TODO Auto-generated constructor stub
	}

	public void service(Protocol p) {
		UserInfo u = (UserInfo) p;
		String uname = u.getUname();
		String phone = u.getPhone();
		Find01 f01 = new Find01();
		UserInfo r = f01.query(uname, phone);
		send.send(r);
	}
}
