package dwz.web.personalmanagement;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Type;
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
import dwz.manageRest.dto.Shop4sUserVO;
import dwz.manageRest.dto.TIto_shop4s_user;
import dwz.manageRest.dto.TItov_Shop4s_manage;
import dwz.manageRest.dto.TZdcHostUser;
import dwz.manageRest.dto.UsAccount;
import dwz.manageRest.dto.hostConditionVO;
import dwz.web.BaseController;

@Controller("personalmanagement.user4sController")
@RequestMapping(value = "/personalmanagement/user4s")
public class User4sController extends BaseController {
	

	/**
	 * 插入4s用户信息
	 * @param request
	 * @param zdcHost
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/insertUser4s", method = RequestMethod.POST)
	public ModelAndView insertHost(HttpServletRequest request,TIto_shop4s_user tIto_shop4s_user) throws Exception {
		
		String account_name = tIto_shop4s_user.getAccount_name();
		String account_password = tIto_shop4s_user.getAccount_password();
		String nickname = tIto_shop4s_user.getNickname();
		String real_name = tIto_shop4s_user.getReal_name();
		String person_sex = tIto_shop4s_user.getPerson_sex();
		String person_tel = tIto_shop4s_user.getPerson_tel();
		String person_email = tIto_shop4s_user.getPerson_email();
		Long company_id=tIto_shop4s_user.getCompany_id();
		String company_id2=company_id.toString();

		Map<String,Object> paramMap=new HashMap<String,Object>();
		paramMap.put("account_name", account_name);
		paramMap.put("account_password", account_password);
		paramMap.put("account_type", "7");
		paramMap.put("account_role_id", "2");
		paramMap.put("company_id", company_id2);
		
		paramMap.put("nickname", nickname);
		paramMap.put("real_name", real_name);
		paramMap.put("person_sex", person_sex);
		paramMap.put("person_tel", person_tel);
		paramMap.put("person_email", person_email);
		

		//paramMap.put("nickname", nickname);
		//paramMap.put("real_name", real_name);
		//paramMap.put("person_sex", person_sex);
		//paramMap.put("person_tel", person_tel);
		//paramMap.put("person_email", person_email);

		/*if(null ==  request.getSession().getAttribute("filePath"))
		{
			return ajaxDoneError("没有上传照片");
		}*/
		/*
		String  pic="";
		pic = (String) request.getSession().getAttribute("filePath");
		if(pic==null || "".equals(pic))
		{
			pic = "defaultpic.png";
		}
		
		paramMap.put("pic", pic);
		*/
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
	/**
	 * 单个文件上传
	 * @param request
	 * @param file
	 * @return
	 */
	@RequestMapping(value="/fileUpload", method = RequestMethod.POST)
	public ModelAndView fileUpload(HttpServletRequest request,MultipartFile  file)
	{
		String realFileName = file.getOriginalFilename();
		boolean bool= true;
		if(null==realFileName || "".equals(realFileName))
		{
			return ajaxDoneError("请上传图片");
		}
		Long l = System.currentTimeMillis(); 
		String timstamp = l.toString();
		Integer ext_index=file.getOriginalFilename().toString().lastIndexOf(".");
		 if(null!=file.getOriginalFilename() && !"".equals(file.getOriginalFilename()))
         {
        	 String ext=file.getOriginalFilename().toString().substring(ext_index);
             if(     
           		!ext.equalsIgnoreCase(".bmp")&&
             		!ext.equalsIgnoreCase(".png")&&
             		!ext.equalsIgnoreCase(".gif")&&
             		!ext.equalsIgnoreCase(".jpeg")&&
             		!ext.equalsIgnoreCase(".jpg"))
             {
             	  bool=false;
             	  return ajaxDoneError("图片格式不正确");
             }
         }
		if(bool)
		{
			// 获取路径  
	        String ctxPath = request.getSession().getServletContext().getRealPath("/styles/upload/host");  
	        File dirPath = new File(ctxPath);  
	        if (!dirPath.exists()) {  
	            dirPath.mkdir();  
	        }  
	        File uploadFile = new File(ctxPath + "/"+timstamp+realFileName);  
	        try {
				FileCopyUtils.copy(file.getBytes(), uploadFile);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
	        String error_msg ="上传成功";
	        request.getSession().setAttribute("filePath",timstamp+realFileName);
	        return ajaxDoneSuccess(error_msg);
		}
		
        
        return ajaxDoneError("图片上传失败");
		
	}
	/**
	 * 多文件上传
	 * @param request
	 * @param myfiles
	 * @return
	 */
	@RequestMapping(value="/multiFileUpload", method = RequestMethod.POST)
	public ModelAndView multiFileUpload(HttpServletRequest request,@RequestParam MultipartFile[]  myfiles)
	{
		String pic="";
		boolean bool = true;
		for(MultipartFile fileOne : myfiles)
		{
	         Integer ext_index=fileOne.getOriginalFilename().toString().lastIndexOf(".");
	         if(null!=fileOne.getOriginalFilename() && !"".equals(fileOne.getOriginalFilename()))
	         {
	        	 String ext=fileOne.getOriginalFilename().toString().substring(ext_index);
                 if(     
               		!ext.equalsIgnoreCase(".bmp")&&
                 		!ext.equalsIgnoreCase(".png")&&
                 		!ext.equalsIgnoreCase(".gif")&&
                 		!ext.equalsIgnoreCase(".jpeg")&&
                 		!ext.equalsIgnoreCase(".jpg"))
                 {
                 	  bool=false;
                 	  return ajaxDoneError("图片格式不正确");
                 }
	         }
     	     
                 
		}
		if(bool)
        {
			for(MultipartFile fileOne : myfiles)
			{
				 try {
					   String realFileName = fileOne.getOriginalFilename();
						// 获取路径  
				        String ctxPath = request.getSession().getServletContext().getRealPath("/styles/upload/host");  
				        //System.out.println("ctxPath---->"+ctxPath);
				        if(null==realFileName||"".equals(realFileName))
				        	continue;
				        pic = pic+realFileName+";";
				        File dirPath = new File(ctxPath);  
				        if (!dirPath.exists()) {  
				            dirPath.mkdir();  
				        }  
						FileUtils.copyInputStreamToFile(fileOne.getInputStream(), new File(ctxPath, realFileName));
		       	 } catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} 
			}
			request.getSession().setAttribute("filePath", pic);
			return ajaxDoneSuccess("上传成功");
       	
        }
		 return ajaxDoneError("图片上传失败");
	}

