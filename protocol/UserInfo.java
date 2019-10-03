package protocol;


public class UserInfo extends Protocol{
	
	private String userId;
	private String pw;
	private String uname;
	private String phone;
	private int cRoom;
	
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getcRoom() {
		return cRoom;
	}
	public void setcRoom(int cRoom) {
		this.cRoom = cRoom;
	}
	@Override
	public String toString() {
		return "UserInfo [userId=" + userId + ", pw=" + pw + ", uname=" + uname + ", phone=" + phone + ", cRoom="
				+ cRoom + "]";
	}
	
}
