package feladat04_Teszt;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.sun.source.tree.AssertTree;

import feladat04.FajlKezeles;
import feladat04.Rendeles;

class FajlKezelesTest {

	@Test
	void ellenorizTeszt() {
		
		FajlKezeles fajlObj = new FajlKezeles();
		String[] tesztCsvSor = {"S00008","toll","100","4000","1"};
		
		assertTrue(fajlObj.ellenoriz(tesztCsvSor));
		
	}
	
	@Test
	void beolvasasTeszt() {
		
		try {
			List<Rendeles> rendelesek = new ArrayList<Rendeles>();
			FajlKezeles fajlObj = new FajlKezeles();
			fajlObj.beolvas(rendelesek, "SzallitoiRendelesek.csv");
			assertTrue(rendelesek.size()>0);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	@Test
	void getMegnevezes() {
		//List<Rendeles> rendelesek = new ArrayList<Rendeles>();
		Rendeles ujRendeles = new Rendeles("S00008","toll",100,4000,false);
		//rendelesek.add(ujRendeles);
		assertEquals("toll", ujRendeles.getMegnevezes());
	}
	

}
