package dao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import protocol.*;


public class Post01 extends FatherDao{
	
	//관심목록 추가
	//중복확인을 위해 가지고있는 id와 글의 번호를 통해서 일치하는 값이 있나 확인. 일치하는 값이 있으면 P01_1 프로토콜 날려
	//중복된 값이 없으면 관심목록에 insert하고 P01_0 프로토콜 날리기
	//값을 insert할때 pk값을 설정해주고 해야 함.
	public IList query(int sNum, String userid) {
		String sql = "select * from ilist where wid = ? and snum = ?";
		PreparedStatement pstmt = null;
		IList ilist = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			pstmt.setInt(2, sNum);
			rs = pstmt.executeQuery();
			//값이 없으면 추가
			//만약 ilist에 없으면 ilist에 추가
			if (!rs.next()) {
				//키값 확인
				int num = 0;
				sql = "select * from ilist order by inum desc";
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
				rs.next();
				num = rs.getInt(1)+1;
//				while(rs.next()) {
//					num++;
//				}
//				num++;
				System.out.println(num);
				sql="insert into ilist values(?, ?, ?)";
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, num);
				pstmt.setInt(2, sNum);
				pstmt.setString(3, userid);
				//값 넣기
				pstmt.executeUpdate();
				ilist = new IList();
				ilist.setProtocol("P01_0");
				return ilist;
			}
			//값이 있으면 P01_1
			ilist = new IList();
			ilist.setProtocol("P01_1");
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
		return ilist;
	}
}
