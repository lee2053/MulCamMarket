package dao;
import java.sql.Connection;

public class FatherDao {
	
	protected Connection conn;
	
	public FatherDao() {
		this.conn = MarketDao.getInstance().getConn();
	}
}
