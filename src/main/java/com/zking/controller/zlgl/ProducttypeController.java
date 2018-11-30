package com.zking.controller.zlgl;

import com.zking.pojo.zlgl.x_customermessage;
import com.zking.pojo.zlgl.x_producttype;
import com.zking.service.zlgl.IProducttypeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ProducttypeController {
    @Resource(name = "IProducttypeServiceImpl")
    private IProducttypeService Ips;

    @ResponseBody
    @RequestMapping(value = "FindProducttypeAll")
    private Map FindProducttypeAll(x_producttype producttype) {
        int i = producttype.getPage();
        if (i == 0) {
            i = 1;
        }
        int l = producttype.getLimit();
        if (l == 0) {
            l = 5;
        }
        producttype.setPage((i - 1) * l);
        producttype.setLimit(l);
        Map map = new HashMap();
        List<x_producttype> listUsers = Ips.FindProducttypeAll(producttype);
        map.put("count", Ips.FindProducttypeCount(producttype));
        map.put("data", listUsers);
        map.put("code", 0);
        return map;
    }

    @RequestMapping(value = "FindProducttypeRemove")
    public String FindProducttypeRemove(x_producttype producttype) {
        int index = Ips.FindProducttypeRemove(producttype);
        if (index > 0) {
            return "zlgl/ProducttypeList";
        }
        return "404";
    }

    @ResponseBody
    @RequestMapping(value = "FindProducttypeAdd")
    public int FindProducttypeAdd(x_producttype producttype) {
        int index = Ips.FindProducttypeAdd(producttype);
        if (index > 0) {
            return 1;
        }
        return 0;
    }

    @RequestMapping(value = "FindProducttypeDateBind")
    @ResponseBody
    public Map FindProducttypeDateBind(x_producttype producttype) {
        Map map = new HashMap();
        x_producttype p = Ips.FindDateBind(producttype);
        map.put("p", p);
        return map;
    }

    @RequestMapping(value = "FindProducttypeEdit")
    @ResponseBody
    public int FindProducttypeEdit(x_producttype producttype) {
        int index = Ips.FindProducttypeEdit(producttype);
        if (index > 0) {
            return 1;
        }
        return 0;
    }

    @ResponseBody
    @RequestMapping("FindProducttypeAlls")
    public Map FindAlls() {
        List<x_producttype> list = Ips.FindAlls();
        Map map = new HashMap();
        map.put("s", list);
        return map;
    }

}
