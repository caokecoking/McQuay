package com.zking.pojo.zlgl;

import com.zking.pojo.BasePojo;

public class x_customer extends BasePojo {
    private String Cid;
    private String CName;
    private String CustSeat;
    private String CustPhone;
    private String CustPartphone;
    private String CustEmail;
    private String EDI_DateTime;
    private String CustId;
    private x_customermessage x_customermessage;

    public x_customer() {
    }

    public x_customer(String cid, String CName, String custSeat, String custPhone, String custPartphone, String custEmail, String EDI_DateTime, String custId, com.zking.pojo.zlgl.x_customermessage x_customermessage) {
        Cid = cid;
        this.CName = CName;
        CustSeat = custSeat;
        CustPhone = custPhone;
        CustPartphone = custPartphone;
        CustEmail = custEmail;
        this.EDI_DateTime = EDI_DateTime;
        CustId = custId;
        this.x_customermessage = x_customermessage;
    }


    public String getCid() {
        return Cid;
    }

    public void setCid(String cid) {
        Cid = cid;
    }

    public String getCName() {
        return CName;
    }

    public void setCName(String CName) {
        this.CName = CName;
    }

    public String getCustSeat() {
        return CustSeat;
    }

    public void setCustSeat(String custSeat) {
        CustSeat = custSeat;
    }

    public String getCustPhone() {
        return CustPhone;
    }

    public void setCustPhone(String custPhone) {
        CustPhone = custPhone;
    }

    public String getCustPartphone() {
        return CustPartphone;
    }

    public void setCustPartphone(String custPartphone) {
        CustPartphone = custPartphone;
    }

    public String getCustEmail() {
        return CustEmail;
    }

    public void setCustEmail(String custEmail) {
        CustEmail = custEmail;
    }

    public String getEDI_DateTime() {
        return EDI_DateTime;
    }

    public void setEDI_DateTime(String EDI_DateTime) {
        this.EDI_DateTime = EDI_DateTime;
    }

    public String getCustId() {
        return CustId;
    }

    public void setCustId(String custId) {
        CustId = custId;
    }

    public com.zking.pojo.zlgl.x_customermessage getX_customermessage() {
        return x_customermessage;
    }

    public void setX_customermessage(com.zking.pojo.zlgl.x_customermessage x_customermessage) {
        this.x_customermessage = x_customermessage;
    }
}