package com.zking.service.xtgl;

import com.zking.pojo.xtgl.Company;

import java.util.List;

public interface ICompanyService {
    public List<Company> findAll(Company company);

    public int getMax(Company company);

    public Company findonly(Company company);

    public int add(Company company);

    public int edit(Company company);

    public int remove(Company company);

    public String getEnd(Company company);

    public List<Company> findByListId(Company company);

    // 请假分公司绑定方法
    public List<Company> findCompanyId();

    // 查询分公司所有销售商
    public List<Company> FindCompanyByAttribute();

    // 查询分公司所有工厂
    public List<Company> FindCompanyByAttribute2();
}
