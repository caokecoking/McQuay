package com.zking.controller.zlgl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zking.pojo.zlgl.x_customer;
import com.zking.service.zlgl.ICustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class Customercontroller {

    @Resource(name = "ICustomerServiceImpl")
    private ICustomerService ics;

    @RequestMapping(value = "FindAll")
    @ResponseBody
    public Map FindAll(x_customer customer) throws Exception {
        int i = customer.getPage();
        if (i == 0) {
            i = 1;
        }
        int l = customer.getLimit();
        if (l == 0) {
            l = 5;
        }
        customer.setPage((i - 1) * l);
        customer.setLimit(l);
        Map map = new HashMap();
        List<x_customer> listUsers = ics.FindAll(customer);
//        ObjectMapper objectMapper = new ObjectMapper();
        map.put("count", ics.FindCount(customer));
        map.put("data", listUsers);
        map.put("code", 0);
//        String outstr = objectMapper.writeValueAsString(map);
//        System.out.println(outstr);
        return map;
    }

    @RequestMapping(value = "FindCustomerremove")
    @ResponseBody
    public String Findremove(x_customer customer) {
        int index = ics.Findremove(customer);
        if (index > 0) {
            return "zlgl/CustomerIdex";
        }
        return "404";
    }


    @RequestMapping(value = "Findx_customerAdd")
    @ResponseBody
    public int Findx_customerAdd(x_customer customer) {
        int index = ics.Findx_customerAdd(customer);
        if (index > 0) {
            return 1;
        }
        return 0;
    }

}
