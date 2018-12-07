package com.zking.service.xtgl;

import com.zking.pojo.xtgl.Personnel;

import java.util.List;

public interface IPersonnelService {
    // 出差部门表邦定
    public List<Personnel> findPersonnel();

    public Personnel FindOnlyBy(Personnel Personnel);

    public List<Personnel> findPersonnelPost(Personnel Personnel);

    public int getPersonnelPostCount(Personnel Personnel);

    public int addPersonnel(Personnel Personnel);

    public int removePersonnel(Personnel Personnel);

    // 登录
    public String FindPersonnelLoGin(String Personnel);

    public int addPersonnelCompany(Personnel personnel);

    public int addPersonneldepartment(Personnel personnel);

    public int addPersonnelJop(Personnel personnel);


    public int editPersonnel(Personnel Personnel);

    public int editPersonnelCompany(Personnel personnel);
    public int editPersonnelDepartment(Personnel personnel);
    public int editPersonnelJop(Personnel personnel);
    public int removepersonnelcompany(Personnel Personnel);
    public int removepersonneldepartment(Personnel Personnel);
    public int removepersonneljop(Personnel Personnel);
}
