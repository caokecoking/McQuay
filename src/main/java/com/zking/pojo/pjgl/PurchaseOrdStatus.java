package com.zking.pojo.pjgl;


import com.zking.pojo.BasePojo;

import java.io.Serializable;

public class PurchaseOrdStatus  extends BasePojo implements Serializable {
	private String Psid;
	private String psodd;
	private String CompId;
	private int Plid;
	private int psfcount;
	private int psscount;

	public PurchaseOrdStatus() {
		super();
	}


	public PurchaseOrdStatus(String psid, String psodd, String compId, int plid, int psfcount, int psscount) {
		super();
		Psid = psid;
		this.psodd = psodd;
		CompId = compId;
		Plid = plid;
		this.psfcount = psfcount;
		this.psscount = psscount;
	}

	public String getPsid() {
		return Psid;
	}

	public void setPsid(String psid) {
		Psid = psid;
	}

	public String getPsodd() {
		return psodd;
	}

	public void setPsodd(String psodd) {
		this.psodd = psodd;
	}

	public String getCompId() {
		return CompId;
	}

	public void setCompId(String compId) {
		CompId = compId;
	}

	public int getPlid() {
		return Plid;
	}

	public void setPlid(int plid) {
		Plid = plid;
	}

	public int getPsfcount() {
		return psfcount;
	}

	public void setPsfcount(int psfcount) {
		this.psfcount = psfcount;
	}

	public int getPsscount() {
		return psscount;
	}

	public void setPsscount(int psscount) {
		this.psscount = psscount;
	}

}
