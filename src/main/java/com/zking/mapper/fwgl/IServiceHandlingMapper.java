package com.zking.mapper.fwgl;

import com.zking.pojo.fwgl.ServiceHandling;

import java.util.List;

public interface IServiceHandlingMapper {
    public List<ServiceHandling> findAll(ServiceHandling serviceHandling);

    public int getMax(ServiceHandling serviceHandling);

    public ServiceHandling findonly(String ShId);

    public int add(ServiceHandling ServiceHandling);

    public int edit(ServiceHandling ServiceHandling);

    public int remove(ServiceHandling ServiceHandling);

    public String getEnd();

    public List<ServiceHandling> findByListId(String ListId);
}
