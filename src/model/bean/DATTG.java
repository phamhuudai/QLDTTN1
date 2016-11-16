package model.bean;

import java.util.Date;

public class DATTG {
	private int maDot;
	private Date thoiGianBD;
	private Date thoiGianKT;
	private int thoiGianTH;
	public int getMaDot() {
		return maDot;
	}
	public void setMaDot(int maDot) {
		this.maDot = maDot;
	}
	public Date getThoiGianBD() {
		return thoiGianBD;
	}
	public void setThoiGianBD(Date thoiGianBD) {
		this.thoiGianBD = thoiGianBD;
	}
	public Date getThoiGianKT() {
		return thoiGianKT;
	}
	public void setThoiGianKT(Date thoiGianKT) {
		this.thoiGianKT = thoiGianKT;
	}
	public int getThoiGianTH() {
		return thoiGianTH;
	}
	public void setThoiGianTH(int thoiGianTH) {
		this.thoiGianTH = thoiGianTH;
	}
	public DATTG(int maDot, Date thoiGianBD, Date thoiGianKT, int thoiGianTH) {
		super();
		this.maDot = maDot;
		this.thoiGianBD = thoiGianBD;
		this.thoiGianKT = thoiGianKT;
		this.thoiGianTH = thoiGianTH;
	}
	
	
}
