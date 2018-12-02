package com.zking.service.impl.xtgl;

import com.zking.mapper.xtgl.IPersonnelMapper;
import com.zking.pojo.xtgl.Personnel;
import com.zking.service.xtgl.IPersonnelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("PersonnelServiceImpl")
public class PersonnelServiceImpl implements IPersonnelService{

    @Autowired
    private IPersonnelMapper ips;

    @Override
    public List<Personnel> findPersonnel() {
        return ips.findPersonnel();
    }

    @Override
    public Personnel FindOnlyBy(Personnel Personnel) {
        return ips.FindOnlyBy(Personnel);
    }

    @Override
    public List<Personnel> findPersonnelPost(Personnel Personnel) {
        return ips.findPersonnelPost(Personnel);
    }

    @Override
    public int getPersonnelPostCount(Personnel Personnel) {
        return ips.getPersonnelPostCount(Personnel);
    }

    @Override
    public int addPersonnel(Personnel Personnel) {
        return ips.addPersonnel(Personnel);
    }

    @Override
    public int removePersonnel(Personnel Personnel) {
        return ips.removePersonnel(Personnel);
    }

    @Override
    public Personnel FindPersonnelLoGin(Personnel Personnel) {
        return ips.FindPersonnelLoGin(Personnel);
    }

    @Override
    public int addPersonnelCompany(Personnel personnel) {
        return ips.addPersonnelCompany(personnel);
    }

    @Override
    public int addPersonneldepartment(Personnel personnel) {
        return ips.addPersonneldepartment(personnel);
    }

    @Override
    public int addPersonnelJop(Personnel personnel) {
        return ips.addPersonnelJop(personnel);
    }

    @Override
    public int editPersonnel(Personnel Personnel) {
        return ips.editPersonnel(Personnel);
    }

    @Override
    public int editPersonnelCompany(Personnel personnel) {
        return ips.editPersonnelCompany(personnel);
    }

    @Override
    public int editPersonnelDepartment(Personnel personnel) {
        return ips.editPersonnelDepartment(personnel);
    }

    @Override
    public int editPersonnelJop(Personnel personnel) {
        return ips.editPersonnelJop(personnel);
    }

    @Override
    public int removepersonnelcompany(Personnel Personnel) {
        return ips.removepersonnelcompany(Personnel);
    }

    @Override
    public int removepersonneldepartment(Personnel Personnel) {
        return ips.removepersonneldepartment(Personnel);
    }

    @Override
    public int removepersonneljop(Personnel Personnel) {
        return ips.removepersonneljop(Personnel);
    }
}
