package com.zking.controller.xtgl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zking.mapper.PingYing;
import com.zking.pojo.xtgl.Company;
import com.zking.service.xtgl.ICompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("Company")
@Controller
public class CompanyControlller {

    @Autowired
    private ICompanyService ics;

    @ResponseBody
    @RequestMapping("findAll")
    public Map findAll(Company company){
        int page = company.getPage();
        if (page==0){
            page=1;
        }
        int limit = company.getLimit();
        if (limit==0){
            limit=10;

        }
        int i = (page - 1) * limit;
        company.setPage(i);
        company.setLimit(limit);

        List<Company> lb=ics.findAll(company);
        int total=ics.getMax(company);
        Map<String, Object> map = new HashMap<>();
        map.put("data", lb);
        map.put("code", 0);
        map.put("count",total);
        return map;
    }


    @ResponseBody
    @RequestMapping("addCompany")
    public Map<String,Object> addCompany(Company company){
        Map<String,Object> map=new HashMap<>();
        String max = String.valueOf(ics.getEnd(company));
        if (max == null || max.equals("null")) {
            max = "1";
        }
        System.out.println(company.getProv());
        String Coding = PingYing.getFirstLetter(company.getProv());
        if (max.length() == 1) {
            Coding += "000" + max;
        } else if (max.length() == 2) {
            Coding += "00" + max;
        } else if (max.length() == 3) {
            Coding += "0" + max;
        } else if (max.length() == 4) {
            Coding += max;
        }
        company.setCompCoding(Coding);
        int index=ics.add(company);
        map.put("msg",index);
        return map;
    }

    @ResponseBody
    @RequestMapping("editCompany")
    public Map<String,Object> editCompany(Company company){
        Map<String,Object> map=new HashMap<>();
        String max = String.valueOf(ics.getEnd(company));
        if (max == null || max.equals("null")) {
            max = "1";
        }
        String Coding = PingYing.getFirstLetter(company.getProv());
        if (max.length() == 1) {
            Coding += "000" + max;
        } else if (max.length() == 2) {
            Coding += "00" + max;
        } else if (max.length() == 3) {
            Coding += "0" + max;
        } else if (max.length() == 4) {
            Coding += max;
        }
        company.setCompCoding(Coding);
        int index=ics.edit(company);
        map.put("msg",index);
        return map;
    }

    @ResponseBody
    @RequestMapping("findOnlyCompany1")
    public Map findOnlyCompany1(Company company){
        Map<String,Object> map=new HashMap<>();
        Company company1=ics.findonly(company);
        map.put("company",company1);
        return map;
    }

    @ResponseBody
    @RequestMapping("findOnlyCompany2")
    public Map findOnlyCompany2(Company company){
        Map<String,Object> map=new HashMap<>();
        Company company1=ics.findonly(company);
        map.put("company",company1);
        return map;
    }

    @ResponseBody
    @RequestMapping("removeCompany")
    public int removeCompany(Company company){
        int index=ics.remove(company);
        return index;
    }
}
