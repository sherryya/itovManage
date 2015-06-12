package rest.util;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Map;
import java.util.Properties;
import rest.bean.reqeustParam;
import rest.bean.requestHeader;
import com.fasterxml.jackson.databind.ObjectMapper;
public class ConnRest {
	public static String remoteServer = "";
	// 应用密钥
	public static String appKey = "sshop";
	// 内容签名密钥
	public static String signKey = "1qazxsw2";
	// 公司标识
	public static int appid = 1;
	// 公司平台标识
	public static int clientPlatform = 1;
	public ConnRest()
	{
	}
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
	public  String getResult(Map paramMap,String restName) throws Exception
	{
		
		String filePath = this.getClass().getClassLoader().getResource("remoteServer.properties").toString().substring(6);;
		filePath = "/"+filePath;
		remoteServer=PropertiesUtil.readValue(filePath, "remoteServer");
		//remoteServer="http://localhost:8098/sshop_dev/";
		//remoteServer="http://125.211.221.231:10081/sshop/";
		String result = ConnUtil.sendPostZip(remoteServer,
				restName,//
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
		return result;
	}
	
	public  String getResult1(Map paramMap,String restName) throws Exception
	{
		
		String filePath = this.getClass().getClassLoader().getResource("remoteServer.properties").toString().substring(6);;
		filePath = "/"+filePath;
		//remoteServer=PropertiesUtil.readValue(filePath, "http://localhost:8098/sshop_dev/");
		//remoteServer="http://localhost:8098/sshop_dev/";
		remoteServer="http://125.211.221.231:10080/sshop/";
		String result = ConnUtil.sendPostZip(remoteServer,
				restName,//
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
	
		//paramMap.put("deviceuid","6091e0c2-65dd-e211-8c19-00163e0071c8");
/*		paramMap.put("deviceuid","283FF47D-43EF-62BC-4339-51684F1A0302");
		paramMap.put("date", "2014-08-19");
		paramMap.put("starttime", "17:00:56");
		paramMap.put("endtime", "18:48:32");
		// connect to server 
		String result = ConnUtil.sendPostZip(
				remoteServer, 
				"gpsinfo.get",//服务名
				jsonParam(paramMap), //拼接报文
				appKey, //appkey
				signKey//signKey
				);
		System.out.println("~~~~~~~~~~~~~~~"+result+"~~~~~~~~~~~~~~");
		// ret value verify
		try {
			ConnUtil.validRequestParam(result, signKey);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		return result;
	}
}
