package dao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import protocol.*;

public class Find01 extends FatherDao{
	
	//F01_1 전화번호 일치 이름 불일치 (잘못입력함) 이게 두번째 
	//F01_2 전화번호 불일치 (id 존재하지 않음.) 이게 첫번째
	public UserInfo query(String uname, String phone) {
		String sql = "select userid from userinfo where phone = ?";
		PreparedStatement pstmt = null;
		UserInfo r = null;
		ResultSet rs = null;
		try {
			//전화번호 일치 값이 있는지
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, phone);
			rs = pstmt.executeQuery();
			//만약 전화번호가 없으면
			if (!rs.next()) {
				r = new UserInfo();
				r.setProtocol("F01_2");
				return r;
			}
			//전화번호랑 이름이랑 같이 일치하는 값이 있는지
			sql = "select userid from userinfo where uname = ? and phone = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, uname);
			pstmt.setString(2, phone);
			rs = pstmt.executeQuery();
			//전화번호랑 이름이랑 일치하는 값이 없으면
			if(!rs.next()) {
				r = new UserInfo();
				r.setProtocol("F01_1");
				return r;
			}
			//일치하면 이거 아직 테스트 완료.
			r = new UserInfo();
			r.setProtocol("F01_0");
			r.setUserId(rs.getString(1));
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
