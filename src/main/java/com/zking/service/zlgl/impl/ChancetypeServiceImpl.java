package com.zking.service.zlgl.impl;

import com.zking.mapper.zlgl.ChancetypeMapper;
import com.zking.pojo.zlgl.x_chancetype;
import com.zking.service.zlgl.IChancetypeService;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository("IChancetypeServiceImpl")
public class ChancetypeServiceImpl implements IChancetypeService {
    @Resource(name = "IChancetypeMapper")
    private ChancetypeMapper cm;


    @Override
    public List<x_chancetype> FindChancetypeAll(x_chancetype chancetype) {
        return cm.FindChancetypeAll(chancetype);
    }

    @Override
    public int FindChancetypeCount(x_chancetype chancetype) {
        return cm.FindChancetypeCount(chancetype);
    }

    @Override
    public int FindChancetypeAdd(x_chancetype chancetype) {
        return cm.FindChancetypeAdd(chancetype);
    }

    @Override
    public int FindChancetypeRemove(x_chancetype chancetype) {
        return cm.FindChancetypeRemove(chancetype);
    }

    @Override
    public x_chancetype FindChancetypeDateBind(x_chancetype chancetype) {
        return cm.FindChancetypeDateBind(chancetype);
    }

    @Override
    public int FindChancetypeEdit(x_chancetype chancetype) {
        return cm.FindChancetypeEdit(chancetype);
    }

    @Override
    public List<x_chancetype> FindChancetypeListDate() {
        return cm.FindChancetypeListDate();
    }
}
