package tuan2.BaiSinhVien;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner inp =  new Scanner(System.in);
		DiemSinhVien sv1 = new DiemSinhVien(21056051, "Nguyen Van A", 9, 9);
		DiemSinhVien sv2 = new DiemSinhVien();
		
		
		System.out.println("Nhap ma sinh vien!");
		int msv = inp.nextInt();
		inp.nextLine();
		System.out.println("Nhap ho ten!");
		String ht = inp.nextLine();
		System.out.println("Nhap diem ly thuyet!");
		float diemLT = inp.nextFloat();
		System.out.println("Nhap diem thuc hanh!");
		float diemTH = inp.nextFloat();
		DiemSinhVien sv3 = new DiemSinhVien(msv, ht, diemLT, diemTH);
		
		System.out.println(sv1.getTitle());
		System.out.println(sv1);
		System.out.println(sv2);
		System.out.println(sv3);
		
		inp.close();
	}
}
