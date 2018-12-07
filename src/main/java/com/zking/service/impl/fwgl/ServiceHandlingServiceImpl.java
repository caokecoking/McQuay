package com.zking.service.impl.fwgl;

import com.zking.mapper.fwgl.IServiceHandlingMapper;
import com.zking.pojo.fwgl.ServiceHandling;
import com.zking.pojo.fwgl.ServicePlan;
import com.zking.pojo.xtgl.Personnel;
import com.zking.service.fwgl.IServiceHandlingService;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository("IServiceHandlingServiceImpl")
public class ServiceHandlingServiceImpl implements IServiceHandlingService {
    @Resource(name = "IServiceHandlingMapper")
    private IServiceHandlingMapper ism;


    @Override
    public List<ServiceHandling> FindServiceHandlingAll(ServiceHandling handling) {
        return ism.FindServiceHandlingAll(handling);
    }

    @Override
    public int FindServiceHandlingCount(ServiceHandling handling) {
        return ism.FindServiceHandlingCount(handling);
    }

    @Override
    public int FindServiceHandlingAdd(ServiceHandling handling) {
        return ism.FindServiceHandlingAdd(handling);
    }

    @Override
    public int FindServiceHandlingRemove(ServiceHandling handling) {
        return ism.FindServiceHandlingRemove(handling);
    }

    @Override
    public ServiceHandling FindServiceHandlingDate(ServiceHandling handling) {
        return ism.FindServiceHandlingDate(handling);
    }

    @Override
    public int FindServiceHandlingEdit(ServiceHandling handling) {
        return ism.FindServiceHandlingEdit(handling);
    }

    @Override
    public List<Personnel> FindPersonnelDate() {
        return ism.FindPersonnelDate();
    }
}
