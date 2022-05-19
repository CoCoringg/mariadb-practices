package vo;

public class CategoryVo {
	private Long no;
	private String sort;
	public Long getNo() {
		return no;
	}
	public void setNo(Long no) {
		this.no = no;
	}
	public String getSort() {
		return sort;
	}
	public void setSort(String sort) {
		this.sort = sort;
	}
	@Override
	public String toString() {
		return "CategoryVo [no=" + no + ", sort=" + sort + "]";
	}
	
	
}
