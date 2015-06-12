package dwz.manageRest.dto;

public class FeedbackVO {
	public final static int PAGE_SHOW_COUNT = 10;
	private int pageNum = 1;
	private int pageSize =0;
	private int totalCount = 0;
	private int feedbackType;
	private int isdeal;
	private String accountName="";
	private String feedbackType_query="%";
	private String isdeal_query="%";

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
	public int getFeedbackType() {
		return feedbackType;
	}
	public void setFeedbackType(int feedbackType) {
		this.feedbackType = feedbackType;
	}
	public int getIsdeal() {
		return isdeal;
	}
	public void setIsdeal(int isdeal) {
		this.isdeal = isdeal;
	}
	public String getAccountName() {
		return "".equals(accountName)? null : accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getFeedbackType_query() {
		return feedbackType_query;
	}

	public void setFeedbackType_query(String feedbackType_query) {
		this.feedbackType_query = feedbackType_query;
	}
	public String getIsdeal_query() {
		return isdeal_query;
	}
	public void setIsdeal_query(String isdeal_query) {
		this.isdeal_query = isdeal_query;
	}
	
}
