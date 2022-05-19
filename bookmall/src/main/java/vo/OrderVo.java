package vo;

public class OrderVo {
	private Long no;
	private String addr;
	private int totalPrice;
	private Long memberNo;
	private int count;
	private Long bookNo;
	private Long orderNo;
	private String orderNum;
	private String name;
	private String email;
	private String title;
	private int price;

	
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getOrderNum() {
		return orderNum;
	}
	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}
	public Long getNo() {
		return no;
	}
	public void setNo(Long no) {
		this.no = no;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public int getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
	public Long getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(Long memberNo) {
		this.memberNo = memberNo;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public Long getBookNo() {
		return bookNo;
	}
	public void setBookNo(Long bookNo) {
		this.bookNo = bookNo;
	}
	public Long getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(Long orderNo) {
		this.orderNo = orderNo;
	}
	@Override
	public String toString() {
		return "OrderVo [no=" + no + ", addr=" + addr + ", totalPrice=" + totalPrice + ", memberNo=" + memberNo
				+ ", count=" + count + ", bookNo=" + bookNo + ", orderNo=" + orderNo + ", orderNum=" + orderNum
				+ ", name=" + name + ", email=" + email + ", title=" + title + ", price=" + price + "]";
	}
	
	
}
