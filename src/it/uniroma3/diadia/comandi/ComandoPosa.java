package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;

public class ComandoPosa implements Comando {
	private IO io;
	private String nomeAttrezzo;
	private final static String NOME = "posa";


	@Override
	public void esegui(Partita partita) {
		Attrezzo a=partita.getGiocatore().getBorsa().getAttrezzo(nomeAttrezzo);
		partita.getLabirinto().getStanzaCorrente().addAttrezzo(a);
		partita.getGiocatore().getBorsa().removeAttrezzo(nomeAttrezzo);
		io.mostraMessaggio("Hai posato l'oggetto " + nomeAttrezzo);
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
	public void setIO(IO io) {
		this.io = io;
	}

	@Override
	public String getNome() {
		return NOME;
	}

}
