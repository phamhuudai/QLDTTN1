package model.bean;

import java.util.Date;

public class DANGKYDETAI {
	private int mdk;
	private int mdt;
	private int hinhthuc;
	private int mssv;
	private Date ngaydk;
	private String tenSV;
	private String tenDeTai;
	public int getMdk() {
		return mdk;
	}
	public void setMdk(int mdk) {
		this.mdk = mdk;
	}
	public int getMdt() {
		return mdt;
	}
	public void setMdt(int mdt) {
		this.mdt = mdt;
	}
	public int getHinhthuc() {
		return hinhthuc;
	}
	public void setHinhthuc(int hinhthuc) {
		this.hinhthuc = hinhthuc;
	}
	public int getMssv() {
		return mssv;
	}
	public void setMssv(int mssv) {
		this.mssv = mssv;
	}
	public Date getNgaydk() {
		return ngaydk;
	}
	public void setNgaydk(Date ngaydk) {
		this.ngaydk = ngaydk;
	}
	public String getTenSV() {
		return tenSV;
	}
	public void setTenSV(String tenSV) {
		this.tenSV = tenSV;
	}
	public String getTenDeTai() {
		return tenDeTai;
	}
	public void setTenDeTai(String tenDeTai) {
		this.tenDeTai = tenDeTai;
	}
	public DANGKYDETAI(int mdk, int mdt, int hinhthuc, int mssv,
			Date ngaydk, String tenSV, String tenDeTai) {
		super();
		this.mdk = mdk;
		this.mdt = mdt;
		this.hinhthuc = hinhthuc;
		this.mssv = mssv;
		this.ngaydk = ngaydk;
		this.tenSV = tenSV;
		this.tenDeTai = tenDeTai;
	}
	
	
	
}

