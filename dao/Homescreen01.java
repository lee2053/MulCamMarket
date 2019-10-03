package dao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import protocol.*;

public class Homescreen01 extends FatherDao{
	
	//DB에서 slist의 전체 레코드를 list에 담아서 리턴
	public ArraySList query() {
		String sql = "select * from slist order by rdate desc";
		PreparedStatement pstmt = null;
		ArraySList asl = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			//arrayslist객체 생성
			asl = new ArraySList();
			asl = WrapSList.wrap(rs);
			asl.setProtocol("H01_0");
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
