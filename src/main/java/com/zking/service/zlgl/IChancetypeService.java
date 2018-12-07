package com.zking.service.zlgl;

import com.zking.pojo.zlgl.x_chancetype;

import java.util.List;

public interface IChancetypeService {
    public List<x_chancetype> FindChancetypeAll(x_chancetype chancetype);

    public int FindChancetypeCount(x_chancetype chancetype);

    public int FindChancetypeAdd(x_chancetype chancetype);

    public int FindChancetypeRemove(x_chancetype chancetype);

    public x_chancetype FindChancetypeDateBind(x_chancetype chancetype);

    public int FindChancetypeEdit(x_chancetype chancetype);

    public List<x_chancetype> FindChancetypeListDate();
}
