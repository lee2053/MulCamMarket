package dao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import protocol.*;

public class MyPage02 extends FatherDao{
	
	//관심상품 찾기 있는 id로 관심상품이 있는지 찾는다. 그것을 배열로 저장해서 보여준다. 
	public ArraySList query(String userid) {
		String sql = 
		"select * from slist, ilist where slist.snum = ilist.snum and ilist.wid=? order by inum desc";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArraySList asl = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			rs = pstmt.executeQuery();
			asl = WrapSList.wrap(rs);
			asl.setProtocol("M02_0");
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
