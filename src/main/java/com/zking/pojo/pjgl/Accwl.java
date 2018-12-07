package com.zking.pojo.pjgl;

import com.zking.pojo.BasePojo;

import java.io.Serializable;

public class Accwl extends BasePojo implements Serializable {
    private String Aqid;
    private String Mid;
    private int Asum;
    private String Adhtime;
    private String Aghtime;
    private String Ascfj;
    private String Mname;
    private String Amm;

    private Acc c;

    public Accwl() {
        super();
    }

  
    public Accwl(String aqid, String mid, int asum, String adhtime, String aghtime, String ascfj, String mname,
                 String amm, Acc c) {
        super();
        Aqid = aqid;
        Mid = mid;
        Asum = asum;
        Adhtime = adhtime;
        Aghtime = aghtime;
        Ascfj = ascfj;
        Mname = mname;
        Amm = amm;
        this.c = c;
    }

    public String getAqid() {
        return Aqid;
    }

    public void setAqid(String aqid) {
        Aqid = aqid;
    }

    public String getMid() {
        return Mid;
    }

    public void setMid(String mid) {
        Mid = mid;
    }

    public int getAsum() {
        return Asum;
    }

    public void setAsum(int asum) {
        Asum = asum;
    }

    public String getAdhtime() {
        return Adhtime;
    }

    public void setAdhtime(String adhtime) {
        Adhtime = adhtime;
    }

    public String getAghtime() {
        return Aghtime;
    }

    public void setAghtime(String aghtime) {
        Aghtime = aghtime;
    }

    public String getAscfj() {
        return Ascfj;
    }

    public void setAscfj(String ascfj) {
        Ascfj = ascfj;
    }

    public String getMname() {
        return Mname;
    }

    public void setMname(String mname) {
        Mname = mname;
    }

    public String getAmm() {
        return Amm;
    }

    public void setAmm(String amm) {
        Amm = amm;
    }

    public Acc getC() {
        return c;
    }

    public void setC(Acc c) {
        this.c = c;
    }

}
