package com.zking.pojo.pjgl;


import com.zking.pojo.BasePojo;

import java.io.Serializable;

public class PurchaseOrd  extends BasePojo implements Serializable {
	private String Pid;
	private String Plid;
	private String PersCoding;
	private String Podd;
	private String CompId;
	private String Atid;
	private float Plprice;
	private int Plcount;
	private String StorID;
	private String Pddate;
	private String Pfdate;
	private String Pdate;
	private String Pdescription;
	private int Comptratify;

	public PurchaseOrd() {
		super();
	}



	public PurchaseOrd(String pid, String plid, String persCoding, String podd, String compId, String atid,
			float plprice, int plcount, String storID, String pddate, String pfdate, String pdate, String pdescription,
			int comptratify) {
		super();
		Pid = pid;
		Plid = plid;
		PersCoding = persCoding;
		Podd = podd;
		CompId = compId;
		Atid = atid;
		Plprice = plprice;
		Plcount = plcount;
		StorID = storID;
		Pddate = pddate;
		Pfdate = pfdate;
		Pdate = pdate;
		Pdescription = pdescription;
		Comptratify = comptratify;
	}

	public String getPid() {
		return Pid;
	}

	public void setPid(String pid) {
		Pid = pid;
	}

	public String getPlid() {
		return Plid;
	}

	public void setPlid(String plid) {
		Plid = plid;
	}

	public String getPersCoding() {
		return PersCoding;
	}

	public void setPersCoding(String persCoding) {
		PersCoding = persCoding;
	}

	public String getPodd() {
		return Podd;
	}

	public void setPodd(String podd) {
		Podd = podd;
	}

	public String getCompId() {
		return CompId;
	}

	public void setCompId(String compId) {
		CompId = compId;
	}

	public String getAtid() {
		return Atid;
	}

	public void setAtid(String atid) {
		Atid = atid;
	}

	public float getPlprice() {
		return Plprice;
	}

	public void setPlprice(float plprice) {
		Plprice = plprice;
	}

	public int getPlcount() {
		return Plcount;
	}

	public void setPlcount(int plcount) {
		Plcount = plcount;
	}

	public String getStorID() {
		return StorID;
	}

	public void setStorID(String storID) {
		StorID = storID;
	}

	public String getPddate() {
		return Pddate;
	}

	public void setPddate(String pddate) {
		Pddate = pddate;
	}

	public String getPfdate() {
		return Pfdate;
	}

	public void setPfdate(String pfdate) {
		Pfdate = pfdate;
	}

	public String getPdate() {
		return Pdate;
	}

	public void setPdate(String pdate) {
		Pdate = pdate;
	}

	public String getPdescription() {
		return Pdescription;
	}

	public void setPdescription(String pdescription) {
		Pdescription = pdescription;
	}

	public int getComptratify() {
		return Comptratify;
	}

	public void setComptratify(int comptratify) {
		Comptratify = comptratify;
	}

}
