package model.bean;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;

public class DETAI {
	private int madetai;
	private String tendetai;
	private int macn;
	private String thongtinnoidung;
	private int magvhd;
	private String tenCN;
	private String tenGVHD;
	public DETAI(int madetai, String tendetai, int macn,String thongtinnoidung,int magvhd, String tenCN, String tenGVHD) {
		super();
		this.madetai = madetai;
		this.tendetai = tendetai;
		this.macn = macn;
		this.thongtinnoidung = thongtinnoidung;
		this.magvhd = magvhd;
		this.tenCN = tenCN;
		this.tenGVHD=tenGVHD;
	}

	public DETAI (int madetai, String tendetai, int macn,String thongtinnoidung, int magvhd) {
		this.madetai = madetai;
		this.tendetai = tendetai;
		this.macn = macn;
		this.thongtinnoidung = thongtinnoidung;
		this.magvhd = magvhd;

	}
	
	public String getTenGVHD() {
		return tenGVHD;
	}

	public void setTenGVHD(String tenGVHD) {
		this.tenGVHD = tenGVHD;
	}

	public String getTenCN() {
		return tenCN;
	}

	public void setTenCN(String tenCN) {
		this.tenCN = tenCN;
	}

	

	public int getMadetai() {
		return madetai;
	}
	public void setMadetai(int madetai) {
		this.madetai = madetai;
	}
	public String getTendetai() {
		return tendetai;
	}
	public void setTendetai(String tendetai) {
		this.tendetai = tendetai;
	}
	public int getMacn() {
		return macn;
	}
	public void setMacn(int macn) {
		this.macn = macn;
	}
	public String getThongtinnoidung() {
		return thongtinnoidung;
	}
	public void setThongtinnoidung(String thongtinnoidung) {
		this.thongtinnoidung = thongtinnoidung;
	}
	public int getMagvhd() {
		return magvhd;
	}
	public void setMagvhd(int magvhd) {
		this.magvhd = magvhd;
	}
	
}
