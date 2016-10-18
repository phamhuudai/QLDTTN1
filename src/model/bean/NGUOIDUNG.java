package model.bean;

public class NGUOIDUNG {
	private int maSo;
	private String pass;
	private String phanQuyen;
	public NGUOIDUNG(int maSo, String pass, String phanQuyen) {
		super();
		this.maSo = maSo;
		this.pass = pass;
		this.phanQuyen = phanQuyen;
	}
	public int getMaSo() {
		return maSo;
	}
	public void setMaSo(int maSo) {
		this.maSo = maSo;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getPhanQuyen() {
		return phanQuyen;
	}
	public void setPhanQuyen(String phanQuyen) {
		this.phanQuyen = phanQuyen;
	}
	

}
