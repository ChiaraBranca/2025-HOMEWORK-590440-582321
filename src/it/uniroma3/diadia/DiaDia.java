package it.uniroma3.diadia;


import java.util.Scanner;
import it.uniroma3.diadia.giocatore.*;
import it.uniroma3.diadia.attrezzi.*;
import it.uniroma3.diadia.comandi.Comando;
import it.uniroma3.diadia.comandi.FabbricaDiComandiFisarmonica;
import it.uniroma3.diadia.ambienti.*;

/**
 * Classe principale di diadia, un semplice gioco di ruolo ambientato al dia.
 * Per giocare crea un'istanza di questa classe e invoca il letodo gioca
 *
 * Questa e' la classe principale crea e istanzia tutte le altre
 *
 * @author  docente di POO 
 *         (da un'idea di Michael Kolling and David J. Barnes) 
 *          
 * @version base
 */

public class DiaDia {

	 static final public String MESSAGGIO_BENVENUTO = ""+
			"Ti trovi nell'Universita', ma oggi e' diversa dal solito...\n" +
			"Meglio andare al piu' presto in biblioteca a studiare. Ma dov'e'?\n"+
			"I locali sono popolati da strani personaggi, " +
			"alcuni amici, altri... chissa!\n"+
			"Ci sono attrezzi che potrebbero servirti nell'impresa:\n"+
			"puoi raccoglierli, usarli, posarli quando ti sembrano inutili\n" +
			"o regalarli se pensi che possano ingraziarti qualcuno.\n\n"+
			"Per conoscere le istruzioni usa il comando 'aiuto'.";

	static final private String[] elencoComandi = {"vai", "aiuto", "fine","prendi","posa"};

	private Partita partita;
	private IO Io;
	private FabbricaDiComandiFisarmonica fabbrica;
	private Labirinto labirinto;

	public DiaDia(Labirinto labirinto,IO Io) {
		this.labirinto=labirinto;
		this.Io = Io;
		this.partita = new Partita(labirinto);
	}

	public void gioca() {
		String istruzione; 
		//Scanner scannerDiLinee;
		
		Io.mostraMessaggio(MESSAGGIO_BENVENUTO);		
		do		
			istruzione = Io.leggiRiga(); 
		while (!processaIstruzione(istruzione));
	}   


	/**
	 * Processa una istruzione 
	 *
	 * @return true se l'istruzione e' eseguita e il gioco continua, false altrimenti
	 */

	private boolean processaIstruzione(String istruzione) {
		
		Comando comandoDaEseguire;
		FabbricaDiComandiFisarmonica fabbrica = new FabbricaDiComandiFisarmonica(this.Io);
		comandoDaEseguire = fabbrica.costruisciComando(istruzione);
		comandoDaEseguire.esegui(partita);
		/*
		if (comandoDaEseguire.getNome().equals("fine")) {
			this.fine(); 
			return true;
		} else if (comandoDaEseguire.getNome().equals("vai"))
			this.vai(comandoDaEseguire.getParametro());
		else if (comandoDaEseguire.getNome().equals("aiuto"))
			this.aiuto();
		else if (comandoDaEseguire.getNome().equals("prendi"))
			this.prendi(comandoDaEseguire.getParametro());
		else if (comandoDaEseguire.getNome().equals("posa"))
			this.posa(comandoDaEseguire.getParametro());
		else
			Io.mostraMessaggio("Comando sconosciuto");*/
		
		if (this.partita.vinta()) {
			Io.mostraMessaggio("Hai vinto!");
			return true;
		} else
			return false;
	} 

	// implementazioni dei comandi dell'utente:

	/**
	 * Stampa informazioni di aiuto.
	 */
	/*
	private void aiuto() {
		for(int i=0; i< elencoComandi.length; i++) 
			Io.mostraMessaggio(elencoComandi[i]+" ");
		Io.mostraMessaggio(" ");
	}*/

	/**
	 * Cerca di andare in una direzione. Se c'e' una stanza ci entra 
	 * e ne stampa il nome, altrimenti stampa un messaggio di errore
	 */
	/*
	private void vai(String direzione) {
		if(direzione==null)
			Io.mostraMessaggio("Dove vuoi andare ?");
		Stanza prossimaStanza = null;
		prossimaStanza = this.partita.getLabirinto().getStanzaCorrente().getStanzaAdiacente(direzione);
		if (prossimaStanza == null)
			Io.mostraMessaggio("Direzione inesistente");
		else {
			this.partita.getLabirinto().setStanzaCorrente(prossimaStanza);
			int cfu = this.partita.getGiocatore().getCfu();
			this.partita.getGiocatore().setCfu(cfu--);
		}
		Io.mostraMessaggio(partita.getLabirinto().getStanzaCorrente().getDescrizione());
	}*/
	
	/**
	 * Comando "Fine".
	 */
/*	private void fine() {
		Io.mostraMessaggio("Grazie di aver giocato!");  // si desidera smettere
	}*/

/*	private void prendi(String nomeAttrezzo) {
		Attrezzo a = this.partita.getLabirinto().getStanzaCorrente().getAttrezzo(nomeAttrezzo);
		this.partita.getGiocatore().getBorsa().addAttrezzo(a);
		this.partita.getLabirinto().getStanzaCorrente().removeAttrezzo(a);
		Io.mostraMessaggio("Hai preso l'oggetto " + nomeAttrezzo);
	}*/

	/*private void posa(String nomeAttrezzo) {
		Attrezzo a=this.partita.getGiocatore().getBorsa().getAttrezzo(nomeAttrezzo);
		this.partita.getLabirinto().getStanzaCorrente().addAttrezzo(a);
		this.partita.getGiocatore().getBorsa().removeAttrezzo(nomeAttrezzo);
		Io.mostraMessaggio("Hai posato l'oggetto " + nomeAttrezzo);
		
		
	}*/

	public static void main(String[] argc) {
		 /*IO io = new IOConsole();
		 DiaDia gioco = new DiaDia(io);
		 gioco.gioca();*/
		/* N.B. unica istanza di IOConsole
		di cui sia ammessa la creazione */
		IO io = new IOConsole();
		Labirinto labirinto = new LabirintoBuilder()
										.addStanzaIniziale("Atrio")
										.addAttrezzo("martello", 3)
										.addStanza("Aula N11")
										.addStanza("Aula N10")
										.addAttrezzo("lanterna", 3)
										.addStanzaBuia("Laboratorio Campus", "lanterna")
										.addStanzaVincente("Biblioteca")
										.addAdiacenza("Atrio", "Biblioteca", "nord")
										.addAdiacenza("Atrio", "Aula N11", "est")
										.addAdiacenza("Atrio", "Aula N10", "sud")
										.addAdiacenza("Atrio", "Laboratorio Campus", "ovest")
										.addAdiacenza("Aula N11", "Laboratorio Campus", "est")
										.addAdiacenza("Aula N11", "Atrio", "ovest")
										.addAdiacenza("Aula N10", "Atrio", "nord")
										.addAdiacenza("Aula N10", "Aula N11", "est")
										.addAdiacenza("Aula N10", "Laboratorio Campus", "ovest")
										.addAdiacenza("Laboratorio Campus", "Atrio", "est")
										.addAdiacenza("Laboratorio Campus", "Aula N11", "ovest")
										.addAdiacenza("Biblioteca", "Atrio", "sud")
									
										.getLabirinto();
		DiaDia gioco = new DiaDia(labirinto,io);
		gioco.gioca();
	}
}