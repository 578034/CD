package no.hvl.dat102;

import no.hvl.dat102.CD.Sjanger;

public interface CDarkivADT {
    
	CD[] hentCdTabell();
	
	void leggTilCd(CD nyCd);
	
	boolean slettCd(int cdNr);
	
	CD[] sokTittel(String delstreng);
	
	CD[] sokArtist(String delstreng);
	
	int antallSjanger(Sjanger sjanger);

    int antall();
    }
    
    
