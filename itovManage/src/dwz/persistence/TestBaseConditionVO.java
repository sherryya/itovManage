package dwz.persistence;

import java.util.Date;

public class TestBaseConditionVO {
	public final static int PAGE_SHOW_COUNT = 10;
	private int pageNum = 1;
	private int pageSize = 0;
	private int totalCount = 0;
	private String orderField;
	private String orderDirection;
	private String keywords;
	private int age=0;
    private int sex=0;
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	public int getPageSize() {
		return pageSize > 0 ? pageSize : PAGE_SHOW_COUNT;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public String getOrderField() {
		return orderField;
	}
	public void setOrderField(String orderField) {
		this.orderField = orderField;
	}
	public String getOrderDirection() {
		return "desc".equals(orderDirection) ? "desc" : "asc";
	}
	public void setOrderDirection(String orderDirection) {
		this.orderDirection = orderDirection;
	}
	
	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	
	public String getKeywords() {
		return "".equals(keywords)? null : keywords;
	}
	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}
	
	public int getStartIndex() {
		int pageNum = this.getPageNum() > 0 ? this.getPageNum() - 1 : 0;
		return pageNum * this.getPageSize();
	}
}
