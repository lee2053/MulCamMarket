package service;
import java.net.Socket;

import protocol.*;
import dao.Post01;

public class Post01Service extends Service{

	public Post01Service(Socket socket) {
		super(socket);
		// TODO Auto-generated constructor stub
	}
	
	public void service(Protocol p, String userid) {
		IList ilist = (IList) p;
		int sNum = ilist.getsNum();
		Post01 p01 = new Post01();
		IList rilist = p01.query(sNum, userid);
		send.send(rilist);
	}
}
