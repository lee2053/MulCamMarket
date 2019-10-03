package dao;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import protocol.*;

public class Admin01 extends FatherDao{
	
	//삭제를 할 때 ilist의 내용을 먼저 삭제를 한 후에 글을 삭제를 해야 한다.
	//그렇기 때문에 쿼리문을 두 단계로 가야 한다.
	//그리고 제대로 업데이트 된 목록을 주어야 하기 때문에 ArraySList 형식으로 리턴한다.
	public ArraySList query(String userid, int sNum) {
		//ilist에 있는 레코드 값 지우기. sNum으로 지운다. 다지워야되니까
		String sql = "delete from ilist where snum = ?";
		PreparedStatement pstmt = null;
		ArraySList asl = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, sNum);
			pstmt.executeUpdate();
			//slist에서도 완전히 지움
			sql = "delete from slist where snum=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, sNum);
			pstmt.executeUpdate();
			//새로운 내가 판매중인 상품을 불러옴
			sql = "select * from slist where wid=? order by rdate desc";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			rs = pstmt.executeQuery();
			asl = WrapSList.wrap(rs);
			asl.setProtocol("A01_0");
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
