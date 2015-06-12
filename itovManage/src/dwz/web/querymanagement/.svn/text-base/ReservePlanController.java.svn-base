package dwz.web.querymanagement;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import rest.util.ConnRest;
import dwz.manageRest.dto.FeedbackVO;
import dwz.manageRest.dto.ReservePlanVO;
import dwz.manageRest.dto.ReserveVO;
import dwz.manageRest.dto.TItov_Shop4s_manage;
import dwz.manageRest.dto.TItov_city_manage;
import dwz.manageRest.dto.Tzdc_query_feedback;
import dwz.manageRest.dto.Tzdc_query_reserve;
import dwz.manageRest.dto.Tzdc_query_reserveplan;
import dwz.web.BaseController;

@Controller("querymanagement.ReservePlanController")
@RequestMapping(value="/querymanagement/reserveplan")
public class ReservePlanController extends BaseController{
	/**
	 * 信息反馈列表
	 * @param vo
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("list")
	public String list(ReservePlanVO vo, Model model) throws Exception {
		@SuppressWarnings("rawtypes")
		Map paramMap = new HashMap();
		paramMap.put("page_num", Integer.valueOf(vo.getPageNum()));
		paramMap.put("page_size", Integer.valueOf(vo.getPageSize()));
		paramMap.put("begin_time", vo.getBegin_time());
		paramMap.put("end_time", vo.getEnd_time());
		
		List<Tzdc_query_reserveplan> list=new ArrayList<Tzdc_query_reserveplan>();
		String result="";
		result=new ConnRest().getResult(paramMap, "reserveplan.query.get");	
		System.out.println("result---->"+result);
		ObjectMapper mapper = new ObjectMapper();
		JsonNode jsonNode = mapper.readTree(result);
		JsonNode bodyNode = jsonNode.get("body");
		System.out.println("body:" + bodyNode);
	    Map<String, Object> map = new HashMap<String, Object>();
		Type mapType_v = new TypeToken<HashMap<String, Object>>(){}.getType();
		Gson gson_v=new Gson();
		map=gson_v.fromJson(bodyNode.toString(), mapType_v);
		Type listType = new TypeToken<ArrayList<Tzdc_query_reserveplan>>(){}.getType();
		Gson gson_v1=new Gson();
		list=gson_v1.fromJson(map.get("result").toString(), listType);
		Integer totalCount =Integer.parseInt(map.get("totalCount").toString().split("\\.")[0]);
		vo.setTotalCount(totalCount);
		model.addAttribute("reservePlanList", list);
		model.addAttribute("vo", vo);
		return "/management/reserve/planlist";
	}
	
	/**
	 * 添加预约内容信息页面
	 * @param vo
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("add")
	public String add(Model model2) throws Exception {
		return "/management/reserve/planAdd";
	}
	
	/**
	 * 保存
	 * @param vo
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/insertReservePlan",method = RequestMethod.POST)
	public ModelAndView insertReservePlan(HttpServletRequest request,Tzdc_query_reserveplan reserveplan) throws Exception {
		
		String begin_time = reserveplan.getBegin_time();
		String end_time = reserveplan.getEnd_time();
		int num= reserveplan.getNum();
		String content =reserveplan.getContent();


		Map<String,Object> paramMap=new HashMap<String,Object>();
		paramMap.put("begin_time", begin_time);
		paramMap.put("end_time", end_time);
		paramMap.put("num", num);
		paramMap.put("content", content);
		/*if(null ==  request.getSession().getAttribute("filePath"))
		{
			return ajaxDoneError("没有上传照片");
		}*/		
		String result="";
		result=new ConnRest().getResult(paramMap, "reservePlan.add");	
		ObjectMapper mapper = new ObjectMapper();
		JsonNode jsonNode = mapper.readTree(result);
		JsonNode headNode = jsonNode.get("head");
		if (headNode.get("error_code").toString().equals("0")) {
			return ajaxDoneSuccess(getMessage("msg.operation.success"));
		} else {
			String error_msg = headNode.get("error_msg").toString();
			return ajaxDoneError(error_msg);
		}
	}
}
