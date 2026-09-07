package tuan3.BaiHangThucPham;


import java.time.LocalDate;
import java.util.Scanner;

public class HangThucPham {

    // Khai báo thuộc tính
    private int id;
    private String maHang = "";       // final -> không thể sửa
    private String tenHang;
    private LocalDate ngaySanXuat;
    private LocalDate ngayHetHan;
    private float gia;
    private static int demSoLuong = 0;

    // Constructor mặc định
    public HangThucPham() {
        this.id = ++demSoLuong;
        this.maHang = "MAC_DINH";
        this.tenHang = "Hàng mặc định";
        this.ngaySanXuat = LocalDate.now();
        this.ngayHetHan = LocalDate.now().plusDays(7);
        this.gia = 1.0f;
    }

    // Kiểm tra ngày sản xuất
    private boolean kiemTraNgaySanXuat(LocalDate ngaySX) {
        return ngaySX != null && !ngaySX.isAfter(LocalDate.now());
    }

    // Kiểm tra ngày hết hạn
    private boolean kiemTraNgayHetHan(LocalDate ngaySX, LocalDate ngayHH) {
        return ngaySX != null && ngayHH != null && ngayHH.isAfter(ngaySX);
    }

    // Constructor có tham số
    public HangThucPham(String maHang, String tenHang,
                        LocalDate ngaySanXuat,
                        LocalDate ngayHetHan,
                        float gia) {

        this.id = ++demSoLuong;

        if (maHang == null || maHang.trim().isEmpty())
            throw new IllegalArgumentException(
                    "Mã hàng không được để trống!");

        if (tenHang == null || tenHang.trim().isEmpty())
            throw new IllegalArgumentException(
                    "Tên hàng không được để trống!");

        if (gia <= 0)
            throw new IllegalArgumentException(
                    "Giá phải lớn hơn 0!");

        if (!kiemTraNgaySanXuat(ngaySanXuat))
            throw new IllegalArgumentException(
                    "Ngày sản xuất không được là ngày trong tương lai!");

        if (!kiemTraNgayHetHan(ngaySanXuat, ngayHetHan))
            throw new IllegalArgumentException(
                    "Ngày hết hạn phải sau ngày sản xuất!");

        this.maHang = maHang;
        this.tenHang = tenHang;
        this.ngaySanXuat = ngaySanXuat;
        this.ngayHetHan = ngayHetHan;
        this.gia = gia;
    }

    // Getter
    public int getId() {
        return id;
    }

    public String getMaHang() {
        return maHang;
    }

    public String getTenHang() {
        return tenHang;
    }

    public LocalDate getNgaySanXuat() {
        return ngaySanXuat;
    }

    public LocalDate getNgayHetHan() {
        return ngayHetHan;
    }

    public float getGia() {
        return gia;
    }

    // Setter (không có setMaHang)
    public void setTenHang(String tenHang) {
        if (tenHang == null || tenHang.trim().isEmpty())
            throw new IllegalArgumentException(
                    "Tên hàng không được để trống!");

        this.tenHang = tenHang;
    }

    public void setNgaySanXuat(LocalDate ngaySanXuat) {
        if (!kiemTraNgaySanXuat(ngaySanXuat))
            throw new IllegalArgumentException(
                    "Ngày sản xuất không được là tương lai!");

        if (this.ngayHetHan != null
                && !kiemTraNgayHetHan(ngaySanXuat, this.ngayHetHan))
            throw new IllegalArgumentException(
                    "Ngày sản xuất phải trước ngày hết hạn!");

        this.ngaySanXuat = ngaySanXuat;
    }

    public void setNgayHetHan(LocalDate ngayHetHan) {
        if (this.ngaySanXuat == null)
            throw new IllegalArgumentException(
                    "Chưa có ngày sản xuất để so sánh!");

        if (!kiemTraNgayHetHan(this.ngaySanXuat, ngayHetHan))
            throw new IllegalArgumentException(
                    "Ngày hết hạn phải sau ngày sản xuất!");

        this.ngayHetHan = ngayHetHan;
    }

    public void setGia(float gia) {
        if (gia <= 0)
            throw new IllegalArgumentException(
                    "Giá phải lớn hơn 0!");

        this.gia = gia;
    }

    // Kiểm tra hết hạn
    public boolean kiemTraHetHan() {
        return LocalDate.now().isAfter(this.ngayHetHan);
    }

    // Trạng thái chi tiết
    public String trangThaiChiTiet() {
        LocalDate homNay = LocalDate.now();

        if (homNay.isBefore(ngaySanXuat))
            return "Chưa sản xuất";

        if (homNay.isAfter(ngayHetHan))
            return "Hết hạn";

        if (homNay.isEqual(ngayHetHan))
            return "Hết hạn hôm nay";

        long con = ngayHetHan.toEpochDay() - homNay.toEpochDay();

        return "Còn " + con + " ngày";
    }

    @Override
    public String toString() {
        return "HangThucPham{" +
                "id=" + id +
                ", maHang='" + maHang + '\'' +
                ", tenHang='" + tenHang + '\'' +
                ", ngaySX=" + ngaySanXuat +
                ", ngayHH=" + ngayHetHan +
                ", gia=" + gia +
                '}';
    }

    public static void main(String[] args) {

        HangThucPham htp1 = new HangThucPham();

        Scanner sc = new Scanner(System.in);

        HangThucPham htp2 = new HangThucPham(
                "HP123456",
                "May Tinh",
                LocalDate.of(2015, 12, 12),
                LocalDate.now(),
                12000000
        );

        System.out.println(htp1.toString());
        System.out.println(htp2.toString());
    }
}