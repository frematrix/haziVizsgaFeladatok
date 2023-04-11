package feladat01_Teszt;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import feladat01.titkositoApplikacio;

class titkositoApplikacioTest {

	@Test
	void titkositTeszt() {
		
		String titkositando = "Tesztszöveg ellenőrzése";
		String elvartEredmeny = "24z34zöv2g62ll2nőrzé42T";
		assertEquals(elvartEredmeny, titkositoApplikacio.titkosit(titkositando));
		
	}
	
	@Test
	void dekodoloTeszt() {
		String elvart = "Tesztszöveg ellenőrzése";
		String titkosit = titkositoApplikacio.titkosit(elvart);
		assertEquals(elvart, titkositoApplikacio.dekodolas(titkosit));
	}

}
