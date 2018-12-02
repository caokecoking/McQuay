package com.zking.service.zlgl.impl;

import com.zking.mapper.zlgl.StorageMapper;
import com.zking.pojo.zlgl.x_storage;
import com.zking.service.zlgl.IStorageService;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository("IStorageServiceImpl")
public class StorageServiceImpl implements IStorageService {
    @Resource(name = "IStorageMapper")
    private StorageMapper sm;

    @Override
    public List<x_storage> FindStorageAll(x_storage storage) {
        return sm.FindStorageAll(storage);
    }

    @Override
    public int FindStorageCount(x_storage storage) {
        return sm.FindStorageCount(storage);
    }

    @Override
    public int FindStorageRemove(x_storage storage) {
        return sm.FindStorageRemove(storage);
    }

    @Override
    public x_storage FindStorageDate(x_storage storage) {
        return sm.FindStorageDate(storage);
    }

    @Override
    public int FindStorageEdit(x_storage storage) {
        return sm.FindStorageEdit(storage);
    }

    @Override
    public int FindStorageAdd(x_storage storage) {
        return sm.FindStorageAdd(storage);
    }
}
