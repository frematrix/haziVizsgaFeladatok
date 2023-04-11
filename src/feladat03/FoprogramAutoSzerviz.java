package feladat03;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class FoprogramAutoSzerviz {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Adja meg az aktuális óradíjat");
		
		int oradij = Integer.parseInt(sc.nextLine());
		
		List<SzervizMunka> munkak = AdatbekeresSzerviz.bekeres();
		munkak.remove(munkak.size()-1);
		
		SzervizMunka legrovidebb = Collections.min(munkak, Comparator.comparing(obj -> obj.getMunkaOra()));
		
		System.out.println("A legrövidebb ideig tartó szerviztevékenység adatai: " + legrovidebb.getSzervizTevekenyseg()
		+", "+legrovidebb.getMunkaOra());
		
		mapSzerkezet(munkak, oradij);
		
		
			
	}

	private static void mapSzerkezet(List<SzervizMunka> munkak, int oradij) {
		Map<String,Integer> munkakMap = new HashMap<String,Integer>();
		
		for (SzervizMunka szervizMunka : munkak) {
			
			if (munkakMap.containsKey(szervizMunka.getSzervizTevekenyseg())) {
				munkakMap.replace(szervizMunka.getSzervizTevekenyseg(), munkakMap.get(szervizMunka.arKepzes(oradij)));
			}
			else {
				munkakMap.put(szervizMunka.getSzervizTevekenyseg(), szervizMunka.arKepzes(oradij));
			}
		}
		
		for (Map.Entry<String,Integer> munka : munkakMap.entrySet()) {
			
			System.out.println("Map szerkezet adatai: "+munka.getKey()+", "+munka.getValue()+ " Ft");
		}
		
	}
	
}
