package com.zking.controller.xtgl;

import com.zking.mapper.PingYing;
import com.zking.pojo.xtgl.Department;
import com.zking.pojo.xtgl.Jop;
import com.zking.service.xtgl.IJopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("Jop")
public class JopController {

    @Autowired
    private IJopService ijs;

    @ResponseBody
    @RequestMapping("findAll")
    public Map findAll(Jop j){
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

        List<Jop> lb = ijs.findAllByJop(j);
        int total = ijs.getMax(j);
        Map<String, Object> map = new HashMap<>();
        map.put("data", lb);
        map.put("code", 0);
        map.put("count", total);
        return map;
    }

    @ResponseBody
    @RequestMapping("add")
    public int add(Jop j) {
        return ijs.addJop(j);
}

    @ResponseBody
    @RequestMapping("edit")
    public int edit(Jop j) {
        return ijs.editJop(j);
    }

    @ResponseBody
    @RequestMapping("removeJop")
    public int remove(Jop j) {
        return ijs.removeJop(j);
    }
    @ResponseBody
    @RequestMapping("findOnly")
    public Jop findOnly(Jop j) {
        return ijs.findOnlybyJop(j);
    }

    @ResponseBody
    @RequestMapping("findAllByDeptid")
    public List<Jop> findAllByDeptid(Jop j){
        return ijs.findAllByDeptid(j);
    }
}
