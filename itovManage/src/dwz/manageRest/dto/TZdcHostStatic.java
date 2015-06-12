package dwz.manageRest.dto;

import java.util.Date;
public class TZdcHostStatic {
	private Long id;

	private String voipaccount;

	private Date onlinetime;

	private Date offtime;

	private Date createtime;

	private Long hostid;
	
	private String linetime;
	private String oftime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getVoipaccount() {
		return voipaccount;
	}

	public void setVoipaccount(String voipaccount) {
		this.voipaccount = voipaccount;
	}


	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public Long getHostid() {
		return hostid;
	}

	public void setHostid(Long hostid) {
		this.hostid = hostid;
	}

	public Date getOnlinetime() {
		return onlinetime;
	}

	public void setOnlinetime(Date onlinetime) {
		this.onlinetime = onlinetime;
	}

	public Date getOfftime() {
		return offtime;
	}

	public void setOfftime(Date offtime) {
		this.offtime = offtime;
	}

	public String getLinetime() {
		return linetime;
	}

	public void setLinetime(String linetime) {
		this.linetime = linetime;
	}

	public String getOftime() {
		return oftime;
	}

	public void setOftime(String oftime) {
		this.oftime = oftime;
	}
	

}
