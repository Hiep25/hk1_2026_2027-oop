package tuan4.CD;

public class CD {
	private int maCD;
	private String tuaCD;
	private int soBaiHat;
	private float giaThanh;
	public CD(int maCD, String tuaCD, int soBaiHat, float giaThanh) throws Exception {
		setMaCD(maCD);
		setTuaCD(tuaCD);
		setSoBaiHat(soBaiHat);
		setGiaThanh(giaThanh);
	}
	public CD() {
		this.maCD = 999999;
		this.tuaCD = "Chua Xac Dinh";
		this.soBaiHat = 1;
		this.giaThanh = 1F;
	}
	public int getMaCD() {
		return maCD;
	}
	public void setMaCD(int maCD) {
		if(maCD > 0) {
			this.maCD = maCD;
		}
		else {
			this.maCD = 999999;
		}
	}
	public String getTuaCD() {
		return tuaCD;
	}
	public void setTuaCD(String tuaCD) throws Exception {
		if(!tuaCD.isEmpty()) {
			this.tuaCD = tuaCD;
		}
		else {
			throw new Exception("Loi! khong duoc rong");
		}
	}
	public int getSoBaiHat() {
		return soBaiHat;
	}
	public void setSoBaiHat(int soBaiHat) {
		if (soBaiHat > 0) {
			this.soBaiHat = soBaiHat;
		}
	}
	public float getGiaThanh() {
		return giaThanh;
	}
	public void setGiaThanh(float giaThanh) {
		if (giaThanh > 0) {
			this.giaThanh = giaThanh;
		}
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		
		return String.format("%d %s %d %f\n", maCD,tuaCD,soBaiHat,giaThanh);
	}
	
	
}
