package service;

import java.net.Socket;

import dao.Edit02;
import protocol.Protocol;
import protocol.UserInfo;

public class Edit02Service extends Service{

	public Edit02Service(Socket socket) {
		super(socket);
		// TODO Auto-generated constructor stub
	}

	public void service(Protocol p) {
		UserInfo u = (UserInfo) p;
		String phone = u.getPhone();
		Edit02 e02 = new Edit02();
		UserInfo r = e02.query(phone);
		send.send(r);
	}
}
