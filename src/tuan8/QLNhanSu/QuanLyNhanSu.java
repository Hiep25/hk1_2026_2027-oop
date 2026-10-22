package tuan8.QLNhanSu;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.*;

// ENUM 1: LoaiNhanVien
enum LoaiNhanVien {
    FULL_TIME("FullTime", "Toàn thời gian"),
    PART_TIME("PartTime", "Bán thời gian");

    private final String ma;
    private final String moTa;

    LoaiNhanVien(String ma, String moTa) {
        this.ma = ma;
        this.moTa = moTa;
    }

    public String getMa() { return ma; }
    public String getMoTa() { return moTa; }

    @Override
    public String toString() { return moTa; }
}

// ENUM 2: ChucVu
enum ChucVu {
    NHAN_VIEN("Nhân viên", 1.0),
    TRUONG_PHONG("Trưởng phòng", 1.5),
    GIAM_DOC("Giám đốc", 2.5);

    private final String ten;
    private final double heSoPhuCap;

    ChucVu(String ten, double heSoPhuCap) {
        this.ten = ten;
        this.heSoPhuCap = heSoPhuCap;
    }

    public String getTen() { return ten; }
    public double getHeSoPhuCap() { return heSoPhuCap; }

    @Override
    public String toString() { return ten; }
}

// ENUM 3: PhongBan
enum PhongBan {
    IT("Công nghệ thông tin"),
    HR("Nhân sự"),
    KE_TOAN("Kế toán"),
    MARKETING("Marketing");

    private final String ten;

    PhongBan(String ten) { this.ten = ten; }

    public String getTen() { return ten; }

    @Override
    public String toString() { return ten; }
}

// ABSTRACT CLASS: NhanVien
abstract class NhanVien {
    protected String maNV;
    protected String hoTen;
    protected LocalDate ngayVaoLam;
    protected double luongCoBan;
    protected LoaiNhanVien loai;
    protected ChucVu chucVu;
    protected PhongBan phongBan;

    public NhanVien(String maNV, String hoTen, LocalDate ngayVaoLam, double luongCoBan, LoaiNhanVien loai, ChucVu chucVu, PhongBan phongBan) {
        this.maNV = maNV;
        this.hoTen = hoTen;
        this.ngayVaoLam = ngayVaoLam;
        this.luongCoBan = luongCoBan;
        this.loai = loai;
        this.chucVu = chucVu;
        this.phongBan = phongBan;
    }

    // Phương thức trừu tượng
    public abstract double tinhLuong();
    public abstract String getMoTaLoai();

    // Getters
    public String getMaNV() { return maNV; }
    public String getHoTen() { return hoTen; }
    public double getLuongCoBan() { return luongCoBan; }
    public LoaiNhanVien getLoai() { return loai; }
    public ChucVu getChucVu() { return chucVu; }
    public PhongBan getPhongBan() { return phongBan; }

    // Setters
    public void setHoTen(String hoTen) { this.hoTen = hoTen; }
    public void setLuongCoBan(double luongCoBan) { this.luongCoBan = luongCoBan; }

    @Override
    public String toString() {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return String.format("%-8s | %-15s | %-12s | %-12s | %-15s | %.2f VNĐ",
                maNV, hoTen, loai, chucVu, phongBan, tinhLuong());
    }
}

// LỚP CON 1: NhanVienFullTime
class NhanVienFullTime extends NhanVien {
    private double heSoLuong;
    private double phuCap;

    public NhanVienFullTime(String maNV, String hoTen, LocalDate ngayVaoLam, double luongCoBan, LoaiNhanVien loai, ChucVu chucVu, PhongBan phongBan, double heSoLuong, double phuCap) {
        super(maNV, hoTen, ngayVaoLam, luongCoBan, loai, chucVu, phongBan);
        this.heSoLuong = heSoLuong;
        this.phuCap = phuCap;
    }

    @Override
    public double tinhLuong() {
        return luongCoBan * heSoLuong * chucVu.getHeSoPhuCap() + phuCap;
    }

