package com.zking.service.impl.xtgl;

import com.zking.mapper.xtgl.IAgreementMapper;
import com.zking.pojo.xtgl.AgreementShop;
import com.zking.service.xtgl.IAgreementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("AgreementServiceImpl")
public class AgreementServiceImpl implements IAgreementService {

    @Autowired
    private IAgreementMapper iam;

    @Override
    public List<AgreementShop> findAll(AgreementShop agreementShop) {
        return iam.findAll(agreementShop);
    }

    @Override
    public int getMax(AgreementShop agreementShop) {
        return iam.getMax(agreementShop);
    }

    @Override
    public AgreementShop findonly(AgreementShop agreementShop) {
        return iam.findonly(agreementShop);
    }

    @Override
    public int add(AgreementShop AgreementShop) {
        return iam.add(AgreementShop);
    }

    @Override
    public int edit(AgreementShop AgreementShop) {
        return iam.edit(AgreementShop);
    }

    @Override
    public int remove(AgreementShop AgreementShop) {
        return iam.remove(AgreementShop);
    }

    @Override
    public String getEnd(AgreementShop agreementShop) {
        return iam.getEnd(agreementShop);
    }

    @Override
    public List<AgreementShop> findByListId(AgreementShop agreementShop) {
        return iam.findByListId(agreementShop);
    }
}
