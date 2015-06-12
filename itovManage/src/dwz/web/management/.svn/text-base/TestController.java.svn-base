package dwz.web.management;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import dwz.business.info.InfoTestServiceMgr;
import dwz.business.info.Tests;
import dwz.persistence.TestBaseConditionVO;
import dwz.web.BaseController;
@Controller("management.testController")
@RequestMapping(value="/management/test")
public class TestController extends BaseController{
	@Autowired
	private InfoTestServiceMgr infoTestMgr;
	@RequestMapping("")
	public String list(TestBaseConditionVO vo, Model model) {
		List<Tests> newsList = infoTestMgr.findPageBreakByCondition(vo);
	   	int totalCount = infoTestMgr.countAll0(vo);
		vo.setTotalCount(totalCount);
		model.addAttribute("testList", newsList);
		model.addAttribute("vo", vo);
		return "/management/test/list";
	}
	@RequestMapping("/add")
	public String add(Model model) {
		//model.addAttribute("newsTypes", NewsType.values());
		return "/management/test/add";
	}
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public ModelAndView insert(Tests tests,MultipartFile  file ) {

		infoTestMgr.insert(tests);
		return ajaxDoneSuccess(getMessage("msg.operation.success"));
	}
	
	
	@RequestMapping("/edit/{testId}")
	public String edit(@PathVariable("testId") int testId, Model model) {
		Tests tests = infoTestMgr.getTests(testId);

		//model.addAttribute("newsTypes", NewsType.values());
		model.addAttribute("Tests", tests);

		return "/management/test/edit";
	}
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ModelAndView update(HttpServletRequest request,  
            HttpServletResponse response,Tests tests,MultipartFile  file ) {
		   System.out.println(file.getOriginalFilename());		
		   String realFileName = file.getOriginalFilename();  
	        // 获取路径  
	        String ctxPath = request.getSession().getServletContext().getRealPath(   "/")    + "\\" + "images\\";  
	        System.out.println(ctxPath);
	        if(true)
	        {
	        	return	ajaxDoneError(getMessage("msg.operation.file.ext"));
	         	
	        }
	        // 创建文件  
	        @SuppressWarnings("unused")
			File dirPath = new File(ctxPath);  
	        if (!dirPath.exists()) {  
	            dirPath.mkdir();  
	        }  
	        File uploadFile = new File(ctxPath + realFileName);  
	        try {
				FileCopyUtils.copy(file.getBytes(), uploadFile);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
		infoTestMgr.update(tests);
		return ajaxDoneSuccess(getMessage("msg.operation.success"));
	}
	
	
	
	@RequestMapping("/delete/{testId}")
	public ModelAndView delete(@PathVariable("testId") int testId) {
		infoTestMgr.delete(testId);
		return ajaxDoneSuccess(getMessage("msg.operation.success"));
	}
}
