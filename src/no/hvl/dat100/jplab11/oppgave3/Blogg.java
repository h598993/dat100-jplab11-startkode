package no.hvl.dat100.jplab11.oppgave3;

import no.hvl.dat100.jplab11.common.TODO;
import no.hvl.dat100.jplab11.oppgave1.*;

public class Blogg {

	// objektvariable
	private Innlegg[] innleggstabell;
	private int nesteledig;

	public Blogg() {
		innleggstabell = new Innlegg[20];
		nesteledig = 0;
	}

	public Blogg(int lengde) {
		innleggstabell = new Innlegg[lengde];
		nesteledig = 0;
	}

	public int getAntall() {
		return nesteledig;
	}

	public Innlegg[] getSamling() {
		return innleggstabell;

	}

	public int finnInnlegg(Innlegg innlegg) {
		int pos = 0;
		while (pos < nesteledig) {
			if (innleggstabell[pos].erLik(innlegg)) {
				return pos;
			}
			pos++;
		}
		return -1;
	}

	public boolean finnes(Innlegg innlegg) {
		for(int i = 0; i < nesteledig;i++) {
			if(innleggstabell[i].erLik(innlegg)) {
				return true;
			}
		}
		return false;
	}

	public boolean ledigPlass() {
		return nesteledig < innleggstabell.length;
	}

	public boolean leggTil(Innlegg innlegg) {
		if(!(finnes(innlegg)) && ledigPlass()) {
			innleggstabell[nesteledig] = innlegg;
			nesteledig++;
			return true;
		}
		return false;
	}

	public String toString() {
		
		String returStreng = "";
		
		for( int i = 0 ; i < nesteledig; i++) {
			returStreng += innleggstabell[i].toString();
		}
		
		
		return nesteledig + "\n" + returStreng;  
	}

	// valgfrie oppgaver nedenfor

	public void utvid() {
		throw new UnsupportedOperationException(TODO.method());
	}

	public boolean leggTilUtvid(Innlegg innlegg) {

		throw new UnsupportedOperationException(TODO.method());

	}

	public boolean slett(Innlegg innlegg) {

		throw new UnsupportedOperationException(TODO.method());
	}

	public int[] search(String keyword) {

		throw new UnsupportedOperationException(TODO.method());

	}
}