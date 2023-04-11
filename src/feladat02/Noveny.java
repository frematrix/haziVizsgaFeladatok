package feladat02;

import java.time.LocalDate;

public class Noveny {
	
	private String azonosito;
	private String megnevezes;
	private String latinNev;
	private int bekerulesEve;
	
	
	public Noveny(String azonosito, String megnevezes, String latinNev, int felfedezesEve) {
		
		this.azonosito = azonosito;
		this.megnevezes = megnevezes;
		this.latinNev = latinNev;
		this.bekerulesEve = felfedezesEve;
		
	}
	

	public int hanyEveLatogathato() {
		
		return LocalDate.now().getYear() - bekerulesEve;
		
	}


	@Override
	public String toString() {
		return "Azonositó: " + azonosito + ", megnevezés: " + megnevezes + ", latin név: " + latinNev
				+ ", bekerülés éve: " + bekerulesEve;
	}
	
	public void alapMetodus() {
		System.out.println("Ez egy növény.\n");
	}
	
	
	

}
