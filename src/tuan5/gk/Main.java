package tuan5.gk;

import java.util.Scanner;

public class Main {
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		CDList ql = new CDList();
		int luaChon = -1;
	
	do {
		System.out.println("\n-------------MENU QUẢN LÝ CD-------------");
		System.out.println("1. Thêm CD");
		System.out.println("2. Xóa CD");
		System.out.println("3. Sửa/ Cap nha theo mã");
		System.out.println("4. Tìm kiếm");
		System.out.println("5. Tim theo tựa - Tien to");
		System.out.println("6. Tim theo tựa - Hau to");
		System.out.println("7. Tim tua gan giong");
		System.out.println("8. Hien thi danh dach");
		System.out.println("9. Thong ke");
		System.out.println("10. Sap xep giam dan");
		System.out.println("11. Sap xep tăng dần");
		System.out.println("0. Thoát");
		System.out.println("------------------------------------------");
		System.out.println("Chon chức năng:");
	
	
	try {
		luaChon = Integer.parseInt(sc.nextLine());
	} catch (NumberFormatException e) {
		System.out.println("Vui long nhap so");
		continue;
	}
	
    switch (luaChon) {

    case 1:
        themCD(ql);break;

    case 2:
        xoaCD(ql);break;

    case 3:
        capNhatCD(ql);break;

    case 4:
        timTheoMa(ql);break;

    case 5:
        timTheoTienTo(ql);break;

    case 6:
        timTheoHauTo(ql);break;

    case 7:
        timGanGiong(ql);break;

    case 8:
        ql.hienthiDanhSach();break;

    case 9:
        thongKe(ql);break;

    case 10:
        ql.sapXepGiamDanTheoGia();
        ql.hienthiDanhSach();
        break;

    case 11:
        ql.sapXepTangDanTheoTua();
        ql.hienthiDanhSach();
        break;

    case 0:
        System.out.println("Tạm biệt!");
        break;

    default:
        System.out.println("Lựa chọn không hợp lệ!");
}

	} while (luaChon != 0);

	sc.close();
}
	
	
	static void themCD(CDList ql) {
		try {
			System.out.println("Nhap ma CD (>0):");
			int ma = Integer.parseInt(sc.nextLine());
			System.out.println("Nhap tua CD:");
			String tua = sc.nextLine();
			System.out.println("Nhap so bai hat(>0)");
			int sbh = Integer.parseInt(sc.nextLine());
			System.out.println("Nhap gia thanh (>0)");
			double gia = Double.parseDouble(sc.nextLine());
			if(ql.themCD(new CD(ma, tua, sbh, gia)))
				System.out.println("Them CD thanh cong");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	static void xoaCD(CDList ql) {
		try {
			System.out.println("Nhap ma CD can xoa:");
			int ma = Integer.parseInt(sc.nextLine());
			if(ql.xoaCD(ma)) System.out.println(" Da xoa CD ma " + ma);
		} catch (NumberFormatException e) {
			System.out.println("Ma phai la so nguyen");		
		}
	}
	
	static void capNhatCD(CDList ql) {
		try {
			System.out.println("Nhap ma cd can sua:");
			int ma = Integer.parseInt(sc.nextLine());
			System.out.println("Tua CD moi:");
			String tua = sc.nextLine();
			System.out.println("So bai hat moi:");
			int sbh = Integer.parseInt(sc.nextLine());
			System.out.println("Gia thanh moi:");
			double gia = Double.parseDouble(sc.nextLine());
			if (ql.capNhatCD(ma, tua, sbh, gia))
				System.out.println("Da cap nhat CD ma" + ma);
		} catch (Exception e) {
			System.out.println();
		}
	}
	
	static void timTheoMa(CDList ql) {

        try {
            System.out.print("Nhập mã CD cần tìm: ");

            int ma = Integer.parseInt(sc.nextLine());

            CD kq = ql.timTheoMa(ma);

            if (kq != null) {
                System.out.println("Tìm thấy:");
                System.out.println(kq);
            } else {
                System.out.println("Không có CD mã " + ma);
            }

        } catch (NumberFormatException e) {
            System.out.println("Mã phải là số!");
        }
    }

    static void timTheoTienTo(CDList ql) {

        System.out.print(
            "Nhập tiền tố tựa CD (so khớp BÊN TRÁI): "
        );

        String tk = sc.nextLine();

        CDList kq = ql.timTheoTienTo(tk);

        System.out.println(
            "Tìm thấy " + kq.laySoLuong()
            + " kết quả (bắt đầu bằng \"" + tk + "\"):"
        );

        kq.hienthiDanhSach();
    }

    static void timTheoHauTo(CDList ql) {

        System.out.print(
            "Nhập hậu tố tựa CD (so khớp BÊN PHẢI): "
        );

        String tk = sc.nextLine();

        CDList kq = ql.timTheoHauTo(tk);

        System.out.println(
            "Tìm thấy " + kq.laySoLuong()
            + " kết quả (kết thúc bằng \"" + tk + "\"):"
        );

        kq.hienthiDanhSach();
    }

    static void timGanGiong(CDList ql) {

        System.out.print(
            "Nhập từ khóa (tìm gần giống, chứa ở bất kỳ vị trí): "
        );

        String tk = sc.nextLine();

        CDList kq = ql.timGanGiong(tk);

        System.out.println(
            "Tìm thấy " + kq.laySoLuong()
            + " kết quả (chứa \"" + tk + "\"):"
        );

        kq.hienthiDanhSach();
    }

    static void thongKe(CDList ql) {

        System.out.println("\n===== THỐNG KÊ =====");

        System.out.println(
            "Số lượng CD: " + ql.tinhSoLuongCD()
        );

        System.out.printf(
            "Tổng giá thành: %,.2f VNĐ\n",
            ql.tinhTongGiaThanh()
        );

        System.out.printf(
            "Giá trung bình: %,.2f VNĐ\n",
            ql.tinhGiaTrungBinh()
        );

        CD max = ql.timCDDatNhat();
        CD min = ql.timCDReNhat();

        if (max != null) {

            System.out.println("CD đắt nhất:");
            System.out.println("   " + max);

            System.out.println("CD rẻ nhất:");
            System.out.println("   " + min);
        }
    }
	
}
