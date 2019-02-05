package no.hvl.dat102;

public class CDarkiv implements CDarkivADT {
      
	private CD[] cdarkiv;
	private int ant;
	
	public CDarkiv() {
		this.cdarkiv = new CD[20];
		this.ant = 0;
	}
	
	public CDarkiv(int størrelse) {
		this.cdarkiv = new CD[størrelse];
		this.ant = 0;
	}
	
	public CD[] hentCdTabell() {
		return this.cdarkiv;
	}
	
	public void leggTilCd(CD nyCd) {
		if (ant == cdarkiv.length)
		cdarkiv[ant] = nyCd;
		ant++;
	}
	
	public boolean slettCd(int cdNr) {
		for ( int i = 0; i < cdarkiv.length; i++) {
			if (cdarkiv[i].getcdnr() == cdNr) {
				cdarkiv[i] = cdarkiv[i-1];
				return true;
			}
		}
				return false;
	}
	
	public CD[] sokTittel(String delstreng) {
		CD[] tittel = new CD[cdarkiv.length];
		int j = 0;
		for (int i = 0; i < cdarkiv.length; i++) {
			if (cdarkiv[i].gettittel() == delstreng ) {
				tittel[j] = cdarkiv[i];
				j++;
			}
			
		}
		return tittel;
	}
	
	public CD[] sokArtist(String delstreng) {
		CD[] aNavn = new CD[cdarkiv.length];
		int j = 0;
		for (int i = 0; i < cdarkiv.length; i++) {
			if (cdarkiv[i].getartist() == delstreng ) {
				aNavn[j] = cdarkiv[i];
				j++;
			}
		}
		
		return aNavn;
	
	}
	
	public int antallSjanger(Sjanger sjanger) {
		int sAnt = 0;
		for (int i = 0; i < cdarkiv.length; i++)
			if (cdarkiv[i].getsjanger() == sjanger)
				sAnt++;
		return sAnt;
	}	

	public int antall() {
		return ant;
	}



	}

