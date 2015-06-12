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

import dwz.manageRest.dto.TItovMenuAssgnRule;
import dwz.manageRest.dto.TItovMenuClass;
public class MenuClassService {

	/**
	 * 得到一级菜单
	 * @param Class_Levels
	 * @param role_id
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static List<TItovMenuClass> getMenuClassFirstlist(Integer Class_Levels, Integer role_id) throws Exception {
		Map paramMap=new HashMap();
		paramMap.put("Class_Levels",Class_Levels);
		paramMap.put("role_id",role_id);
		List<TItovMenuClass> list=new ArrayList<TItovMenuClass>();
		String result="";
		result=new ConnRest().getResult(paramMap, "menu.first.get");	
		ObjectMapper mapper = new ObjectMapper();
		JsonNode jsonNode = mapper.readTree(result);
		JsonNode bodyNode = jsonNode.get("body");
		System.out.println("body:" + bodyNode);
	    Map<String, Object> map = new HashMap<String, Object>();
		Type mapType_v = new TypeToken<HashMap<String, Object>>(){}.getType();
		Gson gson_v=new Gson();
		map=gson_v.fromJson(bodyNode.toString(), mapType_v);
		Type listType = new TypeToken<ArrayList<TItovMenuClass>>(){}.getType();
		Gson gson_v1=new Gson();
		list=gson_v1.fromJson(map.get("result").toString(), listType);
		return list;
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static List<TItovMenuClass> getMenuClassSecondlist(Integer Class_ParentID, Integer role_id) throws Exception {
		Map paramMap=new HashMap();
		paramMap.put("Class_ParentID",Class_ParentID);
		paramMap.put("role_id",role_id);
		List<TItovMenuClass> list=new ArrayList<TItovMenuClass>();
		String result="";
		result=new ConnRest().getResult(paramMap, "menu.second.get");	
		ObjectMapper mapper = new ObjectMapper();
		JsonNode jsonNode = mapper.readTree(result);
		JsonNode bodyNode = jsonNode.get("body");
		System.out.println("body:" + bodyNode);
	    Map<String, Object> map = new HashMap<String, Object>();
		Type mapType_v = new TypeToken<HashMap<String, Object>>(){}.getType();
		Gson gson_v=new Gson();
		map=gson_v.fromJson(bodyNode.toString(), mapType_v);
		Type listType = new TypeToken<ArrayList<TItovMenuClass>>(){}.getType();
		Gson gson_v1=new Gson();
		list=gson_v1.fromJson(map.get("result").toString(), listType);
		return list;
	}
	
/*	
 * 
 * <div class="accordionHeader"><h2><span>Folder</span>系统管理</h2></div>*/
	
	public static String getMenuClass(Integer role_id) throws Exception {
		List<TItovMenuClass> list = new ArrayList<TItovMenuClass>();
		list = getMenuClassFirstlist(1, role_id);
		StringBuffer sb=new StringBuffer();
		if (list != null) {
			for (TItovMenuClass tItovMenuClass : list) {
				sb.append("<div class='accordionHeader'><h2><span>Folder</span>"	+ tItovMenuClass.getClassName() + "</h2></div>");
				List<TItovMenuClass> list1 = new ArrayList<TItovMenuClass>();
				list1 = getMenuClassSecondlist(	tItovMenuClass.getClassId(), role_id);
				sb.append("<div class='accordionContent'><ul class='tree treeFolder'>");
				for (TItovMenuClass tItovMenuClass1 : list1) {
					if (tItovMenuClass1.getLeaf() == 0) {
						sb.append("<li><a>"+ tItovMenuClass1.getClassName() + "</a>");
						sb.append("<ul>");
						List<TItovMenuClass> list2 = new ArrayList<TItovMenuClass>();
						list2 = getMenuClassSecondlist(	tItovMenuClass1.getClassId(), role_id);
						for (TItovMenuClass tItovMenuClass2 : list2) {
						
							sb.append("<li><a href='/itovManage"
									+ tItovMenuClass2.getClassUrl() + "' target='"
									+ tItovMenuClass2.getTarget() + "' rel='"
									+ tItovMenuClass2.getRel() + "'>"
									+ tItovMenuClass2.getClassName() + "</a></li>");
						}
						sb.append("</ul></li>");

					} else {
						sb.append("<li><a href='/itovManage"
								+ tItovMenuClass1.getClassUrl() + "' target='"
								+ tItovMenuClass1.getTarget() + "' rel='"
								+ tItovMenuClass1.getRel() + "'>"
								+ tItovMenuClass1.getClassName() + "</a></li>");
					}
				}
				sb.append("</ul></div>");
			}
		}
		return sb.toString();
	}

