package tuan4.CD;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner inp = new Scanner(System.in);
		CDList cdList = new CDList(15);
		try {
			CD a = new CD(1293, "asdhfsa", 15, 5000);
			CD b = new CD();
			CD c = new CD(11111, "babababab", 10, 200000);
			CD d = new CD(22222,"sdfsf", 15, 120012);
			CD e = new CD(33333,"bruh", 12, 120012);
			CD f = new CD(44444,"lmao", 14, 120012);
			CD g = new CD(55555,"suck", 13, 213345);
			 cdList.appendCD(a);
			 cdList.appendCD(b);
			 cdList.appendCD(c);
			 cdList.appendCD(d);
			 cdList.appendCD(e);
			 cdList.appendCD(f);
			 cdList.appendCD(g);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		System.out.println(cdList);
		System.out.println(cdList.getNumOfCDs());
		System.out.println(cdList.calcTotalPrice());
		
		System.out.println("Nhap ma can tim");
		int ma = inp.nextInt();
		if (cdList.searchMaCD(ma)) {
			System.out.println("Tim thay");
		}
		else {
			System.out.println("Khong tim thay");
		}
		
//		cdList.sortByName();
//		System.out.println(cdList);
//		
//		cdList.sortByPrice();
//		System.out.println(cdList);
		
		System.out.println("Nhap ma can xoa");
		int ma_xoa = inp.nextInt();
		if (cdList.deleteCD(ma_xoa)) {
			System.out.println("Xoa thanh cong");
		}
		else {
			System.out.println("Xoa khong thanh cong");
		}
		System.out.println(cdList);
		System.out.println(cdList.getNumOfCDs());
		inp.close();
	}
}
