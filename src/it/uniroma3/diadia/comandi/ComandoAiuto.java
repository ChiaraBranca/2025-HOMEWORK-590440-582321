package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;

public class ComandoAiuto extends AbstractComando{
	
	static final public String[] ELENCO_COMANDI = {"vai", "aiuto", "fine","prendi", "posa", "guarda","interagisci","saluta"};
	private final static String NOME = "aiuto";
	
	public ComandoAiuto() {
	}
	@Override
	public void esegui(Partita partita) {
		for(int i=0; i< ELENCO_COMANDI.length; i++) 
			getIo().mostraMessaggio(ELENCO_COMANDI[i]+" ");
		getIo().mostraMessaggio("");
	}
	
	@Override
	public String getNome() {
		return NOME;
	}

}
