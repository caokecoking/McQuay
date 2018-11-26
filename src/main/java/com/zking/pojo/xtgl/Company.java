package com.zking.pojo.xtgl;


import com.zking.pojo.BasePojo;

import java.util.HashSet;
import java.util.Set;

public class Company  extends BasePojo {
	public String Compid;

	public String CompCoding;

	public String CompName;

	public String CompAttribute;

	public String Prov;

	public String Dist;

	public String Coun;

	public String CompAddress;

	public String CompEmailAddress;

	public String CompEmailPassword;

	public transient Set<AgreementShop> sa = new HashSet<>();

//	public transient Set<x_chancetype> st = new HashSet<>();

//	public transient Set<x_material> sm = new HashSet<>();

//	public Set<x_material> getSm() {
//		return sm;
//	}

//	public void setSm(Set<x_material> sm) {
//		this.sm = sm;
//	}

	public Set<Personnel> Sp = new HashSet<>();

	public Set<Department> Sd = new HashSet<>();

//	public Set<x_chancetype> getSt() {
//		return st;
//	}
//
//	public void setSt(Set<x_chancetype> st) {
//		this.st = st;
//	}

	public transient Set<Notice> Sn = new HashSet<>();

	public Company() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getCompid() {
		return Compid;
	}

	public void setCompid(String compid) {
		Compid = compid;
	}

	public String getCompCoding() {
		return CompCoding;
	}

	public void setCompCoding(String compCoding) {
		CompCoding = compCoding;
	}

	public String getCompName() {
		return CompName;
	}

	public void setCompName(String compName) {
		CompName = compName;
	}

	public String getCompAttribute() {
		return CompAttribute;
	}

	public void setCompAttribute(String compAttribute) {
		CompAttribute = compAttribute;
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

	public String getCompAddress() {
		return CompAddress;
	}

	public void setCompAddress(String compAddress) {
		CompAddress = compAddress;
	}

	public String getCompEmailAddress() {
		return CompEmailAddress;
	}

	public void setCompEmailAddress(String compEmailAddress) {
		CompEmailAddress = compEmailAddress;
	}

	public String getCompEmailPassword() {
		return CompEmailPassword;
	}

	public void setCompEmailPassword(String compEmailPassword) {
		CompEmailPassword = compEmailPassword;
	}

	public Set<AgreementShop> getSa() {
		return sa;
	}

	public void setSa(Set<AgreementShop> sa) {
		this.sa = sa;
	}

	public Set<Personnel> getSp() {
		return Sp;
	}

	public void setSp(Set<Personnel> sp) {
		Sp = sp;
	}

	public Set<Department> getSd() {
		return Sd;
	}

	public void setSd(Set<Department> sd) {
		Sd = sd;
	}

	public Set<Notice> getSn() {
		return Sn;
	}

	public void setSn(Set<Notice> sn) {
		Sn = sn;
	}

}
