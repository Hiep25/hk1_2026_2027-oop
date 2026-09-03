package tuan1.BaiHinhTron;

public class HinhTron {

	private ToaDo tam;
	private double banKinh;
	public final double PI = 3.1416;
	
	public ToaDo getTam() {
		return tam;
	}

	public void setTam(ToaDo tam) {
		this.tam = tam;
	}

	public double getBanKinh() {
		return banKinh;
	}

	public void setBanKinh(double banKinh) {
		this.banKinh = banKinh;
	}

	/**
	 * @param tam
	 * @param banKinh
	 */
	public HinhTron(ToaDo tam, double banKinh) {
		super();
		this.tam = tam;
		this.banKinh = banKinh;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HinhTron h1 = new HinhTron(new ToaDo("0", 3, 4), 12);
		System.out.println("Thong tin hinh tron");
		System.out.println("Ban kinh la");
		System.out.println(h1.banKinh);
		System.out.println("Tam la:"+h1.tam.getTen());
	}

}
