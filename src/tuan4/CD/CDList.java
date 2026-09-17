package tuan4.CD;

public class CDList {
	private CD[] listCd;
	private int count;

	public CDList(int n) {
		listCd = new CD[n];
		count = 0;
	}
	public boolean trungMa(int maCD) {
		for (int i = 0; i < count; i++) {
			if (listCd[i].getMaCD() == maCD)
				return true;
		}
		return false;
	}
	public void appendCD(int maCD, String tuaCD, int soBaiHat, float giaThanh) throws Exception {
		if (count < listCd.length) {
			listCd[count++] = new CD(maCD, tuaCD, soBaiHat, giaThanh);
			if (listCd[count++].getMaCD() == maCD) {
				throw new Exception("Ma Trung");
			}
		} else {
			throw new Exception("Loi! mang day");
		}
	}

	public void appendCD(CD cd) throws Exception {
		if (count < listCd.length) {
			listCd[count++] = cd;
		} else {
			throw new Exception("Loi! mang day");
		}
	}

	public int getNumOfCDs() {
		return count;
	}


	public boolean deleteCD(int ma) {
		for (int i = 0; i < count; i++) {
			if (listCd[i].getMaCD() == ma) {
				for(int j = i; j < count; j++) {
					listCd[j] = listCd[j+1];
				}
				listCd[count] = null;
				count--;
				return true;
			}
		}
		
		return false;
	}
	public double calcTotalPrice() {
		double total = 0;
		for (int i = 0; i < count; i++) {
			total += listCd[i].getGiaThanh();
		}
		return total;
	}

	public boolean searchMaCD(int ma) {
		for (int i = 0; i < count; i++) {
			if (listCd[i].getMaCD() == ma) {
				return true;
			}
		}
		return false;
	}

	public void sortByPrice() {
		for (int i = 0; i < count - 1; i++) {
			if (listCd[i] != null) {
				for (int j = i + 1; j < count; j++) {
					if (listCd[j] != null) {
						if (listCd[i].getGiaThanh() < listCd[j].getGiaThanh()) {
							CD temp = listCd[i];
							listCd[i] = listCd[j];
							listCd[j] = temp;
						}
					}
				}
			}
		}
	}

	public void sortByName() {

		for (int i = 0; i < count - 1; i++) {
			if (listCd[i] != null) {
				for (int j = i + 1; j < count; j++) {
					if (listCd[j] != null) {
						if (listCd[i].getTuaCD().compareTo(listCd[j].getTuaCD()) > 0) {
							CD temp = listCd[i];
							listCd[i] = listCd[j];
							listCd[j] = temp;
						}
					}
				}
			}
		}
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String s = "";
		for (int i = 0; i < count; i++) {
			s += listCd[i] + "\n";
		}
		return s;
	}
}
