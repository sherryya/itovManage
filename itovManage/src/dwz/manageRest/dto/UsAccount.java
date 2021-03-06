package dwz.manageRest.dto;

import java.util.Date;

public class UsAccount {
	private Long account_id;

	private String account_name;

	private String account_password;

	private Integer account_type;

	private Integer account_role_id;

	private Long company_id;

	private Date account_create_date;
    private String access_id;
    private String access_token;
    private String nickname;
    private String hostType; //主播类型
    private String channelType;  //频道类型
    private Integer roomId;  //房间号
	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getAccess_id() {
		return access_id;
	}

	public void setAccess_id(String access_id) {
		this.access_id = access_id;
	}

	public String getAccess_token() {
		return access_token;
	}

	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}

	public Long getAccount_id() {
		return account_id;
	}

	public void setAccount_id(Long account_id) {
		this.account_id = account_id;
	}

	public String getAccount_name() {
		return account_name;
	}

	public void setAccount_name(String account_name) {
		this.account_name = account_name;
	}

	public String getAccount_password() {
		return account_password;
	}

	public void setAccount_password(String account_password) {
		this.account_password = account_password;
	}

	public Integer getAccount_type() {
		return account_type;
	}

	public void setAccount_type(Integer account_type) {
		this.account_type = account_type;
	}

	public Integer getAccount_role_id() {
		return account_role_id;
	}

	public void setAccount_role_id(Integer account_role_id) {
		this.account_role_id = account_role_id;
	}

	public Long getCompany_id() {
		return company_id;
	}

	public void setCompany_id(Long company_id) {
		this.company_id = company_id;
	}

	public Date getAccount_create_date() {
		return account_create_date;
	}

	public void setAccount_create_date(Date account_create_date) {
		this.account_create_date = account_create_date;
	}

	public String getHostType() {
		return hostType;
	}

	public void setHostType(String hostType) {
		this.hostType = hostType;
	}

	public String getChannelType() {
		return channelType;
	}

	public void setChannelType(String channelType) {
		this.channelType = channelType;
	}

	public Integer getRoomId() {
		return roomId;
	}

	public void setRoomId(Integer roomId) {
		this.roomId = roomId;
	}
	

}