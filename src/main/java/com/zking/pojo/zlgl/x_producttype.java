package com.zking.pojo.zlgl;

import com.zking.pojo.BasePojo;

public class x_producttype extends BasePojo {
    private String PtId;
    private String PtDescribe;

    public x_producttype() {
    }

    public x_producttype(String ptId, String ptDescribe) {
        PtId = ptId;
        PtDescribe = ptDescribe;
    }

    public String getPtId() {
        return PtId;
    }

    public void setPtId(String ptId) {
        PtId = ptId;
    }

    public String getPtDescribe() {
        return PtDescribe;
    }

    public void setPtDescribe(String ptDescribe) {
        PtDescribe = ptDescribe;
    }

}
