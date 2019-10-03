package ServerTest;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import protocol.*;

public class Server {
	public static void main(String[] args) {
		try {
			ServerSocket serverSocket = new ServerSocket(5010);
			while(true) {
				Socket socket = serverSocket.accept();
				
	//			Protocol p = new Protocol();
	//			p.setProtocol("서버에서 보냄");
				// 샌더 객채와 리시버쓰레드를 실행
				Thread receive = new Thread(new Receiver(socket));
				receive.start();
			}
			//샌드로 보냄
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
