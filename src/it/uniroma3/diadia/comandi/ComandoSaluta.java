package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;

public class ComandoSaluta extends AbstractComando {

	private final static String NOME = "saluta";

	@Override
	public void esegui(Partita partita) {
		if(partita.getLabirinto().getStanzaCorrente().getPersonaggio()!=null)
			getIo().mostraMessaggio(partita.getLabirinto().getStanzaCorrente().getPersonaggio().saluta());
		else 
			getIo().mostraMessaggio("Non c'e' alcun personaggio in questa stanza!");
	}

	@Override
	public String getNome() {
		return NOME;
	}

}