	/**
	 * 4s用户列表
	 * @param vo
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/user4slist")
	public String user4slist(Shop4sUserVO vo, Model model) throws Exception {
		Map<String,Object> paramMap = new HashMap<String,Object>();
		paramMap.put("accountName", vo.getAccountName()==null?"%":vo.getAccountName());
		paramMap.put("pageNum", Integer.valueOf(vo.getPageNum()));
		paramMap.put("pageSize", vo.getPageSize());
		List<TIto_shop4s_user> list = new ArrayList<TIto_shop4s_user>();
		String result = "";		
		result = new ConnRest().getResult(paramMap, "user4slist.get");
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
		model.addAttribute("user4slist", list);
		model.addAttribute("vo", vo);
		return "/management/personal/user4slist";
	}
	
	//查找带回
	@RequestMapping("/lookup")
	public String lookup(Shop4sUserVO vo,Model model) throws Exception {
		@SuppressWarnings("rawtypes")
		Map paramMap = new HashMap();
		paramMap.put("page_num", Integer.valueOf(vo.getPageNum()));
		paramMap.put("page_size", Integer.valueOf(vo.getPageSize()));
		paramMap.put("account_name",vo.getAccountName()==null ? "%":vo.getAccountName());
		List<TItov_Shop4s_manage> list = new ArrayList<TItov_Shop4s_manage>();
		String result="";
		result = new ConnRest().getResult(paramMap, "Getshop4sByUser.get");
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
		list = gson_v1.fromJson(map.get("result").toString(), listType);		
		model.addAttribute("shop4sList", list);
		return "/management/personal/searchUser2";
	}
	
	
	
	@RequestMapping("/addUser4s")
	public String addHost(Model model) throws Exception {
		return "/management/personal/user4sInfoAdd";
	}
	
	@RequestMapping("/editUser4s/{user4sId}")
	public String editHost(@PathVariable("user4sId") int user4sId, Model model) throws Exception {
		Map<String,Object> paramMap = new HashMap<String,Object>();
		List<TIto_shop4s_user> list = new ArrayList<TIto_shop4s_user>();
		paramMap.put("id", user4sId);
		String result = "";
		result = new ConnRest().getResult(paramMap, "getUser4sinfoById.get");
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
		list = gson_v1.fromJson(map.get("user4sList").toString(), listType);		
		model.addAttribute("user4sList", list);
		model.addAttribute("accountIdTemp",map.get("accountid").toString());
		
		return "/management/personal/user4sInfoEdit";
	}
	
	@RequestMapping("/editUser4sInfo")
	public ModelAndView editHostInfo(HttpServletRequest request,Model model,TIto_shop4s_user tIto_shop4s_user) throws Exception {
		long id = tIto_shop4s_user.getAccount_id();
		String account_name = tIto_shop4s_user.getAccount_name();
		String account_password = tIto_shop4s_user.getAccount_password();
		String nickname = tIto_shop4s_user.getNickname();
		String real_name = tIto_shop4s_user.getReal_name();
		String person_sex = tIto_shop4s_user.getPerson_sex();
		String person_tel = tIto_shop4s_user.getPerson_tel();
		String person_email = tIto_shop4s_user.getPerson_email();
		Long company_id=tIto_shop4s_user.getCompany_id();

		Map<String,Object> paramMap=new HashMap<String,Object>();
		paramMap.put("account_name", account_name);
		paramMap.put("account_password", account_password);
		paramMap.put("nickname", nickname);
		paramMap.put("real_name", real_name);
		paramMap.put("person_sex", person_sex);
		paramMap.put("person_tel", person_tel);
		paramMap.put("person_email", person_email);
		paramMap.put("company_id", company_id);
		paramMap.put("id", id);

		/**
		String pic = (String) request.getSession().getAttribute("filePath");
		paramMap.put("pic", pic);
		**/
		//paramMap.put("id", hostId);
		String result = "";
		result = new ConnRest().getResult(paramMap, "updateUser4sinfo.upd");
		ObjectMapper mapper = new ObjectMapper();
		JsonNode jsonNode = mapper.readTree(result);
		JsonNode headNode = jsonNode.get("head");
		JsonNode bodyNode = jsonNode.get("body");
		//System.out.println("body:" + bodyNode);
		
		if (null != bodyNode.get("result")&&("1").equals(bodyNode.get("result").toString())) {
			
			return ajaxDoneSuccess(getMessage("msg.operation.success"));
			
		} else {
			String error_msg = headNode.get("error_msg").toString();
			return ajaxDoneError(error_msg);
		}
	}

}
