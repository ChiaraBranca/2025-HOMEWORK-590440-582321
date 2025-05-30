package it.uniroma3.diadia.personaggi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Cane extends AbstractPersonaggio {
	private static final String MESSAGGIO_CANE = "bau bau (il mio cibo preferito)";
	private static final String MESSAGGIO_CANE_ARRABBIATO = "GRRRR (ho fame)";
	private static final String CIBO_PREFERITO = "osso";
	private Attrezzo attrezzo;

	public Cane(String nome, String presentazione) {
		super(nome, presentazione);
	}

	@Override
	public String agisci(Partita partita) {
		String msg = MESSAGGIO_CANE_ARRABBIATO;
		partita.getGiocatore().setCfu(partita.getGiocatore().getCfu() - 1);
		return msg;

	}

	public String riceviRegalo(Attrezzo attrezzo, Partita partita) {
		if (attrezzo.getNome().equals(CIBO_PREFERITO)) {
			partita.getLabirinto().getStanzaCorrente().addAttrezzo(this.attrezzo);
			return MESSAGGIO_CANE;
		}
		partita.getGiocatore().setCfu(partita.getGiocatore().getCfu() - 1);
		return "bau (non voglio questo";

	}

}
