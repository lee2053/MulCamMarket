package dao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import protocol.*;


public class Find02 extends FatherDao{
	
	//비밀번호찾기DAO 
	//F02_1 : id 일치 이름 또는 전화번호 불일치 이게 두 번째
	//F02_2 : ID 불일치 이게 첫 번째
	public UserInfo query(String userid, String uname, String phone) {
		String sql = "select pw from userinfo where userid = ?";
		PreparedStatement pstmt = null;
		UserInfo r = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			rs = pstmt.executeQuery();
			//만약 일치하는 id가 없으면
			if (!rs.next()) {
				r = new UserInfo();
				r.setProtocol("F02_2");
				return r;
			}
			
			sql = "select pw from userinfo where userid =? and uname =? and phone =?";
			//pstmt 꼭 다시 초기화해라!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			pstmt.setString(2, uname);
			pstmt.setString(3, phone);
			rs = pstmt.executeQuery();
			//일치하는 비밀번호가 없으면
			if(!rs.next()) {
				r = new UserInfo();
				r.setProtocol("F02_1");
				return r;
			}
			r = new UserInfo();
			r.setProtocol("F02_0");
			r.setPw(rs.getString(1));
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
		return r;
	}
}
