package dwz.manageRest.dto;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;



public class hostConditionVO {
	public final static int PAGE_SHOW_COUNT = 10;
	DateFormat format2 = new SimpleDateFormat("yyyy-MM-dd");
	String reTime = format2.format(new Date());
	private int pageNum = 1;
	private int pageSize = 10;
	private int totalCount = 0;
	private String voipAccount;
	private String voipStatus;
	private String hostType;
	private String starttime;
	private String keywords="";
	private String endtime;
	public DateFormat getFormat2() {
		return format2;
	}
	public void setFormat2(DateFormat format2) {
		this.format2 = format2;
	}
	public String getReTime() {
		return reTime;
	}
	public void setReTime(String reTime) {
		this.reTime = reTime;
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
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public String getVoipAccount() {
		return voipAccount;
	}
	public void setVoipAccount(String voipAccount) {
		this.voipAccount = voipAccount;
	}
	public String getStarttime() {
		return starttime;
	}
	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}
	public String getKeywords() {
		return keywords;
	}
	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}
	public String getEndtime() {
		return endtime;
	}
	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}
	public static int getPageShowCount() {
		return PAGE_SHOW_COUNT;
	}
	public String getVoipStatus() {
		return voipStatus;
	}
	public void setVoipStatus(String voipStatus) {
		this.voipStatus = voipStatus;
	}
	public String getHostType() {
		return hostType;
	}
	public void setHostType(String hostType) {
		this.hostType = hostType;
	}
	
	
}
