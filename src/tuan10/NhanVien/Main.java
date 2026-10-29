package tuan10.NhanVien;

public class Main {
    public static void main(String[] args) {
        QuanLyNhanVien ql = new QuanLyNhanVien();

        ql.themNhanVien(new NhanVienHC("NV01", "Nguyễn Văn An", 1990,
                "Hà Nội", 5, 2_000_000));
        ql.themNhanVien(new NhanVienHC("NV02", "Trần Thị Bình", 1995,
                "Hải Phòng", 4, 1_500_000));
        ql.themNhanVien(new NhanVienTV("NV03", "Lê Văn Cường", 2000,
                "Đà Nẵng", 4_000_000, 8));
        ql.themNhanVien(new NhanVienTV("NV04", "Phạm Thị Dung", 1998,
                "TP.HCM", 5_000_000, 6));
        ql.themNhanVien(new NhanVienHC("NV05", "Nguyễn Văn An", 1988,
                "Huế", 7, 0)); // trùng tên để kiểm tra sắp xếp

        // Hiển thị (đa hình)
        System.out.println("=== DANH SÁCH BAN ĐẦU ===");
        ql.getDanhSach().forEach(NhanVien::hienThi);

        // Sắp xếp theo lương tăng dần
        System.out.println("\n=== SẮP XẾP LƯƠNG TĂNG DẦN ===");
        SapXep.sapXepTheoLuongTangDan(ql.getDanhSach());
        ql.getDanhSach().forEach(NhanVien::hienThi);

        // Lọc lương > 10 triệu
        System.out.println("\n=== LƯƠNG > 10 TRIỆU ===");
        LocStream.locLuongTren10Trieu(ql.getDanhSach()).forEach(NhanVien::hienThi);

        // Thống kê
        System.out.println("\n=== ĐẾM THEO LOẠI ===");
        System.out.println(ThongKe.demTheoLoai(ql.getDanhSach()));

        System.out.println("\n=== TỔNG LƯƠNG THEO LOẠI ===");
        System.out.println(ThongKe.tongLuongTheoLoai(ql.getDanhSach()));

        System.out.println("\n=== NHÂN VIÊN LƯƠNG CAO NHẤT ===");
        ThongKe.nhanVienLuongCaoNhat(ql.getDanhSach()).ifPresent(NhanVien::hienThi);
    }
}