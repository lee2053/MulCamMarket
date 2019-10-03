package dao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import protocol.*;

public class Change01 extends FatherDao{

	//프로토콜은 M01_0으로 보내기
	public ArraySList query(String userid, String stitle, 
			String category, int pstate, int price, String details, int sNum) {
		//cdate는 여기서 수정하는 것이 아니다.
		String sql = "update slist set stitle=?, category=?, pstate=?, price=?, details=?, rdate = default where snum=?";
		PreparedStatement pstmt = null;
		ArraySList asl = null;
		ResultSet rs = null;
		
		try {
			//글내용 업데이트
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, stitle);
			pstmt.setString(2, category);
			pstmt.setInt(3, pstate);
			pstmt.setInt(4, price);
			pstmt.setString(5, details);
			pstmt.setInt(6, sNum);
			pstmt.executeUpdate();
			
			//M01_0프로토콜 보내기
			sql = "select * from slist where wid=? order by rdate desc";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			rs = pstmt.executeQuery();
			asl = WrapSList.wrap(rs);
			asl.setProtocol("M01_0");
			
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
