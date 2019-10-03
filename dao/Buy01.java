package dao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import protocol.*;

public class Buy01 extends FatherDao{

	public ArraySList query(String keyworld) {
		String sql = "select * from slist where stitle like ? order by rdate desc";
		PreparedStatement pstmt = null;
		ArraySList asl = null;
		ResultSet rs = null;
		String compare = "%"+keyworld+"%";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, compare);
			rs = pstmt.executeQuery();
			asl = WrapSList.wrap(rs);
			asl.setProtocol("B01_0");
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
