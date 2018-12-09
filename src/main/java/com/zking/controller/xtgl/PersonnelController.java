package com.zking.controller.xtgl;

import com.zking.pojo.xtgl.Company;
import com.zking.pojo.xtgl.Department;
import com.zking.pojo.xtgl.Jop;
import com.zking.pojo.xtgl.Personnel;
import com.zking.service.xtgl.IPersonnelService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("Personnel")
public class PersonnelController {

    @Autowired
    private IPersonnelService ips;

    @ResponseBody
    @RequestMapping(value = "login")
    public int login(Personnel personnel){
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken usernamePasswordToken=new UsernamePasswordToken(personnel.getPersCoding(),personnel.getPersPassword());
        subject.login(usernamePasswordToken);
        return 1;
    }

    @ResponseBody
    @RequestMapping("findAll")
    public Map FindAll(Personnel j){
        int page = j.getPage();
        if (page == 0) {
            page = 1;
        }
        int limit = j.getLimit();
        if (limit == 0) {
            limit = 10;

        }
        int i = (page - 1) * limit;
        j.setPage(i);
        j.setLimit(limit);

        List<Personnel> lb = ips.findPersonnelPost(j);
        int total = ips.getPersonnelPostCount(j);
        Map<String, Object> map = new HashMap<>();
        map.put("data", lb);
        map.put("code", 0);
        map.put("count", total);
        return map;
    }

    @ResponseBody
    @RequestMapping("add")
    public int add(Personnel personnel){
        ips.addPersonnel(personnel);
        ips.addPersonnelCompany(personnel);
        ips.addPersonneldepartment(personnel);
        ips.addPersonnelJop(personnel);
        return 1;
    }
    @ResponseBody
    @RequestMapping("edit")
    public int edit(Personnel personnel){
        ips.editPersonnel(personnel);
        Personnel p1=ips.FindOnlyBy(personnel);
        for (Company company : p1.getSc()) {
            if(company.getCompid()!=personnel.getName()){
                ips.editPersonnelCompany(personnel);
            }
        }
        for (Department department : p1.getSd()) {
            if(department.getDeptid()!=personnel.getStartTime()){
                ips.editPersonnelDepartment(personnel);
            }
        }
        for (Jop jop : p1.getSj()) {
            if(jop.getJopId()!=personnel.getEndTime()){
                ips.editPersonnelJop(personnel);
            }
        }
        return 1;
    }
    @ResponseBody
    @RequestMapping("remove")
    public int remove(Personnel personnel){
        ips.removepersonnelcompany(personnel);
        ips.removepersonneldepartment(personnel);
        ips.removepersonneljop(personnel);
        return ips.removePersonnel(personnel);
    }

    @ResponseBody
    @RequestMapping("findOnly")
    public Personnel findOnly(Personnel personnel){
        return ips.FindOnlyBy(personnel);
    }

}
