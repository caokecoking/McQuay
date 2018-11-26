package com.zking.pojo.xtgl;

import com.zking.pojo.BasePojo;

import java.util.HashSet;
import java.util.Set;

public class Notice  extends BasePojo {
	public String NotiCoding;
	
	public String NotiTitle;

	public String NotiContent;

	public Personnel p;

	public String NotiContentTime;

	public Set<Company> Sc=new HashSet<>();

	public Set<Department> Sd=new HashSet<>();

	public Notice() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Notice(String notiCoding, String notiTitle, String notiContent, Personnel p, String notiContentTime,
			Set<Company> sc, Set<Department> sd) {
		super();
		NotiCoding = notiCoding;
		NotiTitle = notiTitle;
		NotiContent = notiContent;
		this.p = p;
		NotiContentTime = notiContentTime;
		Sc = sc;
		Sd = sd;
	}

	public String getNotiCoding() {
		return NotiCoding;
	}

	public void setNotiCoding(String notiCoding) {
		NotiCoding = notiCoding;
	}

	public String getNotiTitle() {
		return NotiTitle;
	}

	public void setNotiTitle(String notiTitle) {
		NotiTitle = notiTitle;
	}

	public String getNotiContent() {
		return NotiContent;
	}

	public void setNotiContent(String notiContent) {
		NotiContent = notiContent;
	}

	public Personnel getP() {
		return p;
	}

	public void setP(Personnel p) {
		this.p = p;
	}

	public String getNotiContentTime() {
		return NotiContentTime;
	}

	public void setNotiContentTime(String notiContentTime) {
		NotiContentTime = notiContentTime;
	}

	public Set<Company> getSc() {
		return Sc;
	}

	public void setSc(Set<Company> sc) {
		Sc = sc;
	}

	public Set<Department> getSd() {
		return Sd;
	}

	public void setSd(Set<Department> sd) {
		Sd = sd;
	}

	
}
