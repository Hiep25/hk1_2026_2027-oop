package tuan7.GiaoDich;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

abstract class GiaoDich {
	protected String maGiaoDich;
	protected LocalDate ngayGiaoDich;
	protected double donGia;
	protected double dienTich;
	/**
	 * @param maGiaoDich
	 * @param ngayGiaoDich
	 * @param donGia
	 * @param dienTich
	 */
	public GiaoDich(String maGiaoDich, LocalDate ngayGiaoDich, double donGia, double dienTich) {
		super();
		this.maGiaoDich = maGiaoDich;
		this.ngayGiaoDich = ngayGiaoDich;
		this.donGia = donGia;
		this.dienTich = dienTich;
	}
	
	//Phuong thuc truu tuong
	public abstract double thanhTien();
	
	//Getter can thiet de truy xuat tu ben ngoai
	public String getMaGiaoDich() {return maGiaoDich;}
	public LocalDate getNgayGiaoDich() {return ngayGiaoDich;}

	//toString()
	@Override
	public String toString() {
		return String.format("Ma: %6s | Ngay: %s | Dongia: %,.0f | DT: %.1f | Thanhtien: %,.0f",
				maGiaoDich,ngayGiaoDich.format(DateTimeFormatter.ofPattern("dd//MM/yyyy")),donGia, dienTich, thanhTien());
	}
	
}
