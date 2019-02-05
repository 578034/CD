package no.hvl.dat102;

import java.util.Scanner;

public class Tekstgrensesnitt {

public Object lesCD() {
	System.out.println("Skriv inn CD-info slik: cdnr,artist,tittel,lansering,sjanger,plateselskap:");
	Scanner skriver = new Scanner(System.in);
	String CD = skriver.nextLine();
	String[] CDinfo = CD.split(",");
	CD lestCD = new CD(Integer.parseInt(CDinfo[0]),CDinfo[1],(CDinfo[2]),Integer.parseInt(CDinfo[3]),Sjanger.valueOf(CDinfo[4]),CDinfo[5]);
	return null;
}

public void visCD(CD cd) {
	
}

public void skrivUtCdDelstrengITittel(CDarkivADT cda, String delStreng) {
	
}

public void skrivUtCdArtist(CDarkivADT cda, String delStreng) {
	
}

public void skrivUtStatistikk(CDarkivADT cda) {
	
}

}

