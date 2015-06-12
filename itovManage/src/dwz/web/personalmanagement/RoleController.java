package dwz.web.personalmanagement;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import dwz.framework.enums.Gender;
import dwz.framework.sys.exception.ServiceException;
import dwz.framework.user.User;
import dwz.manageRest.dto.BaseConditionManageVO;
import dwz.manageRest.dto.TItovMenuRole;
import dwz.manageRest.services.RoleService;
import dwz.web.BaseController;
@Controller("personalmanagement.roleController")
@RequestMapping(value="/personalmanagement/role")
public class RoleController extends BaseController{
	@RequestMapping("list")
	public String list(BaseConditionManageVO vo, Model model) throws Exception {
		List<TItovMenuRole> list=new ArrayList<TItovMenuRole>();
		list=RoleService.getRole();
		model.addAttribute("roleList", list);
		return "/management/role/list";
	}
	@RequestMapping("/add")
	public String add(Model model) {
		return "/management/role/add";
	}
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public ModelAndView insert(TItovMenuRole tItovMenuRole) throws Exception {
		try {
			String ret=RoleService.addRole(tItovMenuRole);
			if(ret.equalsIgnoreCase("0"))
			{
				return ajaxDoneSuccess(getMessage("msg.operation.success"));
			}
			else
			{
				return ajaxDoneError(ret);
			}
		} catch (ServiceException e) {
			return ajaxDoneError(e.getMessage());
		}
	}
}
