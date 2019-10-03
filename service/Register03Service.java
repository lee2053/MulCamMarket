package service;

import java.net.Socket;
import protocol.*;
import dao.Register03;

public class Register03Service extends Service{

	public Register03Service(Socket socket) {
		super(socket);
		// TODO Auto-generated constructor stub
	}

	public void service(Protocol p) {
		UserInfo u = (UserInfo) p;
		String userid = u.getUserId();
		String pw = u.getPw();
		String uname = u.getUname();
		String phone = u.getPhone();
		int croom = u.getcRoom();
		
		Register03 r03 = new Register03();
		UserInfo r = r03.query(userid, pw, uname, phone, croom);
		send.send(r);
	}
}
