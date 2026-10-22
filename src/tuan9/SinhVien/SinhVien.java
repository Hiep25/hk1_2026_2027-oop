package tuan9.SinhVien;

import java.time.LocalDate;

public class SinhVien {
    protected String maSV;       
    protected String hoTen;      
    protected LocalDate ngaySinh;
    protected String lop;        
    protected int soTinChi;     
    protected MonHoc monHoc;     

    // CONSTRUCTOR
    public SinhVien(String maSV, String hoTen, LocalDate ngaySinh,
                    String lop, int soTinChi, MonHoc monHoc) {
        this.maSV = maSV;
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.lop = lop;
        this.soTinChi = soTinChi;
        this.monHoc = monHoc;
    }

    // PHƯƠNG THỨC TÍNH THÀNH TIỀN
    public double thanhTien() {
        return soTinChi * monHoc.getDonGia();
    }

    // PHƯƠNG THỨC LẤY LOẠI - override ở lớp con 
    public String getLoai() { return "Sinh viên"; }

    // THÔNG TIN RIÊNG - override ở lớp con 
    public String getThongTinRieng() { return ""; }

    // GETTER
    public String getMaSV() { return maSV; }
    public String getHoTen() { return hoTen; }
    public LocalDate getNgaySinh() { return ngaySinh; }
    public String getLop() { return lop; }
    public int getSoTinChi() { return soTinChi; }
    public MonHoc getMonHoc() { return monHoc; }
    public float getDonGia() { return monHoc.getDonGia(); }
    public String getTenMonHoc() { return monHoc.getTenMon(); }
}
