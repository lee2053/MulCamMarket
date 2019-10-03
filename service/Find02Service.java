package service;

import java.net.Socket;
import protocol.*;
import dao.Find02;


public class Find02Service extends Service{

	public Find02Service(Socket socket) {
		super(socket);
		// TODO Auto-generated constructor stub
	}

	public void service(Protocol p) {
		UserInfo u = (UserInfo) p;
		String userid = u.getUserId();
		String uname = u.getUname();
		String phone = u.getPhone();
		Find02 f02 = new Find02();
		UserInfo r = f02.query(userid, uname, phone);
		send.send(r);
	}
}
