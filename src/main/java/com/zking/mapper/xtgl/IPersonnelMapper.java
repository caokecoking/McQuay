package com.zking.mapper.xtgl;

import com.zking.pojo.xtgl.Personnel;

import java.util.List;

public interface IPersonnelMapper {
    // 出差部门表邦定
    public List<Personnel> findPersonnel();

    public Personnel FindOnlyBy(Personnel Personnel);

    public List<Personnel> findPersonnelPost(Personnel Personnel);

    public int getPersonnelPostCount(Personnel Personnel);

    public int addPersonnel(Personnel Personnel);

    public int editPersonnel(Personnel Personnel);

    public int editPersonnelCompany(Personnel personnel);
    public int editPersonnelDepartment(Personnel personnel);
    public int editPersonnelJop(Personnel personnel);

    public int removePersonnel(Personnel Personnel);
    public int removepersonnelcompany(Personnel Personnel);
    public int removepersonneldepartment(Personnel Personnel);
    public int removepersonneljop(Personnel Personnel);

    // 登录
    public Personnel FindPersonnelLoGin(Personnel Personnel);

    public int addPersonnelCompany(Personnel personnel);

    public int addPersonneldepartment(Personnel personnel);

    public int addPersonnelJop(Personnel personnel);
}
