package com.zking.controller.xtgl;

import com.zking.pojo.xtgl.Company;
import com.zking.service.xtgl.ICompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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

}
