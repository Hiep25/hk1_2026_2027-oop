package tuan1.BaiHCN;

public class HinhChuNhat {

	private double chieuDai;
	private double chieuRong;
	
	public double getChieuDai() {
		return chieuDai;
	}

	public void setChieuDai(double CD)throws Exception {
		if (CD>0) {
			this.chieuDai = chieuDai;
		} else {
			throw new Exception("Loi");
		}
	}

	public double getChieuRong() {
		return chieuRong;
	}

	public void setChieuRong(double chieuRong) {
		this.chieuRong = chieuRong;
	}

	/**
	 * 
	 */
	public HinhChuNhat() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param chieuDai
	 * @param chieuRong
	 */
	public HinhChuNhat(double chieuDai, double chieuRong) {
		super();
		this.chieuDai = chieuDai;
		this.chieuRong = chieuRong;
	}
	
	public double getDT() {
		return this.chieuDai * this.chieuRong;
	}

	public double getCV() {
		return (this.chieuDai + this.chieuRong)*2;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HinhChuNhat h1 = new HinhChuNhat(7,5);
		System.out.println(h1.getChieuDai());
		System.out.println(h1.chieuRong);
		System.out.println("Chu vi hinh chu nhat");
		System.out.println(h1.getCV());
		System.out.println("Dien tich hinh chu nhat");
		System.out.println(h1.getDT());
	}

}
