package dwz.manageRest.dto;

public class Shop4sUserVO {
	public final static int PAGE_SHOW_COUNT = 10;
	private int pageNum = 1;
	private int pageSize =0;
	private int totalCount = 0;

	private String accountName="";


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
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	
	public String getAccountName() {
		return "".equals(accountName)? null : accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
}
