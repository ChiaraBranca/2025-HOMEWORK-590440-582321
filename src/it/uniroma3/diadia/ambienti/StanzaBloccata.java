package it.uniroma3.diadia.ambienti;

public class StanzaBloccata extends Stanza{
	
	private String direzione_Bloccata;
	private String chiave;
	
	public StanzaBloccata(String nome, String direzione_bloccata, String chiave) {
		super(nome);
		this.chiave = chiave;
		this.direzione_Bloccata = direzione_bloccata; 
	}
	
	@Override
	public Stanza getStanzaAdiacente(String direzione) {
		if (direzione_Bloccata.equals(direzione) && !this.hasAttrezzo(chiave)) {
			// Direzione bloccata e chiave mancante: non si può passare
			return this;
		}
		return super.getStanzaAdiacente(direzione);
	}
	
	@Override
	public String getDescrizione() {
		if (!this.hasAttrezzo(chiave)) {
			return "Stanza bloccata nella direzione: " + direzione_Bloccata +
			       "\nPrendi il " + chiave + " e posalo nella stanza";
		}
		return super.getDescrizione();
	}

}
