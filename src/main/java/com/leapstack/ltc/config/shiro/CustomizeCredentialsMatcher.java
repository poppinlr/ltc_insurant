package com.leapstack.ltc.config.shiro;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;
import org.springframework.stereotype.Component;

/**
 * Created by zhuochen on 2017/7/6.
 */
@Component
public class CustomizeCredentialsMatcher extends SimpleCredentialsMatcher {

    @Override
    public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
        UsernamePasswordToken utoken=(UsernamePasswordToken) token;

        String inPassword = new String(utoken.getPassword());

        String dbPassword=(String) info.getCredentials();

        return this.equals(inPassword, dbPassword);
    }
}
