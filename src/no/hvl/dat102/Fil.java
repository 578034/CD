package no.hvl.dat102;

import no.hvl.dat102.CD.Sjanger;
import no.hvl.dat102.adt.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Fil {
	
	final static String SKILLE = "#";
	
	public static void lesFraFil(CDarkivADT CDarkiv, String filnavn) {
		
		FileReader fil = null;
		try {
			fil = new FileReader(filnavn);
		}catch(FileNotFoundException e) {
			System.out.println("Filen er ikke funnet");
		}
		
		
		BufferedReader leser = null;
		int n;
		String CDinfo;
		try {
		
		leser = new BufferedReader(fil);
		n = Integer.parseInt(leser.readLine());
		CDinfo = leser.readLine();
		for (int i = 0; i < n; i++) {
			String[] cd = CDinfo.split(SKILLE);
			
			int cdnr = Integer.parseInt(cd[0]);
			String artist = cd[1];
			String tittel = cd[2];
			int lansering = Integer.parseInt(cd[3]);
			Sjanger sjanger = Sjanger.valueOf(cd[4]);
			String plateselskap = cd[5];
			CDinfo = leser.readLine();
			CD cd1 = new CD(cdnr, artist, tittel, lansering, sjanger, plateselskap);
			System.out.println(cd1.toString());
		
		}
		fil.close();
		}catch(IOException e) {
			System.out.println("Det skjedde en feil");
		}
		
	}
	
public static void skrivTilFil(CDarkivADT cdarkiv, String filnavn) {
		
		FileWriter fil = null;
		int n;
		try {
			fil = new FileWriter(filnavn);
			PrintWriter skriver = new PrintWriter(fil);
			n = cdarkiv.antall();
			CD[] cd = cdarkiv.hentCdTabell();
			skriver.println(n);
			for (int i = 0; i < n; i++) {
				skriver.print(cd[i].getcdnr()); skriver.print(SKILLE);
				skriver.print(cd[i].getartist()); skriver.print(SKILLE);
				skriver.print(cd[i].gettittel()); skriver.print(SKILLE);
				skriver.print(cd[i].getlansering()); skriver.print(SKILLE);
				skriver.print(cd[i].getSjanger()); skriver.print(SKILLE);
				skriver.print(cd[i].getplateselskap()); skriver.println();
			}
			fil.close();
		}catch(IOException e) {
			System.out.println("Problemer med filen");
		}
		
		System.out.println("Printet ut til filen");
		
	}


}



