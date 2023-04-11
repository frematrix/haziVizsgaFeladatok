package feladat05;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;



public class EloadasABkezelo {
	
	private static Connection kapcsolat;
	private static PreparedStatement utasitas;
	
	public static void kapcsolat() throws SQLException  {
		
		
		try {
			String cim = "jdbc:mysql://localhost:3306/szinhaz_eloadasok_db?useSSL=false";
			kapcsolat = (Connection) DriverManager.getConnection(cim, "root", "Vagyok1125");
		} catch (Exception e) {
			throw new SQLException("Kapcsolat sikertelen");
		
		}
		
	}
	
	private static Connection kapcsolat2;
	private static PreparedStatement utasitas2;
	
	public static void kapcsolat2 () throws SQLException {
		
		try {
			String url = "jdbc:mysql://localhost:3306/szinhaz_eloadasok_db?autoReconnect=true&useSSL=false";
			kapcsolat2 = (Connection) DriverManager.getConnection(url,"root","Vagyok1125");
			
		} catch (Exception e) {
			
			throw new SQLException("Kapcsolat sikertelen");
		}
	
	}
	
	public static List<Eloadas> beolvasas2() throws SQLException {
		
		try {
			List<Eloadas> eloadasok = new ArrayList<Eloadas>();
			utasitas2 = kapcsolat2.prepareStatement("SELECT* from eloadasok");
			
			ResultSet result = utasitas2.executeQuery();
			
			while (result.next()) {
				eloadasok.add(new Eloadas(result.getString("cim"), result.getString("rendezo"), 
					result.getDate("bemutato").toLocalDate(), result.getInt("eloadas_szam")));
			}
			
			result.close();
			return eloadasok;
			
		} catch (Exception e) {
			
			throw new SQLException("Beolvasás sikertelen AB hiba miatt");
		}
		
	}
	
	public static List<Eloadas> beolvasas() throws SQLException {
		
		
		try {
			List<Eloadas> eloadasok = new ArrayList<Eloadas>();
			utasitas = kapcsolat.prepareStatement("SELECT * from eloadasok");
			ResultSet result = utasitas.executeQuery();
			
			while (result.next()) {
				//cim, rendezo, bemutato, eloadas_szam
				eloadasok.add(new Eloadas(result.getString("cim"), result.getString("rendezo"), 
						result.getDate("bemutato").toLocalDate(), result.getInt("eloadas_szam")));
			}
			
			result.close();
			return eloadasok;
			
		} catch (Exception e) {
			throw new SQLException("Beolvasás sikertelen AB hiba miatt");
		}
		
		
	}
	
	

	public static void torles(Eloadas eloadas) throws SQLException {
		
		try {
			utasitas = kapcsolat.prepareStatement("DELETE from eloadasok WHERE cim=?");
			utasitas.setString(1, eloadas.getEloadasCime());
			utasitas.executeUpdate();
			utasitas.clearParameters();
			
		} catch (Exception e) {
			throw new SQLException("Törlés sikertelen!");
		}
		
	}
	
	public static void torles2(Eloadas eloadas) throws SQLException {
		
		try {
			utasitas2 = kapcsolat2.prepareStatement("DELETE from eloadasok WHERE cim=?");
			
			utasitas2.setString(1, eloadas.getEloadasCime());
			
			utasitas2.executeUpdate();
			
			utasitas2.clearParameters();
			
		} catch (Exception e) {
			throw new SQLException("Törlés sikertelen AB hiba miatt");
		}
		
		
	}

	public static void felvitel(Eloadas ujEloadas) throws SQLException {
		
		try {
			utasitas2 = kapcsolat2.prepareStatement("INSERT INTO eloadasok (cim, rendezo, bemutato, eloadas_szam) "
					+ "VALUES (?,?,?,?)");
			utasitas2.setString(1, ujEloadas.getEloadasCime());
			utasitas2.setString(2, ujEloadas.getRendezo());
			utasitas2.setString(3, String.valueOf(ujEloadas.getBemutato()));
			utasitas2.setInt(4, ujEloadas.getEloadasSzam());
			
			utasitas2.executeUpdate();
			utasitas2.clearParameters();
			
		} catch (Exception e) {
			throw new SQLException("Felvitel sikertelen AB hiba miatt");
		}
		
	}

