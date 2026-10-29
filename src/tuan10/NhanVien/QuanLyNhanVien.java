package tuan10.NhanVien;

import java.util.ArrayList;
import java.util.List;

class QuanLyNhanVien {
    private List<NhanVien> danhSach = new ArrayList<>();

    // a) Thêm nhân viên (kiểm tra trùng mã)
    public void themNhanVien(NhanVien nv) {
        if (nv == null) throw new IllegalArgumentException("Nhân viên null!");
        if (timTheoMa(nv.getMaNV()) != null)
            throw new IllegalArgumentException("Mã NV đã tồn tại: " + nv.getMaNV());
        danhSach.add(nv);
    }

    // Hàm phụ tìm theo mã
    public NhanVien timTheoMa(String maNV) {
        for (NhanVien nv : danhSach)
            if (nv.getMaNV().equalsIgnoreCase(maNV)) return nv;
        return null;
    }

    // b) Xóa theo mã
    public boolean xoaNhanVien(String maNV) {
        return danhSach.removeIf(nv -> nv.getMaNV().equalsIgnoreCase(maNV));
    }

    // c) Sửa theo mã
    public boolean suaNhanVien(String maNV, NhanVien nvMoi) {
        for (int i = 0; i < danhSach.size(); i++) {
            if (danhSach.get(i).getMaNV().equalsIgnoreCase(maNV)) {
                // Giữ nguyên mã NV, cập nhật thông tin khác
                danhSach.set(i, nvMoi);
                return true;
            }
        }
        return false;
    }

    public List<NhanVien> getDanhSach() { return danhSach; }
}