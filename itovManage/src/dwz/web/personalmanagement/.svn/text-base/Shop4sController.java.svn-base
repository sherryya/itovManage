package dwz.web.personalmanagement;

import java.io.PrintWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
import dwz.manageRest.dto.BaseConditionManageVO;
import dwz.manageRest.dto.CityManageVO;
import dwz.manageRest.dto.HostSubAccountLog;
import dwz.manageRest.dto.Shop4sUserVO;
import dwz.manageRest.dto.TIto_shop4s_user;
import dwz.manageRest.dto.TItov_Shop4s_manage;
import dwz.manageRest.dto.TItov_city_manage;
import dwz.manageRest.dto.TItov_personal_manage;
import dwz.manageRest.dto.TZdcHostUser;
import dwz.manageRest.dto.UsAccount;
import dwz.manageRest.dto.hostConditionVO;
import dwz.manageRest.services.PersonalService;
import dwz.web.BaseController;

@Controller("personalmanagement.shop4sController")
@RequestMapping(value="/personalmanagement/shop4s")
public class Shop4sController extends BaseController{
	/**
	 * 4s信息列表
	 * @param vo
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("list")
	public String list(CityManageVO vo, Model model) throws Exception {
		@SuppressWarnings("rawtypes")
		Map paramMap=new HashMap();
		
		paramMap.put("pId",vo.getpId()==null?"%":vo.getpId());
		paramMap.put("cId",vo.getcId()==null?"%":vo.getcId());
		paramMap.put("dId",vo.getdId()==null?"%":vo.getdId());
		paramMap.put("pageNum",Integer.valueOf(vo.getPageNum()));
		paramMap.put("pageSize",Integer.valueOf(vo.getPageSize()));
		List<TItov_Shop4s_manage> list=new ArrayList<TItov_Shop4s_manage>();
		String result="";
		result=new ConnRest().getResult(paramMap, "personal.shop4s.get");	
		ObjectMapper mapper = new ObjectMapper();
		JsonNode jsonNode = mapper.readTree(result);
		JsonNode bodyNode = jsonNode.get("body");
		System.out.println("body:" + bodyNode);
	    Map<String, Object> map = new HashMap<String, Object>();
		Type mapType_v = new TypeToken<HashMap<String, Object>>(){}.getType();
		Gson gson_v=new Gson();
		map=gson_v.fromJson(bodyNode.toString(), mapType_v);
		Type listType = new TypeToken<ArrayList<TItov_Shop4s_manage>>(){}.getType();
		Gson gson_v1=new Gson();
		list=gson_v1.fromJson(map.get("result").toString(), listType);
		Integer totalCount =Integer.parseInt(map.get("totalCount").toString().split("\\.")[0]);
		vo.setTotalCount(totalCount);
		model.addAttribute("userList", list);
		model.addAttribute("vo", vo);
		
		//查询省份信息
		List<TItov_city_manage> list2=new ArrayList<TItov_city_manage>();
		String result2="";
		result2=new ConnRest().getResult(paramMap, "personal.province.get");	
		ObjectMapper mapper2 = new ObjectMapper();
		JsonNode jsonNode2 = mapper2.readTree(result2);
		JsonNode bodyNode2 = jsonNode2.get("body");
		System.out.println("body:" + bodyNode2);
	    Map<String, Object> map2 = new HashMap<String, Object>();
		Type mapType_v2 = new TypeToken<HashMap<String, Object>>(){}.getType();
		Gson gson_v2=new Gson();
		map2=gson_v2.fromJson(bodyNode2.toString(), mapType_v2);
		Type listType2 = new TypeToken<ArrayList<TItov_city_manage>>(){}.getType();
		Gson gson_v12=new Gson();
		list2=gson_v12.fromJson(map2.get("result").toString(), listType2);
		model.addAttribute("proList", list2);		
		return "/management/shop4s/list";
	}	
	
	@RequestMapping("citylist/{s1}")
	public void citylist(@PathVariable("s1") String s1,HttpServletResponse response) throws Exception {
		@SuppressWarnings("rawtypes")
		Map paramMap=new HashMap();
		System.out.println("s1------>"+s1);
		paramMap.put("pId",s1);
		List<TItov_city_manage> list2=new ArrayList<TItov_city_manage>();
		String result2="";
		result2=new ConnRest().getResult(paramMap, "personal.city.get");	
		ObjectMapper mapper2 = new ObjectMapper();
		JsonNode jsonNode2 = mapper2.readTree(result2);
		JsonNode bodyNode2 = jsonNode2.get("body");
		System.out.println("body:" + bodyNode2);
	    Map<String, Object> map2 = new HashMap<String, Object>();
		Type mapType_v2 = new TypeToken<HashMap<String, Object>>(){}.getType();
		Gson gson_v2=new Gson();
		map2=gson_v2.fromJson(bodyNode2.toString(), mapType_v2);
		Type listType2 = new TypeToken<ArrayList<TItov_city_manage>>(){}.getType();
		Gson gson_v12=new Gson();
		list2=gson_v12.fromJson(map2.get("result").toString(), listType2);
		//返回xml
		PrintWriter out=response.getWriter();
		out.println("<province>");
		if(list2.size()==0){
			out.println("<city>");
			out.print("<c_id>" + "-9999" + "</c_id>");
			out.print("<c_name>" +"--请选择--" + "</c_name>");
			out.println("</city>");	
		}else{
			for (int i = 0; i < list2.size(); i++) {
				out.println("<city>");
				out.print("<c_id>" + list2.get(i).getcId() + "</c_id>");
				out.print("<c_name>" + list2.get(i).getcName() + "</c_name>");
				out.println("</city>");	
			}
		}

		out.println("</province>");
	}	
	
	@RequestMapping("countrylist/{s2}")
	public void countrylist(@PathVariable("s2") String s2,HttpServletResponse response) throws Exception {
		@SuppressWarnings("rawtypes")
		Map paramMap=new HashMap();
		System.out.println("s2------>"+s2);
		paramMap.put("cId",s2);
		List<TItov_city_manage> list2=new ArrayList<TItov_city_manage>();
		String result2="";
		result2=new ConnRest().getResult(paramMap, "personal.country.get");	
		ObjectMapper mapper2 = new ObjectMapper();
		JsonNode jsonNode2 = mapper2.readTree(result2);
		JsonNode bodyNode2 = jsonNode2.get("body");
		System.out.println("body:" + bodyNode2);
	    Map<String, Object> map2 = new HashMap<String, Object>();
		Type mapType_v2 = new TypeToken<HashMap<String, Object>>(){}.getType();
		Gson gson_v2=new Gson();
		map2=gson_v2.fromJson(bodyNode2.toString(), mapType_v2);
		Type listType2 = new TypeToken<ArrayList<TItov_city_manage>>(){}.getType();
		Gson gson_v12=new Gson();
		list2=gson_v12.fromJson(map2.get("result").toString(), listType2);
		//返回xml
		PrintWriter out=response.getWriter();
		out.println("<city>");
		if(list2.size()==0){
			out.println("<district>");
			out.print("<d_id>" + "-9999" + "</d_id>");
			out.print("<d_name>" + "--请选择--" + "</d_name>");
			out.println("</district>");		
		}else{
			for (int i = 0; i < list2.size(); i++) {
				out.println("<district>");
				out.print("<d_id>" + list2.get(i).getdId() + "</d_id>");
				out.print("<d_name>" + list2.get(i).getdName() + "</d_name>");
				out.println("</district>");	
			}
		}
		out.println("</city>");
	}
	/**
	 * 添加4s信息页面
	 * @param vo
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("add")
	public String add(Model model2) throws Exception {
		//model.addAttribute("genderList", Gender.values());
		
		//查询省份信息
		Map paramMap=new HashMap();
		List<TItov_city_manage> list3=new ArrayList<TItov_city_manage>();
		String result2="";
		result2=new ConnRest().getResult(paramMap, "personal.province.get");	
		ObjectMapper mapper2 = new ObjectMapper();
		JsonNode jsonNode2 = mapper2.readTree(result2);
		JsonNode bodyNode2 = jsonNode2.get("body");
		System.out.println("body:" + bodyNode2);
	    Map<String, Object> map2 = new HashMap<String, Object>();
		Type mapType_v2 = new TypeToken<HashMap<String, Object>>(){}.getType();
		Gson gson_v2=new Gson();
		map2=gson_v2.fromJson(bodyNode2.toString(), mapType_v2);
		Type listType2 = new TypeToken<ArrayList<TItov_city_manage>>(){}.getType();
		Gson gson_v12=new Gson();
		list3=gson_v12.fromJson(map2.get("result").toString(), listType2);
		model2.addAttribute("proList2", list3);	
		
		return "/management/shop4s/shop4sInfoAdd";
	}
	
	/**
	 * 添加4s信息页面
	 * @param vo
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/insertShop4s",method = RequestMethod.POST)
	public ModelAndView insertShop4s(HttpServletRequest request,TItov_Shop4s_manage shop4s) throws Exception {
		
		String shop4s_name = shop4s.getShop4s_name();
		String shop4s_address = shop4s.getShop4s_address();
		String shop4s_proId = shop4s.getShop4s_province_id();
		String shop4s_cId =shop4s.getShop4s_city_id();
		String shop4s_dId = shop4s.getShop4s_country_id();
		String shop4s_principal = shop4s.getShop4s_principal();
		String shop4s_tel = shop4s.getShop4s_tel();
		String shop4s_isuse="1";
		String shop4s_note = shop4s.getShop4s_note();

		Map<String,Object> paramMap=new HashMap<String,Object>();
		paramMap.put("shop4s_name", shop4s_name);
		paramMap.put("shop4s_address", shop4s_address);
		paramMap.put("shop4s_proId", shop4s_proId);
		paramMap.put("shop4s_cId", shop4s_cId);
		paramMap.put("shop4s_dId", shop4s_dId);
		paramMap.put("shop4s_principal", shop4s_principal);
		paramMap.put("shop4s_tel", shop4s_tel);
		paramMap.put("shop4s_isuse", shop4s_isuse);
		paramMap.put("shop4s_note", shop4s_note);

		/*if(null ==  request.getSession().getAttribute("filePath"))
		{
			return ajaxDoneError("没有上传照片");
		}*/		
		String result="";
		result=new ConnRest().getResult(paramMap, "shop4sInfomation.add");	
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
	
	
	@RequestMapping("/edit/{shop4sId}")
	public String edit(@PathVariable("shop4sId") int shop4sId, Model model) throws Exception {
		Map<String,Object> paramMap = new HashMap<String,Object>();
		List<TItov_Shop4s_manage> list = new ArrayList<TItov_Shop4s_manage>();
		paramMap.put("id", shop4sId);
		String result = "";
		result = new ConnRest().getResult(paramMap, "getshop4sinfoById.get");
		ObjectMapper mapper = new ObjectMapper();
		JsonNode jsonNode = mapper.readTree(result);
		JsonNode bodyNode = jsonNode.get("body");
		System.out.println("body:" + bodyNode);
		Map<String, Object> map = new HashMap<String, Object>();
		Type mapType_v = new TypeToken<HashMap<String, Object>>() {
		}.getType();
		Gson gson_v = new Gson();
		map = gson_v.fromJson(bodyNode.toString(), mapType_v);
		Type listType = new TypeToken<ArrayList<TItov_Shop4s_manage>>() {
		}.getType();
		Gson gson_v1 = new Gson();
		list = gson_v1.fromJson(map.get("shop4sList").toString(), listType);
		model.addAttribute("shop4sList", list);
		model.addAttribute("shop4s_id",map.get("shop4s_id").toString());
		
		//查询省份信息
		Map paramMap2=new HashMap();
		List<TItov_city_manage> list3=new ArrayList<TItov_city_manage>();
		String result2="";
		result2=new ConnRest().getResult(paramMap2, "personal.province.get");	
		ObjectMapper mapper2 = new ObjectMapper();
		JsonNode jsonNode2 = mapper2.readTree(result2);
		JsonNode bodyNode2 = jsonNode2.get("body");
		System.out.println("body:" + bodyNode2);
	    Map<String, Object> map2 = new HashMap<String, Object>();
		Type mapType_v2 = new TypeToken<HashMap<String, Object>>(){}.getType();
		Gson gson_v2=new Gson();
		map2=gson_v2.fromJson(bodyNode2.toString(), mapType_v2);
		Type listType2 = new TypeToken<ArrayList<TItov_city_manage>>(){}.getType();
		Gson gson_v12=new Gson();
		list3=gson_v12.fromJson(map2.get("result").toString(), listType2);
		model.addAttribute("proList2", list3);	
				
		return "/management/shop4s/shop4sInfoEdit";
	}
	
