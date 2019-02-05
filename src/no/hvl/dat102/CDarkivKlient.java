package no.hvl.dat102;

public class CDarkivKlient {

	public static void main(String[] args) {

		CD cd1 = new CD(1, "Terje", "Fæst", 1997, Sjanger.ROCK, "Oppdal LP");
		System.out.println(cd1.toString());
		
		CDarkivADT cda = new CDarkiv(10);
		Meny meny = new Meny(cda);
		
		meny.start();
		
	}
}
