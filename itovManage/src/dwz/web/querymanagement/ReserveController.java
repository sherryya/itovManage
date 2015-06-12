package dwz.web.querymanagement;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import rest.util.ConnRest;
import dwz.manageRest.dto.FeedbackVO;
import dwz.manageRest.dto.ReserveVO;
import dwz.manageRest.dto.Tzdc_query_feedback;
import dwz.manageRest.dto.Tzdc_query_reserve;
import dwz.web.BaseController;

@Controller("querymanagement.ReserveController")
@RequestMapping(value="/querymanagement/reserve")
public class ReserveController extends BaseController{
	/**
	 * 信息反馈列表
	 * @param vo
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("/reservelist")
	public String reservelist(ReserveVO vo, Model model) throws Exception {
		@SuppressWarnings("rawtypes")
		Map paramMap = new HashMap();
		paramMap.put("page_num", Integer.valueOf(vo.getPageNum()));
		paramMap.put("page_size", Integer.valueOf(vo.getPageSize()));
		paramMap.put("is_deal", vo.getIs_deal()==null?"%":vo.getIs_deal());
		paramMap.put("reserve_code", vo.getReserve_code()==null?"%":vo.getReserve_code());
		paramMap.put("reserve_name",vo.getName()==null ? "%":vo.getName());
		paramMap.put("phone_no",vo.getPhone_num()==null ? "%":vo.getPhone_num());
		
		List<Tzdc_query_reserve> list=new ArrayList<Tzdc_query_reserve>();
		String result="";
		result=new ConnRest().getResult(paramMap, "reserve.query.get");	
		System.out.println("result---->"+result);
		ObjectMapper mapper = new ObjectMapper();
		JsonNode jsonNode = mapper.readTree(result);
		JsonNode bodyNode = jsonNode.get("body");
		System.out.println("body:" + bodyNode);
	    Map<String, Object> map = new HashMap<String, Object>();
		Type mapType_v = new TypeToken<HashMap<String, Object>>(){}.getType();
		Gson gson_v=new Gson();
		map=gson_v.fromJson(bodyNode.toString(), mapType_v);
		Type listType = new TypeToken<ArrayList<Tzdc_query_reserve>>(){}.getType();
		Gson gson_v1=new Gson();
		list=gson_v1.fromJson(map.get("result").toString(), listType);
		Integer totalCount =Integer.parseInt(map.get("totalCount").toString().split("\\.")[0]);
		vo.setTotalCount(totalCount);
		model.addAttribute("reserveList", list);
		model.addAttribute("vo", vo);
		return "/management/reserve/list";
	}

}
