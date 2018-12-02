package com.zking.service.zlgl;

import com.zking.pojo.zlgl.x_storage;

import java.util.List;

public interface IStorageService {
    public List<x_storage> FindStorageAll(x_storage storage);

    public int FindStorageCount(x_storage storage);

    public int FindStorageRemove(x_storage storage);

    public x_storage FindStorageDate(x_storage storage);

    public int FindStorageEdit(x_storage storage);

    public int FindStorageAdd(x_storage storage);
}
