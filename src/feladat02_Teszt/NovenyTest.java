package feladat02_Teszt;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import feladat02.Fa;
import feladat02.Noveny;

class NovenyTest {

	@Test
	void hanyEveLatogathatoTeszt(){
		
		int bekerulesEve = 2003;
		int aktualisEv = LocalDate.now().getYear();
		int elvartEredmeny = aktualisEv-bekerulesEve;
		
		Noveny novenyObj = new Noveny("0001","magyar rózsa", "Rosa hungarica", bekerulesEve);
		
		assertEquals(elvartEredmeny, novenyObj.hanyEveLatogathato());
		
	}
	
	@Test
	void getMagassagTeszt() {
		
		Fa tesztfa = new Fa("F004", "Fa4", "Latinfa4", 1942, 78);
		
		assertEquals(78, tesztfa.getMagassag());
	}
	
	
	
	

}
