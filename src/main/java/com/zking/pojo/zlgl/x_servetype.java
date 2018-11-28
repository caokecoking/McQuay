package com.zking.pojo.zlgl;

import com.zking.pojo.BasePojo;

public class x_servetype extends BasePojo {
    private String StId;
    private String StDescribe;
    private String StProperty;
    private String StYesno;

    public x_servetype() {
    }

    public void setStId(String stId) {
        StId = stId;
    }


    public void setStDescribe(String stDescribe) {
        StDescribe = stDescribe;
    }

    public void setStProperty(String stProperty) {
        StProperty = stProperty;
    }

    public void setStYesno(String stYesno) {
        StYesno = stYesno;
    }

    public x_servetype(String stId, String stDescribe, String stProperty, String stYesno) {
        StId = stId;
        StDescribe = stDescribe;
        StProperty = stProperty;
        StYesno = stYesno;
    }

    public String getStId() {
        return StId;
    }

    public String getStDescribe() {
        return StDescribe;
    }

    public String getStProperty() {
        return StProperty;
    }

    public String getStYesno() {
        return StYesno;
    }

}
