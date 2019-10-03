package service;
import protocol.*;

import java.net.Socket;

import dao.Verify01;

public class Verify01Service extends Service{

	public Verify01Service(Socket socket) {
		super(socket);
		// TODO Auto-generated constructor stub
	}

	public void service(Protocol p, String userid) {
		UserInfo u = (UserInfo) p;
		String pw = u.getPw();
		Verify01 v01 = new Verify01();
		UserInfo r = v01.query(userid, pw);
		send.send(r);
	}
}
