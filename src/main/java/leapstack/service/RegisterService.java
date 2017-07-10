package leapstack.service;

import com.sun.org.apache.xpath.internal.operations.Bool;
import leapstack.domain.RegisterUser;
import leapstack.domain.SecurityCodeMsgResp;
import leapstack.entity.MobileSecurityCode;
import leapstack.entity.UserRoleEntity;
import leapstack.repository.MobileSecurityCodeRepository;
import leapstack.repository.UserRoleRepository;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by zhuochen on 2017/7/5.
 */
@Service
@Log4j
public class RegisterService {

    @Autowired
    private MobileSecurityCodeRepository mobileSecurityCodeRepository;

    @Autowired
    private UserRoleRepository userRoleRepository;

    @Autowired
    private SendCodeService sendCodeService;

    public int generateSecurityCode(Long mobile) {
        //check  mobile if exist in table
        MobileSecurityCode mobileSecurityCode = mobileSecurityCodeRepository.findByMobile(mobile);
        if(mobileSecurityCode == null){
            mobileSecurityCode = new MobileSecurityCode();
        }

        //send security code
        SecurityCodeMsgResp resp = new SecurityCodeMsgResp();
        try {
            resp = sendCodeService.sendCode(String.valueOf(mobile));
        } catch (Exception e) {
            log.info("sendCode error", e);
        }

        //security send success, insert/update mobile security_code info
//        if(resp.getCode() == 200){
            mobileSecurityCode.setMobile(mobile);
            mobileSecurityCode.setSecurityCode(1);
//            mobileSecurityCode.setSecurityCode(Integer.valueOf(resp.getObj()));
            mobileSecurityCodeRepository.save(mobileSecurityCode);
//        }

        return 200;//TODO hard code
    }

    public int registerUser(RegisterUser registerUser) {
        //check user exist
        UserRoleEntity userRoleEntity = userRoleRepository.findByMobile(registerUser.getMobile());
        if(userRoleEntity != null){
            return -1;
        }

        //check security code is ok
//        if(mobileSecurityCodeRepository.findByMobileAndSecurityCode(registerUser.getMobile(),
//                registerUser.getSecurityCode()) == null) {
//            return -2;
//        }

        //insert user
        userRoleEntity = new UserRoleEntity();
        userRoleEntity.setPassword(registerUser.getPassword());
        userRoleEntity.setMobile(registerUser.getMobile());
        userRoleRepository.save(userRoleEntity);
        return 200;
    }
}
