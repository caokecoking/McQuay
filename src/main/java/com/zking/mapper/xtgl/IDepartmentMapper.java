package com.zking.mapper.xtgl;

import com.zking.pojo.xtgl.Department;

import java.util.List;

public interface IDepartmentMapper {
    // 请假部门表邦定
    public List<Department> findLeaveDepartment();

    public List<Department> findAllByDepartment(Department department);

    public Department findOnlybyDepartment(Department department);

    public int getMax(Department department);

    public int addDepartment(Department Department);

    public int editDepartment(Department Department);

    public int removeDepartment(Department department);

}
