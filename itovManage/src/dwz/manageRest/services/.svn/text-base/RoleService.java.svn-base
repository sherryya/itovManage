package dwz.manageRest.services;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import rest.util.ConnRest;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import dwz.manageRest.dto.TItovMenuRole;
public class RoleService {
	public static List<TItovMenuRole> getRole() throws Exception {
		List<TItovMenuRole> list=new ArrayList<TItovMenuRole>();
		String result="";
		Map paramMap=new HashMap();
		result=new ConnRest().getResult(paramMap, "role.get");	
		ObjectMapper mapper = new ObjectMapper();
		JsonNode jsonNode = mapper.readTree(result);
		JsonNode bodyNode = jsonNode.get("body");
		System.out.println("body:" + bodyNode);
	    Map<String, Object> map = new HashMap<String, Object>();
		Type mapType_v = new TypeToken<HashMap<String, Object>>(){}.getType();
		Gson gson_v=new Gson();
		map=gson_v.fromJson(bodyNode.toString(), mapType_v);
		Type listType = new TypeToken<ArrayList<TItovMenuRole>>(){}.getType();
		Gson gson_v1=new Gson();
		list=gson_v1.fromJson(map.get("result").toString(), listType);
		return list;
	}
	
	public static String addRole(TItovMenuRole tItovMenuRole) throws Exception {
		Map paramMap = new HashMap();
		paramMap.put("Role_Name", tItovMenuRole.getRoleName());
		paramMap.put("Role_Description", tItovMenuRole.getRoleDescription());
		paramMap.put("Role_Taxis", tItovMenuRole.getRoleTaxis());
		String result = "";
		result = new ConnRest().getResult(paramMap, "menuRole.add");
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
		getRole();
	}
}
