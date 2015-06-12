package rest.util;

import java.util.Map;

import rest.bean.reqeustParam;
import rest.bean.requestHeader;



public class GetParam {
	public static String jsonParam(Map param){
		requestHeader rh = new requestHeader();
		rh.setAppid(1);
		rh.setCommand_id(1);
		rh.setPlatform(1);
		rh.setScreenX(1024);
		rh.setScreenY(769);
		rh.setTerm_id("1");
		rh.setTimestamp();
		rh.setUser_id(1);
		reqeustParam rp = new reqeustParam();
		rp.setHead(rh);
		rp.setBody(param);
		Json json = new Json();
		return json.readAsString(rp);
	}
	public static String jsonParam(Long userId,Map param){
		requestHeader rh = new requestHeader();
		rh.setAppid(1);
		rh.setCommand_id(1);
		rh.setPlatform(1);
		rh.setScreenX(1024);
		rh.setScreenY(769);
		rh.setTerm_id("1");
		rh.setTimestamp();
		if(userId!=null){
			rh.setUser_id(userId);
		}
		reqeustParam rp = new reqeustParam();
		rp.setHead(rh);
		rp.setBody(param);
		Json json = new Json();
		return json.readAsString(rp);
	}
}
