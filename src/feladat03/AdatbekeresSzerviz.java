package feladat03;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AdatbekeresSzerviz {

	public static List<SzervizMunka> bekeres() {
		
		List<SzervizMunka> munkak = new ArrayList<SzervizMunka>();
		
		Scanner sc = new Scanner(System.in);
		
		int ora;
		
		do {
			System.out.println("Adja meg a tevékenység nevét!");
			String tevekenyseg = sc.nextLine();
			System.out.println("Adja meg az óra számot!");
			ora = Integer.parseInt(sc.nextLine());
			SzervizMunka munka = new SzervizMunka(tevekenyseg, ora);
			munkak.add(munka);
		} while (ora!=0);
		return munkak;
	}
	
	
	
	

}
