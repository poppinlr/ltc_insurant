package com.leapstack.ltc.config.shiro;

import com.leapstack.ltc.entity.UserRoleEntity;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by zhuochen on 2017/7/6.
 */
public class CustomizeRealm extends AuthorizingRealm {

//    @Autowired
//    private UserRoleRepository userRoleRepository;
//
//    @Autowired
//    private RoleEntityRepository roleEntityRepository;

    public CustomizeRealm() {
        setName("CustomizeRealm");
        setCredentialsMatcher(new CustomizeCredentialsMatcher());
    }

    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException {
//        UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
//
//        UserRoleEntity user = userRoleRepository.findByMobile(token.getUsername());
//        if (user != null) {
//            return new SimpleAuthenticationInfo(user.getMobile(), user.getPassword(), getName());
//        } else {
//            return null;
//        }
        return null;
    }


    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        String mobile = (String) principals.getPrimaryPrincipal();
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();

//        UserRoleEntity userRoleEntity = userRoleRepository.findByMobile(mobile);

        Set<String> roleSet = new HashSet<>();
        roleSet.add("admin");
        authorizationInfo.setRoles(roleSet);

        Set<String> permissionSet = new HashSet<>();
        permissionSet.add("guest");
        authorizationInfo.setStringPermissions(permissionSet);

        return authorizationInfo;
    }
}
