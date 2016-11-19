package model.bean;

import java.util.Date;

public class SINHVIEN {
	private int mssv;
	private String hoTen;
	private Date ngaySinh;
	private int maLop;
	private int maCN;
	
	private String tenLop;
	private String chuyenNganh;
	private String diaChi;
	
	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	

	public SINHVIEN(int mssv, String diaChi, String email, String sdt) {
		super();
		this.mssv = mssv;
		this.diaChi = diaChi;
		this.email = email;
		this.sdt = sdt;
	}

	
	public SINHVIEN(int mssv, String hoTen, Date ngaySinh, int maLop, int maCN,
			String tenLop, String chuyenNganh, String diaChi, String email,
			String sdt) {
		super();
		this.mssv = mssv;
		this.hoTen = hoTen;
		this.ngaySinh = ngaySinh;
		this.maLop = maLop;
		this.maCN = maCN;
		this.tenLop = tenLop;
		this.chuyenNganh = chuyenNganh;
		this.diaChi = diaChi;
		this.email = email;
		this.sdt = sdt;
	}

	public SINHVIEN(int mssv, String hoTen, Date ngaySinh, String tenLop,
			String chuyenNganh, String email, String sdt) {
		super();
		this.mssv = mssv;
		this.hoTen = hoTen;
		this.ngaySinh = ngaySinh;
		this.tenLop = tenLop;
		this.chuyenNganh = chuyenNganh;
		this.email = email;
		this.sdt = sdt;
	}
	
	public String getTenLop() {
		return tenLop;
	}
	public void setTenLop(String tenLop) {
		this.tenLop = tenLop;
	}
	public String getChuyenNganh() {
		return chuyenNganh;
	}
	public void setChuyenNganh(String chuyenNganh) {
		this.chuyenNganh = chuyenNganh;
	}
	private String email;
	private String sdt;
	public int getMssv() {
		return mssv;
	}
	public void setMssv(int mssv) {
		this.mssv = mssv;
	}
	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	public Date getNgaySinh() {
		return ngaySinh;
	}
	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}
	public int getMaLop() {
		return maLop;
	}
	public void setMaLop(int maLop) {
		this.maLop = maLop;
	}
	public int getMaCN() {
		return maCN;
	}
	public void setMaCN(int maCN) {
		this.maCN = maCN;
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
	public SINHVIEN(int mssv, String hoTen, Date ngaySinh, int maLop,
			int maCN, String email, String sdt) {
		super();
		this.mssv = mssv;
		this.hoTen = hoTen;
		this.ngaySinh = ngaySinh;
		this.maLop = maLop;
		this.maCN = maCN;
		this.email = email;
		this.sdt = sdt;
	}
	
	
}
