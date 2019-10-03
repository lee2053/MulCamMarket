package service;
import protocol.*;

import java.net.Socket;

import dao.Sale01;
public class Sale01Service extends Service{

	public Sale01Service(Socket socket) {
		super(socket);
		// TODO Auto-generated constructor stub
	}
	
	public void service(Protocol p, String userid) {
		SList slist = (SList) p;
		String sTitle = slist.getsTitle();
		String category = slist.getCategory();
		int pstate = slist.getpState();
		int price = slist.getPrice();
		String details = slist.getDetails();
		Sale01 s01 = new Sale01();
		SList rslist = s01.query(sTitle, category, pstate, price, details, userid);
		send.send(rslist);
	}
}
