package feladat01;

import java.util.Scanner;

public class titkositoApplikacio {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Kérem, írjon be valamit!");
		
		String titkositandoSzoveg = sc.nextLine();
		
		String titkositottSzoveg = titkosit(titkositandoSzoveg);
		
		System.out.println(titkositottSzoveg);
		
		System.out.println(dekodolas(titkositottSzoveg));
		

	}
	
	public static String dekodolas(String szoveg) {
		
		String mitKellCserelni = "123456";
		String mireKellCserelni = "aetsk ";
		String dekodoltEredmeny = szoveg;
		
		for (int i = 0; i < mitKellCserelni.length(); i++) {
			dekodoltEredmeny = dekodoltEredmeny.replace(mitKellCserelni.charAt(i), mireKellCserelni.charAt(i));
        }
		
	    if (dekodoltEredmeny.length() > 1) {
	    	
	    	//dekodoltEredmeny = dekodoltEredmeny.charAt(dekodoltEredmeny.length()-1)+dekodoltEredmeny.substring(0, dekodoltEredmeny.length()-1);
	    	//dekodoltEredmeny = dekodoltEredmeny.substring(dekodoltEredmeny.length()-1)+
	    		//	dekodoltEredmeny.substring(0, dekodoltEredmeny.length()-1);
	    
	    }
	    return dekodoltEredmeny;
	}

	

	
	public static String titkosit(String titkositando) {
		
		String mitKellCserelni = "aetsk ";
		String mireKellCserelni = "123456";
		String eredmeny = titkositando;
		
	    for (int i = 0; i < mitKellCserelni.length(); i++)
        {
            eredmeny = eredmeny.replace(mitKellCserelni.charAt(i), mireKellCserelni.charAt(i));
        }

	    if (eredmeny.length() > 1) {
	    	
	    	//eredmeny = eredmeny.substring(1)+eredmeny.charAt(0);
	    	eredmeny = eredmeny.substring(1, eredmeny.length())+eredmeny.substring(0, 1);
	    	
	    }	    
		
		return eredmeny;
		
	}

}
