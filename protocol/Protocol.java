package protocol;

import java.io.Serializable;

public class Protocol implements Serializable{
	
	String protocol;
	

	public String getProtocol() {
		return protocol;
	}

	public void setProtocol(String protocol) {
		this.protocol = protocol;
	}

	@Override
	public String toString() {
		return "Protocol [protocol=" + protocol + "]";
	}
	
}
