package com.zking.controller.zlgl;

import com.zking.pojo.zlgl.x_chancetype;
import com.zking.service.zlgl.IChancetypeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ChancetypeController {
    @Resource(name = "IChancetypeServiceImpl")
    private IChancetypeService ics;

    @ResponseBody
    @RequestMapping(value = "FindChancetypeAll")
    private Map FindChancetypeAll(x_chancetype chancetype) {
        if (chancetype.getPtId() == "") {
            System.out.println(chancetype.getPtId());
            chancetype.setPtId(null);
        }
        if (chancetype.getCompid() == "") {
            System.out.println(chancetype.getCompid());
            chancetype.setCompid(null);
        }
        int i = chancetype.getPage();
        if (i == 0) {
            i = 1;
        }
        int l = chancetype.getLimit();
        if (l == 0) {
            l = 5;
        }
        chancetype.setPage((i - 1) * l);
        chancetype.setLimit(l);
        Map map = new HashMap();
        List<x_chancetype> listUsers = ics.FindChancetypeAll(chancetype);
        map.put("count", ics.FindChancetypeCount(chancetype));
        map.put("data", listUsers);
        map.put("code", 0);
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "FindChancetypeAdd")
    public int FindChancetypeAdd(x_chancetype chancetype) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        chancetype.setProductionDate(df.format(new Date()));
        int index = ics.FindChancetypeAdd(chancetype);
        if (index > 0) {
            return 1;
        }
        return 0;
    }

    @RequestMapping(value = "FindChancetypeRemove")
    public String FindChancetypeRemove(x_chancetype chancetype) {
        int index = ics.FindChancetypeRemove(chancetype);
        if (index > 0) {
            return "/zlgl/ChancetypeList";
        }
        return "404";
    }

    @ResponseBody
    @RequestMapping(value = "FindChancetypeEdit")
    public int FindChancetypeEdit(x_chancetype chancetype) {
        int index = ics.FindChancetypeEdit(chancetype);
        if (index > 0) {
            return 1;
        }
        return 0;
    }

    @ResponseBody
    @RequestMapping(value = "FindChancetypeDateBind")
    public Map FindChancetypeDateBind(x_chancetype chancetype) {
        x_chancetype c = ics.FindChancetypeDateBind(chancetype);
        Map map = new HashMap();
        map.put("c", c);
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "FindChancetypeListDate")
    public Map Find() {
        Map map = new HashMap();
        List<x_chancetype> lc = ics.FindChancetypeListDate();
        map.put("lc", lc);
        return map;
    }
}
