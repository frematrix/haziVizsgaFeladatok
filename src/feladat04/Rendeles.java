package feladat04;

public class Rendeles {
	
	private String szallitoiAzonosito;
	private String megnevezes;
	private int mennyiseg;
	private int osszertek;
	private boolean surgos;


	public Rendeles(String[] csvSor) {
		this.szallitoiAzonosito = csvSor[0];
		this.megnevezes = csvSor[1];
		this.mennyiseg = Integer.parseInt(csvSor[2]);
		this.osszertek = Integer.parseInt(csvSor[3]);
		this.surgos = Boolean.parseBoolean(csvSor[4]);
			
	}
	
	public Rendeles(String szallitoiAzonosito, String megnevezes, int mennyiseg, int osszertek, boolean surgos) {
		this.szallitoiAzonosito = szallitoiAzonosito;
		this.megnevezes = megnevezes;
		this.mennyiseg = mennyiseg;
		this.osszertek = osszertek;
		this.surgos = surgos;
	}
	
	


	public String getSzallitoiAzonosito() {
		return szallitoiAzonosito;
	}

	public String getMegnevezes() {
		return megnevezes;
	}

	public int getMennyiseg() {
		return mennyiseg;
	}

	public int getOsszertek() {
		return osszertek;
	}

	public boolean isSurgos() {
		return surgos;
	}

	@Override
	public String toString() {
		return "Szállítói azonosító: " + szallitoiAzonosito + ", megnevezés: " + megnevezes + ", mennyiség: "
				+ mennyiseg + ", összérték: " + osszertek + ", " + ((surgos)?"sürgős":"nem sürgős") ;
	}
	
	



}
