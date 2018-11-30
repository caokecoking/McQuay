package com.zking.pojo.zlgl;

import com.zking.pojo.BasePojo;
import com.zking.pojo.xtgl.Company;

public class x_chancetype extends BasePojo {
    private String CtId;
    private String PtId;
    private String CtName;
    private String CtDescribe;
    private String Compid;
    private String CtUnit;
    private String CtUnitprice;
    private String ProductionDate;
    private x_producttype x_producttype;
    private Company Company;

    public com.zking.pojo.zlgl.x_producttype getX_producttype() {
        return x_producttype;
    }

    public void setX_producttype(com.zking.pojo.zlgl.x_producttype x_producttype) {
        this.x_producttype = x_producttype;
    }

    public com.zking.pojo.xtgl.Company getCompany() {
        return Company;
    }

    public void setCompany(com.zking.pojo.xtgl.Company company) {
        Company = company;
    }

    public String getCtId() {
        return CtId;
    }

    public void setCtId(String ctId) {
        CtId = ctId;
    }

    public String getPtId() {
        return PtId;
    }

    public void setPtId(String ptId) {
        PtId = ptId;
    }

    public String getCtName() {
        return CtName;
    }

    public void setCtName(String ctName) {
        CtName = ctName;
    }

    public String getCtDescribe() {
        return CtDescribe;
    }

    public void setCtDescribe(String ctDescribe) {
        CtDescribe = ctDescribe;
    }

    public String getCompid() {
        return Compid;
    }

    public void setCompid(String compid) {
        Compid = compid;
    }

    public String getCtUnit() {
        return CtUnit;
    }

    public void setCtUnit(String ctUnit) {
        CtUnit = ctUnit;
    }

    public String getCtUnitprice() {
        return CtUnitprice;
    }

    public void setCtUnitprice(String ctUnitprice) {
        CtUnitprice = ctUnitprice;
    }

    public String getProductionDate() {
        return ProductionDate;
    }

    public void setProductionDate(String productionDate) {
        ProductionDate = productionDate;
    }

    public x_chancetype() {
    }

    public x_chancetype(String ctId, String ptId, String ctName, String ctDescribe, String compid, String ctUnit, String ctUnitprice, String productionDate) {
        CtId = ctId;
        PtId = ptId;
        CtName = ctName;
        CtDescribe = ctDescribe;
        Compid = compid;
        CtUnit = ctUnit;
        CtUnitprice = ctUnitprice;
        ProductionDate = productionDate;
    }

}
