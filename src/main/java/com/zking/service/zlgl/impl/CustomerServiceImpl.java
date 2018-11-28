package com.zking.service.zlgl.impl;

import com.zking.service.zlgl.ICustomerService;
import com.zking.mapper.zlgl.customerMapper;
import com.zking.pojo.zlgl.x_customer;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("ICustomerServiceImpl")
public class CustomerServiceImpl implements ICustomerService {
    @Resource(name = "IcustomerMapper")
    private customerMapper cm;

    @Override
    public List<x_customer> FindAll(x_customer c) {
        return cm.FindAll(c);
    }

    @Override
    public int FindCount(x_customer c) {
        return cm.FindCount(c);
    }

    @Override
    public int Findx_customerAdd(x_customer c) {
        return cm.Findx_customerAdd(c);
    }

    @Override
    public int Findremove(x_customer c) {
        return cm.Findremove(c);
    }

    @Override
    public x_customer FindcustomerDate(x_customer c) {
        return cm.FindcustomerDate(c);
    }

    @Override
    public int Findx_customerEdit(x_customer c) {
        return cm.Findx_customerEdit(c);
    }
}
