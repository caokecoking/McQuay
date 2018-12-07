package com.zking.pojo.pjgl;


import com.zking.pojo.BasePojo;

import java.io.Serializable;

public class Consuming  extends BasePojo implements Serializable {
    private String Cid;
    private String Codd;
    private String Persid;
    private String Ctime;
    private String StorID;
    private String CustId;
    private String Cadvice;
    private int Comptratify;
    private String Aid;

    public Consuming() {
        super();
    }


    public Consuming(String cid, String codd, String persid, String ctime, String storID, String custId, String cadvice,
                     int comptratify, String aid) {
        super();
        Cid = cid;
        Codd = codd;
        Persid = persid;
        Ctime = ctime;
        StorID = storID;
        CustId = custId;
        Cadvice = cadvice;
        Comptratify = comptratify;
        Aid = aid;
    }

    public String getCid() {
        return Cid;
    }

    public void setCid(String cid) {
        Cid = cid;
    }

    public String getCodd() {
        return Codd;
    }

    public void setCodd(String codd) {
        Codd = codd;
    }

    public String getPersid() {
        return Persid;
    }

    public void setPersid(String persid) {
        Persid = persid;
    }

    public String getCtime() {
        return Ctime;
    }

    public void setCtime(String ctime) {
        Ctime = ctime;
    }

    public String getStorID() {
        return StorID;
    }

    public void setStorID(String storID) {
        StorID = storID;
    }

    public String getCustId() {
        return CustId;
    }

    public void setCustId(String custId) {
        CustId = custId;
    }

    public String getCadvice() {
        return Cadvice;
    }

    public void setCadvice(String cadvice) {
        Cadvice = cadvice;
    }

    public int getComptratify() {
        return Comptratify;
    }

    public void setComptratify(int comptratify) {
        Comptratify = comptratify;
    }

    public String getAid() {
        return Aid;
    }

    public void setAid(String aid) {
        Aid = aid;
    }

}