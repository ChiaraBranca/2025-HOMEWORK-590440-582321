package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public class ComandoAiuto implements Comando{
	
	public ComandoAiuto() {
	}
	@Override
	public void esegui(Partita partita) {
		for(int i=0; i< elencoComandi.length; i++) 
			Io.mostraMessaggio(elencoComandi[i]+" ");
		Io.mostraMessaggio(" ");
	}

}
