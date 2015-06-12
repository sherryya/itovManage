package dwz.web;

import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import dwz.framework.config.Constants;
import dwz.framework.sys.exception.ServiceException;
import dwz.framework.user.User;
import dwz.framework.user.UserServiceMgr;
import dwz.manageRest.services.LoginService;
import dwz.manageRest.services.MenuClassService;

@Controller
@RequestMapping(value = "/passport")
public class PassportController extends BaseController {

	@Autowired
	private UserServiceMgr userMgr;

	@RequestMapping("/register")
	public ModelAndView register(User user) {
		try {
			userMgr.register(user);
		} catch (ServiceException e) {
			return ajaxDoneError(e.getMessage());
		}

		return ajaxDoneSuccess(getMessage("msg.operation.success"));
	}

	
	
	
	@RequestMapping("/verify/{verifyCode}")
	public String verify(@PathVariable("verifyCode") String verifyCode,
			Model model) {
		try {
			userMgr.verify(verifyCode);
		} catch (ServiceException e) {
			model.addAttribute("statusCode", 300);
			model.addAttribute("message", e.getMessage());
		}
		return "/alert";
	}

	@RequestMapping("/sendVerifyEmail/{username}")
	public ModelAndView sendVerifyEmail(
			@PathVariable("username") String username, Model model) {
		try {
			User user = userMgr.getUserByUsername(username);
			userMgr.sendVerifyEmail(user);
		} catch (ServiceException e) {
			ajaxDoneError(e.getMessage());
		}
		return ajaxDoneSuccess(getMessage("msg.operation.success"));
	}

	@RequestMapping("/login")
	public ModelAndView login(HttpServletRequest request) throws Exception {

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		User user=new User();
		//User user = userMgr.getUserByUsername(username);

		// try {
		// if (isSkipVC() || this.verifyValidationCode(getValidationCode())) {
		// loginOk = userMgr.hasMatchUser(username, password);
		// } else {
		// setStatusCode(300);
		// setMessage(this.getText("msg.validation.code.match"));
		// }
		//
		// } catch (AuthenticationException e) {
		// setStatusCode(300);
	//	 setMessage(e.getLocalizedMessage());

		if (password != null && username != null) {
			String ret = LoginService.login(username, password, "6");
			String [] arr=ret.split(",");
			if (arr[0].equals("0")) {
				user.setUsername(username);
				user.setPassword(password);
				
				user.setDeviceuid(arr[3]);
				String menu=MenuClassService.getMenuClass(Integer.valueOf(arr[1]));
				user.setMenu(menu);
				request.getSession().setAttribute(Constants.AUTHENTICATION_KEY,	user);
				String backToUrl = request.getParameter("backToUrl");
				if (backToUrl == null || backToUrl.trim().length() == 0) {
					backToUrl = "admin".equalsIgnoreCase(user.getUsername()) ? "/management": "/management";
				} else {
					try {
						backToUrl = java.net.URLDecoder.decode(backToUrl,	"UTF-8");
					} catch (UnsupportedEncodingException e) {
						e.printStackTrace();
					}
				}
				return new ModelAndView("redirect:" + backToUrl);
			}
			else if (arr[0].equals("1"))
			{
				return new ModelAndView("login", "error", "没有绑定OBD");
			}
			else {
				return new ModelAndView("login", "error", "系统错误");
			}
		}
		return new ModelAndView("login", "error", "用户名或密码错误。");
	}
	@RequestMapping("/logout")
	public ModelAndView logout(HttpServletRequest request) {

		request.getSession().removeAttribute(Constants.AUTHENTICATION_KEY);

		return new ModelAndView("login");
	}
}