	/*4s修改保存*/
	@RequestMapping("/editShop4sInfo")
	public ModelAndView editShop4sInfo(HttpServletRequest request,Model model,TItov_Shop4s_manage tItov_Shop4s_manage) throws Exception {
		int id = tItov_Shop4s_manage.getShop4s_id();
		String name=tItov_Shop4s_manage.getShop4s_name();
		String address = tItov_Shop4s_manage.getShop4s_address();
		String principal=tItov_Shop4s_manage.getShop4s_principal();
		String tel = tItov_Shop4s_manage.getShop4s_tel();
		String note = tItov_Shop4s_manage.getShop4s_note();
		String pId = tItov_Shop4s_manage.getShop4s_province_id();
		String cId = tItov_Shop4s_manage.getShop4s_city_id();
		String dId = tItov_Shop4s_manage.getShop4s_country_id();
		
		Map<String,Object> paramMap=new HashMap<String,Object>();
		paramMap.put("shop4s_id", id);
		paramMap.put("shop4s_name", name);
		paramMap.put("shop4s_address", address);
		paramMap.put("shop4s_proId", pId);
		paramMap.put("shop4s_cId", cId);
		paramMap.put("shop4s_dId", dId);
		paramMap.put("shop4s_principal", principal);
		paramMap.put("shop4s_tel", tel);
		paramMap.put("shop4s_note", note);
		;
		String result = "";
		result = new ConnRest().getResult(paramMap, "updateShop4sinfo.upd");
		ObjectMapper mapper = new ObjectMapper();
		JsonNode jsonNode = mapper.readTree(result);
		JsonNode headNode = jsonNode.get("head");
		JsonNode bodyNode = jsonNode.get("body");
		
		if (null != bodyNode.get("result")&&("1").equals(bodyNode.get("result").toString())) {
			
			return ajaxDoneSuccess(getMessage("msg.operation.success"));
			
		} else {
			String error_msg = headNode.get("error_msg").toString();
			return ajaxDoneError(error_msg);
		}
	}
	
	
	/**
	 * 查看4s店用户列表
	 * @param vo
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/querylist/{id}")
	public String hostStaticLoglist(@PathVariable("id") String id,Shop4sUserVO vo, Model model) throws Exception {
		Map<String,Object> paramMap = new HashMap<String,Object>();
		//System.out.println("pageNum--->>"+vo.getPageNum()+"---pageSize---->>"+vo.getPageSize()+"----accountId--->>"+vo.getKeywords());
	
		paramMap.put("page_num", vo.getPageNum());
		paramMap.put("page_size", vo.getPageSize());
		paramMap.put("account_name", vo.getAccountName()==null? "%":vo.getAccountName());
		paramMap.put("company_id", id);

		List<TIto_shop4s_user> list = new ArrayList<TIto_shop4s_user>();
		String result = "";
		result = new ConnRest().getResult(paramMap, "shop4sUser.get");
		ObjectMapper mapper = new ObjectMapper();
		JsonNode jsonNode = mapper.readTree(result);
		JsonNode bodyNode = jsonNode.get("body");
		System.out.println("body:" + bodyNode);
		Map<String, Object> map = new HashMap<String, Object>();
		Type mapType_v = new TypeToken<HashMap<String, Object>>() {
		}.getType();
		Gson gson_v = new Gson();
		map = gson_v.fromJson(bodyNode.toString(), mapType_v);
		Type listType = new TypeToken<ArrayList<TIto_shop4s_user>>() {
		}.getType();
		Gson gson_v1 = new Gson();
		list = gson_v1.fromJson(map.get("result").toString(), listType);
		Integer totalCount = Integer.parseInt(map.get("totalCount").toString()
				.split("\\.")[0]);
		vo.setTotalCount(totalCount);
		model.addAttribute("companyId", id);
		model.addAttribute("shop4sUserList", list);
		model.addAttribute("vo", vo);
		
		return "/management/shop4s/queryUser";
	}
	
	
	/**
	 * 导入用户信息页面
	 * @param vo
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("adduser/{companyId}")
	public String adduser(@PathVariable("companyId") int companyId,Model model2) throws Exception {
		//model.addAttribute("genderList", Gender.values());
		
		//查询省份信息
		Map paramMap=new HashMap();

		Integer startLimit =-1;
		paramMap.put("account_type", 1);
		paramMap.put("account_name", "%");
		paramMap.put("pageSize", 10);
		paramMap.put("pageNum", 1);

		List<TItov_personal_manage> list3=new ArrayList<TItov_personal_manage>();
		String result2="";
		result2=new ConnRest().getResult(paramMap, "personal.manage1.get");	
		ObjectMapper mapper2 = new ObjectMapper();
		JsonNode jsonNode2 = mapper2.readTree(result2);
		JsonNode bodyNode2 = jsonNode2.get("body");
		System.out.println("body:" + bodyNode2);
	    Map<String, Object> map2 = new HashMap<String, Object>();
		Type mapType_v2 = new TypeToken<HashMap<String, Object>>(){}.getType();
		Gson gson_v2=new Gson();
		map2=gson_v2.fromJson(bodyNode2.toString(), mapType_v2);
		Type listType2 = new TypeToken<ArrayList<TItov_personal_manage>>(){}.getType();
		Gson gson_v12=new Gson();
		list3=gson_v12.fromJson(map2.get("result").toString(), listType2);
		model2.addAttribute("userList", list3);	
		model2.addAttribute("companyId",companyId);
		return "/management/shop4s/account";
	}
	
	/**
	 * 导入用户
	 * @param vo
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("adduserinfo/{accountId}/{companyId}")
	public ModelAndView adduserinfo(@PathVariable("accountId") int accountId,@PathVariable("companyId") int companyId,Model model2) throws Exception {
		//model.addAttribute("genderList", Gender.values());
		System.out.println("accountId-----$>"+accountId);
		System.out.println("companyId-----$>"+companyId);

		//查询省份信息
		Map paramMap=new HashMap();
		paramMap.put("accountId", accountId);
		paramMap.put("companyId", companyId);

		
		String result="";
		result=new ConnRest().getResult(paramMap, "shop4s.user.save");	
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
