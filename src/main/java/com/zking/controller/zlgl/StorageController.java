package com.zking.controller.zlgl;

import com.zking.pojo.zlgl.x_storage;
import com.zking.service.zlgl.IStorageService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class StorageController {
    @Resource(name = "IStorageServiceImpl")
    private IStorageService iss;

    @RequestMapping(value = "FindStorageAll")
    @ResponseBody
    public Map FindStorageAll(x_storage storage) {
        Map map = new HashMap();
        int i = storage.getPage();
        if (i == 0) {
            i = 1;
        }
        int l = storage.getLimit();
        if (l == 0) {
            l = 5;
        }
        storage.setPage((i - 1) * l);
        storage.setLimit(l);
        List<x_storage> listUsers = iss.FindStorageAll(storage);
        map.put("count", iss.FindStorageCount(storage));
        map.put("data", listUsers);
        map.put("code", 0);
        return map;
    }

    @RequestMapping(value = "FindStorageAdd")
    @ResponseBody
    public int FindStorageAdd(x_storage storage) {
        int index = iss.FindStorageAdd(storage);
        if (index > 0) {
            return 1;
        }
        return 0;
    }

    @RequestMapping(value = "FindStorageRemove")
    public String FindStorageRemove(x_storage storage) {
        int index = iss.FindStorageRemove(storage);
        if (index > 0) {
            return "/zlgl/StorageList";
        }
        return "404";
    }

    @RequestMapping(value = "FindStorageEdit")
    @ResponseBody
    public int FindStorageEdit(x_storage storage) {
        int index = iss.FindStorageEdit(storage);
        if (index > 0) {
            return 1;
        }
        return 0;
    }

    @RequestMapping(value = "FindStorageDate")
    @ResponseBody
    public Map FindStorageDate(x_storage storage) {
        x_storage s = iss.FindStorageDate(storage);
        Map map = new HashMap();
        map.put("s", s);
        return map;
    }

}