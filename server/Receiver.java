package server;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import protocol.*;
import service.LoginService;

public class Receiver implements Runnable{
	
	//클라이언트랑 1:1로 연결된 소켓과 쓰레드
	private MarketService mService; 
	private Socket socket;
	
	public Receiver(Socket socket) {
		mService = new MarketService(socket);
		this.socket = socket;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			ObjectInputStream in = new ObjectInputStream(
					new BufferedInputStream(this.socket.getInputStream()));
			//쿼리문 날리는 클래스 생성
			
			while(true) {
				try {
					Protocol p = (Protocol)in.readObject();
					System.out.println("서버가 읽음");
					System.out.println("프로토콜 : "+p.getProtocol());
					//서비스에서 프로토콜의 값이 뭔지 확인하고 값을 전송하는 메소드.
					mService.find(p);
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("연결끊김");
		}
		
	}
}