    @Override
    public String getMoTaLoai() {
        return "Làm việc toàn thời gian";
    }
}

// LỚP CON 2: NhanVienPartTime
class NhanVienPartTime extends NhanVien {
    private int soGioLam;
    private double luongTheoGio;

    public NhanVienPartTime(String maNV, String hoTen, LocalDate ngayVaoLam, double luongCoBan, LoaiNhanVien loai, ChucVu chucVu, PhongBan phongBan, int soGioLam, double luongTheoGio) {
        super(maNV, hoTen, ngayVaoLam, luongCoBan, loai, chucVu, phongBan);
        this.soGioLam = soGioLam;
        this.luongTheoGio = luongTheoGio;
    }

    @Override
    public double tinhLuong() {
        return soGioLam * luongTheoGio;
    }

    @Override
    public String getMoTaLoai() {
        return "Làm việc bán thời gian";
    }
}

// INTERFACE: IQuanLy
interface IQuanLy<T> {
    void them(T t);
    boolean xoa(String ma);
    boolean sua(String ma, T moi);
    List<T> timKiemTheoTen(String ten);
    List<T> timKiemTheoMa(String prefix);
    List<T> sapXepTheoLuong();
    List<T> sapXepTheoTen();
    Map<String, Double> thongKeLuongTheoLoai();
    Map<String, List<T>> groupByLoai();
    Map<String, List<T>> groupByPhongBan();
    List<T> locLuongTren(double mucLuong);
    List<T> timTheoChucVu(ChucVu chucVu);
}

// CLASS: ListQuanLy
class ListQuanLy implements IQuanLy<NhanVien> {
    private List<NhanVien> danhSach = new ArrayList<>();

    @Override
    public void them(NhanVien nv) {
        if (timTheoMa(nv.getMaNV()) != null) {
            System.out.println("Mã đã tồn tại!");
            return;
        }
        danhSach.add(nv);
    }

    private NhanVien timTheoMa(String ma) {
        return danhSach.stream()
                .filter(nv -> nv.getMaNV().equalsIgnoreCase(ma))
                .findFirst().orElse(null);
    }

    @Override
    public boolean xoa(String ma) {
        return danhSach.removeIf(nv -> nv.getMaNV().equalsIgnoreCase(ma));
    }

    @Override
    public boolean sua(String ma, NhanVien moi) {
        for (int i = 0; i < danhSach.size(); i++) {
            if (danhSach.get(i).getMaNV().equalsIgnoreCase(ma)) {
                danhSach.set(i, moi);
                return true;
            }
        }
        return false;
    }

    @Override
    public List<NhanVien> timKiemTheoTen(String ten) {
        String keyword = ten.toLowerCase();
        return danhSach.stream()
                .filter(nv -> nv.getHoTen().toLowerCase().contains(keyword))
                .collect(Collectors.toList());
    }

    @Override
    public List<NhanVien> timKiemTheoMa(String prefix) {
        return danhSach.stream()
                .filter(nv -> nv.getMaNV().toLowerCase().startsWith(prefix.toLowerCase()))
                .collect(Collectors.toList());
    }

    @Override
    public List<NhanVien> sapXepTheoLuong() {
        return danhSach.stream()
                .sorted(Comparator.comparingDouble(NhanVien::tinhLuong))
                .collect(Collectors.toList());
    }

    @Override
    public List<NhanVien> sapXepTheoTen() {
        return danhSach.stream()
                .sorted(Comparator.comparing(NhanVien::getHoTen))
                .collect(Collectors.toList());
    }

    @Override
    public Map<String, Double> thongKeLuongTheoLoai() {
        return danhSach.stream()
                .collect(Collectors.groupingBy(
                        nv -> nv.getLoai().getMa(),
                        Collectors.summingDouble(NhanVien::tinhLuong)
                ));
    }

    @Override
    public Map<String, List<NhanVien>> groupByLoai() {
        return danhSach.stream()
                .collect(Collectors.groupingBy(nv -> nv.getLoai().getMa()));
    }

