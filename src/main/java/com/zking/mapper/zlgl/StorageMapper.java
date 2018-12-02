package com.zking.mapper.zlgl;

import com.zking.pojo.zlgl.x_storage;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("IStorageMapper")
public interface StorageMapper {
    public List<x_storage> FindStorageAll(x_storage storage);

    public int FindStorageCount(x_storage storage);

    public int FindStorageRemove(x_storage storage);

    public x_storage FindStorageDate(x_storage storage);

    public int FindStorageEdit(x_storage storage);

    public int FindStorageAdd(x_storage storage);
}
