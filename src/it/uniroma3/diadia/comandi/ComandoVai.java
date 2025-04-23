package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

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
	}

}
