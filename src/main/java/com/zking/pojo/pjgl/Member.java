package com.zking.pojo.pjgl;

import com.zking.pojo.BasePojo;

import java.io.Serializable;

public class Member extends BasePojo implements Serializable {
	private String Mid;
	private String Modd;
	private String PersCoding;
	private String Codd;
	private String StorID;
	private String Mjtype;
	private String CustId;
	private String Mtime;
	private String CompId;
	private int Mtratify;

	public Member() {
		super();
	}

	public Member(String mid, String modd, String persCoding, String codd, String storID, String mjtype, String custId,
			String mtime, String compId, int mtratify) {
		super();
		Mid = mid;
		Modd = modd;
		PersCoding = persCoding;
		Codd = codd;
		StorID = storID;
		Mjtype = mjtype;
		CustId = custId;
		Mtime = mtime;
		CompId = compId;
		Mtratify = mtratify;
	}

	public String getMid() {
		return Mid;
	}

	public void setMid(String mid) {
		Mid = mid;
	}

	public String getModd() {
		return Modd;
	}

	public void setModd(String modd) {
		Modd = modd;
	}

	public String getPersCoding() {
		return PersCoding;
	}

	public void setPersCoding(String persCoding) {
		PersCoding = persCoding;
	}

	public String getCodd() {
		return Codd;
	}

	public void setCodd(String codd) {
		Codd = codd;
	}

	public String getStorID() {
		return StorID;
	}

	public void setStorID(String storID) {
		StorID = storID;
	}

	public String getMjtype() {
		return Mjtype;
	}

	public void setMjtype(String mjtype) {
		Mjtype = mjtype;
	}

	public String getCustId() {
		return CustId;
	}

	public void setCustId(String custId) {
		CustId = custId;
	}

	public String getMtime() {
		return Mtime;
	}

	public void setMtime(String mtime) {
		Mtime = mtime;
	}

	public String getCompId() {
		return CompId;
	}

	public void setCompId(String compId) {
		CompId = compId;
	}

	public int getMtratify() {
		return Mtratify;
	}

	public void setMtratify(int mtratify) {
		Mtratify = mtratify;
	}

}
