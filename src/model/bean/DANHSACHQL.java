package model.bean;

public class DANHSACHQL {
	private String tenSV;
	private int maSV;
	private String lop;
	private String email;
	private String sdt;
	private String tenCN;
	private String tenDT;
	public String getTenSV() {
		return tenSV;
	}
	public void setTenSV(String tenSV) {
		this.tenSV = tenSV;
	}
	public String getLop() {
		return lop;
	}
	public void setLop(String lop) {
		this.lop = lop;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSdt() {
		return sdt;
	}
	public void setSdt(String sdt) {
		this.sdt = sdt;
	}
	public String getTenCN() {
		return tenCN;
	}
	public void setTenCN(String tenCN) {
		this.tenCN = tenCN;
	}
	public String getTenDT() {
		return tenDT;
	}
	public void setTenDT(String tenDT) {
		this.tenDT = tenDT;
	}
	public DANHSACHQL(String tenSV,int maSV, String lop, String email, String sdt,
			String tenCN, String tenDT) {
		super();
		this.tenSV = tenSV;
		this.maSV=maSV;
		this.lop = lop;
		this.email = email;
		this.sdt = sdt;
		this.tenCN = tenCN;
		this.tenDT = tenDT;
	}
	public int getMaSV() {
		return maSV;
	}
	public void setMaSV(int maSV) {
		this.maSV = maSV;
	}
	
}
