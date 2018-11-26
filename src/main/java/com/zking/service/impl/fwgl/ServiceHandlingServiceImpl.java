package com.zking.service.impl.fwgl;

import com.zking.mapper.fwgl.IServiceHandlingMapper;
import com.zking.pojo.fwgl.ServiceHandling;
import com.zking.service.fwgl.IServiceHandlingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("ServiceHandlingServiceImpl")
public class ServiceHandlingServiceImpl implements IServiceHandlingService{

    @Autowired
    private IServiceHandlingMapper ism;

    @Override
    public List<ServiceHandling> findAll(ServiceHandling serviceHandling) {
        return ism.findAll(serviceHandling);
    }

    @Override
    public int getMax(ServiceHandling serviceHandling) {
        return ism.getMax(serviceHandling);
    }

    @Override
    public ServiceHandling findonly(String ShId) {
        return ism.findonly(ShId);
    }

    @Override
    public int add(ServiceHandling ServiceHandling) {
        return ism.add(ServiceHandling);
    }

    @Override
    public int edit(ServiceHandling ServiceHandling) {
        return ism.edit(ServiceHandling);
    }

    @Override
    public int remove(ServiceHandling ServiceHandling) {
        return ism.remove(ServiceHandling);
    }

    @Override
    public String getEnd() {
        return ism.getEnd();
    }

    @Override
    public List<ServiceHandling> findByListId(String ListId) {
        return ism.findByListId(ListId);
    }
}
