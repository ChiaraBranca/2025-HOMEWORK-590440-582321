package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaBuia extends Stanza{
	
	private String nomeAttrezzo;
	
	public StanzaBuia(String nome, String nomeAttrezzo) {
		super(nome);
		this.nomeAttrezzo=nomeAttrezzo;
	}
	
	@Override
	public String getDescrizione() {
		String a= new String();
		a="qui c'è un buio pesto";
		if(!this.hasAttrezzo(nomeAttrezzo)) {
			return a;
		}
		return super.getDescrizione();
	}
	
	

}
