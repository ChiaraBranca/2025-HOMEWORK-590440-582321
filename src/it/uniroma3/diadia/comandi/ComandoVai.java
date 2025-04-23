package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
<<<<<<< HEAD

public class ComandoVai implements Comando {
	private String direzione;

	public ComandoVai(String direzione) {
	this.direzione = direzione;
	}

	/**
	* esecuzione del comando
	*/
	@Override
	public void esegui(Partita partita) {
	// qui il codice per cambiare stanza ...
	public void esegui(Partita partita){

		Stanza stanzaCorrente = partita.getLabirinto().getStanzaCorrente(); 
		Stanza prossimaStanza = null; 
		if (direzione==null) { 
			System.out.println("Dove vuoi andare? Devi specificare una direzione"); 
			return; 
		} 
		prossimaStanza = stanzaCorrente.getStanzaAdiacente(this.direzione); 
		if (prossimaStanza==null) { 
			System.out.println("Direzione inesistente"); 
			return; 
		} 
		partita.getLabirinto().setStanzaCorrente(prossimaStanza); 
		System.out.println(partita.getLabirinto().getStanzaCorrente().getNome()); 
		partita.getGiocatore().setCfu (partita.getGiocatore().getCfu()-1); 
>>>>>>> simo
	}

}
