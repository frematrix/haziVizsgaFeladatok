package feladat02;

public class botanikusKertApplikacio {

	public static void main(String[] args) {
		
		Noveny noveny1 = new Noveny("N001", "Növény1", "Latinnövény1", 2001);
		Fa fa1 = new Fa("F001", "Fa1", "Latinfa1", 2000, 45);
		Noveny noveny3 = new Noveny("N003", "Növény3", "Latinnövény3", 1983);
		Fa fa4 = new Fa("F004", "Fa4", "Latinfa4", 1942, 78);
		Fa fa5 = new Fa("F005", "Fa5", "Latinfa5", 1982, 58);
		
		Noveny[] novenyek = new Noveny[] {noveny1, fa1, noveny3, fa4, fa5};
		
		kiiratas(novenyek);
	

	}

	private static void kiiratas(Noveny[] novenyek) {
		
		for (Noveny noveny : novenyek) {
			System.out.println(noveny.toString()+", ennyi éve látogatható: "+noveny.hanyEveLatogathato());
			noveny.alapMetodus();
			
		}
		
	}



}
