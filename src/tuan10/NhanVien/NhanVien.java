package tuan10.NhanVien;

import java.util.*;

//================= LỚP TRỪU TƯỢNG =================
abstract class NhanVien {
 protected String maNV;
 protected String hoTen;
 protected int namSinh;
 protected String diaChi;

 public NhanVien(String maNV, String hoTen, int namSinh, String diaChi) {
     if (maNV == null || maNV.trim().isEmpty())
         throw new IllegalArgumentException("Mã NV không được rỗng!");
     if (hoTen == null || hoTen.trim().isEmpty())
         throw new IllegalArgumentException("Họ tên không được rỗng!");
     int namHienTai = java.time.Year.now().getValue();
     if (namSinh < 1900 || namSinh > namHienTai - 18)
         throw new IllegalArgumentException("Năm sinh không hợp lệ (phải >= 18 tuổi)!");
     this.maNV = maNV.trim();
     this.hoTen = hoTen.trim();
     this.namSinh = namSinh;
     this.diaChi = diaChi;
 }

 public String getMaNV() { return maNV; }
 public String getHoTen() { return hoTen; }
 public int getNamSinh() { return namSinh; }

 // Phương thức trừu tượng
 public abstract double getLuong();

 // Phương thức hiển thị chung
 public void hienThi() {
     System.out.printf("Mã: %s | Tên: %s | Năm sinh: %d | Địa chỉ: %s | Lương: %.0f%n",
             maNV, hoTen, namSinh, diaChi, getLuong());
 }

 @Override
 public String toString() { return maNV + " - " + hoTen; }
}

//================= LỚP CON HÀNH CHÍNH =================
class NhanVienHC extends NhanVien {
 private int bacLuong;   // bậc lương
 private double phuCap;  // phụ cấp

 public NhanVienHC(String maNV, String hoTen, int namSinh, String diaChi,
                   int bacLuong, double phuCap) {
     super(maNV, hoTen, namSinh, diaChi);
     if (bacLuong < 1 || bacLuong > 10)
         throw new IllegalArgumentException("Bậc lương phải từ 1 đến 10!");
     if (phuCap < 0)
         throw new IllegalArgumentException("Phụ cấp không được âm!");
     this.bacLuong = bacLuong;
     this.phuCap = phuCap;
 }

 public int getBacLuong() { return bacLuong; }
 public double getPhuCap() { return phuCap; }

 // Công thức: bậc lương * 1.800.000 + phụ cấp
 @Override
 public double getLuong() {
     return bacLuong * 1_800_000 + phuCap;
 }
}

//================= LỚP CON THỜI VỤ =================
class NhanVienTV extends NhanVien {
 private double luongThang;   // lương tháng
 private int soThangLamViec;  // số tháng làm việc

 public NhanVienTV(String maNV, String hoTen, int namSinh, String diaChi,
                   double luongThang, int soThangLamViec) {
     super(maNV, hoTen, namSinh, diaChi);
     if (luongThang < 0)
         throw new IllegalArgumentException("Lương tháng không được âm!");
     if (soThangLamViec < 1 || soThangLamViec > 12)
         throw new IllegalArgumentException("Số tháng làm việc phải từ 1 đến 12!");
     this.luongThang = luongThang;
     this.soThangLamViec = soThangLamViec;
 }

 public double getLuongThang() { return luongThang; }
 public int getSoThangLamViec() { return soThangLamViec; }

 // Công thức: lương tháng * số tháng làm việc
 @Override
 public double getLuong() {
     return luongThang * soThangLamViec;
 }
}