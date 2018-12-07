package com.zking.controller.zlgl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zking.pojo.zlgl.x_customer;
import com.zking.service.zlgl.ICustomerService;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.text.SimpleDateFormat;
import java.util.Date;
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
        map.put("count", ics.FindCount(customer));
        map.put("data", listUsers);
        map.put("code", 0);
        return map;
    }

    @RequestMapping(value = "FindCustomerremove")
    public String Findremove(x_customer customer) {
        int index = ics.Findremove(customer);
        if (index > 0) {
            return "zlgl/CustomerIdex";
        }
        return "404";
    }


    @ResponseBody
    @RequestMapping(value = "Findx_customerAdd")
    public int Findx_customerAdd(x_customer customer) {
        int index = ics.Findx_customerAdd(customer);
        if (index > 0) {
            return 1;
        }
        return 0;
    }

    @RequestMapping(value = "FindcustomerDate")
    @ResponseBody
    public Map FindcustomerDate(x_customer customer) throws Exception {
        x_customer c = ics.FindcustomerDate(customer);
        Map map = new HashMap();
        map.put("c", c);
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "Findx_customerEdit")
    public int Findx_customerEdit(x_customer customer) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        customer.setEDI_DateTime(df.format(new Date()));
        int index = ics.Findx_customerEdit(customer);
        if (index > 0) {
            return index;
        }
        return 0;
    }

    @RequestMapping(value = "FindCustomerDate")
    @ResponseBody
    public Map FindCustomerDate() {
        List<x_customer> c = ics.FindCustomerDate();
        Map map = new HashMap();
        map.put("c", c);
        return map;
    }

    @RequestMapping(value = "FindCustomerDateAll")
    @ResponseBody
    public Map FindCustomerDateAll(x_customer customer) {
        x_customer c = ics.FindCustomerDateAll(customer);
        Map map = new HashMap();
        map.put("c", c);
        return map;
    }
}