	public static void modositas(Eloadas modEloadas) throws SQLException {
		
		try {
			utasitas2 = kapcsolat2.prepareStatement("UPDATE eloadasok SET eloadas_szam=? WHERE cim=?");
			utasitas2.setInt(1, modEloadas.getEloadasSzam());
			utasitas2.setString(2, modEloadas.getEloadasCime());
			
			utasitas2.executeUpdate();
			utasitas2.clearParameters();
			
			
		} catch (Exception e) {
			throw new SQLException("Módosítás sikertelen AB hiba miatt");
			
		}
		
	}
	
	
	/*
	 * R-BEOLVASÁS: select* from tabla
	 * (itt kell ResultSet result, a new előtt result = utasitas.executeQuery)
	 * 
	 * C-ÚJ: insert into tabla (sqloszlop1, sqloszlop2, sqloszlop3) values (?,?,?)
	 * 
	 * U-MÓDOSÍTÁS: update tabla SET sqloszlop2=?, sqloszlop3=? where sqloszlop1=?
	 * (ha 2 módosítandó adat van)
	 * 
	 * D-TÖRLÉS: delete from tabla where sqloszlop1=?
	 */
	
	
	/*
	 * beolvas
	 * utasitas = kapcsolat.PrepareStatement(SELECT* from tabla)
	 * ResultSet result = utasitas.executeQuery()
	 * 
	 * while res.next() {
	 * new Object (res.getString(sqloszlopcim);
	 * }
	 * res.close()
	 * 
	 * return List
	 * 
	 * 
	 *----
	 *
	 *új: 
	 *utasitas = kapcsolat.PrepareStatement(INSERT INTO tabla (oszlopcimek) values (?,?,?))
	 *utasitas.setString(1,ujObj.getCim);
	 *...
	 *utasitas.executeUpdate()
	 *utasitas.clearParameters()
	 *----
	 *
	 *módosítás:
	 *utasitas = kapcsolat.PrepareStatement(update tabla set oszlopcim=? where oszlopcim1=?)
	 *
	 *
	 *törlés:
	 *utasitas = kapcsolat.PrepareStatement(delete from tabla where oszlopcim1=?)
	 * 
	 * kapcsolat:
	 * String cim = JDBC_connection_string/database_name?autoReconnect=true&useSSL=?;
	 * kapcsolat = (Connection) DriverManager.getConnection(cim,"root","Vagyok1125");
	 * 
	 * beolvasas:
	 * utasitas = kapcsolat.PrepareStatement("SELECT* FROM table");
	 * ResultSet result = utasitas.executeQuery();
	 * 
	 * while (result.next()) {
	 * 
	 * lista.add(new Object(result.getString("nev"), result.getInt("eletkor"), result.getInt("szuletesiEv"));
	 * 
	 * }
	 * result.close();
	 * return lista;
	 * 
	 * uj objektum:
	 * utasitas = kapcsolat.PrepareStatement("INSERT INTO table (nev, eletkor, szuletesiEv) VALUES (?,?,?)");
	 * utasitas.setString(1,ujObject.getNev());
	 * utasitas.setInt(2,ujObject.getKor());
	 * utasitas.setInt(3,ujObject.getSzulEv());
	 * 
	 * utasitas.executeUpdate();
	 * utasitas.clearParameters();
	 * 
	 * modositas: UPDATE TABLE SET ATTRIBUTE WHERE ATTRIBUTE1
	 * utasitas = kapcsolat.PrepareStatement("UPDATE table SET kor=? WHERE nev=?");
	 * utasitas.setInt(1,ujObject.getKor());
	 * utasitas.setString(2,ujObject.getNev());
	 * 
	 * utasitas.executeUpdate();
	 * utasitas.clearParameters();
	 * 
	 * törlés: DELETE FROM TABLE WHERE ATTRIBUTE1=?
	 * utasitas = kapcsolat.PrepareStatement("DELETE from table WHERE nev=?");
	 * utasitas.setString(1,ujObject.getNev());
	 * 
	 * utasitas.executeUpdate();
	 * utasitas.clearParameters();
	 */
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
