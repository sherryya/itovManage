package dwz.manageRest.dto;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;



public class BaseConditionManageVO {
	public final static int PAGE_SHOW_COUNT = 15;
	DateFormat format2 = new SimpleDateFormat("yyyy-MM-dd");
	String reTime = format2.format(new Date());
	private int pageNum = 1;
	private int pageSize = 0;
	private int totalCount = 0;
	private String orderField;
	private String orderDirection;
	private String keywords="";
	private String account_type="4";
	private String account_type1="1";
	private String deviceuid="";
	private String date=reTime;//里程时间
	public String getDeviceuid() {
		return deviceuid;
	}
	public void setDeviceuid(String deviceuid) {
		this.deviceuid = deviceuid;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getAgentstate() {
		return agentstate;
	}
	public void setAgentstate(String agentstate) {
		this.agentstate = agentstate;
	}

	private String account_type2="5";
	private String agentstate="%";
	public String getAccount_type1() {
		return account_type1;
	}
	public void setAccount_type1(String account_type1) {
		this.account_type1 = account_type1;
	}
	public String getAccount_type2() {
		return account_type2;
	}
	public void setAccount_type2(String account_type2) {
		this.account_type2 = account_type2;
	}


	public String getAccount_type() {
		return account_type;
	}
	public void setAccount_type(String account_type) {
		this.account_type = account_type;
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
