package com.zking.pojo.xtgl;

import com.zking.pojo.BasePojo;

import java.util.HashSet;
import java.util.Set;

public class Department  extends BasePojo {
	public String Deptid;
	
	public String DeptCoding;

	public String DeptName;

	public transient Set<Company> Sc=new HashSet<>();

	public Set<Personnel> Sp=new HashSet<>();
	
	public transient Set<Notice> Sn=new HashSet<>();

	public Set<Jop> Sj=new HashSet<>();

	public Department() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Department(String deptid, String deptCoding, String deptName, Set<Company> sc, Set<Personnel> sp,
			Set<Notice> sn, Set<Jop> sj) {
		super();
		Deptid = deptid;
		DeptCoding = deptCoding;
		DeptName = deptName;
		Sc = sc;
		Sp = sp;
		Sn = sn;
		Sj = sj;
	}
	public String getDeptid() {
		return Deptid;
	}
	public void setDeptid(String deptid) {
		Deptid = deptid;
	}
	public String getDeptCoding() {
		return DeptCoding;
	}
	public void setDeptCoding(String deptCoding) {
		DeptCoding = deptCoding;
	}
	public String getDeptName() {
		return DeptName;
	}
	public void setDeptName(String deptName) {
		DeptName = deptName;
	}
	public Set<Company> getSc() {
		return Sc;
	}
	public void setSc(Set<Company> sc) {
		Sc = sc;
	}
	public Set<Personnel> getSp() {
		return Sp;
	}
	public void setSp(Set<Personnel> sp) {
		Sp = sp;
	}
	public Set<Notice> getSn() {
		return Sn;
	}
	public void setSn(Set<Notice> sn) {
		Sn = sn;
	}
	public Set<Jop> getSj() {
		return Sj;
	}
	public void setSj(Set<Jop> sj) {
		Sj = sj;
	}


	
	
}