    @Override
    public Map<String, List<NhanVien>> groupByPhongBan() {
        return danhSach.stream()
                .collect(Collectors.groupingBy(nv -> nv.getPhongBan().getTen()));
    }

    @Override
    public List<NhanVien> locLuongTren(double mucLuong) {
        return danhSach.stream()
                .filter(nv -> nv.tinhLuong() > mucLuong)
                .collect(Collectors.toList());
    }

    @Override
    public List<NhanVien> timTheoChucVu(ChucVu chucVu) {
        return danhSach.stream()
                .filter(nv -> nv.getChucVu() == chucVu)
                .collect(Collectors.toList());
    }

    public List<NhanVien> getDanhSach() {
        return danhSach;
    }
}

// MAIN
public class QuanLyNhanSu {
    static Scanner sc = new Scanner(System.in);
    static ListQuanLy ql = new ListQuanLy();

    public static void main(String[] args) {
        while (true) {
            hienThiMenu();
            System.out.print("Chọn: ");
            int chon = Integer.parseInt(sc.nextLine());

            switch (chon) {
                case 1: chucNangThem(); break;
                case 2: chucNangXoa(); break;
                case 3: chucNangSua(); break;
                case 4: chucNangTimTheoTen(); break;
                case 5: chucNangTimTheoMa(); break;
                case 6: hienThi(ql.sapXepTheoLuong()); break;
                case 7: hienThi(ql.sapXepTheoTen()); break;
                case 8: chucNangThongKeLuong(); break;
                case 9: chucNangNhomTheoLoai(); break;
                case 10: chucNangNhomTheoPhongBan(); break;
                case 11: chucNangTimTheoChucVu(); break;
                case 12: chucNangLocLuong(); break;
                case 13: hienThi(ql.getDanhSach()); break;
                case 0:
                    System.out.println("Tạm biệt!");
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        }
    }

    static void hienThiMenu() {
        System.out.println("\n========== MENU QUẢN LÝ NHÂN SỰ ==========");
        System.out.println("1. Thêm nhân viên");
        System.out.println("2. Xóa theo mã");
        System.out.println("3. Sửa theo mã");
        System.out.println("4. Tìm theo tên");
        System.out.println("5. Tìm theo mã (tiền tố)");
        System.out.println("6. Sắp xếp theo lương");
        System.out.println("7. Sắp xếp theo tên");
        System.out.println("8. Thống kê lương theo loại");
        System.out.println("9. Nhóm theo loại");
        System.out.println("10. Nhóm theo phòng ban");
        System.out.println("11. Tìm theo chức vụ");
        System.out.println("12. Lọc lương trên mức X");
        System.out.println("13. Xuất tất cả");
        System.out.println("0. Thoát");
    }

    static void chucNangThem() {
        NhanVien nv = nhapNV();
        ql.them(nv);
        System.out.println("Đã thêm!");
    }

    static void chucNangXoa() {
        System.out.print("Nhập mã cần xóa: ");
        String ma = sc.nextLine();
        boolean ok = ql.xoa(ma);
        System.out.println(ok ? "Đã xóa!" : "Không tìm thấy!");
    }

    static void chucNangSua() {
        System.out.print("Nhập mã cần sửa: ");
        String ma = sc.nextLine();
        System.out.println("Nhập thông tin mới:");
        NhanVien moi = nhapNV();
        boolean ok = ql.sua(ma, moi);
        System.out.println(ok ? "Đã sửa!" : "Không tìm thấy!");
    }

    static void chucNangTimTheoTen() {
        System.out.print("Nhập tên cần tìm: ");
        hienThi(ql.timKiemTheoTen(sc.nextLine()));
    }

    static void chucNangTimTheoMa() {
        System.out.print("Nhập tiền tố mã: ");
        hienThi(ql.timKiemTheoMa(sc.nextLine()));
    }

    static void chucNangThongKeLuong() {
        System.out.println("--- Thống kê lương theo loại ---");
        ql.thongKeLuongTheoLoai().forEach((k, v) ->
                System.out.printf("%-12s : %.2f VNĐ%n", k, v));
    }

    static void chucNangNhomTheoLoai() {
        System.out.println("--- Nhóm theo loại ---");
        ql.groupByLoai().forEach((k, v) -> {
            System.out.println("Loại: " + k);
            v.forEach(nv -> System.out.println("  " + nv));
        });
    }

    static void chucNangNhomTheoPhongBan() {
        System.out.println("--- Nhóm theo phòng ban ---");
        ql.groupByPhongBan().forEach((k, v) -> {
            System.out.println("Phòng: " + k);
            v.forEach(nv -> System.out.println("  " + nv));
        });
    }

    static void chucNangTimTheoChucVu() {
        System.out.println("--- Chọn chức vụ ---");
        ChucVu[] chucVus = ChucVu.values();
        for (int i = 0; i < chucVus.length; i++) {
            System.out.println((i + 1) + ". " + chucVus[i]);
        }
        System.out.print("Chọn: ");
        int chon = Integer.parseInt(sc.nextLine());
        if (chon >= 1 && chon <= chucVus.length) {
            hienThi(ql.timTheoChucVu(chucVus[chon - 1]));
        }
    }

    static void chucNangLocLuong() {
        System.out.print("Nhập mức lương: ");
        double muc = Double.parseDouble(sc.nextLine());
        hienThi(ql.locLuongTren(muc));
    }

    static NhanVien nhapNV() {
        System.out.print("Mã NV: ");
        String ma = sc.nextLine();
        System.out.print("Tên: ");
        String ten = sc.nextLine();
        System.out.print("Ngày vào làm (yyyy-MM-dd): ");
        LocalDate ngay = LocalDate.parse(sc.nextLine());
        System.out.print("Lương cơ bản: ");
        double lcb = Double.parseDouble(sc.nextLine());

        // Chọn loại
        System.out.println("--- Chọn loại nhân viên ---");
        LoaiNhanVien[] loais = LoaiNhanVien.values();
        for (int i = 0; i < loais.length; i++) {
            System.out.println((i + 1) + ". " + loais[i].getMoTa());
        }
        System.out.print("Chọn: ");
        LoaiNhanVien loai = loais[Integer.parseInt(sc.nextLine()) - 1];

        // Chọn chức vụ
        System.out.println("--- Chọn chức vụ ---");
        ChucVu[] chucVus = ChucVu.values();
        for (int i = 0; i < chucVus.length; i++) {
            System.out.println((i + 1) + ". " + chucVus[i]);
        }
        System.out.print("Chọn: ");
        ChucVu chucVu = chucVus[Integer.parseInt(sc.nextLine()) - 1];

        // Chọn phòng ban
        System.out.println("--- Chọn phòng ban ---");
        PhongBan[] phongBans = PhongBan.values();
        for (int i = 0; i < phongBans.length; i++) {
            System.out.println((i + 1) + ". " + phongBans[i]);
        }
        System.out.print("Chọn: ");
        PhongBan phongBan = phongBans[Integer.parseInt(sc.nextLine()) - 1];

        // Tạo đối tượng theo loại
        if (loai == LoaiNhanVien.FULL_TIME) {
            System.out.print("Hệ số lương: ");
            double hs = Double.parseDouble(sc.nextLine());
            System.out.print("Phụ cấp: ");
            double pc = Double.parseDouble(sc.nextLine());
            return new NhanVienFullTime(ma, ten, ngay, lcb, loai, chucVu, phongBan, hs, pc);
        } else {
            System.out.print("Số giờ làm: ");
            int gio = Integer.parseInt(sc.nextLine());
            System.out.print("Lương theo giờ: ");
            double lg = Double.parseDouble(sc.nextLine());
            return new NhanVienPartTime(ma, ten, ngay, lcb, loai, chucVu, phongBan, gio, lg);
        }
    }

    static void hienThi(List<NhanVien> list) {
        if (list.isEmpty()) {
            System.out.println("Danh sách rỗng");
        } else {
            list.forEach(System.out::println);
        }
    }
}