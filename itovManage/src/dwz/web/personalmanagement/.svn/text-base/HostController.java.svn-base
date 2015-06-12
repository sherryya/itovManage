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
import dwz.manageRest.dto.TZdcHostUser;
import dwz.manageRest.dto.UsAccount;
import dwz.manageRest.dto.hostConditionVO;
import dwz.web.BaseController;

@Controller("personalmanagement.hostController")
@RequestMapping(value = "/personalmanagement/host")
public class HostController extends BaseController {
	
	@RequestMapping("/addHost")
	public String addHost(Model model) {
		model.addAttribute("genderList", Gender.values());
		return "/host/hostInfoAdd";
	}
	@RequestMapping("/addHostAccount/{id}")
	public String addHostAccount(HttpServletRequest request,Model model,@PathVariable("id") int id) {
		request.getSession().setAttribute("id", id);
		model.addAttribute("genderList", Gender.values());
		return "/host/addHostAccount";
	}
	@RequestMapping("/picture")
	public String pic(Model model) {
		model.addAttribute("genderList", Gender.values());
		return "/host/picInfo";
	}
	/**
	 * 插入主播信息
	 * @param request
	 * @param zdcHost
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/insertHost", method = RequestMethod.POST)
	public ModelAndView insertHost(HttpServletRequest request,TZdcHostUser zdcHost) throws Exception {
		
		String address = zdcHost.getAddress();
		String birthday = zdcHost.getBirthday();
		String createdate = zdcHost.getCreatedate();
		String email = zdcHost.getEmail();
		String height = zdcHost.getHeight();
		String name = zdcHost.getName();
		String nation = zdcHost.getNation();
		String nativeplace = zdcHost.getNativePlace();
		String pic = zdcHost.getPic();
		String school = zdcHost.getSchool();
		String sex = zdcHost.getSex();
		String specdate = zdcHost.getSpecdate();
		String specialty = zdcHost.getSpecialty();
		String telphone = zdcHost.getTelphone();
		String weight = zdcHost.getWeight();
		String introduce = zdcHost.getIntroduce();
		String grade = zdcHost.getGrade();
		String prell = zdcHost.getPrell();
		String nickname = zdcHost.getNickname();
		Map<String,Object> paramMap=new HashMap<String,Object>();
		paramMap.put("address", address);
		paramMap.put("birthday", birthday);
		paramMap.put("createDate", createdate);
		paramMap.put("email", email);
		paramMap.put("height", height);
		paramMap.put("name", name);
		paramMap.put("nation", nation);
		paramMap.put("native_place", nativeplace);
		paramMap.put("nickname", nickname);
		paramMap.put("school", school);
		paramMap.put("sex", sex);
		paramMap.put("specDate", specdate);
		paramMap.put("specialty", specialty);
		paramMap.put("telphone", telphone);
		paramMap.put("weight", weight);
		paramMap.put("introduce", introduce);
		paramMap.put("grade", grade);
		paramMap.put("prell", prell);
		/*if(null ==  request.getSession().getAttribute("filePath"))
		{
			return ajaxDoneError("没有上传照片");
		}*/
		pic = (String) request.getSession().getAttribute("filePath");
		if(pic==null || "".equals(pic))
		{
			pic = "defaultpic.png";
		}
		
