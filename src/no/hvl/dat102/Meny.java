package no.hvl.dat102;

import java.util.Scanner;

public class Meny {

	private Tekstgrensesnitt tekstgr;
	private CDarkivADT cda;
	
	public Meny(CDarkivADT cda) {
		tekstgr = new Tekstgrensesnitt();
		this.cda = cda;
	}
	
	Scanner sc = new Scanner(System.in);
	
	public boolean nyttEllerEksisterende() {
		boolean lest = false;
		
		System.out.println("Opprette nytt arkiv eller bruke eksisterende?");
		System.out.println("1 - Oprette nytt arkiv.");
		System.out.println("2 - Bruke eksisterende arkiv.");
		String fil;
		int input = sc.nextInt();
			sc.nextLine();
		
			
		switch(input) {
			
			case 1:
				System.out.println("Du har valgt å lage nytt arkiv.");
				this.cda = new CDarkiv();
				lest = true;
				break;
			
			case 2:
				System.out.println("Du har valgt å bruke eksisterende arkiv.");
				System.out.println("Skriv inn filnavn for eksisterende arkiv: ");
				fil = sc.nextLine() + ".txt";
				
				Fil.lesFraFil(cda, fil);
				
				lest = true;
				break;
			}
			return lest;
	}
	
	public void start() {
		nyttEllerEksisterende();
		standardValg();
	}
		
	public void switchMeny() {
		int input = sc.nextInt();
		sc.nextLine();
	
		switch(input) {
	
		case 1:
			System.out.println("Husk å lagre til fil når du har lagt til en CD.");
			cda.leggTilCd((CD) tekstgr.lesCD());
		
			break;
		
		case 2:
			System.out.println("Skriv inn nummer på CD som skal slettes: ");
			int slettnr = sc.nextInt();
				sc.hasNextLine();
			cda.slettCd(slettnr);
			System.out.println("CD nr." + slettnr + " ble slettet");
			System.out.println();
			break;
		
		case 3:
			System.out.println("Skriv inn hele eller del av tittel: ");
			String tittel = sc.nextLine();
			tekstgr.skrivUtCdDelstrengITittel(cda, tittel);
			System.out.println();
			break;
			
		case 4:
			System.out.println("Skriv inn hele eller del av artistnavn: ");
			String artist = sc.nextLine();
			tekstgr.skrivUtCdArtist(cda, artist);
			System.out.println();
			break;
			
		case 5:
			tekstgr.skrivUtStatistikk(cda);
			System.out.println();
			break;
			
		case 6:
			System.out.println("Skriv inn filnavnet du vil lagre til: ");
			String filnavn = sc.nextLine() + ".txt";
			Fil.skrivTilFil(cda, filnavn);
			break;
			
		case 7:
			System.out.println("Program avsluttet...");
			avslutt();
			
		default:
			System.out.println("Ugyldig input. Starter på nytt.");
			start();
			break;
		}
	}	
		
	public void avslutt() {
		System.exit(0);
	}
	
	public void standardValg() {
		System.out.println("1 - Lese inn CD og legge til i arkivet.");
		System.out.println("2 - Slette en CD.");
		System.out.println("3 - Skrive ut CD'er med en gitt delstreng i tittelen.");
		System.out.println("4 - Skrive ut CD'er med en gitt delstreng i artistnavnet.");
		System.out.println("5 - Skrive ut en oversikt over arkivet.");
		System.out.println("6 - Lagre arkivet på fil");
		System.out.println("7 - Avslutt.");
		switchMeny();
		standardValg();
	}
	
}
