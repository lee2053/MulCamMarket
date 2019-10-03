package ServerTest;

import java.net.Socket;
import protocol.*;

public class MarketService {
	
	Sender send;
	//DAO 싱글턴
	
	public MarketService(Socket socket) {
		send = new Sender(socket);
	}
	
	public void find(Protocol p) {
		String protocol = p.getProtocol();
		if(protocol.equals("L01")) {
			UserInfo u = (UserInfo) p;
			u.setUname("테스트");
			send.send(u);
		}
	}
	
}
