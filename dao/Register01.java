package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import protocol.*;

public class Register01 extends FatherDao{
	
	public UserInfo query(String userId) {
		String sql = "select userid from userinfo where userid= ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		UserInfo r = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			rs = pstmt.executeQuery();
			//만약 id가 없으면
			if (!rs.next()) {
				r = new UserInfo();
				r.setProtocol("R01_0");
				return r;
			}
			r = new UserInfo();
			r.setProtocol("R01_1");
			//id가 있으면
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
