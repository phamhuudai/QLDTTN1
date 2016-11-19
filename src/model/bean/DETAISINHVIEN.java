package model.bean;

public class DETAISINHVIEN {
	private int maDeTai;
	private String tenDeTai;
	private String tenChuyenNganh;
	private String giaoVienHuongDan;
	private String noidungDeTai;
	
	
	public String getNoidungDeTai() {
		return noidungDeTai;
	}
	public void setNoidungDeTai(String noidungDeTai) {
		this.noidungDeTai = noidungDeTai;
	}
	public int getMaDeTai() {
		return maDeTai;
	}
	public void setMaDeTai(int maDeTai) {
		this.maDeTai = maDeTai;
	}
	public String getTenDeTai() {
		return tenDeTai;
	}
	public void setTenDeTai(String tenDeTai) {
		this.tenDeTai = tenDeTai;
	}

	
	public String getTenChuyenNganh() {
		return tenChuyenNganh;
	}
	public void setTenChuyenNganh(String tenChuyenNganh) {
		this.tenChuyenNganh = tenChuyenNganh;
	}
	public String getGiaoVienHuongDan() {
		return giaoVienHuongDan;
	}
	public void setGiaoVienHuongDan(String giaoVienHuongDan) {
		this.giaoVienHuongDan = giaoVienHuongDan;
	}
	public DETAISINHVIEN(int maDeTai, String tenDeTai, String tenChuyenNganh,
			String giaoVienHuongDan) {
		super();
		this.maDeTai = maDeTai;
		this.tenDeTai = tenDeTai;
		this.tenChuyenNganh = tenChuyenNganh;
		this.giaoVienHuongDan = giaoVienHuongDan;
	}
	public DETAISINHVIEN(int maDeTai, String tenDeTai,
			String tenChuyenNganh, String giaoVienHuongDan, String noidungDeTai) {
		super();
		this.maDeTai = maDeTai;
		this.tenDeTai = tenDeTai;
		this.tenChuyenNganh = tenChuyenNganh;
		this.giaoVienHuongDan = giaoVienHuongDan;
		this.noidungDeTai = noidungDeTai;
	}
	
	
	
}
