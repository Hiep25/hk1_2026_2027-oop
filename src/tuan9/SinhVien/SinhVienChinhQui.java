package tuan9.SinhVien;


import java.time.LocalDate;

public class SinhVienChinhQui extends SinhVien {
    private String hocTrucTiep; 

    // CONSTRUCTOR - gọi super() 
    public SinhVienChinhQui(String maSV, String hoTen, LocalDate ngaySinh,
                            String lop, int soTinChi, MonHoc monHoc,
                            String hocTrucTiep) {
        super(maSV, hoTen, ngaySinh, lop, soTinChi, monHoc);
        this.hocTrucTiep = hocTrucTiep;
    }

    // GETTER + SETTER 
    public String getHocTrucTiep() { return hocTrucTiep; }
    public void setHocTrucTiep(String hocTrucTiep) { this.hocTrucTiep = hocTrucTiep; }

    // OVERRIDE - trả về loại 
    @Override
    public String getLoai() { return "Chính quy"; }

    // OVERRIDE - thông tin riêng
    @Override
    public String getThongTinRieng() {
        return "Học trực tiếp tại: " + hocTrucTiep;
    }

    // OVERRIDE toString - gọi super.toString() rồi nối thêm 
    @Override
    public String toString() {
        return super.toString() + " | " + getThongTinRieng();
    }
}