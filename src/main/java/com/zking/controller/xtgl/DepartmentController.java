package com.zking.controller.xtgl;

import com.zking.mapper.PingYing;
import com.zking.pojo.xtgl.Company;
import com.zking.pojo.xtgl.Department;
import com.zking.service.xtgl.IDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("department")
public class DepartmentController {

    @Autowired
    private IDepartmentService ids;

    @ResponseBody
    @RequestMapping("findAll")
    public Map findAll(Department department) {
        int page = department.getPage();
        if (page == 0) {
            page = 1;
        }
        int limit = department.getLimit();
        if (limit == 0) {
            limit = 10;

        }
        int i = (page - 1) * limit;
        department.setPage(i);
        department.setLimit(limit);

        List<Department> lb = ids.findAllByDepartment(department);
        int total = ids.getMax(department);
        Map<String, Object> map = new HashMap<>();
        map.put("data", lb);
        map.put("code", 0);
        map.put("count", total);
        return map;
    }

    @ResponseBody
    @RequestMapping("addDepartment")
    public int addDepartment(Department department) {
        String pingyin = PingYing.getFirstLetter(department.getDeptName());
        department.setDeptCoding(pingyin + "1");
        return ids.addDepartment(department);
    }

    @ResponseBody
    @RequestMapping("editDepartment")
    public int editDepartment(Department department) {
        return ids.editDepartment(department);
    }

    @ResponseBody
    @RequestMapping("findOnly")
    public Department findOnly(Department department) {
        Department department1 = ids.findOnlybyDepartment(department);
        return department1;
    }
}
