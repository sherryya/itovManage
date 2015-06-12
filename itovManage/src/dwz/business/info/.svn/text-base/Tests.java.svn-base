package dwz.business.info;

import java.io.Serializable;
import java.util.Date;

import dwz.framework.sys.business.AbstractBusinessObject;
import dwz.persistence.beans.InfNews;
import dwz.persistence.beans.InfoTest;

public class Tests extends AbstractBusinessObject {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7228528303697108518L;
	private InfoTest infNews;

	public Tests(InfoTest po) {
		this.infNews = po;
	}

	public Tests() {
		Date now = new Date();
		this.infNews = new InfoTest();
		/*this.infNews.setType(NewsType.NEWS.toString());
		this.infNews.setStatus( NewsStatus.PENDING.toString());
		this.infNews.setInsertDate(now);
		this.infNews.setUpdateDate(now);*/
	}
	public Integer getId() {
		return infNews.getId();
	}
	public void setId(Integer id){
		infNews.setId(id);
	}
	public InfoTest getInfNews() {
		return this.infNews;
	}
	public String getName()
	{
		return infNews.getName();
	}
	
	public void setName(String name)
	{
		 infNews.setName(name);
	}

	public String getNick_name()
	{
		return infNews.getNick_name();
	}
	
	public void setNick_name(String nick_name)
	{
		 infNews.setNick_name(nick_name);
	}
	
	
	
	public Integer getSex() {
		return infNews.getSex();
	}
	public void setSex(Integer sex){
		infNews.setSex(sex);
	}
	
	public Integer getAge() {
		return infNews.getAge();
	}
	public void setAge(Integer age){
		infNews.setAge(age);
	}
}
