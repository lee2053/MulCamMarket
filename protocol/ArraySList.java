package protocol;

import java.util.ArrayList;

public class ArraySList extends Protocol{
	
	ArrayList<SList> list;
	//키워드와 카테고리에 대한 검색이 필요하기 때문에 넣음.
	String keyworld;
	String category;
	String userId;
	//삭제할때
	int sNum;
	
	
	public ArrayList<SList> getList() {
		return list;
	}

	public void setList(ArrayList<SList> list) {
		this.list = list;
	}

	public String getKeyworld() {
		return keyworld;
	}

	public void setKeyworld(String keyworld) {
		this.keyworld = keyworld;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "ArraySList [list=" + list + ", keyworld=" + keyworld + ", category=" + category + "]";
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
	
	
}
