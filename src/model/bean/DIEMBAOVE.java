package model.bean;

public class DIEMBAOVE {
	private int mssv1;
	private int mssv2;
	private String tenSinhVien1;
	private String tenSinhVien2;
	private String tenDeTai;
	
	private String tenHoiDong;
	private float diem1;
	private float diem2;
	private float diem3;
	private int maGVHD1;
	private int maGVHD2;
	private int maGVHD3;
	private int maHDBV;
	private String nhanXet;
	private String tenGV1;
	private String tenGV2;
	private String tenGV3;
	private String maDangKy;
	

	public int getMssv1() {
		return mssv1;
	}
	public void setMssv1(int mssv1) {
		this.mssv1 = mssv1;
	}
	public int getMssv2() {
		return mssv2;
	}
	public void setMssv2(int mssv2) {
		this.mssv2 = mssv2;
	}
	public String getTenSinhVien1() {
		return tenSinhVien1;
	}
	public void setTenSinhVien1(String tenSinhVien1) {
		this.tenSinhVien1 = tenSinhVien1;
	}
	public String getTenSinhVien2() {
		return tenSinhVien2;
	}
	public void setTenSinhVien2(String tenSinhVien2) {
		this.tenSinhVien2 = tenSinhVien2;
	}
	public String getTenDeTai() {
		return tenDeTai;
	}
	public void setTenDeTai(String tenDeTai) {
		this.tenDeTai = tenDeTai;
	}
	public String getTenHoiDong() {
		return tenHoiDong;
	}
	public void setTenHoiDong(String tenHoiDong) {
		this.tenHoiDong = tenHoiDong;
	}
	public float getDiem1() {
		return diem1;
	}
	public void setDiem1(float diem1) {
		this.diem1 = diem1;
	}
	public float getDiem2() {
		return diem2;
	}
	public void setDiem2(float diem2) {
		this.diem2 = diem2;
	}
	public float getDiem3() {
		return diem3;
	}
	public void setDiem3(float diem3) {
		this.diem3 = diem3;
	}
	public int getMaGVHD1() {
		return maGVHD1;
	}
	public void setMaGVHD1(int maGVHD1) {
		this.maGVHD1 = maGVHD1;
	}
	public int getMaHDBV() {
		return maHDBV;
	}
	public void setMaHDBV(int maHDBV) {
		this.maHDBV = maHDBV;
	}
	public String getNhanXet() {
		return nhanXet;
	}
	public void setNhanXet(String nhanXet) {
		this.nhanXet = nhanXet;
	}
	public String getTenGV1() {
		return tenGV1;
	}
	public void setTenGV1(String tenGV1) {
		this.tenGV1 = tenGV1;
	}
	public String getTenGV2() {
		return tenGV2;
	}
	public void setTenGV2(String tenGV2) {
		this.tenGV2 = tenGV2;
	}
	public String getTenGV3() {
		return tenGV3;
	}
	public void setTenGV3(String tenGV3) {
		this.tenGV3 = tenGV3;
	}
	public String getMaDangKy() {
		return maDangKy;
	}
	public void setMaDangKy(String maDangKy) {
		this.maDangKy = maDangKy;
	}
	public int getMaGVHD2() {
		return maGVHD2;
	}
	public void setMaGVHD2(int maGVHD2) {
		this.maGVHD2 = maGVHD2;
	}
	public int getMaGVHD3() {
		return maGVHD3;
	}
	public void setMaGVHD3(int maGVHD3) {
		this.maGVHD3 = maGVHD3;
	}
	public DIEMBAOVE(int mssv1, int mssv2, String tenSinhVien1,
			String tenSinhVien2, String tenDeTai, String tenHoiDong,
			float diem1, float diem2, float diem3, int maGVHD1, int maGVHD2,
			int maGVHD3, int maHDBV, String nhanXet, String tenGV1,
			String tenGV2, String tenGV3, String maDangKy) {
		super();
		this.mssv1 = mssv1;
		this.mssv2 = mssv2;
		this.tenSinhVien1 = tenSinhVien1;
		this.tenSinhVien2 = tenSinhVien2;
		this.tenDeTai = tenDeTai;
		this.tenHoiDong = tenHoiDong;
		this.diem1 = diem1;
		this.diem2 = diem2;
		this.diem3 = diem3;
		this.maGVHD1 = maGVHD1;
		this.maGVHD2 = maGVHD2;
		this.maGVHD3 = maGVHD3;
		this.maHDBV = maHDBV;
		this.nhanXet = nhanXet;
		this.tenGV1 = tenGV1;
		this.tenGV2 = tenGV2;
		this.tenGV3 = tenGV3;
		this.maDangKy = maDangKy;
	}
	public DIEMBAOVE(int mssv1, int mssv2, String tenSinhVien1,
			String tenSinhVien2, String tenDeTai, float diem1, float diem2,
			float diem3, int maGVHD1, int maGVHD2, int maGVHD3, String tenGV1,
			String tenGV2, String tenGV3) {
		super();
		this.mssv1 = mssv1;
		this.mssv2 = mssv2;
		this.tenSinhVien1 = tenSinhVien1;
		this.tenSinhVien2 = tenSinhVien2;
		this.tenDeTai = tenDeTai;
		this.diem1 = diem1;
		this.diem2 = diem2;
		this.diem3 = diem3;
		this.maGVHD1 = maGVHD1;
		this.maGVHD2 = maGVHD2;
		this.maGVHD3 = maGVHD3;
		this.tenGV1 = tenGV1;
		this.tenGV2 = tenGV2;
		this.tenGV3 = tenGV3;
	}
	
}