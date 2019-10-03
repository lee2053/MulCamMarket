package service;

import java.net.Socket;
import protocol.*;
import dao.Change01;

public class Change01Service extends Service{

	public Change01Service(Socket socket) {
		super(socket);
		// TODO Auto-generated constructor stub
	}

	//slist로 받아서 ArraySList로 보내줌
	public void service(Protocol p, String userid) {
		SList slist = (SList) p;
		String stitle = slist.getsTitle();
		String category = slist.getCategory();
		int pstate = slist.getpState();
		int price = slist.getPrice();
		String details = slist.getDetails();
		int sNum = slist.getsNum();
		Change01 c01 = new Change01();
		ArraySList rasl = c01.query(userid, stitle, category, pstate, price, details, sNum);
		send.send(rasl);
	}
}
