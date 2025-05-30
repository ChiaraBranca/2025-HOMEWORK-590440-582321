package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;

public class ComandoPosa extends AbstractComando {
	private String nomeAttrezzo;
	private final static String NOME = "posa";


	@Override
	public void esegui(Partita partita) {
		Attrezzo a=partita.getGiocatore().getBorsa().getAttrezzo(nomeAttrezzo);

	    if(a != null) {
	    	partita.getGiocatore().getBorsa().removeAttrezzo(nomeAttrezzo);
	        partita.getLabirinto().getStanzaCorrente().addAttrezzo(a);  
	        getIo().mostraMessaggio("Hai posato l'oggetto " + nomeAttrezzo);
	    } else {
	        getIo().mostraMessaggio("Non c'e' l'attrezzo nella borsa");
	    }
	}

	@Override
	public void setParametro(String parametro) {
		this.nomeAttrezzo  = parametro;

	}

	@Override
	public String getParametro() {
		return this.nomeAttrezzo;
	}

	@Override
	public String getNome() {
		return NOME;
	}

}
