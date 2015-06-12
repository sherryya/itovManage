package dwz.web.zdjsmanagement;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import dwz.framework.config.Constants;
import dwz.framework.user.User;
import dwz.manageRest.dto.BaseConditionManageVO;
import dwz.manageRest.dto.MessageDriverKilometer;
import dwz.manageRest.dto.TItovViewspot;
import dwz.manageRest.dto.TItovViewspotPicture;
import dwz.manageRest.services.ZdjsService;
import dwz.web.BaseController;
@Controller("zdjsmanagement.zdjsController")
@RequestMapping(value="/zdjsmanagement/zdjs")
public class ZdjsController extends BaseController{
	/**
	 * 得到用户的所有里程
	 * @param vo
	 * @param model
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("list")
	public String list(BaseConditionManageVO vo, Model model,HttpServletRequest request) throws Exception {
		List<MessageDriverKilometer> list=new ArrayList<MessageDriverKilometer>();
		User user= new User();
		user=(User)request.getSession().getAttribute(Constants.AUTHENTICATION_KEY);
		list=ZdjsService.getMileageList(user.getDeviceuid(), vo.getDate());
		model.addAttribute("date", vo.getDate());
		model.addAttribute("deviceuid", user.getDeviceuid());//283FF47D-43EF-62BC-4339-51684F1A0302
		model.addAttribute("List", list);
		return "/management/zdjs/list";
	}
	/**
	 * 打开地图
	 * @param objId
	 * @param model
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/add/{objId}")
	public String add(@PathVariable("objId") String objId, Model model,HttpServletRequest request) throws Exception {
		String[] obj=objId.split(",");
		String date=(obj[0].split(" ")[0]).toString();
		String dt1=(obj[0].split(" ")[1]).toString();
		String dt2=(obj[1].split(" ")[1]).toString();
		User user= new User();
		user=(User)request.getSession().getAttribute(Constants.AUTHENTICATION_KEY);
		model.addAttribute("deviceuid",user.getDeviceuid());
		model.addAttribute("starttime", dt1);
		model.addAttribute("endtime", dt2);
		model.addAttribute("date", date);
		return "/management/zdjs/add";
	}
	@RequestMapping("/displayallviewspot")
	public String displayallviewspot(Model model,HttpServletRequest request) throws Exception {
		User user= new User();
		user=(User)request.getSession().getAttribute(Constants.AUTHENTICATION_KEY);
		model.addAttribute("deviceuid",user.getDeviceuid());
		return "/management/zdjs/displayallviewspot";
	}
	/**
	 * 得到轨迹坐标信息
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	//接收前台传过来的字符串格式的json对象，在后台进行解析  2014-08-19
    @RequestMapping("/resolveJsonObject")  
    public void resolveJsonObject(HttpServletRequest request,HttpServletResponse response) throws Exception {  
        //解码  
        String str = URLDecoder.decode(request.getParameter("orderJson"),"UTF-8");  
        ObjectMapper mapper = new ObjectMapper();
		JsonNode jsonNode = mapper.readTree(str);
        String deviceuid=jsonNode.get("deviceuid").toString().replace("\"", "");
        String date=jsonNode.get("date").toString().replace("\"", "");
        String starttime=jsonNode.get("starttime").toString().replace("\"", "");
        String endtime=jsonNode.get("endtime").toString().replace("\"", "");
        String ret=ZdjsService.getGpsInfo(deviceuid, date, starttime, endtime);
        response.getWriter().print(ret) ;
    }
    /**
     * 打开景点上传的窗体
     * @param objId
     * @param objId1
     * @param model
     * @return
     * @throws Exception
     */
    //此处如果不加{objId1}  取值不完整 ，还啥 不知道
	@RequestMapping("/infoedit/{objId}/{objId1}")
	public String infoedit(@PathVariable("objId") String objId,@PathVariable("objId1") String objId1, Model model) throws Exception {

		String lonlat = objId.replace("'", "\"");
		ObjectMapper mapper = new ObjectMapper();
		JsonNode jsonNode = mapper.readTree(lonlat);
		String lon = jsonNode.get("lon").toString();
		String lat = jsonNode.get("lat").toString();
		TItovViewspot tItovViewspot=new TItovViewspot();
		tItovViewspot=ZdjsService.getViewSpotByLonlat(lon+"_"+lat);
		model.addAttribute("lonlatId", lon+"_"+lat);
		model.addAttribute("lonlat", lon+","+lat);
		model.addAttribute("vo", tItovViewspot);
		return "/management/zdjs/infoedit";
	}
    /**
     * 景点信息上传 以及修改
     * @param tItovViewspot
     * @param myfiles
     * @param request
     * @param response
     * @throws IOException
     */
	@RequestMapping(value="/save", method=RequestMethod.POST)  
    public void save(TItovViewspot tItovViewspot, @RequestParam MultipartFile[] myfiles,	HttpServletRequest request,HttpServletResponse response) throws IOException{  
        //如果只是上传一个文件，则只需要MultipartFile类型接收文件即可，而且无需显式指定@RequestParam注解  
        //如果想上传多个文件，那么这里就要用MultipartFile[]类型来接收文件，并且还要指定@RequestParam注解  
        //并且上传多个文件时，前台表单中的所有<input type="file"/>的name都应该是myfiles，否则参数里的myfiles无法获取到所有上传的文件  
		response.setContentType("text/html"); 
	    response.setCharacterEncoding("utf-8"); 
	    PrintWriter out = response.getWriter(); 
	    out.write("<script>parent.show(1);</script>");
	    Boolean b=false;
	    //1. 添加景点主表信息
	    User user= new User();
		user=(User)request.getSession().getAttribute(Constants.AUTHENTICATION_KEY);
	    tItovViewspot.setDeviceuid(user.getDeviceuid());
	    try {
			ZdjsService.addViewSpot(tItovViewspot);
			b=true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    //2 删除原来的图片
/*	    try {
			ZdjsService.deleteViewSpotPicture(tItovViewspot.getLonlatId());
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}*/
	    //3. 添加图片
	    Boolean bool=true;
	    String fname="";
	    for(MultipartFile myfile : myfiles){  
            if(myfile.isEmpty()){  
                System.out.println("文件未上传");  
            }else{  
            	  Integer ext_index=myfile.getOriginalFilename().toString().lastIndexOf(".");
      	          String ext=myfile.getOriginalFilename().toString().substring(ext_index);
                  if(     
                		!ext.equalsIgnoreCase(".bmp")&&
                  		!ext.equalsIgnoreCase(".png")&&
                  		!ext.equalsIgnoreCase(".gif")&&
                  		!ext.equalsIgnoreCase(".jpeg")&&
                  		!ext.equalsIgnoreCase(".jpg"))
                  {
                  	  bool=false;
                      fname=myfile.getOriginalFilename();
                  	  break;
                  }
            }
	    }
	    if(bool==false)
	    {
	    	 out.write("<script>parent.show(0);</script>");
	    	 out.write("<script>parent.callback('false','图片格式不正确["+fname+"]')</script>");
	    }
	    else
	    {
	        for(MultipartFile myfile : myfiles){  
	            if(myfile.isEmpty()){  
	                System.out.println("文件未上传");  
	            }else{  
	                System.out.println("文件长度: " + myfile.getSize());  
	                System.out.println("文件类型: " + myfile.getContentType());  
	                System.out.println("文件名称: " + myfile.getName());  
	                System.out.println("文件原名: " + myfile.getOriginalFilename()); 
	                Integer ext_index=myfile.getOriginalFilename().toString().lastIndexOf(".");
	    	        String ext=myfile.getOriginalFilename().toString().substring(ext_index);
	                String filename=System.currentTimeMillis()+"";
	                TItovViewspotPicture tItovViewspotPicture=new TItovViewspotPicture();
	                tItovViewspotPicture.setLonlatId(tItovViewspot.getLonlatId());
	                tItovViewspotPicture.setPicId(filename);
	                tItovViewspotPicture.setPicIntroduction("");
	                tItovViewspotPicture.setPicPathName(filename+ext);
	                try {
						ZdjsService.addViewSpotPicture(tItovViewspotPicture);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	                String realPath = request.getSession().getServletContext().getRealPath("/styles/upload");  
	                //这里不必处理IO流关闭的问题，因为FileUtils.copyInputStreamToFile()方法内部会自动把用到的IO流关掉
	                FileUtils.copyInputStreamToFile(myfile.getInputStream(), new File(realPath, filename+ext)); 
	                b=true;
	            }  
	        }   
	    }
        if(b==true)
        {
           out.write("<script>parent.show(0);</script>");	
           out.write("<script>parent.getViewSpotAllPoi(\""+user.getDeviceuid()+"\");parent.callback('true','您的数据提交成功')</script>"); 
        }
    }
	
	/**
	 * 得到用户所有的景点坐标点 用于 地图的显示
	 * @param request
	 * @param response
	 * @throws Exception
	 */
    @RequestMapping("/resolveJsonObjectForMap")  
    public void resolveJsonObjectForMap(HttpServletRequest request,HttpServletResponse response) throws Exception {  
        //解码  
        String str = URLDecoder.decode(request.getParameter("Json"),"UTF-8");  
        ObjectMapper mapper = new ObjectMapper();
		JsonNode jsonNode = mapper.readTree(str);
        String deviceuid=jsonNode.get("deviceuid").toString().replace("\"", "");
        
        String ret=ZdjsService.getViewSpotList(deviceuid);
        response.getWriter().print(ret) ;
    }
    /**
     * 删除景点信息
     * @param request
     * @param response
     * @throws Exception
     */
    @RequestMapping("/resolveJsonObjectForDelViewSpot")  
    public void resolveJsonObjectForDelViewSpot(HttpServletRequest request,HttpServletResponse response) throws Exception {  
        //解码  
        String str = URLDecoder.decode(request.getParameter("Json"),"UTF-8");  
        ObjectMapper mapper = new ObjectMapper();
		JsonNode jsonNode = mapper.readTree(str);
        String lonlat=jsonNode.get("lonlat").toString().replace("\"", "");
        String ret=ZdjsService.deleteViewSpot(lonlat);
        response.getWriter().print(ret) ;
    }
    
    /**
     * 打开景点图所有图片信息
     * @param objId
     * @param objId1
     * @param model
     * @param request
     * @return
     * @throws Exception
     */
	@RequestMapping("/displaypicture/{objId}/{objId1}")
	public String displaypicture(@PathVariable("objId") String objId, @PathVariable("objId1") String objId1,  Model model,HttpServletRequest request) throws Exception {

		 ObjectMapper mapper = new ObjectMapper();
		 JsonNode jsonNode = mapper.readTree(objId);
		 String lon=jsonNode.get("lon").toString();
		 String lat=jsonNode.get("lat").toString();
		 model.addAttribute("lonlatID", lon+"_"+lat);
		 return "/management/zdjs/displaypicture";
	}
	/**
	 * 显示所有景点照片
	 * @param request
	 * @param response
	 * @throws Exception
	 */
    @RequestMapping("/viewSpotPicture1")  
    public void viewSpotPicture1(HttpServletRequest request,HttpServletResponse response) throws Exception {  
        //解码  
		String str = URLDecoder.decode(request.getParameter("Json"), "UTF-8");
		ObjectMapper mapper = new ObjectMapper();
		JsonNode jsonNode = mapper.readTree(str);
		String lon = jsonNode.get("lon").toString().replace("\"", "");
		String lat = jsonNode.get("lat").toString().replace("\"", "");
		 List<TItovViewspotPicture> list=new ArrayList<TItovViewspotPicture>();
		 list=ZdjsService.getViewSpotPictureList(lon+"_"+lat);
		 StringBuffer sb=null;
		 StringBuffer sb1=new StringBuffer();
		 for(TItovViewspotPicture tItovViewspotPicture:list)
		 {
			 sb=new StringBuffer();
			 sb.append("<dl class='nowrap' style='vertical-align: middle;text-align: center;'>");
			 sb.append("<dd style='width:80%'>");
			 sb.append("<img alt='' src='/itovManage/styles/upload/"+tItovViewspotPicture.getPicPathName()+"'>");
			 sb.append("</dd>");
			 sb.append("<dd style='width:20%; height:200px;  vertical-align:middle; text-align: left;display: table-cell;line-height: 200px;'>");
			 sb.append("<a class='button' onclick=delPicture(\""+tItovViewspotPicture.getPicId()+"\",\""+tItovViewspotPicture.getPicPathName()+"\");><span>删除</span></a>");
			 sb.append("</dd>");
			 sb.append("</dl>");
			 sb1.append(sb.toString());
		 }
		response.getWriter().print(sb1.toString());
    }	
    /**
     * delete 
     * @param request
     * @param response
     * @throws Exception
     */
    @RequestMapping("/viewSpotPictureDel")  
    public void viewSpotPictureDel(HttpServletRequest request,HttpServletResponse response) throws Exception {  
        
		String str = URLDecoder.decode(request.getParameter("Json"), "UTF-8");
		ObjectMapper mapper = new ObjectMapper();
		JsonNode jsonNode = mapper.readTree(str);
		String name = jsonNode.get("name").toString().replace("\"", "");
		String path_name=jsonNode.get("path_name").toString().replace("\"", "");
		String ret = ZdjsService.deleteViewSpotPictureByID(name);
		if(ret.equals("0"))
		{
		    String realPath = request.getSession().getServletContext().getRealPath("/styles/upload");
		    File file=new File(realPath+"\\"+path_name);
		    if(file.exists())
		    {
		    	file.delete();
		    }
		}
		response.getWriter().print(ret);
    }
}
