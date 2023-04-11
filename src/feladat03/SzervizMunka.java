package feladat03;

public class SzervizMunka {
	
	private String szervizTevekenyseg;
	private int munkaOra;
	
	
	public SzervizMunka(String szervizTevekenyseg, int munkaOra) {
		this.szervizTevekenyseg = szervizTevekenyseg;
		this.munkaOra = munkaOra;
	}
	
	
	public int arKepzes(int oradij) {
		
		return oradij * munkaOra;
		
	}


	public String getSzervizTevekenyseg() {
		return szervizTevekenyseg;
	}


	public int getMunkaOra() {
		return munkaOra;
	}

	
	

}
