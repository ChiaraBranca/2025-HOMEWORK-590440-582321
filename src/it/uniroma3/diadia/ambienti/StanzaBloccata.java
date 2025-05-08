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
		if(direzione_Bloccata.equals(direzione)&& this.hasAttrezzo(chiave)) {
			return this;
		}
		return super.getStanzaAdiacente(direzione);
	}
	
	@Override
	public String getDescrizione() {
		String Bloccato = "Questa stanza ha la direzione: " + direzione_Bloccata +"\n bloccata, per sblocarla usa: " + chiave + "\n e posalo nella stanza.";
		
		if(!this.hasAttrezzo(chiave)){
			return Bloccato;
		}
		return super.getDescrizione();
	}

}
