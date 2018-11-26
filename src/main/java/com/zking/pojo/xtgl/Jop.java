package com.zking.pojo.xtgl;

import com.zking.pojo.BasePojo;

import java.util.HashSet;
import java.util.Set;

public class Jop  extends BasePojo {
	public String JopId;

	public String JopName;

	public String Rel;

	public Set<Menu> sm=new HashSet<>();
	
	public Set<Personnel> sp=new HashSet<>();

	public transient Set<Department> sd=new HashSet<>();
	
	public Jop() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Jop(String jopId, String jopName, String rel, Set<Menu> sm, Set<Personnel> sp, Set<Department> sd) {
		super();
		JopId = jopId;
		JopName = jopName;
		Rel = rel;
		this.sm = sm;
		this.sp = sp;
		this.sd = sd;
	}
	public String getJopId() {
		return JopId;
	}
	public void setJopId(String jopId) {
		JopId = jopId;
	}
	public String getJopName() {
		return JopName;
	}
	public void setJopName(String jopName) {
		JopName = jopName;
	}
	public String getRel() {
		return Rel;
	}
	public void setRel(String rel) {
		Rel = rel;
	}
	public Set<Menu> getSm() {
		return sm;
	}
	public void setSm(Set<Menu> sm) {
		this.sm = sm;
	}
	public Set<Personnel> getSp() {
		return sp;
	}
	public void setSp(Set<Personnel> sp) {
		this.sp = sp;
	}
	public Set<Department> getSd() {
		return sd;
	}
	public void setSd(Set<Department> sd) {
		this.sd = sd;
	}


}
