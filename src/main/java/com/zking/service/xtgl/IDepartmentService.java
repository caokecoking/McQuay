package com.zking.service.xtgl;

import com.zking.pojo.xtgl.Department;

import java.util.List;

public interface IDepartmentService {
    // 请假部门表邦定
    public List<Department> findLeaveDepartment();

    public List<Department> findAllByDepartment(Department department);

    public Department findOnlybyDepartment(Department department);

    public int getMax(Department department);

    public int addDepartment(Department Department);

    public int editDepartment(Department Department);

    public List<Department> findAllByCompid(String Compid);
}
