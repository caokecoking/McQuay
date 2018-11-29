package com.zking.controller.xtgl;

import com.zking.mapper.PingYing;
import com.zking.pojo.xtgl.AgreementShop;
import com.zking.pojo.xtgl.Company;
import com.zking.service.xtgl.IAgreementService;
import com.zking.service.xtgl.ICompanyService;
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

    @Autowired
    private ICompanyService ics;

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

    @ResponseBody
    @RequestMapping("addAgreement")
    public int addAgreement(AgreementShop agreementShop) {
        int index=0;
        Company c1 = new Company();
        c1.setCompid(agreementShop.getName());
        Company c = ics.findonly(c1);
        AgreementShop a1=new AgreementShop();
        a1.setPage(0);
        a1.setLimit(1000);
        List<AgreementShop> lu = ias.findAll(a1);
        if (!c.getProv().equals(agreementShop.getProv())) {
            index= 3;
        }
        for (AgreementShop agreementShop1 : lu) {
            if (agreementShop1.getCoun().equals(agreementShop.getCoun())) {
                index= 2;
                break;
            } else {
                String max = String.valueOf(ias.getEnd(agreementShop));
                if (max == null) {
                    max = "1";
                }
                String Coding = c.getCompCoding();
                if (max.length() == 1) {
                    Coding += "000" + max;
                } else if (max.length() == 2) {
                    Coding += "00" + max;
                } else if (max.length() == 3) {
                    Coding += "0" + max;
                } else if (max.length() == 4) {
                    Coding += max;
                }
                agreementShop.setAgreCoding(Coding);
                int index1=ias.add(agreementShop);
                if (index1 > 0) {
                    index= 1;
                }
                break;
            }
        }
        return index;
    }

    @ResponseBody
    @RequestMapping("removeAgreement")
    public void removeAgreement(AgreementShop agreementShop){
        ias.remove(agreementShop);
    }

    @ResponseBody
    @RequestMapping("findOnly1")
    public Map findOnly1(AgreementShop agreementShop){
        Map<String,Object> map=new HashMap<>();
        map.put("agreement",ias.findonly(agreementShop));
        return map;
    }

    @ResponseBody
    @RequestMapping("editAgreement")
    public int editAgreement(AgreementShop agreementShop){
        return ias.edit(agreementShop);
    }
}
