package service;
import java.net.Socket;
import server.Sender;

public class Service {
	Sender send;
	public Service(Socket socket) {
		this.send = new Sender(socket);
	}
}
