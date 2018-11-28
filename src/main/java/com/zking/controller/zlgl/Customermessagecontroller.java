package com.zking.controller.zlgl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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
    public Map FindCustomermessageMapperDateBind() throws JsonProcessingException {
        List<x_customermessage> lcm = ics.FindDateBind();
        /*ObjectMapper objectMapper = new ObjectMapper();
        String outstr = objectMapper.writeValueAsString(lcm);
        System.out.println(outstr);*/
        Map map = new HashMap();
        map.put("outstr", lcm);
        return map;
    }
}
