package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Direzione;

public class ComandoNonValido extends AbstractComando {

	private final static String NOME = "non valido";
	
	public ComandoNonValido() {
		
	}
	@Override 
	public void esegui(Partita partita) {
		getIo().mostraMessaggio("Comando non valido");
	}
	

	@Override
	public String getNome() {
		return NOME;
	}

}
