package protocol;

public class IList extends Protocol{
	
	private int sNum;
	private String userId;
	
	
	
	public int getsNum() {
		return sNum;
	}
	public void setsNum(int sNum) {
		this.sNum = sNum;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	@Override
	public String toString() {
		return "IList [sNum=" + sNum + ", userId=" + userId + "]";
	}
}
