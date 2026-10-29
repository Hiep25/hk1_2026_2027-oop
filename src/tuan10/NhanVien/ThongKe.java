package tuan10.NhanVien;

import java.util.*;
import java.util.stream.Collectors;

class ThongKe {

    // a) Đếm số lượng theo loại nhân viên
    public static Map<String, Long> demTheoLoai(List<NhanVien> ds) {
        return ds.stream()
                 .collect(Collectors.groupingBy(
                         nv -> nv instanceof NhanVienHC ? "Hành chính" : "Thời vụ",
                         Collectors.counting()));
    }

    // b) Tổng lương theo loại nhân viên
    public static Map<String, Double> tongLuongTheoLoai(List<NhanVien> ds) {
        return ds.stream()
                 .collect(Collectors.groupingBy(
                         nv -> nv instanceof NhanVienHC ? "Hành chính" : "Thời vụ",
                         Collectors.summingDouble(NhanVien::getLuong)));
    }

    // c) Nhân viên có lương cao nhất
    public static Optional<NhanVien> nhanVienLuongCaoNhat(List<NhanVien> ds) {
        return ds.stream()
                 .max(Comparator.comparingDouble(NhanVien::getLuong));
    }
}
