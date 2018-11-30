package com.zking.mapper.zlgl;

import com.zking.pojo.zlgl.x_producttype;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository("IProducttypeMapper")
public interface ProducttypeMapper {
    public List<x_producttype> FindProducttypeAll(x_producttype producttype);

    public int FindProducttypeCount(x_producttype producttype);

    public int FindProducttypeAdd(x_producttype producttype);

    public int FindProducttypeRemove(x_producttype producttype);

    public x_producttype FindDateBind(x_producttype producttype);

    public int FindProducttypeEdit(x_producttype producttype);

    public List<x_producttype> FindAlls();

}
