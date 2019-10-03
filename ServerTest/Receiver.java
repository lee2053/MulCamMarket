package ServerTest;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

import protocol.*;

public class Receiver implements Runnable{
	
	//클라이언트랑 1:1로 연결된 소켓과 쓰레드
	String id;
	
	MarketService mService; 
	Socket socket;
	Protocol p;
	
	
	public Receiver(Socket socket) {
		mService = new MarketService(socket);
		this.socket = socket;
	}
	
	
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(this.socket.getInputStream()));
			//쿼리문 날리는 클래스 생성
			
			while(true) {
				try {
					Protocol p = (Protocol)in.readObject();
					System.out.println("서버에서 읽음");
					String msg = p.getProtocol();
					System.out.println(msg);
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println(socket.getRemoteSocketAddress() + " 연결끊김");//클라이언트가 끊을 때라서 다시해야됌 
		}
		
	}

}
