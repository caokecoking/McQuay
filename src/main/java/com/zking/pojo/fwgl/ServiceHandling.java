package com.zking.pojo.fwgl;

import com.zking.pojo.BasePojo;
import com.zking.pojo.xtgl.Personnel;

public class ServiceHandling extends BasePojo{
	private String ShId;

	private String ShPhone;

	public Personnel p;

//	public x_customermessage c;

	private String AppointmentTime;

	private String AcceptDate;

	private String PtDescribe;

	private String StDescribe;

	private String PurchaseDate;

	private String AcceptDescription ;

	private String ChargeType;

	private String DoorFee;

	private String Dispatch;

	private String CounselContent;

	private String SendCharge;

	private String Other;

	public ServiceHandling() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ServiceHandling(String shId, String shPhone, Personnel p, String appointmentTime,
			String acceptDate, String ptDescribe, String stDescribe, String purchaseDate, String acceptDescription,
			String chargeType, String doorFee, String dispatch, String counselContent, String sendCharge,
			String other) {
		super();
		ShId = shId;
		ShPhone = shPhone;
		this.p = p;
//		this.c = c;
		AppointmentTime = appointmentTime;
		AcceptDate = acceptDate;
		PtDescribe = ptDescribe;
		StDescribe = stDescribe;
		PurchaseDate = purchaseDate;
		AcceptDescription = acceptDescription;
		ChargeType = chargeType;
		DoorFee = doorFee;
		Dispatch = dispatch;
		CounselContent = counselContent;
		SendCharge = sendCharge;
		Other = other;
	}

	public String getShId() {
		return ShId;
	}

	public void setShId(String shId) {
		ShId = shId;
	}

	public String getShPhone() {
		return ShPhone;
	}

	public void setShPhone(String shPhone) {
		ShPhone = shPhone;
	}

	public Personnel getP() {
		return p;
	}

	public void setP(Personnel p) {
		this.p = p;
	}

//	public x_customermessage getC() {
//		return c;
//	}
//
//	public void setC(x_customermessage c) {
//		this.c = c;
//	}

	public String getAppointmentTime() {
		return AppointmentTime;
	}

	public void setAppointmentTime(String appointmentTime) {
		AppointmentTime = appointmentTime;
	}

	public String getAcceptDate() {
		return AcceptDate;
	}

	public void setAcceptDate(String acceptDate) {
		AcceptDate = acceptDate;
	}

	public String getPtDescribe() {
		return PtDescribe;
	}

	public void setPtDescribe(String ptDescribe) {
		PtDescribe = ptDescribe;
	}

	public String getStDescribe() {
		return StDescribe;
	}

	public void setStDescribe(String stDescribe) {
		StDescribe = stDescribe;
	}

	public String getPurchaseDate() {
		return PurchaseDate;
	}

	public void setPurchaseDate(String purchaseDate) {
		PurchaseDate = purchaseDate;
	}

	public String getAcceptDescription() {
		return AcceptDescription;
	}

	public void setAcceptDescription(String acceptDescription) {
		AcceptDescription = acceptDescription;
	}

	public String getChargeType() {
		return ChargeType;
	}

	public void setChargeType(String chargeType) {
		ChargeType = chargeType;
	}

	public String getDoorFee() {
		return DoorFee;
	}

	public void setDoorFee(String doorFee) {
		DoorFee = doorFee;
	}

	public String getDispatch() {
		return Dispatch;
	}

	public void setDispatch(String dispatch) {
		Dispatch = dispatch;
	}

	public String getCounselContent() {
		return CounselContent;
	}

	public void setCounselContent(String counselContent) {
		CounselContent = counselContent;
	}

	public String getSendCharge() {
		return SendCharge;
	}

	public void setSendCharge(String sendCharge) {
		SendCharge = sendCharge;
	}

	public String getOther() {
		return Other;
	}

	public void setOther(String other) {
		Other = other;
	}
	
}
