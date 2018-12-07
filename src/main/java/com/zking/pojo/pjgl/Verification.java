package com.zking.pojo.pjgl;

import com.zking.pojo.BasePojo;

import java.io.Serializable;

public class Verification extends BasePojo implements Serializable {
    private String Vid;
    private String Compodd;
    private String Iname;
    private String Iunits;
    private int Vsum;
    private String SpId;
    private String Mid;
    private String Atid;
    private String vreason;

    public Verification() {
        super();
    }


    public Verification(String vid, String compodd, String iname, String iunits, int vsum, String spId, String mid,
                        String atid, String vreason) {
        super();
        Vid = vid;
        Compodd = compodd;
        Iname = iname;
        Iunits = iunits;
        Vsum = vsum;
        SpId = spId;
        Mid = mid;
        Atid = atid;
        this.vreason = vreason;
    }

    public String getVid() {
        return Vid;
    }

    public void setVid(String vid) {
        Vid = vid;
    }

    public String getCompodd() {
        return Compodd;
    }

    public void setCompodd(String compodd) {
        Compodd = compodd;
    }

    public String getIname() {
        return Iname;
    }

    public void setIname(String iname) {
        Iname = iname;
    }

    public String getIunits() {
        return Iunits;
    }

    public void setIunits(String iunits) {
        Iunits = iunits;
    }

    public int getVsum() {
        return Vsum;
    }

    public void setVsum(int vsum) {
        Vsum = vsum;
    }

    public String getSpId() {
        return SpId;
    }

    public void setSpId(String spId) {
        SpId = spId;
    }

    public String getMid() {
        return Mid;
    }

    public void setMid(String mid) {
        Mid = mid;
    }

    public String getAtid() {
        return Atid;
    }

    public void setAtid(String atid) {
        Atid = atid;
    }

    public String getVreason() {
        return vreason;
    }

    public void setVreason(String vreason) {
        this.vreason = vreason;
    }

}
