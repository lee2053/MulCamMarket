package dao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import protocol.*;

public class Admin02  extends FatherDao{
	
	//가지고있는 id와 클라이언트로부터 snum을 받아서 글의 cdate 상태를 default로 설정 
	//업데이트된 값을 전송
	public ArraySList query(String userid, int sNum) {
		String sql = "update slist set cdate = default where snum=?";
		PreparedStatement pstmt = null;
		ArraySList asl = null;
		ResultSet rs = null;
		
		try {
			//cdate를 default로 설정
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, sNum);
			pstmt.executeUpdate();
			
			//내가 가진 판매목록을 불러오기
			sql = "select * from slist where wid=? order by rdate desc";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			rs = pstmt.executeQuery();
			asl = WrapSList.wrap(rs);
			asl.setProtocol("A02_0");
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
		
		return asl;
	}
}
