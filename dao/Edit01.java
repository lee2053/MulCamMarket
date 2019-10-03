package dao;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import protocol.*;

public class Edit01 extends FatherDao{
	
	//새로 입력된 회원정보를 id를 찾아서 레코드 값을 바꿈.
	public UserInfo query(String userid, String pw, String uname, 
			String phone, int croom) {
		String sql = "update userinfo set pw =?, uname =?, phone =?, croom =? where userid =?";
		PreparedStatement pstmt = null;
		UserInfo u = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pw);
			pstmt.setString(2, uname);
			pstmt.setString(3, phone);
			pstmt.setInt(4, croom);
			pstmt.setString(5, userid);
			pstmt.executeUpdate();
			u = new UserInfo();
			u.setProtocol("E01_0");
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
		return u;
	}
}
