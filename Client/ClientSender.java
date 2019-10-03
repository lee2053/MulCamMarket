package Client;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import protocol.*;

public class ClientSender {
	private static ClientSender cinstance;
	private Socket clientsocket;
	private static ObjectOutputStream out;
	
	public static ClientSender getInstance(Socket socket){
		if(cinstance == null) {
			cinstance = new ClientSender(socket);
		}else {
			cinstance.clientsocket = socket;
		}
		setWriter(socket);
		return cinstance;
	}
	
	private ClientSender(Socket socket) {
		clientsocket = socket;
	}
	
	private static void setWriter(Socket socket) {
		try {
			out = new ObjectOutputStream(
					new BufferedOutputStream(socket.getOutputStream()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
		}
	}
	
	public void Sender(Protocol p) {
		try {
			out.writeObject(p);
			out.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
