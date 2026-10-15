package tuan8.QLHoaDon;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

// ABSTRACT CLASS: KhachHang
abstract class KhachHang {
    protected String maKhachHang;
    protected String hoTen;
    protected LocalDate ngayLapHoaDon;
    protected double soKW;
    protected double donGia;

    public KhachHang(String ma, String ten, LocalDate ngay, double soKW, double donGia) {
        this.maKhachHang = ma;
        this.hoTen = ten;
        this.ngayLapHoaDon = ngay;
        this.soKW = soKW;
        this.donGia = donGia;
    }

    // Phương thức trừu tượng để tính thành tiền
    public abstract double thanhTien();

    public LocalDate getNgayLapHoaDon() { return ngayLapHoaDon; }
    public String getMaKhachHang() { return maKhachHang; }
    public String getHoTen() { return hoTen; }

    @Override
    public String toString() {
        return String.format("%s | %s | Ngày: %s | TT: %.0f", 
                maKhachHang, hoTen, ngayLapHoaDon, thanhTien());
    }
}

// LỚP CON 1: KhachHangVietNam
class KhachHangVietNam extends KhachHang {
    private String doiTuong;
    private double dinhMuc;

    public KhachHangVietNam(String ma, String ten, LocalDate ngay, double soKW, double donGia, String doiTuong, double dinhMuc) {
        super(ma, ten, ngay, soKW, donGia);
        this.doiTuong = doiTuong;
        this.dinhMuc = dinhMuc;
    }

    public String getDoiTuong() { return doiTuong; }

    @Override
    public double thanhTien() {
        if (soKW <= dinhMuc) {
            return soKW * donGia;
        } else {
            return dinhMuc * donGia + (soKW - dinhMuc) * donGia * 2.5;
        }
    }
}

// LỚP CON 2: KhachHangNuocNgoai
class KhachHangNuocNgoai extends KhachHang {
    private String quocTich;

    public KhachHangNuocNgoai(String ma, String ten, LocalDate ngay, double soKW, double donGia, String quocTich) {
        super(ma, ten, ngay, soKW, donGia);
        this.quocTich = quocTich;
    }

    public String getQuocTich() { return quocTich; }

    @Override
    public double thanhTien() {
        return soKW * donGia;
    }
}

// CLASS QUẢN LÝ 
class ListQuanLy<T> {
    private List<T> danhSach = new ArrayList<>();

    // Thêm 1 đối tượng
    public void them(T t) {
        danhSach.add(t);
    }

    // Thêm nhiều đối tượng 
    @SafeVarargs
    public final void themNhieu(T... list) {
        for (T t : list) {
            danhSach.add(t);
        }
    }
    // Đếm số lượng thỏa mãn điều kiện
    public long dem(Predicate<T> dieuKien) {
        return danhSach.stream().filter(dieuKien).count();
    }

    public void xuatDanhSach() {
        danhSach.forEach(System.out::println);
    }
}

//Main
public class QuanLyHoaDon_Ver2 {
    public static void main(String[] args) {
        // Khởi tạo danh sách quản lý kiểu KhachHang
        ListQuanLy<KhachHang> ql = new ListQuanLy<>();

        // Thêm dữ liệu mẫu
        ql.themNhieu(
                new KhachHangVietNam("VN01", "Nguyen Van A", LocalDate.of(2018, 9, 10), 100, 1500, "sinh hoat", 50),
                new KhachHangVietNam("VN02", "Tran Thi B", LocalDate.of(2018, 10, 5), 200, 2000, "kinh doanh", 100),
                new KhachHangVietNam("VN03", "Le Van C", LocalDate.of(2019, 1, 20), 80, 1800, "san xuat", 60),
                new KhachHangNuocNgoai("NN01", "John Smith", LocalDate.of(2018, 9, 25), 150, 2500, "Mỹ"),
                new KhachHangNuocNgoai("NN02", "Yuki Tanaka", LocalDate.of(2018, 8, 15), 120, 3000, "Nhật"),
                new KhachHangNuocNgoai("NN03", "Kim Min Su", LocalDate.of(2019, 3, 8), 90, 2800, "Hàn")
        );

        // Đếm số lượng khách hàng Việt Nam và Nước Ngoài
        System.out.println("--- THỐNG KÊ SỐ LƯỢNG ---");
        System.out.println("VN: " + ql.dem(kh -> kh instanceof KhachHangVietNam));
        System.out.println("NN: " + ql.dem(kh -> kh instanceof KhachHangNuocNgoai));
    }
}
