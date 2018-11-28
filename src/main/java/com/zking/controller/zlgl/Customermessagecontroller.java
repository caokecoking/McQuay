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
import java.util.List;

@Controller
public class Customermessagecontroller {

    @Resource(name = "ICustomermessageServiceImpl")
    private ICustomermessageService ics;


    @ResponseBody
    @RequestMapping(value = "FindCustomermessageMapperDateBind", method = RequestMethod.POST)
    public String FindCustomermessageMapperDateBind() throws JsonProcessingException {
        List<x_customermessage> lcm = ics.FindDateBind();
        ObjectMapper objectMapper = new ObjectMapper();
        String outstr = objectMapper.writeValueAsString(lcm);
        return outstr;
    }
}
