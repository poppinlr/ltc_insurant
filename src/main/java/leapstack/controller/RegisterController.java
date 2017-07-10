package leapstack.controller;

import leapstack.domain.RegisterUser;
import leapstack.service.LoginService;
import leapstack.service.RegisterService;
import lombok.extern.log4j.Log4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@Log4j
@RequestMapping("/register")
public class RegisterController {

    @Autowired
    private RegisterService registerService;

    @RequestMapping(value = "/send", method = RequestMethod.GET)
    @ResponseBody
    public Integer sendCode(Long mobile){
        return registerService.generateSecurityCode(mobile);
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    public Integer register(@RequestBody RegisterUser registerUser) {
        return registerService.registerUser(registerUser);
    }
}
