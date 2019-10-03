package server;

import java.net.Socket;
import protocol.*;
import service.*;

public class MarketService {
	
	private String id;
	private Socket socket;
//	
	public MarketService(Socket socket) {
		this.socket = socket;
	}
	
	public void find(Protocol p) {
		String protocol = p.getProtocol();
		if(p.getProtocol().equals("L01")) {
			LoginService ls = new LoginService(this.socket);
			this.id = ls.service(p);
			System.out.println(this.id);//이거 해봐야됌 
		}
		else if(protocol.equals("R01")) {
			Register01Service r01 = new Register01Service(this.socket);
			r01.service(p);
		}
		else if(protocol.equals("R02")) {
			Register02Service r02 = new Register02Service(this.socket);
			r02.service(p);
		}
		else if(protocol.equals("R03")) {
			Register03Service r03 = new Register03Service(this.socket);
			r03.service(p);
		}
		else if(protocol.equals("F01")) {
			Find01Service f01 = new Find01Service(this.socket);
			f01.service(p);
		}
		else if(protocol.equals("F02")) {
			Find02Service f02 = new Find02Service(this.socket);
			f02.service(p);
		}
		else if(protocol.equals("H01")) {
			Homescreen01Service h01 = new Homescreen01Service(this.socket);
			h01.service(p);
		}
		//B01 아직 안했음
		else if(protocol.equals("B01")) {
			Buy01Service b01 = new Buy01Service(this.socket);
			b01.service(p);
		}
		else if(protocol.equals("B02")) {
			Buy02Service b02 = new Buy02Service(this.socket);
			b02.service(p);
		}
		else if(protocol.equals("P01")) {
			Post01Service p01 = new Post01Service(this.socket);
			p01.service(p, this.id);
		}
		else if(protocol.equals("S01")) {
			Sale01Service s01 = new Sale01Service(this.socket);
			s01.service(p, this.id);
		}
		else if(protocol.equals("M01")) {
			MyPage01Service m01 = new MyPage01Service(this.socket);
			m01.service(p, this.id);
		}
		else if(protocol.equals("M02")) {
			MyPage02Service m02 = new MyPage02Service(this.socket);
			m02.service(p, this.id);
		}
		else if(protocol.equals("V01")) {
			Verify01Service v01 = new Verify01Service(this.socket);
			v01.service(p, this.id);
		}
		else if(protocol.equals("E01")) {
			Edit01Service e01 = new Edit01Service(this.socket);
			e01.service(p, this.id);
		}
		else if(protocol.equals("E02")) {
			Edit02Service e02 = new Edit02Service(this.socket);
			e02.service(p);
		}
		else if(protocol.equals("A01")) {
			Admin01Service a01 = new Admin01Service(this.socket);
			a01.service(p, this.id);
		}
		else if(protocol.equals("A02")) {
			Admin02Service a02 = new Admin02Service(this.socket);
			a02.service(p, this.id);
		}
		else if(protocol.equals("C01")) {
			Change01Service c01 = new Change01Service(this.socket);
			c01.service(p, this.id);
		}
		else if(protocol.equals("W01")){
			Wish01Service w01 = new Wish01Service(this.socket);
			w01.service(p, this.id);
		}
	}
	
}
