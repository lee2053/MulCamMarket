package dao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import protocol.*;

public class Verify01 extends FatherDao{
	
	//비밀번호확인쿼리 가지고있는 id와 비밀번호가 같으면 V01_0 비밀번호가 다르면 V01_1
	
	public UserInfo query(String userid, String pw) {
		String sql = "select pw from userinfo where userid = ? and pw = ?";
		PreparedStatement pstmt = null;
		UserInfo u = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			pstmt.setString(2, pw);
			rs = pstmt.executeQuery();
			//비밀번호가 일치하지 않으면
			if(!rs.next()) {
				u = new UserInfo();
				u.setProtocol("V01_1");
				return u;
			}
			//비밀번호가 일치하면
			u = new UserInfo();
			u.setProtocol("V01_0");
			
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
		return u;
	}
}
