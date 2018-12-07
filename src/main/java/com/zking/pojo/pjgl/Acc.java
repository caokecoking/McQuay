package com.zking.pojo.pjgl;

import com.zking.pojo.BasePojo;

import java.io.Serializable;

public class Acc  extends BasePojo implements Serializable {

    private String Aid;
    private String Aodd;
    private String PersId;
    private String Acause;
    private String Atime;
    private String Aadvice;
    private int Comptratify;
    private String CustId;
    private String PtId;
    private String CtId;
    private String CaID;
    private String Acabz;

    public Acc() {
        super();
    }

    public Acc(String aid, String aodd, String persId, String acause, String atime, String aadvice, int comptratify,
               String custId, String ptId, String ctId, String caID, String acabz) {
        super();
        Aid = aid;
        Aodd = aodd;
        PersId = persId;
        Acause = acause;
        Atime = atime;
        Aadvice = aadvice;
        Comptratify = comptratify;
        CustId = custId;
        PtId = ptId;
        CtId = ctId;
        CaID = caID;
        Acabz = acabz;
    }

    public String getAid() {
        return Aid;
    }

    public void setAid(String aid) {
        Aid = aid;
    }

    public String getAodd() {
        return Aodd;
    }

    public void setAodd(String aodd) {
        Aodd = aodd;
    }

    public String getPersId() {
        return PersId;
    }

    public void setPersId(String persId) {
        PersId = persId;
    }

    public String getAcause() {
        return Acause;
    }

    public void setAcause(String acause) {
        Acause = acause;
    }

    public String getAtime() {
        return Atime;
    }

    public void setAtime(String atime) {
        Atime = atime;
    }

    public String getAadvice() {
        return Aadvice;
    }

    public void setAadvice(String aadvice) {
        Aadvice = aadvice;
    }

    public int getComptratify() {
        return Comptratify;
    }

    public void setComptratify(int comptratify) {
        Comptratify = comptratify;
    }

    public String getCustId() {
        return CustId;
    }

    public void setCustId(String custId) {
        CustId = custId;
    }

    public String getPtId() {
        return PtId;
    }

    public void setPtId(String ptId) {
        PtId = ptId;
    }

    public String getCtId() {
        return CtId;
    }

    public void setCtId(String ctId) {
        CtId = ctId;
    }

    public String getCaID() {
        return CaID;
    }

    public void setCaID(String caID) {
        CaID = caID;
    }

    public String getAcabz() {
        return Acabz;
    }

    public void setAcabz(String acabz) {
        Acabz = acabz;
    }


}
