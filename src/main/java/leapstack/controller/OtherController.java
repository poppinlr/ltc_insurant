package leapstack.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by zhuochen on 2017/7/6.
 */
@Controller
public class OtherController {

    @RequiresRoles(value = "admin")
    @RequestMapping(value = "/adminPage", method = RequestMethod.GET)
    public void login() {
    }

    @RequiresPermissions(value = "guest")
    @RequestMapping(value = "/guest", method = RequestMethod.GET)
    public void guest(){

    }
}
