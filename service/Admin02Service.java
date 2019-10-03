package service;
import protocol.*;
import dao.Admin02;
import java.net.Socket;

public class Admin02Service extends Service{

	public Admin02Service(Socket socket) {
		super(socket);
		// TODO Auto-generated constructor stub
	}

	public void service(Protocol p, String userid) {
		ArraySList asl = (ArraySList) p;
		int sNum = asl.getsNum();
		Admin02 a02 = new Admin02();
		ArraySList rasl = a02.query(userid, sNum);
		send.send(rasl);
	}
}
