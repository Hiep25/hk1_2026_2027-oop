package tuan2.BaiSinhVien;

public class DiemSinhVien {
	private int maSinhVien;
	private String hoTen;
	private float diemLT;
	private float diemTH;
	public DiemSinhVien(int maSinhVien, String hoTen, float diemLT, float diemTH) {
		setMaSinhVien(maSinhVien);
		setHoTen(hoTen);
		setDiemLT(diemLT);
		setDiemTH(diemTH);
	}
	public DiemSinhVien() {
		this.maSinhVien = 0;
		this.hoTen = "no name";
		this.diemLT = 0;
		this.diemTH = 0;
	}
	public int getMaSinhVien() {
		return maSinhVien;
	}
	public void setMaSinhVien(int maSinhVien) {
		if (maSinhVien > 0) {
			this.maSinhVien = maSinhVien;
		}
		else {
			this.maSinhVien = 0;
		}
	}
	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		if (!hoTen.isEmpty()) {
			this.hoTen = hoTen;
		}
		else {
			this.hoTen = "no name";
		}
	}
	public float getDiemLT() {
		return diemLT;
	}
	public void setDiemLT(float diemLT) {
		if (diemLT >= 0 && diemLT <= 10) {
			this.diemLT = diemLT;
		}
		else {
			this.diemLT = 0;
		}
	}
	public float getDiemTH() {
		return diemTH;
	}
	public void setDiemTH(float diemTH) {
		if (diemTH >= 0 && diemTH <= 10) {
			this.diemTH = diemTH;
		}
		else {
			this.diemTH = 0;
		}
	}
	public float tinhDiemTrungBinh() {
		return (this.diemLT+this.diemTH)/2;
	}
	public String getTitle() {
		return String.format("%-10s %-20s %10s %10s %10s", "MSSV","HoTen","DiemLT","DiemTH","DiemTB");
	}
	public String toString() {
		return String.format("%-10d %-20s %10.2f %10.2f %10.2f", maSinhVien,hoTen,diemLT,diemTH,tinhDiemTrungBinh());
	}
	
}
