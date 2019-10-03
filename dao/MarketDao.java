package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MarketDao {
	//L01
	private Connection conn; // 연결객체를 필드로 선언

	// 연결을 위한 정보를 상수로 정의
	private final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private final String USER = "multi";
	private final String PWD = "multi234";
	
	private static MarketDao instance;
	
	private MarketDao() {
		// Connection 객체를 얻어서 DB와의 연결
		try {
			conn = DriverManager.getConnection(URL, USER, PWD);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static MarketDao getInstance() {
		if(instance == null) {
			instance = new MarketDao();
		}
		return instance;
	}
	
	
	public Connection getConn() {
		return conn;
	}

	public String getURL() {
		return URL;
	}


	public String getUSER() {
		return USER;
	}


	public String getPWD() {
		return PWD;
	}
}
