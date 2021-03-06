package dwz.web.personalmanagement;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
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
import dwz.framework.enums.Gender;
import dwz.framework.user.UserServiceMgr;
import dwz.manageRest.dto.BaseConditionManageVO;
import dwz.manageRest.dto.TItov_personal_manage;
import dwz.manageRest.dto.UsAccount;
import dwz.manageRest.services.PersonalService;
import dwz.persistence.beans.TerminalInfo;
import dwz.web.BaseController;
@Controller("personalmanagement.personalController")
@RequestMapping(value="/personalmanagement/personal")
public class PersonalController extends BaseController{
	
	@Autowired
	private UserServiceMgr userMgr;

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
		Map paramMap=new HashMap();
		paramMap.put("account_type",Integer.valueOf(vo.getAccount_type()));
		paramMap.put("agentstate",vo.getAgentstate());
		paramMap.put("account_name",vo.getKeywords()==null ? "%":vo.getKeywords());
		paramMap.put("pageNum",Integer.valueOf(vo.getPageNum()));
		paramMap.put("pageSize",Integer.valueOf(vo.getPageSize()));
		List<TItov_personal_manage> list=new ArrayList<TItov_personal_manage>();
		String result="";
		result=new ConnRest().getResult(paramMap, "personal.manage.get");	
		ObjectMapper mapper = new ObjectMapper();
		JsonNode jsonNode = mapper.readTree(result);
		JsonNode bodyNode = jsonNode.get("body");
		System.out.println("body:" + bodyNode);
	    Map<String, Object> map = new HashMap<String, Object>();
		Type mapType_v = new TypeToken<HashMap<String, Object>>(){}.getType();
		Gson gson_v=new Gson();
		map=gson_v.fromJson(bodyNode.toString(), mapType_v);
		Type listType = new TypeToken<ArrayList<TItov_personal_manage>>(){}.getType();
		Gson gson_v1=new Gson();
		list=gson_v1.fromJson(map.get("result").toString(), listType);
		Integer totalCount =Integer.parseInt(map.get("totalCount").toString().split("\\.")[0]);
		vo.setTotalCount(totalCount);
		model.addAttribute("userList", list);
		model.addAttribute("vo", vo);
		return "/management/personal/list";
	}	
	/**
	 * 终端用户列表
	 * @param vo
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("list1")
	public String list1(BaseConditionManageVO vo, Model model) throws Exception {
		@SuppressWarnings("rawtypes")
		Map paramMap=new HashMap();
		paramMap.put("account_type",Integer.valueOf(vo.getAccount_type1()));
		paramMap.put("account_name",vo.getKeywords()==null ? "%":vo.getKeywords());
		paramMap.put("pageNum",Integer.valueOf(vo.getPageNum()));
		paramMap.put("pageSize",Integer.valueOf(vo.getPageSize()));		
		List<TItov_personal_manage> list=new ArrayList<TItov_personal_manage>();
		String result="";
		result=new ConnRest().getResult(paramMap, "personal.manage1.get");	
		ObjectMapper mapper = new ObjectMapper();
		JsonNode jsonNode = mapper.readTree(result);
		JsonNode bodyNode = jsonNode.get("body");
		System.out.println("body:" + bodyNode);
	    Map<String, Object> map = new HashMap<String, Object>();
		Type mapType_v = new TypeToken<HashMap<String, Object>>(){}.getType();
		Gson gson_v=new Gson();
		map=gson_v.fromJson(bodyNode.toString(), mapType_v);		
		Type listType = new TypeToken<ArrayList<TItov_personal_manage>>(){}.getType();
		Gson gson_v1=new Gson();
		list=gson_v1.fromJson(map.get("result").toString(), listType);
		Integer totalCount =Integer.parseInt(map.get("totalCount").toString().split("\\.")[0]);
		vo.setTotalCount(totalCount);
		model.addAttribute("userList", list);
		model.addAttribute("vo", vo);
		return "/management/personal/list1";
	}
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public ModelAndView insert(UsAccount usAccount) throws Exception {
		@SuppressWarnings("rawtypes")
		Map paramMap=new HashMap();
		String Account_role_id="0";//usAccount.getAccount_role_id().toString();
		String Account_type="4";//usAccount.getAccount_type().toString();
		paramMap.put("account_type",Account_type);
		paramMap.put("account_name",usAccount.getAccount_name());
		paramMap.put("account_password",usAccount.getAccount_password());
		paramMap.put("account_role_id",Account_role_id);	
		paramMap.put("company_id","0");	
		String result="";
		result=new ConnRest().getResult(paramMap, "user.add");	
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
	@RequestMapping("/add")
	public String add(Model model) {
		model.addAttribute("genderList", Gender.values());
		return "/management/personal/add";
	}
	@RequestMapping("/edit/{userId}")
	public String edit(@PathVariable("userId") int userId, Model model) throws Exception {
		TItov_personal_manage tItov_personal_manage  = PersonalService.getPersonalInfoByAccountID(userId);
		model.addAttribute("vo", tItov_personal_manage);
		return "/management/personal/edit";
	}
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ModelAndView update(TItov_personal_manage tItov_personal_manage)	throws Exception {
		String ret = PersonalService.updPersonalInfoByAccountID(tItov_personal_manage);
		if (ret.equalsIgnoreCase("0")) {
			return ajaxDoneSuccess(getMessage("msg.operation.success"));
		} else {
			return ajaxDoneError(ret);
		}
	}
	
	
	@RequestMapping("/updpwd")
	public String updpwd(Model model) {
		return "/management/editPwd";
	}
	
	@RequestMapping("/QRCodeIndex")
	public String QRCodeIndex(Model model) {
		model.addAttribute("genderList", Gender.values());
		return "/management/ruilang/indexruilang";
	}
	@RequestMapping("/getTerminalList")
	public String getTerminalList(Model model,TerminalInfo terminal) throws Exception {
	
		if(terminal.getPageSize()==0)
		{
			terminal.setPageSize(10);
		}
		if(terminal.getPageNum()<=0)
		{
			terminal.setPageNum(1);
		}
		terminal.setStartLimit((terminal.getPageNum()-1)*terminal.getPageSize());
		List<TerminalInfo> list = userMgr.queryTerminalList(terminal);  //分页查询所有车辆imei
		int totalCount = userMgr.queryCountTerminalList();   //查询总条数s
		
		terminal.setTotalCount(totalCount);
		model.addAttribute("terminalList", list);
		model.addAttribute("vo", terminal);
		return "/management/car/terminalList";
	}
	@RequestMapping("/printSkip/{terminal_imei}")
	public String printSkip(@PathVariable("terminal_imei")String terminal_imei, HttpServletRequest request,Model model,TerminalInfo terminal) throws Exception {
	    String data = "[{\\\"terminal_imei\\\":\\\""+terminal_imei+"\\\"},{\\\"terminal_imei\\\":\\\"12345678\\\"}]";
		//terminal.setStartLimit((terminal.getPageNum()-1)*terminal.getPageSize());
		//List<TerminalInfo> list = userMgr.queryTerminalList(terminal);  //分页查询所有车辆imei
		//int totalCount = userMgr.queryCountTerminalList();   //查询总条数s
		//String data = "/itovManage/management/ruilang/data/xmlInvoiceMany.jsp";
		//terminal.setTotalCount(totalCount);
	    request.setAttribute("report", "qr.grf");
	    request.setAttribute("data", data);
		//model.addAttribute("report", "qr.grf");
		//model.addAttribute("data", data);
		return "/management/ruilang/General/PrintReport";
	}
}
