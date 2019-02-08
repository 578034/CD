package no.hvl.dat102;

public class CD {
	
	private int cdnr;
	private String artist;
	private String tittel;
	private int lansering;
	public enum Sjanger {POP, ROCK, OPERA, KLASSISK}
	private Sjanger sjanger;
	private String plateselskap;

	
	public CD() {	
		this(0, "", "", 0, null, "");
	}
    
	public CD(int cdnr, String artist, String tittel, int lansering, Sjanger sjanger, 
			String plateselskap) {
		this.cdnr = cdnr;
		this.artist = artist;
		this.tittel = tittel;
		this.lansering = lansering;
		this.sjanger = sjanger;
		this.plateselskap = plateselskap;
	}

public int getcdnr() {
	return cdnr;
}

public void setcdnr(int cdnr) {
	this.cdnr = cdnr;
}

public String getartist() {
	return artist;
}

public void setartist(String artist) {
	this.artist = artist;
}

public String gettittel() {
	return tittel;
}

public void settittel(String tittel) {
	this.tittel = tittel;
}

public int getlansering() {
	return lansering;
}

public void setlansering(int lansering) {
	this.lansering = lansering;
}

public Sjanger getSjanger() {
	return sjanger;
}

public void setSjanger(Sjanger sjanger) {
	this.sjanger = sjanger;
}

public String getplateselskap() {
	return plateselskap;
}

public void setplateselskap(String plateselvskap) {
	this.plateselskap = plateselvskap;
}

@Override
public String toString() {
	return cdnr + "#" + artist + "#" + tittel + "#" + lansering + "#" + sjanger + "#" + plateselskap;
}

}

