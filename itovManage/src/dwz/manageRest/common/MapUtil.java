package dwz.manageRest.common;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
public class MapUtil {
	private static final String url = "http://api.map.baidu.com/ag/coord/convert?from=0&to=4&mode=1";
	public static final String LOGON_SITE_LOGIN = "10.110.0.206";
	public static final int LOGON_PORT = 28001;
	public static final String BAIDU_InverseGeographic= "http://api.map.baidu.com/geocoder/v2/?ak=5PcpmkXyitGo3RbBZ93KcsF4";//百度逆地理url
	/*
	 * 
	 * 百度逆地理
	 */
	public static String  getBaiduInverseGeographic(String  param) {
		String url = BAIDU_InverseGeographic + param;
		String retStr = "";
		try{
			java.net.URL getUrl = new URL(url);
			HttpURLConnection connection = (HttpURLConnection) getUrl
					.openConnection();
			connection.setRequestProperty("contentType", "utf-8");
			connection.setConnectTimeout(100000);
			connection.connect();
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					connection.getInputStream(), "utf-8"));
			
			String lines;
			while ((lines = reader.readLine()) != null) {
				retStr = retStr + lines;
			}
			reader.close();
			connection.disconnect();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return retStr;
	}
	
	/*
	 * 
	 * 图吧坐标转化
	 */
	
	public static String  getMapBar(String param)  throws  java.io.IOException{
        String url = "http://geocode.mapbar.com/Decode/encode_xml.jsp?lonlat=";
        url = url +param;
        java.net.URL getUrl  =   new  URL(url);
        HttpURLConnection connection  =  (HttpURLConnection) getUrl.openConnection();
    	connection.setConnectTimeout(100000);
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
	
	/*
	 * 
	 * 图吧逆地理
	 */
	public static String readContentFromGet(String param)
			throws java.io.IOException {
		String url = "http://geocode.mapbar.com/dynamic/inverse/getInverseGeocoding.jsp?";
		url = url + param;
		java.net.URL getUrl = new URL(url);
		HttpURLConnection connection = (HttpURLConnection) getUrl
				.openConnection();
		connection.setConnectTimeout(100000);
		connection.setRequestProperty("contentType", "utf-8");
		connection.connect();
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				connection.getInputStream(), "utf-8"));
		String retStr = "";
		String lines;
		while ((lines = reader.readLine()) != null) {
			retStr = retStr + lines;
		}
		reader.close();
		connection.disconnect();
		return retStr;

	}

	public static void test() {
		// TODO Auto-generated method stub
		try {
			String param = "";
			param += "detail=1&zoom=11&road=1&customer=2&latlon=";
			param += "116.33850,39.93834";
			String xml = readContentFromGet(param);

			Document document = DocumentHelper.parseText(xml);
			Element el_req = document.getRootElement();

			String retMsg = "";
			// 省
			if (el_req.element("province") != null) {
				retMsg += el_req.element("province").getText() + ",";
			}
			// 市
			if (el_req.element("city") != null) {
				retMsg += el_req.element("city").getText() + ",";
			}
			// 区县
			if (el_req.element("dist") != null) {
				retMsg += el_req.element("dist").getText() + ",";
			}
			// 区域
			if (el_req.element("area") != null) {
				retMsg += el_req.element("area").getText() + ",";
			}
			// 乡镇
			if (el_req.element("town") != null) {
				retMsg += el_req.element("town").getText() + ",";
			}
			// 村
			if (el_req.element("village") != null) {
				retMsg += el_req.element("village").getText() + ",";
			}
			// 附近地标
			if (el_req.element("poi") != null) {
				retMsg += el_req.element("poi").getText() + ",";
			}
			System.out.println("返回信息:" + retMsg);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
