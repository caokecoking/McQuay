package com.zking.mapper.xtgl;

import com.zking.pojo.xtgl.AgreementShop;

import java.util.List;

public interface IAgreementMapper {

    public List<AgreementShop> findAll(AgreementShop agreementShop);

    public int getMax(AgreementShop agreementShop);

    public AgreementShop findonly(AgreementShop agreementShop);

    public int add(AgreementShop AgreementShop);

    public int edit(AgreementShop AgreementShop);

    public int remove(AgreementShop AgreementShop);

    public String getEnd(AgreementShop agreementShop);

    public List<AgreementShop> findByListId(AgreementShop agreementShop);
}
