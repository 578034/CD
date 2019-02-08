package no.hvl.dat102;

import no.hvl.dat102.CD.Sjanger;

public abstract class CDarkiv2 implements CDarkivADT {

	private int antall = 0;
	private LinearNode start;
	private final String TOM = "CD arkivet er tomt";

	public CDarkiv2() {
		start = null;
		antall = 0;
	}

	@Override
	public CD[] hentCdTabell() {

		CD[] tab = new CD[antall];
		int i = 0;
		LinearNode denne = start;

		if (start == null) {
			System.out.println(TOM);
		} else {
			while (i < antall && denne != null) {
				tab[i] = (CD) denne.getElement();
				denne = denne.getNeste();
				i++;
			}
		}
		return tab;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void leggTilCd(CD nyCd) {
		LinearNode<CD> newNode = new LinearNode<CD>(nyCd);
		newNode.setNeste(start); 
		start = newNode; 
		antall++;

	}

	@Override
	public boolean slettCd(int cdNr) {
		boolean delete = false;
		LinearNode<CD> tempNode = start;
		LinearNode<CD> neste = tempNode.getNeste();

		if (start == null) { 
			return delete;
		}
		if (((CD) start.getElement()).getcdnr() == cdNr) { 
			start = start.getNeste();
			antall--;
			return true;
		}

		while (tempNode != null && delete != true) {

			if (tempNode.getElement().getcdnr() == cdNr && neste == null) {
				tempNode = null;
				antall--;
			}
			if (neste.getElement().getcdnr() == cdNr) {
				tempNode.setNeste(neste.getNeste());
				delete = true;
				antall--;

			} else {
				tempNode = tempNode.getNeste();
			}
		}
		return delete;
	}

	@Override
	public CD[] sokTittel(String delstreng) {

		CD[] tab = new CD[antall];
		int i = 0;
		LinearNode<CD> denne = start;

		if (antall == 0) {
			System.out.println(TOM);
		} else {
			while (denne != null) {
				if (denne.getElement().gettittel().contains(delstreng)) {
					tab[i] = denne.getElement();
					i++;
					denne = denne.getNeste();
				} else {
					denne = denne.getNeste();
				}
			}
		}
		tab = trimTab(tab, i);
		return tab;
	}

	@Override
	public CD[] sokArtist(String delstreng) {
		CD[] tab = new CD[antall];
		int i = 0;
		LinearNode<CD> denne = start;

		if (antall == 0) {
			System.out.println(TOM);
		} else {
			while (denne != null) {
				if (denne.getElement().getartist().contains(delstreng)) {
					tab[i] = denne.getElement();
					i++;
					denne = denne.getNeste();
				} else {
					denne = denne.getNeste();
				}
			}
			tab = trimTab(tab, i);
		}

		return tab;
	}

	private CD[] trimTab(CD[] tab, int n) { 
		int i = 0;
		CD[] cdtab2 = new CD[n];
		while (i < n) {
		         cdtab2[i] = tab[i];
		         i++;
		   }
		return cdtab2; 
	}
	
	@Override
	public int antall() {
		return antall;

	}
	@Override
	public int antallSjanger(Sjanger sjanger) {
		LinearNode<CD> denne = start;
		int nr = 0;

		while (denne != null) {
			if (denne.getElement().getSjanger() == sjanger) {
				nr++;
				denne = denne.getNeste();
			} else {
				denne = denne.getNeste();
			}
		}
		return nr;
	}

}