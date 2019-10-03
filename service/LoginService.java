package service;

import protocol.*;
import java.net.Socket;
import dao.*;

public class LoginService extends Service{
	
	
	public LoginService(Socket socket) {
		super(socket);
	}

	public String service(Protocol p) {
		String socketId = null;
		UserInfo u = (UserInfo) p;
		String userId = u.getUserId();
		String pw = u.getPw();
		LoginDao ld = new LoginDao();
		UserInfo r = ld.query(userId, pw);
		send.send(r);
		if(r.getProtocol().equals("L01_0")) {
			socketId = r.getUserId();
		}
		return socketId;
	}
}