		paramMap.put("pic", pic);
		String result="";
		result=new ConnRest().getResult(paramMap, "hostInfomation.add");	
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
	 * 插入账户信息同时更新主播表的accountid
	 * @param request
	 * @param usAccount
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/insertAccount", method = RequestMethod.POST)
	public ModelAndView insertAccount(HttpServletRequest request,UsAccount usAccount) throws Exception {
		Map<String,Object> paramMap=new HashMap<String,Object>();
		//String Account_role_id="0";//usAccount.getAccount_role_id().toString();
		//String Account_type=usAccount.getAccount_type().toString();
		paramMap.put("account_type","6");
		paramMap.put("account_name",usAccount.getAccount_name());
		paramMap.put("account_password",usAccount.getAccount_password());
		paramMap.put("hostType",usAccount.getHostType());	
		//如果是主播则插入频道类型否则频道类型为null
		if("0".equals(usAccount.getHostType()))
		{
			paramMap.put("channelType",usAccount.getChannelType());	
		
		}else
		{
			paramMap.put("channelType",null);	
		}
		//paramMap.put("roomId",usAccount.getRoomId());	
		paramMap.put("company_id","0");	
		String result="";
		result=new ConnRest().getResult(paramMap, "user.add");	
		ObjectMapper mapper = new ObjectMapper();
		JsonNode jsonNode = mapper.readTree(result);
		JsonNode headNode = jsonNode.get("head");
		if (headNode.get("error_code").toString().equals("0")) {
			int id = (Integer) request.getSession().getAttribute("id");
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("id",id);
			map.put("account_name", usAccount.getAccount_name());
			result=new ConnRest().getResult(map, "updateHostAccountId");
			ObjectMapper mapper1 = new ObjectMapper();
			JsonNode jsonNode1 = mapper1.readTree(result);
			JsonNode headNode1 = jsonNode1.get("body");
			if(null !=headNode1 && null != headNode1.get("result"))
			{
				if(("1").equals(headNode1.get("result").toString()))
				{
					return ajaxDoneSuccess(getMessage("msg.operation.success"));
				}else
				{
					//String error_msg = headNode.get("error_msg").toString();
					return ajaxDoneError("用户账号已经存在");
				}
			}else
			{
				//String error_msg = headNode.get("error_msg").toString();
				//System.out.println("error_msg-----1111111111-->"+error_msg);
				return ajaxDoneError("用户账号已经存在");
			}
			
			
		} else {
			//String error_msg = headNode.get("error_msg").toString();
			//System.out.println("error_msg-----0000-->"+error_msg);
			return ajaxDoneError("用户账号已经存在");
		}
	}
	/**
	 * 主播列表
	 * @param vo
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/hostlist")
	public String Hostlist(hostConditionVO vo, Model model) throws Exception {
		Map<String,Object> paramMap = new HashMap<String,Object>();
		//System.out.println("pageNum--->>"+vo.getPageNum()+"---pageSize---->>"+vo.getPageSize()+"----accountId--->>"+vo.getKeywords());
		paramMap.put("pageNum", Integer.valueOf(vo.getPageNum()));
		paramMap.put("pageSize", vo.getPageSize());
		List<TZdcHostUser> list = new ArrayList<TZdcHostUser>();
		String result = "";
		if((null!= vo.getVoipStatus() && !"".equals(vo.getVoipStatus()))||(null != vo.getHostType() && !"".equals(vo.getHostType())))
		{
			paramMap.put("voip_status", vo.getVoipStatus());
			paramMap.put("hostType", vo.getHostType());
			result = new ConnRest().getResult(paramMap, "hostListByVoipStatus.get");
		}else
		{
			result = new ConnRest().getResult(paramMap, "hostList.get");
		}
		
		ObjectMapper mapper = new ObjectMapper();
		JsonNode jsonNode = mapper.readTree(result);
		JsonNode bodyNode = jsonNode.get("body");
		System.out.println("body:" + bodyNode);
		Map<String, Object> map = new HashMap<String, Object>();
		Type mapType_v = new TypeToken<HashMap<String, Object>>() {
		}.getType();
		Gson gson_v = new Gson();
		map = gson_v.fromJson(bodyNode.toString(), mapType_v);
		Type listType = new TypeToken<ArrayList<TZdcHostUser>>() {
		}.getType();
		Gson gson_v1 = new Gson();
		list = gson_v1.fromJson(map.get("hostList").toString(), listType);
		Integer totalCount = Integer.parseInt(map.get("totalCount").toString()
				.split("\\.")[0]);
		vo.setTotalCount(totalCount);
		model.addAttribute("hostList", list);
		model.addAttribute("vo", vo);
		
		return "/host/hostlist";
	}
	
	@RequestMapping("/editHost/{hostId}")
	public String editHost(@PathVariable("hostId") int hostId, Model model) throws Exception {
		Map<String,Object> paramMap = new HashMap<String,Object>();
		List<TZdcHostUser> list = new ArrayList<TZdcHostUser>();
		paramMap.put("id", hostId);
		String result = "";
		result = new ConnRest().getResult(paramMap, "gethostinfoById.get");
		ObjectMapper mapper = new ObjectMapper();
		JsonNode jsonNode = mapper.readTree(result);
		JsonNode bodyNode = jsonNode.get("body");
		System.out.println("body:" + bodyNode);
		Map<String, Object> map = new HashMap<String, Object>();
		Type mapType_v = new TypeToken<HashMap<String, Object>>() {
		}.getType();
		Gson gson_v = new Gson();
		map = gson_v.fromJson(bodyNode.toString(), mapType_v);
		Type listType = new TypeToken<ArrayList<TZdcHostUser>>() {
		}.getType();
		Gson gson_v1 = new Gson();
		list = gson_v1.fromJson(map.get("hostList").toString(), listType);
		model.addAttribute("hostList", list);
		model.addAttribute("accountIdTemp",map.get("accountid").toString());
		
		return "/host/editHost";
	}
	
	@RequestMapping("/editHostInfo")
	public ModelAndView editHostInfo(HttpServletRequest request,Model model,TZdcHostUser zdcHost) throws Exception {
		int id = zdcHost.getId();
		String address = zdcHost.getAddress();
		String birthday = zdcHost.getBirthday();
		String createdate = zdcHost.getCreatedate();
		String email = zdcHost.getEmail();
		String height = zdcHost.getHeight();
		String name = zdcHost.getName();
		String nation = zdcHost.getNation();
		String nativeplace = zdcHost.getNativePlace();
		String school = zdcHost.getSchool();
		String sex = zdcHost.getSex();
		String specdate = zdcHost.getSpecdate();
		String specialty = zdcHost.getSpecialty();
		String telphone = zdcHost.getTelphone();
		String weight = zdcHost.getWeight();
		String introduce = zdcHost.getIntroduce();
		String grade = zdcHost.getGrade();
		String prell = zdcHost.getPrell();
		String nickname = zdcHost.getNickname();
		Map<String,Object> paramMap=new HashMap<String,Object>();
		paramMap.put("id", id);
		paramMap.put("address", address);
		paramMap.put("birthday", birthday);
		paramMap.put("createDate", createdate);
		paramMap.put("email", email);
		paramMap.put("height", height);
		paramMap.put("name", name);
		paramMap.put("nation", nation);
		paramMap.put("native_place", nativeplace);
		paramMap.put("nickname", nickname);
		paramMap.put("school", school);
		paramMap.put("sex", sex);
		paramMap.put("specDate", specdate);
		paramMap.put("specialty", specialty);
		paramMap.put("telphone", telphone);
		paramMap.put("weight", weight);
		paramMap.put("introduce", introduce);
		paramMap.put("grade", grade);
		paramMap.put("prell", prell);
		String pic = (String) request.getSession().getAttribute("filePath");
		paramMap.put("pic", pic);
		List<TZdcHostUser> list = new ArrayList<TZdcHostUser>();
		//paramMap.put("id", hostId);
		String result = "";
		result = new ConnRest().getResult(paramMap, "updateHostinfo.upd");
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
