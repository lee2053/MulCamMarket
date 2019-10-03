package dao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import protocol.*;

public class Sale01 extends FatherDao{
	//판매등록 
	public SList query(
			String sTitle, String category, int pstate, int price, String details, String userid) {
		//sNum이랑 rDate는 내가 넣어줘야 한다. sNum쿼리를 통해, rDate는 시스템에서 default로
//		String sql = "insert into slist values(?,?,?,?,?,?,null,default,?)";
		String sql = "select * from slist";
		PreparedStatement pstmt = null;
		SList slist = null;
		ResultSet rs = null;
		try {
			int num = 0;
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			//테스트 안됌 
			sql = "select * from slist order by snum desc";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			rs.next();
			num = rs.getInt(1)+1;
			
			sql = "insert into slist values(?,?,?,?,?,?,null,default,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.setString(2, sTitle);
			pstmt.setString(3, category);
			pstmt.setInt(4, pstate);
			pstmt.setInt(5, price);
			pstmt.setString(6, details);
			pstmt.setString(7, userid);
			pstmt.executeUpdate();
			slist = new SList();
			slist.setProtocol("S01_0");
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
		return slist;
	}
}
