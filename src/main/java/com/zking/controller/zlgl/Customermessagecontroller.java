package com.zking.controller.zlgl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zking.pojo.zlgl.x_customer;
import com.zking.pojo.zlgl.x_customermessage;
import com.zking.service.zlgl.ICustomermessageService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class Customermessagecontroller {

    @Resource(name = "ICustomermessageServiceImpl")
    private ICustomermessageService ics;

    @ResponseBody
    @RequestMapping(value = "FindCustomermessageMapperDateBind")
    public Map FindCustomermessageMapperDateBind() {
        List<x_customermessage> lcm = ics.FindDateBind();
        Map map = new HashMap();
        map.put("outstr", lcm);
        return map;
    }

    @RequestMapping(value = "FindCustomermessageAll")
    @ResponseBody
    public Map FindAll(x_customermessage customer) {
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
        List<x_customermessage> listUsers = ics.FindCustomermessageAll(customer);
        map.put("count", ics.FindCustomermessageCount(customer));
        map.put("data", listUsers);
        map.put("code", 0);
        return map;
    }

    @RequestMapping(value = "FindCustomermessagereomve")
    public String Findremove(x_customermessage customer) {
        int index = ics.FindCustomermessagereomve(customer);
        if (index > 0) {
            return "zlgl/CustomerIdex";
        }
        return "404";
    }

    @RequestMapping(value = "FindCustomermessageadd")
    @ResponseBody
    public int FindCustomermessageadd(x_customermessage customer) {
        int index = ics.FindCustomermessageadd(customer);
        if (index > 0) {
            return 1;
        }
        return 0;
    }

    @RequestMapping(value = "FindCustomermessageDateBind")
    @ResponseBody
    public Map FindCustomermessageDateBind(x_customermessage customermessage) {
        x_customermessage customermessags = ics.FindCustomermessageDateBind(customermessage);
        Map map = new HashMap();
        map.put("c", customermessags);
        return map;
    }

    @RequestMapping(value = "FindCustomermessageEdit")
    @ResponseBody
    public int FindCustomermessageEdit(x_customermessage customermessage) {
        int index = ics.FindCustomermessageEdit(customermessage);
        if (index > 0) {
            return 1;
        }
        return 0;
    }
}
