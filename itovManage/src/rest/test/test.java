package rest.test;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import rest.bean.reqeustParam;
import rest.bean.requestHeader;
import rest.util.ConnUtil;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import dwz.manageRest.dto.TItov_personal_manage;
public class test {
	public static String remoteServer = "http://192.168.0.122:8098/sshop_dev/";
	// 应用密钥
	public static String appKey = "sshop";
	// 内容签名密钥
	public static String signKey = "1qazxsw2";
	// 公司标识
	public static int appid = 1;
	// 公司平台标识
	public static int clientPlatform = 1;
	//
	/**
	 * Header配置
	 * 
	 * @param param
	 * @return
	 */
	public static String jsonParam(Map param) throws Exception {




		
		
		
		requestHeader rh = new requestHeader();
		rh.setAppid(appid);
		rh.setCommand_id(1000);// 客户端使用
		rh.setPlatform(clientPlatform);
		rh.setScreenX(1024);// 终端屏幕尺寸-宽
		rh.setScreenY(769);// 终端屏幕尺寸-高
		rh.setTerm_id("111111");// 终端标识
		rh.setTimestamp();// 客户端使用
		rh.setUser_id(1);// (可选)
		reqeustParam rp = new reqeustParam();
		rp.setHead(rh);
		rp.setBody(param);
		return new ObjectMapper().writeValueAsString(rp);
	}
public static void main(String[] args) throws Exception {
	
	

	
	
	Map paramMap = new HashMap();// 传递body内容
	paramMap.put("account_type",1);
	String result = ConnUtil.sendPostZip(remoteServer,
			"personal.manage.get",//
			jsonParam(paramMap), // 拼接报文
			appKey, // appkey
			signKey// signKey
			);
	try {
		ConnUtil.validRequestParam(result, signKey);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	// body value analysis
	ObjectMapper mapper = new ObjectMapper();
	// System.out.println("result:"+result);
	JsonNode jsonNode = mapper.readTree(result);
	JsonNode headNode = jsonNode.get("head");
	JsonNode bodyNode = jsonNode.get("body");
//	System.out.println("jsonNode:" + jsonNode);
	//System.out.println("header:" + headNode);
	System.out.println("body:" + bodyNode);
	
    Map<String, Object> map = new HashMap<String, Object>();
	Type mapType_v = new TypeToken<HashMap<String, Object>>(){}.getType();
	Gson gson_v=new Gson();
	map=gson_v.fromJson(bodyNode.toString(), mapType_v);//需要显示的版本信息
    System.out.println(map.get("result"));
	        
	        
	        
	        
	        
	        
	      
    List<TItov_personal_manage> list=new ArrayList<TItov_personal_manage>();
	Type listType = new TypeToken<ArrayList<TItov_personal_manage>>(){}.getType();
	Gson gson_v1=new Gson();
	list=gson_v1.fromJson(map.get("result").toString(), listType);//需要显示的版本信息
}
}
