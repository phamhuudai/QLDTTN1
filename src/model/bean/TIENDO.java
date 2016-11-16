package model.bean;

public class TIENDO {
	private int maDeTai;
	private String tenDeTai;
	private String tenCN;
	private String gvhd;
	private float tienDo;
	public TIENDO(int maDeTai, String tenDeTai, String tenCN, String gvhd,
			float tienDo) {
		super();
		this.maDeTai = maDeTai;
		this.tenDeTai = tenDeTai;
		this.tenCN = tenCN;
		this.gvhd = gvhd;
		this.tienDo = tienDo;
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
	public String getTenCN() {
		return tenCN;
	}
	public void setTenCN(String tenCN) {
		this.tenCN = tenCN;
	}
	public String getGvhd() {
		return gvhd;
	}
	public void setGvhd(String gvhd) {
		this.gvhd = gvhd;
	}
	public float getTienDo() {
		return tienDo;
	}
	public void setTienDo(float tienDo) {
		this.tienDo = tienDo;
	}
	

}
