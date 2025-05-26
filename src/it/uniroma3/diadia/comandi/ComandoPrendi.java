package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPrendi extends AbstractComando{
	private String nomeAttrezzo;
	private final static String NOME = "prendi";


	@Override
	public void esegui(Partita partita) {
		Attrezzo a = partita.getLabirinto().getStanzaCorrente().getAttrezzo(nomeAttrezzo);
		if(a == null) { getIo().mostraMessaggio("attrezzo  non presente nella stanza \n");}
		else {
			partita.getGiocatore().getBorsa().addAttrezzo(a);
			partita.getLabirinto().getStanzaCorrente().removeAttrezzo(a);
			getIo().mostraMessaggio("Hai preso l'oggetto " + nomeAttrezzo);
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
