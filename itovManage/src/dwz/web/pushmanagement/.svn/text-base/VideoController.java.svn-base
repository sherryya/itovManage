package dwz.web.pushmanagement;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.aspectj.apache.bcel.classfile.Constant;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import rest.util.ConnRest;
import rest.util.PropertiesUtil;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import dwz.business.info.News;
import dwz.business.info.Tests;
import dwz.framework.enums.Gender;
import dwz.manageRest.dto.BaseConditionManageVO;
import dwz.manageRest.dto.TItovVideo;
import dwz.manageRest.dto.TItov_personal_manage;
import dwz.manageRest.dto.UsAccount;
import dwz.manageRest.services.PersonalService;
import dwz.web.BaseController;

@Controller("pushmanagement.VideoController")
@RequestMapping(value = "/pushmanagement/video")
public class VideoController extends BaseController {

    private final static List<String[]> list = new ArrayList<String[]>();

    static {
	list.add(0, new String[] { "篮球天地", "足球世界", "综合体育", "极限运动", "武术摔跤",
		"美女花边" });
	list.add(1, new String[] { "网络游戏", "电子竞技", "单机电玩", "游戏达人", "工会战队" });
	list.add(2, new String[] { "新车速递", "车型推荐", "改装酷玩", "汽车广告", "评测报告",
		"美女车模" });
	list.add(3, new String[] { "社会", "国内", "国际", "财富", "科技" });
	list.add(4, new String[] { "疯狂恶搞", "搞笑综艺", "原创搞笑", "爆笑宠物", "雷人囧事",
		"经典回顾" });
	list.add(5,
		new String[] { "原创影视", "音乐动画", "火星搞笑", "校园作品", "网络红人", "拍客" });
	list.add(6, new String[] { "明星八卦", "影视资讯" });
    }

    @SuppressWarnings("unchecked")
    @RequestMapping("list")
    public String list(BaseConditionManageVO vo, Model model) throws Exception {
	@SuppressWarnings("rawtypes")
	Map paramMap = new HashMap();
	paramMap.put("account_type", Integer.valueOf(vo.getAccount_type()));
	paramMap.put("agentstate", vo.getAgentstate());
	paramMap.put("account_name",
		vo.getKeywords() == null ? "%" : vo.getKeywords());
	paramMap.put("page", String.valueOf(vo.getPageNum()));
	paramMap.put("num", String.valueOf(vo.getPageSize()));
	//
	List<TItovVideo> list = new ArrayList<TItovVideo>();
	String result = new ConnRest().getResult(paramMap, "Video.get");
	//
	ObjectMapper mapper = new ObjectMapper();
	JsonNode jsonNode = mapper.readTree(result);
	JsonNode bodyNode = jsonNode.get("body");
	//
	Map<String, Object> map = new HashMap<String, Object>();
	Type mapType_v = new TypeToken<HashMap<String, Object>>() {
	}.getType();
	Gson gson_v = new Gson();
	map = gson_v.fromJson(bodyNode.toString(), mapType_v);
	//
	Type listType = new TypeToken<ArrayList<TItovVideo>>() {
	}.getType();
	Gson gson_v1 = new Gson();
	String listStr = map.get("list").toString();
	list = gson_v1.fromJson(listStr, listType);
	vo.setTotalCount(list.size());
	model.addAttribute("userList", list);
	model.addAttribute("vo", vo);
	return "/management/push/list_video";
    }

    @RequestMapping("add")
    public String add(Model model) {
	model.addAttribute("genderList", Gender.values());
	return "/management/push/add";
    }

    @RequestMapping("/edit/{selID}")
    public String edit(@PathVariable("selID") int selID, Model model)
	    throws Exception {
	System.out.println("===============" + selID + "===============");
	model.addAttribute("genderList", Gender.values());
	model.addAttribute("userId", selID);
	Map<String, Integer> paramMap = new HashMap<String, Integer>();
	paramMap.put("select", selID);
	String result = new ConnRest().getResult(paramMap, "Video.get");
	ObjectMapper mapper = new ObjectMapper();
	JsonNode jsonNode = mapper.readTree(result);
	JsonNode headNode = jsonNode.get("head");
	if (headNode.get("error_code").toString().equals("0")) {
	    JsonNode bodyNode = jsonNode.get("list");
	    Map<String, Object> map = new HashMap<String, Object>();
	    Type mapType_v = new TypeToken<HashMap<String, Object>>() {
	    }.getType();
	    Gson gson_v = new Gson();
	    map = gson_v.fromJson(bodyNode.toString(), mapType_v);
	    Type listType = new TypeToken<TItov_personal_manage>() {
	    }.getType();
	    Gson gson_v1 = new Gson();
	    model.addAttribute("vo",
		    gson_v1.fromJson(map.get("result").toString(), listType));
	} else {
	    String error_msg = headNode.get("error_msg").toString();
	}
	return "/management/push/edit";
    }

