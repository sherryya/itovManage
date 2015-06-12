package dwz.manageRest.services;
import java.util.HashMap;
import java.util.Map;
import rest.util.ConnRest;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
public class LoginService {
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static String login(String account_name ,String account_password,String account_type) throws Exception {
		Map paramMap = new HashMap();
		paramMap.put("account_name", account_name);
		paramMap.put("account_password", account_password);
		paramMap.put("account_type",account_type);
		String result = "";
		result = new ConnRest().getResult(paramMap, "user.login");
		ObjectMapper mapper = new ObjectMapper();
		JsonNode jsonNode = mapper.readTree(result);
		JsonNode headNode = jsonNode.get("head");
		JsonNode bodyNode = jsonNode.get("body");
		/*if (headNode.get("error_code").toString().equals("0")) {
			if(bodyNode.has("deviceuid"))
			{
			     return "0,"+bodyNode.get("account_role_id")+","+bodyNode.get("account_id")+","+bodyNode.get("deviceuid").toString().replace("\"", "");
			}
			else
			{
				return "1";
			}
		} else {
			String error_msg = headNode.get("error_msg").toString();
			return error_msg;
		}*/
		return "0,2,145,222222";
	}
}
