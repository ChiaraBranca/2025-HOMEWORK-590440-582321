package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Direzione;

public class ComandoGuarda extends AbstractComando {
	private final static String NOME = "guarda";
	
	
	public ComandoGuarda() {
	}
	@Override
	public void esegui( Partita partita) {
		getIo().mostraMessaggio(partita.getLabirinto().getStanzaCorrente().getDescrizione());
		getIo().mostraMessaggio("Hai ancora: "+partita.getGiocatore().getCfu()+ "CFU");
		getIo().mostraMessaggio(partita.getGiocatore().getBorsa().toString());
		
	}
	 @Override
	 public String getNome() {
		 return NOME;
		 
	 }

}
