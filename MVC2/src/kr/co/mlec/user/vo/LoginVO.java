package kr.co.mlec.user.vo;

public class LoginVO {

	
	public LoginVO(String id, String password) {
		super();
		this.id = id;
		this.password = password;
	}
	
	
	private String id;
	private String password;
	private String type; // s면 관리자 u는 일반 사용자
	public LoginVO() {
		
	}
	public LoginVO(String id, String password, String type) {
		super();
		this.id = id;
		this.password = password;
		this.type = type;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "LoginVO [id=" + id + ", password=" + password + ", type=" + type + "]";
	}
	
	
	
	
}
