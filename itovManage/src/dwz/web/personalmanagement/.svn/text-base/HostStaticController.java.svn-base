package dwz.web.personalmanagement;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import rest.util.ConnRest;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import dwz.framework.enums.Gender;
import dwz.manageRest.dto.BaseConditionManageVO;
import dwz.manageRest.dto.HostSubAccountLog;
import dwz.manageRest.dto.TZdcHostStatic;
import dwz.manageRest.dto.UsAccount;
import dwz.manageRest.dto.hostConditionVO;
import dwz.web.BaseController;

@Controller("personalmanagement.hostStaticController")
@RequestMapping(value = "/personalmanagement/hostStatic")
public class HostStaticController extends BaseController {

	/**
	 * 主播账户列表
	 * @param vo
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/hostStaticlist")
	public String hostStaticlist(hostConditionVO vo, Model model) throws Exception {
		Map<String,Object> paramMap = new HashMap<String,Object>();
		//System.out.println("pageNum--->>"+vo.getPageNum()+"---pageSize---->>"+vo.getPageSize()+"----accountId--->>"+vo.getKeywords());
		paramMap.put("page_num", vo.getPageNum());
		paramMap.put("page_size", vo.getPageSize());
		paramMap.put("voipAccount", vo.getVoipAccount());
		paramMap.put("voip_status", vo.getVoipStatus());
		List<HostSubAccountLog> list = new ArrayList<HostSubAccountLog>();
		String result = "";
		result = new ConnRest().getResult(paramMap, "hostSubLogCondition.get");
		ObjectMapper mapper = new ObjectMapper();
		JsonNode jsonNode = mapper.readTree(result);
		JsonNode bodyNode = jsonNode.get("body");
		System.out.println("body:" + bodyNode);
		Map<String, Object> map = new HashMap<String, Object>();
		Type mapType_v = new TypeToken<HashMap<String, Object>>() {
		}.getType();
		Gson gson_v = new Gson();
		map = gson_v.fromJson(bodyNode.toString(), mapType_v);
		Type listType = new TypeToken<ArrayList<HostSubAccountLog>>() {
		}.getType();
		Gson gson_v1 = new Gson();
		list = gson_v1.fromJson(map.get("hostStaticList").toString(), listType);
		Integer totalCount = Integer.parseInt(map.get("totalCount").toString()
				.split("\\.")[0]);
		vo.setTotalCount(totalCount);
		model.addAttribute("hostStaticList", list);
		model.addAttribute("vo", vo);
		
		return "/host/hostStaticList";
	}
	
	/**
	 * 主播账户列表
	 * @param vo
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/hostStaticLoglist/{voipAccount}")
	public String hostStaticLoglist(@PathVariable("voipAccount") String voipAccount,hostConditionVO vo, Model model) throws Exception {
		Map<String,Object> paramMap = new HashMap<String,Object>();
		//System.out.println("pageNum--->>"+vo.getPageNum()+"---pageSize---->>"+vo.getPageSize()+"----accountId--->>"+vo.getKeywords());
		String endtime=vo.getEndtime();
		String starttime = vo.getStarttime();
		paramMap.put("page_num", vo.getPageNum());
		paramMap.put("page_size", vo.getPageSize());
		paramMap.put("voipAccount", vo.getVoipAccount());
		paramMap.put("starttime", starttime);
		paramMap.put("endtime",endtime);
		paramMap.put("voip_status", vo.getVoipStatus());
		List<HostSubAccountLog> list = new ArrayList<HostSubAccountLog>();
		String result = "";
		result = new ConnRest().getResult(paramMap, "hostSubAccountLog.get");
		ObjectMapper mapper = new ObjectMapper();
		JsonNode jsonNode = mapper.readTree(result);
		JsonNode bodyNode = jsonNode.get("body");
		System.out.println("body:" + bodyNode);
		Map<String, Object> map = new HashMap<String, Object>();
		Type mapType_v = new TypeToken<HashMap<String, Object>>() {
		}.getType();
		Gson gson_v = new Gson();
		map = gson_v.fromJson(bodyNode.toString(), mapType_v);
		Type listType = new TypeToken<ArrayList<HostSubAccountLog>>() {
		}.getType();
		Gson gson_v1 = new Gson();
		list = gson_v1.fromJson(map.get("hostStaticLogList").toString(), listType);
		Integer totalCount = Integer.parseInt(map.get("totalCount").toString()
				.split("\\.")[0]);
		vo.setTotalCount(totalCount);
		model.addAttribute("hostStaticLogList", list);
		model.addAttribute("voipAccount", voipAccount);
		model.addAttribute("starttime", starttime);
		model.addAttribute("endtime", endtime);
		model.addAttribute("vo", vo);
		
		return "/host/hostStaticLogByVoip";
	}
	/**
	 * 查询主播账户的日志信息获取登录时间
	 * @param hostId
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/hostStaticInfo/{voipAccount}")
	public String hostStaticInfo(@PathVariable("voipAccount")String voipAccount,hostConditionVO vo, Model model) throws Exception {
		Map<String,Object> paramMap = new HashMap<String,Object>();
		paramMap.put("voipAccount", vo.getVoipAccount());
		paramMap.put("page_num", vo.getPageNum());
		paramMap.put("page_size", vo.getPageSize());
		List<TZdcHostStatic> list = new ArrayList<TZdcHostStatic>();
		String result = "";
		result = new ConnRest().getResult(paramMap, "hostStaticByAccount.get");
		ObjectMapper mapper = new ObjectMapper();
		JsonNode jsonNode = mapper.readTree(result);
		JsonNode bodyNode = jsonNode.get("body");
		System.out.println("body:" + bodyNode);
		Map<String, Object> map = new HashMap<String, Object>();
		Type mapType_v = new TypeToken<HashMap<String, Object>>() {
		}.getType();
		Gson gson_v = new Gson();
		map = gson_v.fromJson(bodyNode.toString(), mapType_v);
		Type listType = new TypeToken<ArrayList<TZdcHostStatic>>() {
		}.getType();
		Gson gson_v1 = new Gson();
		list = gson_v1.fromJson(map.get("hostStaticInfoList").toString(), listType);
		Integer totalCount = Integer.parseInt(map.get("totalCount").toString()
				.split("\\.")[0]);
		vo.setTotalCount(totalCount);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		for(TZdcHostStatic sta:list)
		{
			if(null !=sta.getOnlinetime())
			{
				sta.setLinetime(sdf.format(sta.getOnlinetime()));//.setOnlinetime(sdf.format(sta.getOnlinetime()));
			}
			if(null !=sta.getOfftime())
			{
				//sta.setOfftime(sdf.format(sta.getOfftime()));
				sta.setOftime(sdf.format(sta.getOfftime()));
			}
			
		}
		model.addAttribute("hostStaticInfoList", list);
		model.addAttribute("voipAccount", voipAccount);
		model.addAttribute("vo", vo);
		return "/host/hostStaticInfo";
	}
	
	/**
	 * 主播账户列表
	 * @param vo
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/hostStaticLogById/{id}")
	public String hostStaticLogById(@PathVariable("id") int id,hostConditionVO vo, Model model) throws Exception {
		Map<String,Object> paramMap1 = new HashMap<String,Object>();
		paramMap1.put("id", id);
		List<TZdcHostStatic> liststatic = new ArrayList<TZdcHostStatic>();
		String result1 = "";
		result1 = new ConnRest().getResult(paramMap1, "hostStaticById.get");
		ObjectMapper mapper1 = new ObjectMapper();
		JsonNode jsonNode1 = mapper1.readTree(result1);
		JsonNode bodyNode1 = jsonNode1.get("body");
		System.out.println("body:" + bodyNode1);
		Map<String, Object> map1 = new HashMap<String, Object>();
		Type mapType_v1 = new TypeToken<HashMap<String, Object>>() {
		}.getType();
		Gson gson1 = new Gson();
		map1 = gson1.fromJson(bodyNode1.toString(), mapType_v1);
		Type listType1 = new TypeToken<ArrayList<TZdcHostStatic>>() {
		}.getType();
		Gson gson = new Gson();
		liststatic = gson.fromJson(map1.get("hostStatic").toString(), listType1);
		//格式化日期
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Map<String,Object> paramMap = new HashMap<String,Object>();
		//System.out.println("pageNum--->>"+vo.getPageNum()+"---pageSize---->>"+vo.getPageSize()+"----accountId--->>"+vo.getKeywords());
		paramMap.put("page_num", vo.getPageNum());
		paramMap.put("page_size", vo.getPageSize());
		paramMap.put("voipAccount", liststatic.get(0).getVoipaccount());
		paramMap.put("starttime", sdf.format(liststatic.get(0).getOnlinetime()));  //格式化在线时间
		paramMap.put("endtime", sdf.format(liststatic.get(0).getOfftime())); //格式化下线时间
		paramMap.put("voip_status", vo.getVoipStatus());
		List<HostSubAccountLog> list = new ArrayList<HostSubAccountLog>();
		String result = "";
		result = new ConnRest().getResult(paramMap, "hostSubAccountLog.get");
		ObjectMapper mapper = new ObjectMapper();
		JsonNode jsonNode = mapper.readTree(result);
		JsonNode bodyNode = jsonNode.get("body");
		System.out.println("body:" + bodyNode);
		Map<String, Object> map = new HashMap<String, Object>();
		Type mapType_v = new TypeToken<HashMap<String, Object>>() {
		}.getType();
		Gson gson_v = new Gson();
		map = gson_v.fromJson(bodyNode.toString(), mapType_v);
		Type listType = new TypeToken<ArrayList<HostSubAccountLog>>() {
		}.getType();
		Gson gson_v1 = new Gson();
		list = gson_v1.fromJson(map.get("hostStaticLogList").toString(), listType);
		Integer totalCount = Integer.parseInt(map.get("totalCount").toString()
				.split("\\.")[0]);
		vo.setTotalCount(totalCount);
		model.addAttribute("hostStaticLogList", list);
		model.addAttribute("voipAccount", liststatic.get(0).getVoipaccount());
		model.addAttribute("vo", vo);
		
		return "/host/hostStaticLogByVoip";
	}

}
