package com.zking.pojo.zlgl;

import com.zking.pojo.BasePojo;
import com.zking.pojo.xtgl.Company;

public class x_customermessage extends BasePojo {
    private String CustId;
    private String CustName;
    private String CustProject;
    private String Prov;
    private String Dist;
    private String Coun;
    private String CustAddress;
    private String CustType;
    private String Compid;
    private String EDI_DateTime;
    private Company Company;
    private x_customer x_customer;
    private String ShId;
    private String SpId;

    public String getShId() {
        return ShId;
    }

    public String getSpId() {
        return SpId;
    }

    public void setShId(String shId) {
        ShId = shId;
    }

    public void setSpId(String spId) {
        SpId = spId;
    }

    public com.zking.pojo.zlgl.x_customer getX_customer() {
        return x_customer;
    }

    public void setX_customer(com.zking.pojo.zlgl.x_customer x_customer) {
        this.x_customer = x_customer;
    }

    public com.zking.pojo.xtgl.Company getCompany() {
        return Company;
    }

    public void setCompany(com.zking.pojo.xtgl.Company company) {
        Company = company;
    }

    public String getCustId() {
        return CustId;
    }

    public void setCustId(String custId) {
        CustId = custId;
    }

    public String getCustName() {
        return CustName;
    }

    public void setCustName(String custName) {
        CustName = custName;
    }

    public String getCustProject() {
        return CustProject;
    }

    public void setCustProject(String custProject) {
        CustProject = custProject;
    }

    public String getProv() {
        return Prov;
    }

    public void setProv(String prov) {
        Prov = prov;
    }

    public String getDist() {
        return Dist;
    }

    public void setDist(String dist) {
        Dist = dist;
    }

    public String getCoun() {
        return Coun;
    }

    public void setCoun(String coun) {
        Coun = coun;
    }

    public String getCustAddress() {
        return CustAddress;
    }

    public void setCustAddress(String custAddress) {
        CustAddress = custAddress;
    }

    public String getCustType() {
        return CustType;
    }

    public void setCustType(String custType) {
        CustType = custType;
    }

    public String getCompid() {
        return Compid;
    }

    public void setCompid(String compid) {
        Compid = compid;
    }

    public String getEDI_DateTime() {
        return EDI_DateTime;
    }

    public void setEDI_DateTime(String EDI_DateTime) {
        this.EDI_DateTime = EDI_DateTime;
    }

    public x_customermessage() {
    }

    public x_customermessage(String custId, String custName, String custProject, String prov, String dist, String coun, String custAddress, String custType, String compid, String EDI_DateTime) {
        CustId = custId;
        CustName = custName;
        CustProject = custProject;
        Prov = prov;
        Dist = dist;
        Coun = coun;
        CustAddress = custAddress;
        CustType = custType;
        Compid = compid;
        this.EDI_DateTime = EDI_DateTime;
    }
}
