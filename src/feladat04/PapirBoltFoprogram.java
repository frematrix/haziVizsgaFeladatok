package feladat04;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PapirBoltFoprogram {

	public static void main(String[] args) throws IOException {
		
		List<Rendeles> rendelesek = new ArrayList<Rendeles>();
		FajlKezeles fajlObj = new FajlKezeles();
		
		System.out.println("Fájl beolvasva. Hibás tételek száma: "+fajlObj.beolvas(rendelesek,"SzallitoiRendelesek.csv"));

		for (Rendeles rendeles : rendelesek) {
			System.out.println(rendeles.toString());
		}
		
		Rendeles ujRendeles1 = new Rendeles("P00001", "Pelikan hegyező", 300, 90000, false);
		Rendeles ujRendeles2 = new Rendeles("P00002", "Pelikan tűfilc", 400, 120000, true);
		
		rendelesek.add(ujRendeles1);
		rendelesek.add(ujRendeles2);
		
		fajlObj.kiirasFajlba(rendelesek, "UjSzallitoiRendelesek.csv");
	}

}
