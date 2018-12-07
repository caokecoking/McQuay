package com.zking.pojo.pjgl;

import com.zking.pojo.BasePojo;

import java.io.Serializable;

public class Inventory  extends BasePojo implements Serializable {
	private String Iid;
	private String StorID;
	private String CompId;
	private String Iunits;
	private int Iloss;
	private int Ileigh;
	private int Icounte;
	private int Inumber;
	private String Iremarks;

	public Inventory() {
		super();
	}


	public Inventory(String iid, String storID, String compId, String iunits, int iloss, int ileigh, int icounte,
			int inumber, String iremarks) {
		super();
		Iid = iid;
		StorID = storID;
		CompId = compId;
		Iunits = iunits;
		Iloss = iloss;
		Ileigh = ileigh;
		Icounte = icounte;
		Inumber = inumber;
		Iremarks = iremarks;
	}

	public String getIid() {
		return Iid;
	}

	public void setIid(String iid) {
		Iid = iid;
	}

	public String getStorID() {
		return StorID;
	}

	public void setStorID(String storID) {
		StorID = storID;
	}

	public String getCompId() {
		return CompId;
	}

	public void setCompId(String compId) {
		CompId = compId;
	}

	public String getIunits() {
		return Iunits;
	}

	public void setIunits(String iunits) {
		Iunits = iunits;
	}

	public int getIloss() {
		return Iloss;
	}

	public void setIloss(int iloss) {
		Iloss = iloss;
	}

	public int getIleigh() {
		return Ileigh;
	}

	public void setIleigh(int ileigh) {
		Ileigh = ileigh;
	}

	public int getIcounte() {
		return Icounte;
	}

	public void setIcounte(int icounte) {
		Icounte = icounte;
	}

	public int getInumber() {
		return Inumber;
	}

	public void setInumber(int inumber) {
		Inumber = inumber;
	}

	public String getIremarks() {
		return Iremarks;
	}

	public void setIremarks(String iremarks) {
		Iremarks = iremarks;
	}

}
