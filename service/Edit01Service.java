package service;
import protocol.*;

import java.net.Socket;

import dao.Edit01;

public class Edit01Service extends Service{

	public Edit01Service(Socket socket) {
		super(socket);
		// TODO Auto-generated constructor stub
	}

	public void service(Protocol p, String userid) {
		UserInfo u = (UserInfo) p;
		String pw = u.getPw();
		String uname = u.getUname();
		String phone = u.getPhone();
		int croom = u.getcRoom();
		Edit01 e01 = new Edit01();
		UserInfo r = e01.query(userid, pw, uname, phone, croom);
		send.send(r);
	}
}
