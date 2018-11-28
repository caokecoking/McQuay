package com.zking.controller.xtgl;

import com.zking.pojo.xtgl.AgreementShop;
import com.zking.pojo.xtgl.Company;
import com.zking.service.xtgl.IAgreementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("Agreement")
public class AgreementController {

    @Autowired
    private IAgreementService ias;

    @ResponseBody
    @RequestMapping("findAll")
    public Map findAll(AgreementShop agreementShop){
        int page = agreementShop.getPage();
        if (page==0){
            page=1;
        }
        int limit = agreementShop.getLimit();
        if (limit==0){
            limit=10;

        }
        int i = (page - 1) * limit;
        agreementShop.setPage(i);
        agreementShop.setLimit(limit);

        List<AgreementShop> lb=ias.findAll(agreementShop);
        int total=ias.getMax(agreementShop);
        Map<String, Object> map = new HashMap<>();
        map.put("data", lb);
        map.put("code", 0);
        map.put("count",total);
        return map;
    }
}
