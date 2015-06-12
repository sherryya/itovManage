package dwz.web.personalmanagement;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import rest.util.ConnRest;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.ibm.icu.text.SimpleDateFormat;

import dwz.framework.enums.Gender;
import dwz.manageRest.dto.BaseConditionManageVO;
import dwz.manageRest.dto.TItovPttCallLog;
import dwz.manageRest.dto.TItovPttEmpAgent;
import dwz.manageRest.dto.TItov_personal_manage;
import dwz.manageRest.dto.UsAccount;
import dwz.manageRest.services.PersonalService;
import dwz.web.BaseController;

@Controller("personalmanagement.empLogController")
@RequestMapping(value = "/personalmanagement/empAgent")
public class EmpLogController extends BaseController {
	
	/**
	 * 
	 * @param logBean
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("getLog")
	public String getLog(BaseConditionManageVO vo, Model model) throws Exception {
		@SuppressWarnings("rawtypes")
		Map paramMap = new HashMap();
		// paramMap.put("account_type",Integer.valueOf(vo.getAccount_type()));
		// paramMap.put("agentstate",vo.getAgentstate());
		// paramMap.put("account_name",vo.getKeywords()==null ?
		// "%":vo.getKeywords());
		System.out.println("pagesize---->>"+vo.getPageSize()+"----pageno--->"+vo.getPageNum()+"-----keyWords----->>"+vo.getKeywords());
		//vo.
		paramMap.put("agentId", vo.getKeywords());
		paramMap.put("pageNum", Integer.valueOf(vo.getPageNum()));
		paramMap.put("pageSize", Integer.valueOf(vo.getPageSize()));
		List<TItovPttCallLog> list = new ArrayList<TItovPttCallLog>();
		String result = "";
		result = new ConnRest().getResult(paramMap, "callLogByAgentId.get");
		ObjectMapper mapper = new ObjectMapper();
		JsonNode jsonNode = mapper.readTree(result);
		JsonNode bodyNode = jsonNode.get("body");

		JsonNode bodyNodes = bodyNode.get("items_list");
		//System.out.println("1111" + bodyNodes.asText());
		System.out.println("2222" + bodyNodes.toString());
		String aaa = bodyNode.get("items_list").toString();
		
		Iterator element = bodyNodes.elements();

		while (element.hasNext()) {
			//System.out.println(element.next());
			JsonNode items_list = mapper.readTree(element.next() + "");
			TItovPttCallLog tItovPttCallLog = new TItovPttCallLog();
			System.out.println("~~~~~~~~~~~~~"+new SimpleDateFormat("yyyy-MM-dd").format((new SimpleDateFormat("yyyy-MM-dd").parse(items_list.get("calldatetime").asText()))));
			tItovPttCallLog.setCalldatetime(new SimpleDateFormat("yyyy-MM-dd").format((new SimpleDateFormat("yyyy-MM-dd").parse(items_list.get("calldatetime").asText()))));
			tItovPttCallLog.setAgentid(Integer.parseInt(items_list.get("agentid").asText()));
			tItovPttCallLog.setCallto(items_list.get("callto").asText());
			tItovPttCallLog.setAgentstate(Integer.parseInt(items_list.get("agentstate").asText()));
			tItovPttCallLog.setCallduration(items_list.get("callduration").asText());
			tItovPttCallLog.setCallfrom(items_list.get("callfrom").asText());
			tItovPttCallLog.setCallid(items_list.get("callid").asText());
			tItovPttCallLog.setCallto(items_list.get("callto").asText());
			tItovPttCallLog.setDirection(items_list.get("direction").asText());
			tItovPttCallLog.setEndettime(new SimpleDateFormat("yyyy-MM-dd").format((new SimpleDateFormat("yyyy-MM-dd").parse(items_list.get("endettime").asText()))));
			tItovPttCallLog.setErrorcode(items_list.get("errorcode").asText());
			tItovPttCallLog.setId(Long.parseLong(items_list.get("id").asText()));
			//tItovPttCallLog.setPageSize(items_list.get("agentid").asText()pageSize);
			tItovPttCallLog.setRecordid(items_list.get("recordid").asText());
			tItovPttCallLog.setRecordurl(items_list.get("recordurl").asText());
			//tItovPttCallLog.setStartLimit(Integer.parseInt(items_list.get("startLimit").asText()));
			tItovPttCallLog.setStarttime(new SimpleDateFormat("yyyy-MM-dd").format((new SimpleDateFormat("yyyy-MM-dd").parse(items_list.get("starttime").asText()))));
			list.add(tItovPttCallLog);
		}

		Map<String, Object> map = new HashMap<String, Object>();
		Type mapType_v = new TypeToken<HashMap<String, Object>>() {
		}.getType();
		Gson gson_v = new Gson();

		map = gson_v.fromJson(bodyNode.toString(), mapType_v);
		/*
		 * Map<String, Object> map = new HashMap<String, Object>(); Type
		 * mapType_v = new TypeToken<HashMap<String, Object>>(){}.getType();
		 * //Gson gson_v=new Gson();
		 * 
		 * Gson gson_v = new GsonBuilder() .setDateFormat("yyyy-MM-dd HH:mm:ss")
		 * .create();
		 * 
		 * Gson gson_v = new
		 * GsonBuilder().setDateFormat("yyyy-MM-dd").registerTypeAdapter
		 * (Date.class, new DateTypeAdapter()).create();
		 * map=gson_v.fromJson(bodyNode.toString(), mapType_v);
		 * System.out.println("map---->>"+map); Type listType = new
		 * TypeToken<ArrayList<TItovPttCallLog>>(){}.getType(); Gson gson_v1=
		 * new
		 * GsonBuilder().setDateFormat("yyyy-MM-dd").registerTypeAdapter(Date
		 * .class, new DateTypeAdapter()).create(); Gson gson_v1 = new
		 * GsonBuilder() .setDateFormat("yyyy-MM-dd HH:mm:ss") .create();
		 * 
		 * String ret=map.get("items_list").toString();
		 * System.out.println("~~"+ret); ObjectMapper objectMapper = new
		 * ObjectMapper();
		 * 
		 * 
		 * 
		 * 
		 * 
		 * list=gson_v1.fromJson(map.get("items_list").toString(), listType);
		 */

		
        