    @RequestMapping("/delete/{selID}")
    public String delete(@PathVariable("selID") int selID, Model model)
	    throws Exception {
	System.out.println("===============" + selID + "===============");
	model.addAttribute("genderList", Gender.values());
	// model.addAttribute("vo", tItov_personal_manage);
	model.addAttribute("userId", selID);
	return "/management/push/edit";
    }

    @RequestMapping(value = "insert", method = RequestMethod.POST)
    public ModelAndView insert(HttpServletRequest request,
	    HttpServletResponse response, BaseConditionManageVO vo)
	    throws Exception {
	Map paramMap = new HashMap();
	String fileName = request.getParameter("fileNames");
	String picNames = request.getParameter("picNames");
	paramMap.put("account_type", Integer.valueOf(vo.getAccount_type()));
	paramMap.put("agentstate", vo.getAgentstate());
	paramMap.put("account_name",
		vo.getKeywords() == null ? "%" : vo.getKeywords());
	//
	paramMap.put("leftType", request.getParameter("videoType") + "-"
		+ request.getParameter("videoChild"));
	paramMap.put("topType", request.getParameter("hotrecommand") + "-"
		+ request.getParameter("typerecommand"));
	paramMap.put("VideoTitle", request.getParameter("videoTitle"));
	paramMap.put("VideoSize", request.getParameter("videoSize"));
	paramMap.put("VideoPictureUr",
		"http://125.211.221.231:10081/itovManage/styles/upload/"
			+ picNames);
	paramMap.put("VideoUrl",
		"http://125.211.221.231:10081/itovManage/styles/upload/"
			+ fileName);
	//
	new ConnRest().getResult(paramMap, "Video.put");
	return ajaxDoneSuccess(getMessage("msg.operation.success"));
    }

    @RequestMapping(value = "/gainVideoType", method = RequestMethod.POST)
    public @ResponseBody
    String gainVideoType(HttpServletRequest req, HttpServletResponse resp,
	    HttpSession session) throws Exception {
	String code = req.getParameter("code");
	StringBuffer sf = new StringBuffer();
	int location = Integer.parseInt(code) - 1;
	String result = null;
	if (location != -1) {
	    String resultArray[] = list.get(location);
	    sf.append("[");
	    for (int index = 0; index < resultArray.length; index++) {
		sf.append("[" + "\"" + new Integer(index + 1) + "\"" + ","
			+ "\"" + resultArray[index] + "\"" + "],");
	    }
	    result = sf.substring(0, sf.length() - 1) + "]";
	} else {
	    result = "[" + "[" + "\"" + "0" + "\"" + "," + "\"" + "子类型" + "\""
		    + "]" + "]";
	}
	return result;
    }

    @RequestMapping(value = "insertFile", method = RequestMethod.POST)
    @ResponseBody
    public ModelAndView insertFile(MultipartHttpServletRequest request,
	    Model model) throws Exception {
	String serverPath = request.getSession().getServletContext()
		.getRealPath("/");
	List<MultipartFile> files = request.getFiles("uploadify");
	StringBuffer sf = new StringBuffer();
	for (MultipartFile file : files) {
	    if (file.isEmpty())
		continue;
	    String filePath = serverPath + "styles/upload/"
		    + file.getOriginalFilename();
	    FileOutputStream fileOS = new FileOutputStream(filePath);
	    fileOS.write(file.getBytes());
	    fileOS.close();
	    fileOS.flush();
	    sf.append(new File(filePath).getAbsolutePath().toString());
	}
	return ajaxDoneSuccess(getMessage("msg.operation.success"));
    }

    @RequestMapping(value = "insertFile_Pic", method = RequestMethod.POST)
    @ResponseBody
    public ModelAndView insertFile_Pic(MultipartHttpServletRequest request,
	    Model model) throws Exception {
	String serverPath = request.getSession().getServletContext()
		.getRealPath("/");
	List<MultipartFile> files = request.getFiles("uploadify_pic");
	StringBuffer sf = new StringBuffer();
	for (MultipartFile file : files) {
	    if (file.isEmpty())
		continue;
	    String filePath = serverPath + "styles/upload/"
		    + file.getOriginalFilename();
	    FileOutputStream fileOS = new FileOutputStream(filePath);
	    fileOS.write(file.getBytes());
	    fileOS.close();
	    fileOS.flush();
	    sf.append(new File(filePath).getAbsolutePath().toString());
	}
	return ajaxDoneSuccess(getMessage("msg.operation.success"));
    }
}
