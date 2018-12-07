package com.zking.pojo.fwgl;

import com.zking.pojo.BasePojo;
import com.zking.pojo.xtgl.Personnel;

public class ServiceHandling extends BasePojo {
    private String ShId; //ID

    private String CustId; //客户编号

    private String CustName; //客户名称

    private String CName;

    private String CustSeat; //联系人电话

    private String Prov;//省

    private String Dist;// 市

    private String Coun;//区

    private String CustAddress;// 客户地址

    private String Dealer; //经销商

    private String HandlingID; //受理单号

    private String Ordering; //接单员

    private String AppointmentTime;  //预约时间

    private String PtDescribe; //产品类型

    private String DateOfPurchase; //购买日期

    private String HandlingType;   //受理类型

    private String HandlingDescribe; //受理描述

    private String YesNo; //是否派工

    private String DateOfSupervisor;//派单主管

    private String Cause; //不派工原因

    private String state; //服务状态


    public ServiceHandling() {
    }

    public ServiceHandling(String shId, String custId, String custName, String CName, String custSeat, String prov, String dist, String coun, String custAddress, String dealer, String handlingID, String ordering, String appointmentTime, String ptDescribe, String dateOfPurchase, String handlingType, String handlingDescribe, String yesNo, String dateOfSupervisor, String cause, String state) {
        ShId = shId;
        CustId = custId;
        CustName = custName;
        this.CName = CName;
        CustSeat = custSeat;
        Prov = prov;
        Dist = dist;
        Coun = coun;
        CustAddress = custAddress;
        Dealer = dealer;
        HandlingID = handlingID;
        Ordering = ordering;
        AppointmentTime = appointmentTime;
        PtDescribe = ptDescribe;
        DateOfPurchase = dateOfPurchase;
        HandlingType = handlingType;
        HandlingDescribe = handlingDescribe;
        YesNo = yesNo;
        DateOfSupervisor = dateOfSupervisor;
        Cause = cause;
        this.state = state;
    }

    public String getShId() {
        return ShId;
    }

    public void setShId(String shId) {
        ShId = shId;
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

    public String getDealer() {
        return Dealer;
    }

    public void setDealer(String dealer) {
        Dealer = dealer;
    }

    public String getHandlingID() {
        return HandlingID;
    }

    public void setHandlingID(String handlingID) {
        HandlingID = handlingID;
    }

    public String getOrdering() {
        return Ordering;
    }

    public void setOrdering(String ordering) {
        Ordering = ordering;
    }

    public String getAppointmentTime() {
        return AppointmentTime;
    }

    public void setAppointmentTime(String appointmentTime) {
        AppointmentTime = appointmentTime;
    }

    public String getPtDescribe() {
        return PtDescribe;
    }

    public void setPtDescribe(String ptDescribe) {
        PtDescribe = ptDescribe;
    }

    public String getDateOfPurchase() {
        return DateOfPurchase;
    }

    public void setDateOfPurchase(String dateOfPurchase) {
        DateOfPurchase = dateOfPurchase;
    }

    public String getHandlingType() {
        return HandlingType;
    }

    public void setHandlingType(String handlingType) {
        HandlingType = handlingType;
    }

    public String getHandlingDescribe() {
        return HandlingDescribe;
    }

    public void setHandlingDescribe(String handlingDescribe) {
        HandlingDescribe = handlingDescribe;
    }

    public String getYesNo() {
        return YesNo;
    }

    public void setYesNo(String yesNo) {
        YesNo = yesNo;
    }

    public String getDateOfSupervisor() {
        return DateOfSupervisor;
    }

    public void setDateOfSupervisor(String dateOfSupervisor) {
        DateOfSupervisor = dateOfSupervisor;
    }

    public String getCause() {
        return Cause;
    }

    public void setCause(String cause) {
        Cause = cause;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
