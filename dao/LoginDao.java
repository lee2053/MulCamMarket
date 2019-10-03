package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import protocol.*;

public class LoginDao  extends FatherDao{
	
	public UserInfo query(String id, String pw) {
		String sql = "select userid from userinfo where userid = ?"; 
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		UserInfo login = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			//아이디가 존재하지 않을 때
			if (!rs.next()) {
				login = new UserInfo();
				login.setProtocol("L01_2");
				return login;
			}
			//아이디랑 비밀번호가 일치하지 않을 때
			sql = "select userid,pw from userinfo where userid=? and pw =?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			rs = pstmt.executeQuery();
			if(!rs.next()) {
				login = new UserInfo();
				login.setProtocol("L01_1");
				return login;
			}
			//아이디랑 비밀번호가 일치할 때
			login = new UserInfo();
			login.setProtocol("L01_0");
			login.setUserId(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(pstmt!= null && !pstmt.isClosed()) pstmt.close();
				if(rs != null && !rs.isClosed()) rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return login;		
	}
}


