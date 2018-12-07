package com.zking.pojo.xtgl;

import com.zking.pojo.BasePojo;

public class Buttons extends BasePojo{

    private String bid;
    private String bname;
    private String premission;

    public Buttons() {
    }

    public Buttons(String bid, String bname, String premission) {
        this.bid = bid;
        this.bname = bname;
        this.premission = premission;
    }

    public String getBid() {
        return bid;
    }

    public void setBid(String bid) {
        this.bid = bid;
    }

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }

    public String getPremission() {
        return premission;
    }

    public void setPremission(String premission) {
        this.premission = premission;
    }
}
