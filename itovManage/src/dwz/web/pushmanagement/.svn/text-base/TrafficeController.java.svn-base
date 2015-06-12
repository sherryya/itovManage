package dwz.web.pushmanagement;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import rest.util.ConnRest;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import dwz.manageRest.dto.BaseConditionManageVO;
import dwz.manageRest.dto.TItov_personal_manage;

@Controller("pushmanagement.TrafficeController")
@RequestMapping(value="/pushmanagement/traffic")
public class TrafficeController {
	/**
	 * 坐席信息列表
	 * @param vo
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("list")
	public String list(BaseConditionManageVO vo, Model model) throws Exception {
		@SuppressWarnings("rawtypes")
		//
		Map paramMap=new HashMap();
		paramMap.put("account_type",Integer.valueOf(vo.getAccount_type()));
		paramMap.put("agentstate",vo.getAgentstate());
		paramMap.put("account_name",vo.getKeywords()==null ? "%":vo.getKeywords());
		paramMap.put("pageNum",Integer.valueOf(vo.getPageNum()));
		paramMap.put("pageSize",Integer.valueOf(vo.getPageSize()));
		//
		List<TItov_personal_manage> list=new ArrayList<TItov_personal_manage>();
		String result="";
		result=new ConnRest().getResult(paramMap, "personal.manage.get");
		//
		ObjectMapper mapper = new ObjectMapper();
		JsonNode jsonNode = mapper.readTree(result);
		JsonNode bodyNode = jsonNode.get("body");
		System.out.println("body:" + bodyNode);
		//
	    Map<String, Object> map = new HashMap<String, Object>();
		Type mapType_v = new TypeToken<HashMap<String, Object>>(){}.getType();
		Gson gson_v=new Gson();
		map=gson_v.fromJson(bodyNode.toString(), mapType_v);
		//
		Type listType = new TypeToken<ArrayList<TItov_personal_manage>>(){}.getType();
		Gson gson_v1=new Gson();
		list=gson_v1.fromJson(map.get("result").toString(), listType);
		Integer totalCount =Integer.parseInt(map.get("totalCount").toString().split("\\.")[0]);
		vo.setTotalCount(totalCount);
		//
		model.addAttribute("userList", list);
		model.addAttribute("vo", vo);
		
		return "/management/push/list";
	}	
}
