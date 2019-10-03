package service;
import java.net.Socket;
import dao.Buy01;
import protocol.*;

public class Buy01Service extends Service{

	public Buy01Service(Socket socket) {
		super(socket);
		// TODO Auto-generated constructor stub
	}
	
	public void service(Protocol p) {
		ArraySList asl = (ArraySList) p;
		String keyworld = asl.getKeyworld();
		Buy01 b01 = new Buy01();
		ArraySList rasl = b01.query(keyworld);
		send.send(rasl);
	}
}
