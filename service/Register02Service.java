package service;

import java.net.Socket;
import protocol.*;
import dao.Register02;;

public class Register02Service extends Service{

	public Register02Service(Socket socket) {
		super(socket);
		// TODO Auto-generated constructor stub
	}
	public void service(Protocol p) {
		//형변환 핸드폰번호추출 DAO객체 생성 DAO메소드 실행
		UserInfo u = (UserInfo) p;
		String phone = u.getPhone();
		Register02 r02 = new Register02();
		UserInfo r = r02.query(phone);
		send.send(r);
	}
}
