package com.zking.mapper.fwgl;

import com.zking.pojo.fwgl.ServiceHandling;
import com.zking.pojo.fwgl.ServicePlan;
import com.zking.pojo.xtgl.Personnel;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("IServiceHandlingMapper")
public interface IServiceHandlingMapper {
    public List<ServiceHandling> FindServiceHandlingAll(ServiceHandling handling);

    public int FindServiceHandlingCount(ServiceHandling handling);

    public int FindServiceHandlingAdd(ServiceHandling handling);

    public int FindServiceHandlingRemove(ServiceHandling handling);

    public ServiceHandling FindServiceHandlingDate(ServiceHandling handling);

    public int FindServiceHandlingEdit(ServiceHandling handling);

    public List<Personnel> FindPersonnelDate();
}
