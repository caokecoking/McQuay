package com.zking.controller.fwgl;

import com.zking.pojo.fwgl.ServiceHandling;
import com.zking.service.fwgl.IServiceHandlingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("service")
public class ServiceController {

    @Autowired
    private IServiceHandlingService iss;

    @ResponseBody
    @RequestMapping("findAllByServiceHandling")
    public Map findAllByServiceHandling(ServiceHandling serviceHandling, String CustAddress){
        serviceHandling.setOther(CustAddress);
        List<ServiceHandling> ls= iss.findAll(serviceHandling);
        int total =iss.getMax(serviceHandling);
        Map<String,Object> map=new HashMap<>();
        map.put("data",ls);
        map.put("code", 0);
        map.put("count",total);
        return map;
    }
    @ResponseBody
    @RequestMapping("addByServiceHandling")
    public String addByServiceHandling(ServiceHandling serviceHandling){
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
        serviceHandling.setAcceptDate(sdf1.format(new Date()));
        serviceHandling.setDispatch("已接单");
        return "1";
    }
}
