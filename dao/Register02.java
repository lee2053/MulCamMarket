package dao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import protocol.*;

public class Register02 extends FatherDao{
	
	//폰번호중복확인
	public UserInfo query(String phone) {
		String sql = "select phone from userinfo where phone =?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		UserInfo r = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, phone);
			rs = pstmt.executeQuery();
			//값이 없으면
			if (!rs.next()) {
				r = new UserInfo();
				r.setProtocol("R02_0");
				return r;
			}
			//값이 있으면
			r = new UserInfo();
			r.setProtocol("R02_1");
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
