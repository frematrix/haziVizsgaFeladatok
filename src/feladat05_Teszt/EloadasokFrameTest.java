package feladat05_Teszt;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import feladat05.Eloadas;
import feladat05.EloadasABkezelo;
import feladat05.EloadasokFrame;

class EloadasokFrameTest {

	@Test
	void initializeTeszt() {
		
		EloadasokFrame foAblak = new EloadasokFrame();
		
		// szélesség 700 ellenőrzése:
		assertTrue(foAblak.getFrmEloadasok().getBounds().width == 700);

	}
	
	@Test
	void csatlakozasTeszt() {
		
		String hibasURL = "jdbc:mysql://localhost:3306/szinhaz_eloadashibas_db?autoReconnect=true&useSSL=false";
		
		assertThrows(SQLException.class, () -> DriverManager.getConnection(hibasURL,"root","Vagyok1125") );
	}
	
	@Test
	void beolvasasTeszt() {
		
		try {
			EloadasABkezelo.kapcsolat();
			List<Eloadas> eloadasok = new ArrayList<Eloadas>();
			eloadasok = EloadasABkezelo.beolvasas();
			assertTrue(eloadasok.size()>0);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Test
	void felvitelTeszt() {
		
		
		try {
			Eloadas tesztEloadas = new Eloadas("Előadás címe", "Rendező", null, 300);
			EloadasABkezelo.kapcsolat();
			assertThrows(SQLException.class, ()->EloadasABkezelo.felvitel(tesztEloadas));
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