		Integer totalCount = Integer.parseInt(map.get("sum_count").toString()
				.split("\\.")[0]);
		//Integer page_count = Integer.parseInt(map.get("page_count").toString()
		//		.split("\\.")[0]);
		System.out.println("totalCount----->>>"+totalCount);
		vo.setTotalCount(totalCount);
		//vo.setPageNum(1);
		model.addAttribute("logList", list);
		model.addAttribute("vo", vo);
		return "/management/personal/logCall";
	}
	
	/**
	 * 坐席信息列表
	 * 
	 * @param vo
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("empAgentlist")
	public String empAgentlist(BaseConditionManageVO vo, Model model) throws Exception {
		@SuppressWarnings("rawtypes")
		Map paramMap = new HashMap();
		//paramMap.put("account_type", Integer.valueOf(vo.getAccount_type()));
		//paramMap.put("agentstate", vo.getAgentstate());
		paramMap.put("accountId", vo.getKeywords());
		//paramMap.put("accountId", 48);
		System.out.println("pageNUm--->>"+vo.getPageNum()+"---pageSize---->>"+vo.getPageSize()+"----accountId--->>"+vo.getKeywords());
		paramMap.put("pageNum", Integer.valueOf(vo.getPageNum()));
		paramMap.put("pageSize", Integer.valueOf(vo.getPageSize()));
		List<TItovPttEmpAgent> list = new ArrayList<TItovPttEmpAgent>();
		String result = "";
		result = new ConnRest().getResult(paramMap, "empAgentList.get");
		ObjectMapper mapper = new ObjectMapper();
		JsonNode jsonNode = mapper.readTree(result);
		JsonNode bodyNode = jsonNode.get("body");
		System.out.println("body:" + bodyNode);
		Map<String, Object> map = new HashMap<String, Object>();
		Type mapType_v = new TypeToken<HashMap<String, Object>>() {
		}.getType();
		Gson gson_v = new Gson();
		map = gson_v.fromJson(bodyNode.toString(), mapType_v);
		Type listType = new TypeToken<ArrayList<TItovPttEmpAgent>>() {
		}.getType();
		Gson gson_v1 = new Gson();
		list = gson_v1.fromJson(map.get("emp_list").toString(), listType);
		System.out.println("list----->>"+list);
		for(TItovPttEmpAgent empBean : list)
		{
			System.out.println("empName----->>"+empBean.getAgent_name());
		}
		Integer totalCount = Integer.parseInt(map.get("totalCount").toString()
				.split("\\.")[0]);
		vo.setTotalCount(totalCount);
		model.addAttribute("empList", list);
		model.addAttribute("vo", vo);
		return "/management/personal/empAgent";
	}

}
