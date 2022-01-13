package kr.co.mlec.board.vo;

public class MemberVO {

	private String id;
	private String name;
	private String password;
	private String emailId;
	private String emailDomain;
	private int tel1;
	private int tel2;
	private int tel3;
	private int post;
	private String basicAddr;
	private String detailAddr;
	private String type;
	private String regDate;
	public MemberVO() {
	}
	public MemberVO(String id, String name, String password, String emailId, String emailDomain, int tel1, int tel2,
			int tel3, int post, String basicAddr, String detailAddr, String type, String regDate) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.emailId = emailId;
		this.emailDomain = emailDomain;
		this.tel1 = tel1;
		this.tel2 = tel2;
		this.tel3 = tel3;
		this.post = post;
		this.basicAddr = basicAddr;
		this.detailAddr = detailAddr;
		this.type = type;
		this.regDate = regDate;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getEmailDomain() {
		return emailDomain;
	}
	public void setEmailDomain(String emailDomain) {
		this.emailDomain = emailDomain;
	}
	public int getTel1() {
		return tel1;
	}
	public void setTel1(int tel1) {
		this.tel1 = tel1;
	}
	public int getTel2() {
		return tel2;
	}
	public void setTel2(int tel2) {
		this.tel2 = tel2;
	}
	public int getTel3() {
		return tel3;
	}
	public void setTel3(int tel3) {
		this.tel3 = tel3;
	}
	public int getPost() {
		return post;
	}
	public void setPost(int post) {
		this.post = post;
	}
	public String getBasicAddr() {
		return basicAddr;
	}
	public void setBasicAddr(String basicAddr) {
		this.basicAddr = basicAddr;
	}
	public String getDetailAddr() {
		return detailAddr;
	}
	public void setDetailAddr(String detailAddr) {
		this.detailAddr = detailAddr;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	@Override
	public String toString() {
		return "MemberVO [id=" + id + ", name=" + name + ", password=" + password + ", emailId=" + emailId
				+ ", emailDomain=" + emailDomain + ", tel1=" + tel1 + ", tel2=" + tel2 + ", tel3=" + tel3 + ", post="
				+ post + ", basicAddr=" + basicAddr + ", detailAddr=" + detailAddr + ", type=" + type + ", regDate="
				+ regDate + "]";
	}
	
	
}


