package feladat05;

import java.time.LocalDate;

public class Eloadas {
	
	private String eloadasCime;
	private String rendezo;
	private LocalDate bemutato;
	private int eloadasSzam;
	
	
	public Eloadas(String eloadasCime, String rendezo, LocalDate bemutato, int eloadasSzam) {
		this.eloadasCime = eloadasCime;
		this.rendezo = rendezo;
		this.bemutato = bemutato;
		this.eloadasSzam = eloadasSzam;
	}
	
	
	public String getEloadasCime() {
		return eloadasCime;
	}
	public String getRendezo() {
		return rendezo;
	}
	public LocalDate getBemutato() {
		return bemutato;
	}
	public int getEloadasSzam() {
		return eloadasSzam;
	}


	@Override
	public String toString() {
		return eloadasCime + ", rendező: " + rendezo + " bemutató dátuma: " + bemutato
				+ " tervezett előadásszám: " + eloadasSzam;
	}
	

}
