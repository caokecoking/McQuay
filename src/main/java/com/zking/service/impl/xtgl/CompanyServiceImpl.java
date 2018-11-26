package com.zking.service.impl.xtgl;

import com.zking.mapper.xtgl.ICompanyMapper;
import com.zking.pojo.xtgl.Company;
import com.zking.service.xtgl.ICompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("CompanyServiceImpl")
public class CompanyServiceImpl implements ICompanyService{

    @Autowired
    private ICompanyMapper icm;

    @Override
    public List<Company> findAll(Company company) {
        return icm.findAll(company);
    }

    @Override
    public int getMax(Company company) {
        return icm.getMax(company);
    }

    @Override
    public Company findonly(Company company) {
        return icm.findonly(company);
    }

    @Override
    public int add(Company company) {
        return icm.add(company);
    }

    @Override
    public int edit(Company company) {
        return icm.edit(company);
    }

    @Override
    public int remove(Company company) {
        return icm.remove(company);
    }

    @Override
    public String getEnd(Company company) {
        return icm.getEnd(company);
    }

    @Override
    public List<Company> findByListId(Company company) {
        return icm.findByListId(company);
    }

    @Override
    public List<Company> findCompanyId() {
        return icm.findCompanyId();
    }

    @Override
    public List<Company> FindCompanyByAttribute() {
        return icm.FindCompanyByAttribute();
    }

    @Override
    public List<Company> FindCompanyByAttribute2() {
        return icm.FindCompanyByAttribute2();
    }
}
