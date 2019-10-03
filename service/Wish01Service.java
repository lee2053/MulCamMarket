package service;
import protocol.*;

import java.net.Socket;

import dao.Wish01;

public class Wish01Service extends Service{

	public Wish01Service(Socket socket) {
		super(socket);
		// TODO Auto-generated constructor stub
	}

	public void service(Protocol p, String userid) {
		ArraySList asl = (ArraySList) p;
		int sNum = asl.getsNum();
		Wish01 w01 = new Wish01();
		ArraySList rasl = w01.query(userid, sNum);
		send.send(rasl);
	}
}
