package com.zking.controller.zlgl;

import com.zking.service.zlgl.IStorageService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Controller
public class StorageController {
    @Resource(name = "IStorageServiceImpl")
    private IStorageService iss;

    @RequestMapping(value = "FindStorageAll")
    public Map FindStorageAll() {
        Map map = new HashMap();

        return map;
    }
}
