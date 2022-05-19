package vo;

public class MemberVo {
	private Long no;
	private String name;
	private String phone;
	private String email;
	private String pwd;
	public Long getNo() {
		return no;
	}
	public void setNo(Long no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	@Override
	public String toString() {
		return "MemberVo [no=" + no + ", name=" + name + ", phone=" + phone + ", email=" + email + ", pwd=" + pwd + "]";
	}
	
	
}
