package com.zking.shiro;

import com.zking.mapper.xtgl.IButtons;
import com.zking.pojo.xtgl.Buttons;
import com.zking.service.xtgl.IButtonsService;
import com.zking.service.xtgl.IPersonnelService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ShiroRealm extends AuthorizingRealm{

    @Autowired
    private IPersonnelService ips;
    @Autowired
    private IButtonsService ibs;
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String uname= (String) principalCollection.getPrimaryPrincipal();
        //连接数据库，获取当前用户的角色
        SimpleAuthorizationInfo SimpleAuthorizationInfo=new SimpleAuthorizationInfo();
        Set<String> roles=new HashSet<>();
        roles.add("admin");
        //连接数据库，获取当前角色的权限
        List<Buttons> lb=ibs.findButtonsByPersCoding(uname);
        Set<String> permission=new HashSet<>();
        for (Buttons buttons : lb) {
            permission.add(buttons.getPremission());
        }
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
