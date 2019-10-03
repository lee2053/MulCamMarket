package Client.Frame;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JFrame;

import Client.ClientSender;
import protocol.Protocol;


public class FrameManager {
	private static LogInFrame login_frame;
	private static MainFrame main_frame;
	static Socket socket = null;
	static ClientSender sender = null;
	
	public FrameManager(){
		new Thread(new clientThread()).start();
		
		
		login_frame = new LogInFrame();
		main_frame = new MainFrame();
		login_frame.setVisible(true);
		main_frame.setVisible(false);
	}
	
	public static void turnFrame(String s) {
		if(s.equals("main")) {
			login_frame.setVisible(false);
			main_frame.setVisible(true);
		}else if(s.equals("logout")) {
			login_frame.setVisible(true);
			main_frame.setVisible(false);
			try {
				socket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	class clientThread implements Runnable{
		@Override
		public void run() {
			// TODO Auto-generated method stub
			try {
				socket = new Socket(InetAddress.getByName("70.12.247.143"), 5010);
				sender = ClientSender.getInstance(socket);
				
				while(true) {
					if(socket.isClosed()) { 
						socket = new Socket(InetAddress.getByName("70.12.247.143"), 5010);
						sender = ClientSender.getInstance(socket);
//						login_frame.setSocket(socket);
						System.out.println("여기가 되긴 함");
					}
				}
			} catch (UnknownHostException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}