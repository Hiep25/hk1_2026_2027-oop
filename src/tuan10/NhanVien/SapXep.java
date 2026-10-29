package tuan10.NhanVien;

import java.util.Comparator;
import java.util.List;

class SapXep {

    // a) Lương tăng dần
    public static void sapXepTheoLuongTangDan(List<NhanVien> ds) {
        ds.sort(Comparator.comparingDouble(NhanVien::getLuong));
        // hoặc: Collections.sort(ds, Comparator.comparingDouble(NhanVien::getLuong));
    }

    // b) Họ tên alphabet; trùng tên → năm sinh tăng dần
    public static void sapXepTheoTenVaNamSinh(List<NhanVien> ds) {
        ds.sort(Comparator
                .comparing(NhanVien::getHoTen)
                .thenComparingInt(NhanVien::getNamSinh));
    }

    // c) Hành chính trước, Thời vụ sau; cùng loại → lương giảm dần
    public static void sapXepTheoLoaiVaLuong(List<NhanVien> ds) {
        ds.sort(Comparator
                .comparingInt((NhanVien nv) -> (nv instanceof NhanVienHC) ? 0 : 1)
                .thenComparing(Comparator.comparingDouble(NhanVien::getLuong).reversed()));
    }
}