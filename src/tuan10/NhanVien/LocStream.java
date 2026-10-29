package tuan10.NhanVien;

import java.util.*;
import java.util.stream.Collectors;

class LocStream {

    // a) Lương > 10.000.000
    public static List<NhanVien> locLuongTren10Trieu(List<NhanVien> ds) {
        return ds.stream()
                 .filter(nv -> nv.getLuong() > 10_000_000)
                 .collect(Collectors.toList());
    }

    // b) Thời vụ có số tháng >= 6
    public static List<NhanVien> locThoiVuTu6Thang(List<NhanVien> ds) {
        return ds.stream()
                 .filter(nv -> nv instanceof NhanVienTV)
                 .map(nv -> (NhanVienTV) nv)
                 .filter(tv -> tv.getSoThangLamViec() >= 6)
                 .collect(Collectors.toList());
    }

    // c) Hành chính có phụ cấp > 0, sắp xếp bậc lương giảm dần
    public static List<NhanVien> locHanhChinhCoPhuCap(List<NhanVien> ds) {
        return ds.stream()
                 .filter(nv -> nv instanceof NhanVienHC)
                 .map(nv -> (NhanVienHC) nv)
                 .filter(hc -> hc.getPhuCap() > 0)
                 .sorted(Comparator.comparingInt(NhanVienHC::getBacLuong).reversed())
                 .collect(Collectors.toList());
    }
}