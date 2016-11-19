package model.bean;

import java.util.Date;

public class SINHVIENDANGKYDETAI {
	private int MDK;
	private int MDT;
	private boolean hinhThuc;
	private int MSSV1;
	private int MSSV2;
	private Date ngayDK;
	public int getMDK() {
		return MDK;
	}
	public void setMDK(int mDK) {
		MDK = mDK;
	}
	public int getMDT() {
		return MDT;
	}
	public void setMDT(int mDT) {
		MDT = mDT;
	}
	public boolean isHinhThuc() {
		return hinhThuc;
	}
	public void setHinhThuc(boolean hinhThuc) {
		this.hinhThuc = hinhThuc;
	}
	public int getMSSV1() {
		return MSSV1;
	}
	public void setMSSV1(int mSSV1) {
		MSSV1 = mSSV1;
	}
	public int getMSSV2() {
		return MSSV2;
	}
	public void setMSSV2(int mSSV2) {
		MSSV2 = mSSV2;
	}
	public Date getNgayDK() {
		return ngayDK;
	}
	public void setNgayDK(Date ngayDK) {
		this.ngayDK = ngayDK;
	}
	public SINHVIENDANGKYDETAI(int mDK, int mDT, boolean hinhThuc, int mSSV1,
			int mSSV2, Date ngayDK) {
		super();
		MDK = mDK;
		MDT = mDT;
		this.hinhThuc = hinhThuc;
		MSSV1 = mSSV1;
		MSSV2 = mSSV2;
		this.ngayDK = ngayDK;
	}
	public SINHVIENDANGKYDETAI(int mDK, int mDT, boolean hinhThuc, int mSSV1,
			Date ngayDK) {
		super();
		MDK = mDK;
		MDT = mDT;
		this.hinhThuc = hinhThuc;
		MSSV1 = mSSV1;
		this.ngayDK = ngayDK;
	}
	
	
	
	
	
}