	/**
	 * 得到菜单表t_itov_menu_class  的菜单
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("rawtypes")
	public static List<TItovMenuClass> getItovMenuClassFirstlist() throws Exception {
		Map paramMap=new HashMap();
		List<TItovMenuClass> list=new ArrayList<TItovMenuClass>();
		String result="";
		result=new ConnRest().getResult(paramMap, "menuClass.First.get");	
		ObjectMapper mapper = new ObjectMapper();
		JsonNode jsonNode = mapper.readTree(result);
		JsonNode bodyNode = jsonNode.get("body");
		System.out.println("body:" + bodyNode);
	    Map<String, Object> map = new HashMap<String, Object>();
		Type mapType_v = new TypeToken<HashMap<String, Object>>(){}.getType();
		Gson gson_v=new Gson();
		map=gson_v.fromJson(bodyNode.toString(), mapType_v);
		Type listType = new TypeToken<ArrayList<TItovMenuClass>>(){}.getType();
		Gson gson_v1=new Gson();
		list=gson_v1.fromJson(map.get("result").toString(), listType);
		return list;
	}
	/**
	 * 得到菜单表的 子菜单
	 * @param classParentid
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static List<TItovMenuClass> getItovMenuClassSecondlist(Integer classParentid) throws Exception {
		Map paramMap=new HashMap();
		paramMap.put("classParentid",classParentid);
		List<TItovMenuClass> list=new ArrayList<TItovMenuClass>();
		String result="";
		result=new ConnRest().getResult(paramMap, "menuclass.second.get");	
		ObjectMapper mapper = new ObjectMapper();
		JsonNode jsonNode = mapper.readTree(result);
		JsonNode bodyNode = jsonNode.get("body");
		System.out.println("body:" + bodyNode);
	    Map<String, Object> map = new HashMap<String, Object>();
		Type mapType_v = new TypeToken<HashMap<String, Object>>(){}.getType();
		Gson gson_v=new Gson();
		map=gson_v.fromJson(bodyNode.toString(), mapType_v);
		Type listType = new TypeToken<ArrayList<TItovMenuClass>>(){}.getType();
		Gson gson_v1=new Gson();
		list=gson_v1.fromJson(map.get("result").toString(), listType);
		return list;
	}
	/**
	 * 得到角色对应的权限
	 * @param roleId
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static List<TItovMenuAssgnRule> getItovMenuAssgnRulelist(Integer roleId) throws Exception {
		Map paramMap=new HashMap();
		paramMap.put("roleId",roleId);
		List<TItovMenuAssgnRule> list=new ArrayList<TItovMenuAssgnRule>();
		String result="";
		result=new ConnRest().getResult(paramMap, "menuAssgnRule.get");	
		ObjectMapper mapper = new ObjectMapper();
		JsonNode jsonNode = mapper.readTree(result);
		JsonNode bodyNode = jsonNode.get("body");
		System.out.println("body:" + bodyNode);
	    Map<String, Object> map = new HashMap<String, Object>();
		Type mapType_v = new TypeToken<HashMap<String, Object>>(){}.getType();
		Gson gson_v=new Gson();
		map=gson_v.fromJson(bodyNode.toString(), mapType_v);
		Type listType = new TypeToken<ArrayList<TItovMenuAssgnRule>>(){}.getType();
		Gson gson_v1=new Gson();
		list=gson_v1.fromJson(map.get("result").toString(), listType);
		return list;
	}
	
	public static void getMenuClass()
	{
		
		 List<TItovMenuClass> list1=new  ArrayList<TItovMenuClass>();
	}
	
	
	
	public static void main(String[] args) throws Exception {
		
		MenuClassService.getItovMenuAssgnRulelist(2);
	
	}
}
