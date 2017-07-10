package leapstack.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by zhuochen on 2017/7/6.
 */
@Controller
public class LoginController {

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(String mobile, String password, HttpServletRequest request) {
        System.out.println(request.getRequestURI());
        System.out.println(request.getRequestURL());
        UsernamePasswordToken usernamePasswordToken=new UsernamePasswordToken(mobile,password);
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(usernamePasswordToken);
            return "redirect:/authPage";
        } catch(Exception e) {
            return "redirect:/loginPage";
        }
    }

    @RequestMapping(value="/logout",method=RequestMethod.GET)
    public String logout(){
        SecurityUtils.getSubject().logout();
        return "redirect:/loginPage";
    }
}
