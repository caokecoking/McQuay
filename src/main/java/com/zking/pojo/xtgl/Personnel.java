package com.zking.pojo.xtgl;

import com.zking.pojo.BasePojo;

import java.util.HashSet;
import java.util.Set;

public class Personnel  extends BasePojo {
	public String PersId;

	public String PersCoding;

	public String PersName;

	public String PersPassword;

	public String WorkCenter;

	public String Sex;

	public String FixedTelephone;

	public String TheExtension;

	public String Phone;

	public String Email;

	public String LeftTime;

	public String Hiredate;

	public String PersJudge;

	public Set<Jop> sj = new HashSet<>();

	public Set<Company> sc = new HashSet<>();

	public Set<Department> sd = new HashSet<>();

	public transient Set<Notice> sn = new HashSet<>();

//	public transient Set<ServiceHandling> ss=new HashSet<>();
	
	public Personnel() {
		super();
	}

	public Personnel(String persId, String persCoding, String persName, String persPassword, String workCenter,
			String sex, String fixedTelephone, String theExtension, String phone, String email, String leftTime,
			String hiredate, String persJudge, Set<Jop> sj, Set<Company> sc, Set<Department> sd, Set<Notice> sn) {
		super();
		PersId = persId;
		PersCoding = persCoding;
		PersName = persName;
		PersPassword = persPassword;
		WorkCenter = workCenter;
		Sex = sex;
		FixedTelephone = fixedTelephone;
		TheExtension = theExtension;
		Phone = phone;
		Email = email;
		LeftTime = leftTime;
		Hiredate = hiredate;
		PersJudge = persJudge;
		this.sj = sj;
		this.sc = sc;
		this.sd = sd;
		this.sn = sn;
	}

	public String getPersId() {
		return PersId;
	}

	public void setPersId(String persId) {
		PersId = persId;
	}

	public String getPersCoding() {
		return PersCoding;
	}

	public void setPersCoding(String persCoding) {
		PersCoding = persCoding;
	}

	public String getPersName() {
		return PersName;
	}

	public void setPersName(String persName) {
		PersName = persName;
	}

	public String getPersPassword() {
		return PersPassword;
	}

	public void setPersPassword(String persPassword) {
		PersPassword = persPassword;
	}

	public String getWorkCenter() {
		return WorkCenter;
	}

	public void setWorkCenter(String workCenter) {
		WorkCenter = workCenter;
	}

	public String getSex() {
		return Sex;
	}

	public void setSex(String sex) {
		Sex = sex;
	}

	public String getFixedTelephone() {
		return FixedTelephone;
	}

	public void setFixedTelephone(String fixedTelephone) {
		FixedTelephone = fixedTelephone;
	}

	public String getTheExtension() {
		return TheExtension;
	}

	public void setTheExtension(String theExtension) {
		TheExtension = theExtension;
	}

	public String getPhone() {
		return Phone;
	}

	public void setPhone(String phone) {
		Phone = phone;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getLeftTime() {
		return LeftTime;
	}

	public void setLeftTime(String leftTime) {
		LeftTime = leftTime;
	}

	public String getHiredate() {
		return Hiredate;
	}

	public void setHiredate(String hiredate) {
		Hiredate = hiredate;
	}

	public String getPersJudge() {
		return PersJudge;
	}

	public void setPersJudge(String persJudge) {
		PersJudge = persJudge;
	}

	public Set<Jop> getSj() {
		return sj;
	}

	public void setSj(Set<Jop> sj) {
		this.sj = sj;
	}

	public Set<Company> getSc() {
		return sc;
	}

	public void setSc(Set<Company> sc) {
		this.sc = sc;
	}

	public Set<Department> getSd() {
		return sd;
	}

	public void setSd(Set<Department> sd) {
		this.sd = sd;
	}

	public Set<Notice> getSn() {
		return sn;
	}

	public void setSn(Set<Notice> sn) {
		this.sn = sn;
	}

}
