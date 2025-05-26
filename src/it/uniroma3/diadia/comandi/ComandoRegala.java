package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.personaggi.AbstractPersonaggio;
import it.uniroma3.diadia.attrezzi.*;

public class ComandoRegala extends AbstractComando{
	private static final String MESSAGGIO_CON_CHI =

			"Con chi dovrei interagire?...";
	private String nomeAttrezzo;
	private String messaggio;
	private final static String NOME = "regala";

	@Override
	public void esegui(Partita partita) {
		AbstractPersonaggio personaggio;
		Attrezzo a=  partita.getGiocatore().getBorsa().getAttrezzo(this.getParametro());;
		personaggio = partita.getLabirinto().getStanzaCorrente().getPersonaggio();
		if (personaggio != null) {
			this.messaggio = personaggio.riceviRegalo(a,partita);
			getIo().mostraMessaggio(this.messaggio);

		} else
			getIo().mostraMessaggio(MESSAGGIO_CON_CHI);
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
