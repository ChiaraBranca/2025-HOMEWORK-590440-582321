package it.uniroma3.diadia.attrezzi;

import java.util.Comparator;

public class ComparatoreAttrezziPerPeso implements Comparator<Attrezzo> {
	@Override
	public int compare(Attrezzo a1, Attrezzo a2) {
		int cmp = Integer.compare(a1.getPeso(), a2.getPeso());
	    if (cmp == 0)
	        return a1.getNome().compareTo(a2.getNome()); // risolve i pareggi
	    return cmp;
	}

}
