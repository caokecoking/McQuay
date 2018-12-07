package com.zking.service.zlgl;

import com.zking.pojo.zlgl.x_customer;

import java.util.List;

public interface ICustomerService {
    public List<x_customer> FindAll(x_customer c);

    public int FindCount(x_customer c);

    public int Findx_customerAdd(x_customer c);

    public int Findremove(x_customer c);

    public x_customer FindcustomerDate(x_customer c);

    public int Findx_customerEdit(x_customer c);

    public List<x_customer> FindCustomerDate();

    public x_customer FindCustomerDateAll(x_customer customer);
}
