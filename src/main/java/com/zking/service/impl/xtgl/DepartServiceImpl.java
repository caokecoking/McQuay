package com.zking.service.impl.xtgl;

import com.zking.mapper.xtgl.IDepartmentMapper;
import com.zking.pojo.xtgl.Department;
import com.zking.service.xtgl.IDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("DepartServiceImpl")
public class DepartServiceImpl implements IDepartmentService {

    @Autowired
    private IDepartmentMapper idm;
    @Override
    public List<Department> findLeaveDepartment() {
        return idm.findLeaveDepartment();
    }

    @Override
    public List<Department> findAllByDepartment(Department department) {
        return idm.findAllByDepartment(department);
    }

    @Override
    public Department findOnlybyDepartment(Department department) {
        return idm.findOnlybyDepartment(department);
    }

    @Override
    public int getMax(Department department) {
        return idm.getMax(department);
    }

    @Override
    public int addDepartment(Department Department) {
        return idm.addDepartment(Department);
    }

    @Override
    public int editDepartment(Department Department) {
        return idm.editDepartment(Department);
    }

    @Override
    public List<Department> findAllByCompid(String Compid) {
        return idm.findAllByCompid(Compid);
    }

}
