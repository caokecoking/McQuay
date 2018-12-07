package com.zking.shiro;

import com.zking.service.xtgl.IPersonnelService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Set;

public class ShiroRealm extends AuthorizingRealm{

    @Autowired
    private IPersonnelService ips;
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String uname= (String) principalCollection.getPrimaryPrincipal();

        //连接数据库，获取当前用户的角色
        SimpleAuthorizationInfo SimpleAuthorizationInfo=new SimpleAuthorizationInfo();
        Set<String> roles=new HashSet<>();
        roles.add("admin");
        //连接数据库，获取当前角色的权限
        Set<String> permission=new HashSet<>();
        permission.add("add");
        permission.add("remove");
        permission.add("query");

        SimpleAuthorizationInfo.addRoles(roles);
        SimpleAuthorizationInfo.addStringPermissions(permission);
        return SimpleAuthorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken usernamePasswordToken= (UsernamePasswordToken) authenticationToken;
        String name=usernamePasswordToken.getUsername();
        String password=ips.FindPersonnelLoGin(name);
        SimpleAccount simpleAccount=new SimpleAccount(name,password,this.getName());
        return simpleAccount;
    }
}
