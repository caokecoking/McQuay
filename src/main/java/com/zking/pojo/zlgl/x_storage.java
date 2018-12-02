package com.zking.pojo.zlgl;

import com.zking.pojo.BasePojo;

public class x_storage extends BasePojo {
    private String StorId;
    private String StorName;
    private String CompId;
    private String CompName;

    public String getStorId() {
        return StorId;
    }

    public String getStorName() {
        return StorName;
    }

    public String getCompId() {
        return CompId;
    }

    public String getCompName() {
        return CompName;
    }

    public void setStorId(String storId) {
        StorId = storId;
    }

    public void setStorName(String storName) {
        StorName = storName;
    }

    public void setCompId(String compId) {
        CompId = compId;
    }

    public void setCompName(String compName) {
        CompName = compName;
    }

    public x_storage(String storId, String storName, String compId, String compName) {
        StorId = storId;
        StorName = storName;
        CompId = compId;
        CompName = compName;
    }

    public x_storage() {
    }
}
