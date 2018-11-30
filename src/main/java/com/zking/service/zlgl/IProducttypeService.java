package com.zking.service.zlgl;

import com.zking.pojo.zlgl.x_producttype;

import java.util.List;

public interface IProducttypeService {
    public List<x_producttype> FindProducttypeAll(x_producttype producttype);

    public int FindProducttypeCount(x_producttype producttype);

    public int FindProducttypeAdd(x_producttype producttype);

    public int FindProducttypeRemove(x_producttype producttype);

    public x_producttype FindDateBind(x_producttype producttype);

    public int FindProducttypeEdit(x_producttype producttype);

    public List<x_producttype> FindAlls();
}
