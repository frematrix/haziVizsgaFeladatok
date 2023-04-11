package feladat02;

public class Fa extends Noveny {
	
	private int magassag;
	
	public Fa(String azonosito, String megnevezes, String latinNev, int felfedezesEve, int magassag) {
		
		super(azonosito, megnevezes, latinNev, felfedezesEve);
		this.magassag = magassag;
		
		
	}

	public int getMagassag() {
		return magassag;
	}

	@Override
	public String toString() {
		return super.toString() + ", a fa magassága: " + magassag;
	}
	
	public void alapMetodus() {
		System.out.println("Ez egy fa.\n");
	}
	
	
	
	

}
