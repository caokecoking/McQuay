package com.zking.service.fwgl;

import com.zking.pojo.fwgl.ServiceHandling;
import com.zking.pojo.fwgl.ServicePlan;
import com.zking.pojo.xtgl.Personnel;

import java.util.List;

public interface IServiceHandlingService {
    public List<ServiceHandling> FindServiceHandlingAll(ServiceHandling handling);

    public int FindServiceHandlingCount(ServiceHandling handling);

    public int FindServiceHandlingAdd(ServiceHandling handling);

    public int FindServiceHandlingRemove(ServiceHandling handling);

    public ServiceHandling FindServiceHandlingDate(ServiceHandling handling);

    public int FindServiceHandlingEdit(ServiceHandling handling);

    public List<Personnel> FindPersonnelDate();
}
