package model.bean;

import java.util.Date;

public class GIAOVIEN {
	private int magvhd;
	private String hoten;
	private Date ngaysinh;
	private int macn;
	private String email;
	private String sdt;
	private String diachi;
	private String tencn;
	public GIAOVIEN(int magvhd, String hoten, Date ngaysinh, int macn,
			String email, String diachi, String sdt, String tencn) {
		super();
		this.magvhd = magvhd;
		this.hoten = hoten;
		this.ngaysinh = ngaysinh;
		this.macn = macn;
		this.email = email;
		this.sdt = sdt;
		this.diachi=diachi;
		this.tencn=tencn;
	}
	public GIAOVIEN(int magvhd, String hoten, Date ngaysinh, int macn,
			String email,  String diachi, String sdt) {
		super();
		this.magvhd = magvhd;
		this.hoten = hoten;
		this.ngaysinh = ngaysinh;
		this.macn = macn;
		this.email = email;
		this.sdt = sdt;
		this.diachi = diachi;
	}
	public String getDiachi() {
		return diachi;
	}
	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}
	public String getTencn() {
		return tencn;
	}
	public void setTencn(String tencn) {
		this.tencn = tencn;
	}
	public GIAOVIEN() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getMagvhd() {
		return magvhd;
	}
	public void setMagvhd(int magvhd) {
		this.magvhd = magvhd;
	}
	public String getHoten() {
		return hoten;
	}
	public void setHoten(String hoten) {
		this.hoten = hoten;
	}
	public Date getNgaysinh() {
		return ngaysinh;
	}
	public void setNgaysinh(Date ngaysinh) {
		this.ngaysinh = ngaysinh;
	}
	public int getMacn() {
		return macn;
	}
	public void setMacn(int macn) {
		this.macn = macn;
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
	public void setDiaChi(String diachi) {
		this.diachi = diachi;
	}
	public String getDiaChi() {
		return diachi;
	}
	
}
