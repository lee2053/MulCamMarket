package protocol;

import java.util.ArrayList;

public class ArrayIList extends Protocol{
	
	ArrayList<IList> list;
	String userId; //이 아이디로 검색
	int sNum;
	
	public ArrayList<IList> getList() {
		return list;
	}
	public void setList(ArrayList<IList> list) {
		this.list = list;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public int getsNum() {
		return sNum;
	}
	public void setsNum(int sNum) {
		this.sNum = sNum;
	}
	@Override
	public String toString() {
		return "ArrayIList [list=" + list + ", userId=" + userId + ", sNum=" + sNum + "]";
	}
	
}
