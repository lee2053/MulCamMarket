package dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import protocol.*;

public class Register03 extends FatherDao{
	
	//회원정보를 DB에 저장하는 쿼리.
	
	public UserInfo query(String userid, String pw, String uname, 
			String phone, int croom) {
		String sql = "insert into userinfo values(?, ?, ?, ?, ?)";
		PreparedStatement pstmt = null;
		UserInfo r = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			pstmt.setString(2, pw);
			pstmt.setString(3, uname);
			pstmt.setString(4, phone);
			pstmt.setInt(5, croom);
			pstmt.executeUpdate();
			System.out.println("레코드 생성 완료");
			r = new UserInfo();
			r.setProtocol("R03_0");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(pstmt!= null && !pstmt.isClosed()) pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		return r;
	}
}
