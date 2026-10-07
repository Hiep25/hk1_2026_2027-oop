package tuan7.GiaoDich;

import java.time.LocalDate;

class GiaoDichNha extends GiaoDich {
    private String loaiNha; // "cao cấp", "thường"
    private String diaChi;

    public GiaoDichNha(String ma, LocalDate ngay, double donGia,
                       double dienTich, String loaiNha, String diaChi) {
        super(ma, ngay, donGia, dienTich);
        this.loaiNha = loaiNha;
        this.diaChi = diaChi;
    }

    @Override
    public double thanhTien() {
        if (loaiNha.equalsIgnoreCase("cao cấp")) {
            return dienTich * donGia;
        }
        // Loại thường: giảm còn 90%
        return dienTich * donGia * 0.9;
    }

    @Override
    public String toString() {
        return "[NHA] " + super.toString()
                + " | Loại: " + loaiNha + " | DC: " + diaChi;
    }
}
