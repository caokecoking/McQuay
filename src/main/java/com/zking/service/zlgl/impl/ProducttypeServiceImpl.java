package com.zking.service.zlgl.impl;

import com.zking.mapper.zlgl.ProducttypeMapper;
import com.zking.pojo.zlgl.x_producttype;
import com.zking.service.zlgl.IProducttypeService;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service("IProducttypeServiceImpl")
public class ProducttypeServiceImpl implements IProducttypeService {
    @Resource(name = "IProducttypeMapper")
    private ProducttypeMapper pm;

    @Override
    public List<x_producttype> FindProducttypeAll(x_producttype producttype) {
        return pm.FindProducttypeAll(producttype);
    }

    @Override
    public int FindProducttypeCount(x_producttype producttype) {
        return pm.FindProducttypeCount(producttype);
    }

    @Override
    public int FindProducttypeAdd(x_producttype producttype) {
        return pm.FindProducttypeAdd(producttype);
    }

    @Override
    public int FindProducttypeRemove(x_producttype producttype) {
        return pm.FindProducttypeRemove(producttype);
    }

    @Override
    public x_producttype FindDateBind(x_producttype producttype) {
        return pm.FindDateBind(producttype);
    }

    @Override
    public int FindProducttypeEdit(x_producttype producttype) {
        return pm.FindProducttypeEdit(producttype);
    }
}
