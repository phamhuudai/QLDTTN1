package model.bean;

public class CHUYENNGANH {
	private int macn;
	private String tencn;
	public CHUYENNGANH(int macn, String tencn) {
		super();
		this.macn = macn;
		this.tencn = tencn;
	}
	public CHUYENNGANH() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getMacn() {
		return macn;
	}
	public void setMacn(int macn) {
		this.macn = macn;
	}
	public String getTencn() {
		return tencn;
	}
	public void setTencn(String tencn) {
		this.tencn = tencn;
	}
	
	
}
