package tuan5.gk;

public class CD {

	private int maCD;
	private String tuaCD;
	private int soBaiHat;
	private double giaThanh;
	
	public static final int MA_CD_MAC_DINH = 999999;
	public static final String TUA_CD_MAC_DINH = "chua xac dinh";
	
	
	/**
	 * @param maCD
	 * @param tuaCD
	 * @param soBaiHat
	 * @param giaThanh
	 */
	public CD() {
		this.maCD = MA_CD_MAC_DINH;
		this.tuaCD = TUA_CD_MAC_DINH;
		this.soBaiHat = 1;
		this.giaThanh = 1.0;
	}
	
	public CD(int maCD, String tuaCD, int soBaiHat, double giaThanh) {
		setMaCD(maCD);
		setTuaCD(tuaCD);
		setSoBaiHat(soBaiHat);
		setGiaThanh(giaThanh);
	}

	
	public int getMaCD() {return maCD;}
	public String getTuaCD() {return tuaCD; }
	public int getSoBaiHat() {return soBaiHat;}
	public double getGiaThanh() {return giaThanh;}
	

	/**
	 * @param maCD the maCD to set
	 */
	public void setMaCD(int maCD) {
		if (maCD <=0)
			throw new IllegalArgumentException("Loi: Ma CD phai > 0!");
		this.maCD = maCD;
	}


	public void setTuaCD(String tuaCD) {
		if(tuaCD == null || tuaCD.trim().isEmpty())
			throw new IllegalArgumentException("Loi: Tua CD ko dc rong!");
		this.tuaCD = tuaCD;
	}


	/**
	 * @param soBaiHat the soBaiHat to set
	 */
	public void setSoBaiHat(int soBaiHat) {
		if(soBaiHat <=0)
			throw new IllegalArgumentException("Loi: So bai hat phai >0!");
		this.soBaiHat = soBaiHat;
	}

	/**
	 * @param giaThanh the giaThanh to set
	 */
	public void setGiaThanh(double giaThanh) {
		if (giaThanh <=0)
			throw new IllegalArgumentException("Loi: gia thanh phai >0");
		this.giaThanh = giaThanh;
	}

	@Override
	public String toString() {
		return String.format("| %-10d | %-25s | %-12d | %-15.2f |", maCD, tuaCD, soBaiHat, giaThanh);
	}
}
