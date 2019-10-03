package dao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import protocol.*;

public class WrapSList {
	
	
	public static ArraySList wrap(ResultSet rs) {
		
		ArraySList asl = new ArraySList();
		ArrayList<SList> list = new ArrayList<SList>();
		try {
			while(rs.next()) {
				SList slist = new SList();
				slist.setsNum(rs.getInt(1));
				slist.setsTitle(rs.getString(2));
				slist.setCategory(rs.getString(3));
				slist.setpState(rs.getInt(4));
				slist.setPrice(rs.getInt(5));
				slist.setDetails(rs.getString(6));
				slist.setcDate(rs.getTimestamp(7));
				slist.setrDate(rs.getTimestamp(8));
				slist.setUserId(rs.getString(9));
				list.add(slist);
			}
			asl.setList(list);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(rs != null && !rs.isClosed()) rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return asl;
	}
}
