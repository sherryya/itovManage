package dwz.manageRest.services;

import java.lang.reflect.Type;

import java.util.HashMap;
import java.util.Map;

import rest.util.ConnRest;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;


import dwz.manageRest.dto.TItov_personal_manage;

public class PersonalService {
	/**
	 * 得到用户基本信息通过用户ID
	 * @param account_id
	 * @return
	 * @throws Exception
	 */
	public static TItov_personal_manage getPersonalInfoByAccountID(Integer account_id ) throws Exception {
		Map paramMap = new HashMap();
		paramMap.put("account_id", account_id);
		String result = "";
		result = new ConnRest().getResult(paramMap, "personal.info.get");
		ObjectMapper mapper = new ObjectMapper();
		JsonNode jsonNode = mapper.readTree(result);
		JsonNode headNode = jsonNode.get("head");
		JsonNode bodyNode = jsonNode.get("body");
		TItov_personal_manage tItov_personal_manage=new  TItov_personal_manage();
		if (headNode.get("error_code").toString().equals("0")) {
			    Map<String, Object> map = new HashMap<String, Object>();
				Type mapType_v = new TypeToken<HashMap<String, Object>>(){}.getType();
				Gson gson_v=new Gson();
				map=gson_v.fromJson(bodyNode.toString(), mapType_v);		
				Type listType = new TypeToken<TItov_personal_manage>(){}.getType();
				Gson gson_v1=new Gson();
				tItov_personal_manage=gson_v1.fromJson(map.get("result").toString(), listType);
		} else {
			String error_msg = headNode.get("error_msg").toString();
		}
		return tItov_personal_manage;
	}
	/**
	 * 修改用户基本信息
	 * @param account_id
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static String updPersonalInfoByAccountID(TItov_personal_manage tItov_personal_manage ) throws Exception {
		Map paramMap = new HashMap();
		paramMap.put("account_id", tItov_personal_manage.getAccount_id());
		paramMap.put("personal_real_name", tItov_personal_manage.getPersonal_real_name());
		paramMap.put("personal_tel", tItov_personal_manage.getPersonal_tel());
		paramMap.put("personal_email", tItov_personal_manage.getPersonal_email());
		paramMap.put("personal_qq", tItov_personal_manage.getPersonal_qq());
		paramMap.put("personal_age", tItov_personal_manage.getPersonal_age());
		paramMap.put("personal_sex", tItov_personal_manage.getPersonal_sex());

		
		
		String result = "";
		result = new ConnRest().getResult(paramMap, "personal.info.upd");
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
}
