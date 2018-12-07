package com.zking.pojo.pjgl;

import com.zking.pojo.BasePojo;

import java.io.Serializable;

public class AccPJ  extends BasePojo implements Serializable {
    private String apid;
    private String apadd;
    private String apmas;
    private String aptime;
    private String apdanw;
    private float aprice;
    private String CompId;


    public AccPJ() {
        super();
    }

    public AccPJ(String apid, String apadd, String apmas, String aptime, String apdanw, float aprice, String compId) {
        super();
        this.apid = apid;
        this.apadd = apadd;
        this.apmas = apmas;
        this.aptime = aptime;
        this.apdanw = apdanw;
        this.aprice = aprice;
        CompId = compId;
    }

    public String getApid() {
        return apid;
    }

    public void setApid(String apid) {
        this.apid = apid;
    }

    public String getApadd() {
        return apadd;
    }

    public void setApadd(String apadd) {
        this.apadd = apadd;
    }

    public String getApmas() {
        return apmas;
    }

    public void setApmas(String apmas) {
        this.apmas = apmas;
    }

    public String getAptime() {
        return aptime;
    }

    public void setAptime(String aptime) {
        this.aptime = aptime;
    }

    public String getApdanw() {
        return apdanw;
    }

    public void setApdanw(String apdanw) {
        this.apdanw = apdanw;
    }

    public float getAprice() {
        return aprice;
    }

    public void setAprice(float aprice) {
        this.aprice = aprice;
    }

    public String getCompId() {
        return CompId;
    }

    public void setCompId(String compId) {
        CompId = compId;
    }

}
