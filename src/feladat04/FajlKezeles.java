package feladat04;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;

public class FajlKezeles {
	
	public int beolvas(List<Rendeles> rendelesek, String fajlnev) throws IOException {
		
		int hibasTetelekSzama = 0;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(fajlnev),"UTF-8"));
		
		while (br.ready()) {
			
			String csvSor[] = br.readLine().split(";");
			
			if (ellenoriz(csvSor)) {
				
				rendelesek.add(new Rendeles(csvSor));
				
			}
			else {
				
				hibasTetelekSzama++;
				
			}
			
		}
		
		br.close();
		return hibasTetelekSzama;
		
	}

	public boolean ellenoriz(String[] csvSor) {
		
		return csvSor.length >= 5 && csvSor[0].length() >= 5;
		
	}

	public void kiirasFajlba(List<Rendeles> rendelesek, String fajl) throws IOException {
		
		try {
			
			OutputStreamWriter out = new OutputStreamWriter(new FileOutputStream(fajl, false), "UTF-8");
			
			String[] fejlec = {"Azonosito","Megnevezes","Mennyiseg","Osszertek","Surgos-e"};
			
			out.write(fejlec[0]);
			out.write(";");
			out.write(fejlec[1]);
			out.write(";");
			out.write(fejlec[2]);
			out.write(";");
			out.write(fejlec[3]);
			out.write(";");
			out.write(fejlec[4]);
			out.write("\n");
			
			for (int i = 0; i < rendelesek.size(); i++) {
				
				out.write(rendelesek.get(i).getSzallitoiAzonosito());
				out.write(";");
				out.write(rendelesek.get(i).getMegnevezes());
				out.write(";");
				out.write(String.valueOf(rendelesek.get(i).getMennyiseg()));
				out.write(";");
				out.write(String.valueOf(rendelesek.get(i).getOsszertek()));
				out.write(";");
				out.write((rendelesek.get(i).isSurgos()?"1":"0"));
				out.write("\n");
			}
			
			out.close();
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	


}
