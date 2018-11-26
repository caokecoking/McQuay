package com.zking.pojo.xtgl;

import com.zking.pojo.BasePojo;

public class AgreementShop  extends BasePojo {
	public String AgreCoding;
	
	public String AgreName;
	
	public Company c;

	public String Prov;

	public String Dist;

	public String Coun;

	public String AgreAddress;

	public String ChargeName;

	public String ChargePhone;

	public String ChargeEmail;

	public String TeleFax;

	public String DepositBank;
	
	public String BankAccount;

	public String CorpName;

	public String CorpPhone;

	public String CorpEmail;

	public String AgreStartTime;

	public String AgreFinishTime;
	

	public AgreementShop() {
		super(); 
	}


	public AgreementShop(String agreCoding, String agreName, Company c, String prov, String dist, String coun,
			String agreAddress, String chargeName, String chargePhone, String chargeEmail, String teleFax,
			String depositBank, String bankAccount, String corpName, String corpPhone, String corpEmail,
			String agreStartTime, String agreFinishTime) {
		super();
		AgreCoding = agreCoding;
		AgreName = agreName;
		this.c = c;
		Prov = prov;
		Dist = dist;
		Coun = coun;
		AgreAddress = agreAddress;
		ChargeName = chargeName;
		ChargePhone = chargePhone;
		ChargeEmail = chargeEmail;
		TeleFax = teleFax;
		DepositBank = depositBank;
		BankAccount = bankAccount;
		CorpName = corpName;
		CorpPhone = corpPhone;
		CorpEmail = corpEmail;
		AgreStartTime = agreStartTime;
		AgreFinishTime = agreFinishTime;
	}


	public String getAgreCoding() {
		return AgreCoding;
	}


	public void setAgreCoding(String agreCoding) {
		AgreCoding = agreCoding;
	}


	public String getAgreName() {
		return AgreName;
	}


	public void setAgreName(String agreName) {
		AgreName = agreName;
	}


	public Company getC() {
		return c;
	}


	public void setC(Company c) {
		this.c = c;
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


	public String getAgreAddress() {
		return AgreAddress;
	}


	public void setAgreAddress(String agreAddress) {
		AgreAddress = agreAddress;
	}


	public String getChargeName() {
		return ChargeName;
	}


	public void setChargeName(String chargeName) {
		ChargeName = chargeName;
	}


	public String getChargePhone() {
		return ChargePhone;
	}


	public void setChargePhone(String chargePhone) {
		ChargePhone = chargePhone;
	}


	public String getChargeEmail() {
		return ChargeEmail;
	}


	public void setChargeEmail(String chargeEmail) {
		ChargeEmail = chargeEmail;
	}


	public String getTeleFax() {
		return TeleFax;
	}


	public void setTeleFax(String teleFax) {
		TeleFax = teleFax;
	}


	public String getDepositBank() {
		return DepositBank;
	}


	public void setDepositBank(String depositBank) {
		DepositBank = depositBank;
	}


	public String getBankAccount() {
		return BankAccount;
	}


	public void setBankAccount(String bankAccount) {
		BankAccount = bankAccount;
	}


	public String getCorpName() {
		return CorpName;
	}


	public void setCorpName(String corpName) {
		CorpName = corpName;
	}


	public String getCorpPhone() {
		return CorpPhone;
	}


	public void setCorpPhone(String corpPhone) {
		CorpPhone = corpPhone;
	}


	public String getCorpEmail() {
		return CorpEmail;
	}


	public void setCorpEmail(String corpEmail) {
		CorpEmail = corpEmail;
	}


	public String getAgreStartTime() {
		return AgreStartTime;
	}


	public void setAgreStartTime(String agreStartTime) {
		AgreStartTime = agreStartTime;
	}


	public String getAgreFinishTime() {
		return AgreFinishTime;
	}


	public void setAgreFinishTime(String agreFinishTime) {
		AgreFinishTime = agreFinishTime;
	}


	
}
