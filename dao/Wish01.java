package dao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import protocol.*;

public class Wish01 extends FatherDao{

	//관심상품 삭제. 가지고있는 userid와 클라이언트에게 받은 sNum값으로 관심상품을 삭제 후 새목록을 보내줌
	//ilist의 INUM순으로 정렬해서 보내주기
	public ArraySList query(String userid, int sNum) {
		String sql = "delete from ilist where wid=? and sNum=?";
		PreparedStatement pstmt = null;
		ArraySList asl = null;
		ResultSet rs = null;
		//지우기
		try {
			//값 지우기
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			pstmt.setInt(2, sNum);
			pstmt.executeUpdate();
			
			//값 다시 보내주기 inum정렬을 통해서 
			asl = new ArraySList();
			asl.setProtocol("W01_0");
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
