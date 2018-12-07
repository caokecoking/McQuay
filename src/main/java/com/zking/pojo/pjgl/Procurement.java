package com.zking.pojo.pjgl;


import com.zking.pojo.BasePojo;

import java.io.Serializable;

public class Procurement  extends BasePojo implements Serializable {
	private String Poid;
	private String Podd;
	private String Persid;
	private String Aid;
	private String Pdate;
	private String psodd;
	private String Padvice;
	private String Prsum;
	private String Prbz;
	private int Comptratify;

	public Procurement() {
		super();
	}



	public Procurement(String poid, String podd, String persid, String aid, String pdate, String psodd, String padvice,
			String prsum, String prbz, int comptratify) {
		super();
		Poid = poid;
		Podd = podd;
		Persid = persid;
		Aid = aid;
		Pdate = pdate;
		this.psodd = psodd;
		Padvice = padvice;
		Prsum = prsum;
		Prbz = prbz;
		Comptratify = comptratify;
	}

	public String getPoid() {
		return Poid;
	}

	public void setPoid(String poid) {
		Poid = poid;
	}

	public String getPodd() {
		return Podd;
	}

	public void setPodd(String podd) {
		Podd = podd;
	}

	public String getPersid() {
		return Persid;
	}

	public void setPersid(String persid) {
		Persid = persid;
	}

	public String getAid() {
		return Aid;
	}

	public void setAid(String aid) {
		Aid = aid;
	}

	public String getPdate() {
		return Pdate;
	}

	public void setPdate(String pdate) {
		Pdate = pdate;
	}

	public String getPsodd() {
		return psodd;
	}

	public void setPsodd(String psodd) {
		this.psodd = psodd;
	}

	public String getPadvice() {
		return Padvice;
	}

	public void setPadvice(String padvice) {
		Padvice = padvice;
	}

	public String getPrsum() {
		return Prsum;
	}

	public void setPrsum(String prsum) {
		Prsum = prsum;
	}

	public String getPrbz() {
		return Prbz;
	}

	public void setPrbz(String prbz) {
		Prbz = prbz;
	}

	public int getComptratify() {
		return Comptratify;
	}

	public void setComptratify(int comptratify) {
		Comptratify = comptratify;
	}

}
