package dwz.web.personalmanagement;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import dwz.manageRest.dto.BaseConditionManageVO;
import dwz.manageRest.dto.TItovMenuRole;
import dwz.manageRest.dto.TItov_personal_manage;
import dwz.manageRest.services.PersonalService;
import dwz.manageRest.services.RoleService;
import dwz.web.BaseController;
@Controller("personalmanagement.ruleController")
@RequestMapping(value="/personalmanagement/rule")
public class RuleController extends BaseController{
	@RequestMapping("list")
	public String list(BaseConditionManageVO vo, Model model) throws Exception {
		List<TItovMenuRole> list=new ArrayList<TItovMenuRole>();
		list=RoleService.getRole();
		model.addAttribute("roleList", list);
		return "/management/rule/list";
	}
	
	
	@RequestMapping("/edit/{userId}")
	public String edit(@PathVariable("userId") int userId, Model model) throws Exception {
		TItov_personal_manage tItov_personal_manage  = PersonalService.getPersonalInfoByAccountID(userId);
		model.addAttribute("vo", tItov_personal_manage);
		return "/management/rule/edit";
	}
}
