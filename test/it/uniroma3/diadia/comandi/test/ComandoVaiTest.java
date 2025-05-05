package it.uniroma3.diadia.comandi.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.comandi.ComandoVai;

public class ComandoVaiTest {
	
	private ComandoVai comandoVai;
	private IO io;
	private Stanza s1;
	private Stanza s2;
	private Partita partita;
	
	@Before 
	public void setUp() {
		this.partita= new Partita();
		this.io= new IOConsole();	
		this.comandoVai= new ComandoVai();
		this.s1= new Stanza("n11");
		this.s2= new Stanza("n12");
		partita.getLabirinto().setStanzaCorrente(s1);
		s1.impostaStanzaAdiacente("nord", s2);
		this.comandoVai.setIO(io);
		
		
	}
	
	@Test
	public void direzioneEsistenteTest() {
		this.comandoVai.setParametro("nord");
		comandoVai.esegui(partita);
		assertEquals("n12", partita.getLabirinto().getStanzaCorrente().getNome());
		
	}
	
	@Test
	public void direzioneInesistenteTest() {
		this.comandoVai.setParametro("sud");
		comandoVai.esegui(partita);
		assertEquals("n11", partita.getLabirinto().getStanzaCorrente().getNome());
		assertEquals(20, partita.getGiocatore().getCfu());
	}

}


