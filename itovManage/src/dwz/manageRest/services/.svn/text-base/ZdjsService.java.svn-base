package dwz.manageRest.services;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.log4j.TTCCLayout;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import rest.util.ConnRest;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;


import dwz.manageRest.dto.MessageDriverKilometer;
import dwz.manageRest.dto.TItovViewspot;
import dwz.manageRest.dto.TItovViewspotPicture;
public class ZdjsService {
	/**
	 * 得到里程信息
	 * @param deviceuid
	 * @param date
	 * @return
	 * @throws Exception
	 */
	public static List<MessageDriverKilometer> getMileageList(String deviceuid,String date) throws Exception {
		List<MessageDriverKilometer> list=new ArrayList<MessageDriverKilometer>();
		String result="";
		Map paramMap = new HashMap();
		paramMap.put("deviceuid",deviceuid);
		paramMap.put("date", date);
		paramMap.put("starttime", "00:00:00");
		paramMap.put("endtime", "23:59:59");
		paramMap.put("targetpage","1");
		paramMap.put("pagesize", "50");
		result=new ConnRest().getResult(paramMap, "listbypage.get");	
		ObjectMapper mapper = new ObjectMapper();
		JsonNode jsonNode = mapper.readTree(result);
		JsonNode bodyNode = jsonNode.get("body");
		Type listType = new TypeToken<ArrayList<MessageDriverKilometer>>(){}.getType();
		Gson gson_v1=new Gson();
		list=gson_v1.fromJson(bodyNode.get("Data").toString(), listType);
		return list;
	}
	 public static  String  readContentFromGet(String param)  throws  java.io.IOException{
         String url = "http://geocode.mapbar.com/Decode/encode_xml.jsp?lonlat=";
         url = url +param;
         java.net.URL getUrl  =   new  URL(url);
         HttpURLConnection connection  =  (HttpURLConnection) getUrl.openConnection();
         connection.connect();
         BufferedReader reader  =   new  BufferedReader( new  InputStreamReader(connection.getInputStream()));
         String retStr="";
         String lines;
         while((lines  =  reader.readLine())  !=   null ){
             retStr=retStr+lines;
         } 
         reader.close();
         connection.disconnect();
         return retStr;
     } 
	 /**
	  * 得到GPS信息
	  * @param deviceuid
	  * @param date
	  * @param starttime
	  * @param endtime
	  * @return
	  * @throws Exception
	  */
	public static String getGpsInfo(String deviceuid,String date,String starttime,String endtime) throws Exception {
		String result = "";
		String param = "";
		int i = 0;
		String retXml = "";
		String retMsg ="";
		Map paramMap = new HashMap();
		paramMap.put("deviceuid", deviceuid);
		paramMap.put("date", date);
		paramMap.put("starttime", starttime);
		paramMap.put("endtime", endtime);
		result = new ConnRest().getResult(paramMap, "gpsinfo.get");
		ObjectMapper mapper = new ObjectMapper();
		JsonNode jsonNode = mapper.readTree(result);
		JsonNode bodyNode = jsonNode.get("body");
		if (Integer.valueOf(bodyNode.get("Status").toString())==1) {
			Iterator it = bodyNode.get("Data").iterator();
			while (it.hasNext()) {
				i++;
				JsonNode jsNode = (JsonNode) it.next();
				String Latitude = jsNode.get("Latitude").asText();
				String Longitude = jsNode.get("Longitude").asText();
				//if (i % 4 == 0)
				//param += Longitude + "," + Latitude + "!";
			    param += Longitude + "," + Latitude + ";";
				if (i % 50 == 0) {
					retXml = readContentFromGet(param);
					Document document = DocumentHelper.parseText(retXml);
					Element el_req = document.getRootElement();
					List lonlatList = el_req.element("item").elements();
					if (lonlatList != null && lonlatList.size() > 0) {
						for (int j = 0; j < lonlatList.size(); j++) {
							retMsg = retMsg	+ ((Element) lonlatList.get(j)).getText()+ "!";
						}
					}
					i = 0;
					param = "";
				}
			}
			//如果取模不为0的时候
			if (i > 0) {
				retXml = readContentFromGet(param);
				Document document = DocumentHelper.parseText(retXml);
				Element el_req = document.getRootElement();
				List lonlatList = el_req.element("item").elements();
				if (lonlatList != null && lonlatList.size() > 0) {
					for(int j=0;j<lonlatList.size();j++){
						retMsg = retMsg +((Element) lonlatList.get(j)).getText()+"!";
					}					
				}	
			}
		} else {
			
		}
		return "{\"Status\":1,\"Lonlat\":\""+retMsg+"\"}";
	}
	/**
	 * 添加景点主表信息
	 * @param tItovViewspot
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings({ "unchecked"})
	public static String addViewSpot(TItovViewspot tItovViewspot) throws Exception {
		String result="";
		@SuppressWarnings("rawtypes")
		Map paramMap = new HashMap();
		paramMap.put("accountId",tItovViewspot.getAccountId());
		paramMap.put("deviceuid", tItovViewspot.getDeviceuid());
		paramMap.put("lonlat", tItovViewspot.getLonlat());
		paramMap.put("spotName", tItovViewspot.getSpotName());
		paramMap.put("spotTel",tItovViewspot.getSpotTel());
		paramMap.put("spotAddress", tItovViewspot.getSpotAddress());
		paramMap.put("spotManager", tItovViewspot.getSpotManager());
		paramMap.put("spotIntroduction", tItovViewspot.getSpotIntroduction());
		paramMap.put("lonlatId", tItovViewspot.getLonlatId());
		paramMap.put("sportNote1", tItovViewspot.getSportNote1());
		paramMap.put("sportNote2", tItovViewspot.getSportNote2());
		String lonlatName=getLonlatName(tItovViewspot.getLonlat());
		paramMap.put("sportNote3", lonlatName);//图吧逆地理
		paramMap.put("spotNote", tItovViewspot.getSpotNote());
		result=new ConnRest().getResult(paramMap, "viewspot.add");	
		ObjectMapper mapper = new ObjectMapper();
		JsonNode jsonNode = mapper.readTree(result);
		JsonNode headNode = jsonNode.get("head");
		if (headNode.get("error_code").toString().equals("0")) {
			  return "0";
		} else {
			String error_msg = headNode.get("error_msg").toString();
			return error_msg;
		}
	}
	/**
	 * 添加景点图片
	 * @param tItovViewspotPicture
	 * @return
	 * @throws Exception
	 */
	public static String addViewSpotPicture(TItovViewspotPicture tItovViewspotPicture) throws Exception {
		String result="";
		@SuppressWarnings("rawtypes")
		Map paramMap = new HashMap();
		paramMap.put("picId",tItovViewspotPicture.getPicId());
		paramMap.put("lonlatId", tItovViewspotPicture.getLonlatId());
		paramMap.put("picPathName", tItovViewspotPicture.getPicPathName());
		paramMap.put("picIntroduction", tItovViewspotPicture.getPicIntroduction());
		paramMap.put("picNote", tItovViewspotPicture.getPicNote());
		paramMap.put("picName", tItovViewspotPicture.getPicName());
		result=new ConnRest().getResult(paramMap, "viewspotpicture.add");	
		ObjectMapper mapper = new ObjectMapper();
		JsonNode jsonNode = mapper.readTree(result);
		JsonNode headNode = jsonNode.get("head");
		if (headNode.get("error_code").toString().equals("0")) {
			  return "0";
		} else {
			String error_msg = headNode.get("error_msg").toString();
			return error_msg;
		}
	}
	/**
	 * 删除景点主表信息
	 * @param lonlatId
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public static String deleteViewSpot(String lonlatId) throws Exception {
		String result="";
		@SuppressWarnings("rawtypes")
		Map paramMap = new HashMap();
		paramMap.put("lonlatId",lonlatId);
		result=new ConnRest().getResult(paramMap, "viewspot.delete");	
		ObjectMapper mapper = new ObjectMapper();
		JsonNode jsonNode = mapper.readTree(result);
		JsonNode headNode = jsonNode.get("head");
		if (headNode.get("error_code").toString().equals("0")) {
			  return "0";
		} else {
			String error_msg = headNode.get("error_msg").toString();
			return error_msg;
		}
	}
	/**
	 * 删除景点图片信息
	 * @param lonlatId
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public static String deleteViewSpotPicture(String lonlatId) throws Exception {
		String result="";
		@SuppressWarnings("rawtypes")
		Map paramMap = new HashMap();
		paramMap.put("lonlatId",lonlatId);
		result=new ConnRest().getResult(paramMap, "viewspotpicture.delete");	
		ObjectMapper mapper = new ObjectMapper();
		JsonNode jsonNode = mapper.readTree(result);
		JsonNode headNode = jsonNode.get("head");
		if (headNode.get("error_code").toString().equals("0")) {
			  return "0";
		} else {
			String error_msg = headNode.get("error_msg").toString();
			return error_msg;
		}
	}
	public  static String getLonlatName(String lonlat) throws IOException
	{
		// 调用图吧地图api，获取图吧逆地理名称
		String param = "";
		param = "detail=1&zoom=11&road=1&customer=2&latlon=";
		param += lonlat;
		String xml = dwz.manageRest.common.MapUtil.readContentFromGet(param);
		Document document = null;
		try {
			document = DocumentHelper.parseText(xml);
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		Element el_req = document.getRootElement();
		String retMsg = "";
		if (el_req.element("poi") != null) {
			retMsg += el_req.element("poi").getText() + ",";
			retMsg = URLDecoder.decode(retMsg, "utf-8");
		}
		return retMsg;
	}
	/**
	 * 通过用户的uid 查询所有的景点信息
	 * @param deviceuid
	 * @return
	 * @throws Exception
	 */
	public static String getViewSpotList(String deviceuid) throws Exception {
		List<TItovViewspot> list=new ArrayList<TItovViewspot>();
		String result="";
		Map paramMap = new HashMap();
		paramMap.put("deviceuid",deviceuid);
		result=new ConnRest().getResult(paramMap, "zdjs.viewspotlist.get");	
		ObjectMapper mapper = new ObjectMapper();
		JsonNode jsonNode = mapper.readTree(result);
		JsonNode bodyNode = jsonNode.get("body");
/*		Type listType = new TypeToken<ArrayList<TItovViewspot>>(){}.getType();
		Gson gson_v1=new Gson();
		list=gson_v1.fromJson(bodyNode.get("Data").toString(), listType);
	    Gson gson=new Gson();
	    String json=gson.toJson(list, listType);*/
		String json=bodyNode.get("Data").toString();
		return json;
	}
	/**
	 * 通过 lonlatID 查询景点主表信息
	 * @param lonlat
	 * @return
	 * @throws Exception
	 */
	public static TItovViewspot getViewSpotByLonlat(String lonlat) throws Exception {
		TItovViewspot tItovViewspot=new TItovViewspot();
		String result="";
		Map paramMap = new HashMap();
		paramMap.put("lonlat",lonlat);
		result=new ConnRest().getResult(paramMap, "zdjs.viewspotbylonlat.get");	
		ObjectMapper mapper = new ObjectMapper();
		JsonNode jsonNode = mapper.readTree(result);
		JsonNode bodyNode = jsonNode.get("body");
        if(bodyNode.get("result").toString().replace("\"", "").equals("1"))
        {
			tItovViewspot.setDeviceuid(bodyNode.get("deviceuid").toString().replace("\"", ""));
			tItovViewspot.setSportNote3(bodyNode.get("spot_note3").toString().replace("\"", ""));
			tItovViewspot.setSpotAddress(bodyNode.get("spot_address").toString().replace("\"", ""));
			tItovViewspot.setSpotIntroduction(bodyNode.get("spot_introduction").toString().replace("\"", ""));
			tItovViewspot.setSpotManager(bodyNode.get("spot_manager").toString().replace("\"", ""));
			tItovViewspot.setSpotName(bodyNode.get("spot_name").toString().replace("\"", ""));
			tItovViewspot.setSpotTel(bodyNode.get("spot_tel").toString().replace("\"", ""));
			tItovViewspot.setSpotNote(bodyNode.get("spot_note").toString().replace("\"", ""));
        }
		return tItovViewspot;
	}
	/**
	 * 得到景点照片
	 * @param lonlatID
	 * @return
	 * @throws Exception
	 */
	public static List<TItovViewspotPicture>  getViewSpotPictureList(String lonlatID) throws Exception {
		List<TItovViewspotPicture> list=new ArrayList<TItovViewspotPicture>();
		String result="";
		Map paramMap = new HashMap();
		paramMap.put("lonlatID",lonlatID);
		result=new ConnRest().getResult(paramMap, "zdjs.viewspotpicturelist.get");	
		ObjectMapper mapper = new ObjectMapper();
		JsonNode jsonNode = mapper.readTree(result);
		JsonNode bodyNode = jsonNode.get("body");
		Type listType = new TypeToken<ArrayList<TItovViewspotPicture>>(){}.getType();
		Gson gson_v1=new Gson();
		list=gson_v1.fromJson(bodyNode.get("Data").toString(), listType);
		return list;
	}
	/**
	 * 通过景点ID删除某张图片
	 * @param pic_id
	 * @return
	 * @throws Exception
	 */
	public static String deleteViewSpotPictureByID(String pic_id) throws Exception {
		String result="";
		@SuppressWarnings("rawtypes")
		Map paramMap = new HashMap();
		paramMap.put("pic_id",pic_id);
		result=new ConnRest().getResult(paramMap, "viewspotpictureByID.delete");	
		ObjectMapper mapper = new ObjectMapper();
		JsonNode jsonNode = mapper.readTree(result);
		JsonNode headNode = jsonNode.get("head");
		if (headNode.get("error_code").toString().equals("0")) {
			  return "0";
		} else {
			String error_msg = headNode.get("error_msg").toString();
			return error_msg;
		}
	}
	public static void main(String[] args) throws Exception {
       ZdjsService.getViewSpotPictureList("126.65451_45.75519");
	}
}
