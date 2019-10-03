package protocol;

import java.util.Date;

public class SList extends Protocol{
	
	private int sNum;
	private String sTitle;
	private String category;
	private int pState;
	private int price;
	private String details;
	private Date cDate;
	private Date rDate;
	
	private String userId;
	
	
	public int getsNum() {
		return sNum;
	}
	public void setsNum(int sNum) {
		this.sNum = sNum;
	}
	public String getsTitle() {
		return sTitle;
	}
	public void setsTitle(String sTitle) {
		this.sTitle = sTitle;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getpState() {
		return pState;
	}
	public void setpState(int pState) {
		this.pState = pState;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public Date getcDate() {
		return cDate;
	}
	public void setcDate(Date cDate) {
		this.cDate = cDate;
	}
	public Date getrDate() {
		return rDate;
	}
	public void setrDate(Date rDate) {
		this.rDate = rDate;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	@Override
	public String toString() {
		return "SList [sNum=" + sNum + ", sTitle=" + sTitle + ", category=" + category + ", pState=" + pState
				+ ", price=" + price + ", details=" + details + ", cDate=" + cDate + ", rDate=" + rDate + ", userId="
				+ userId + "]";
	}
}
