package it.unitoma3.diadia.test;

import static org.junit.Assert.assertFalse;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;


import it.uniroma3.diadia.Partita;

public class PartitaTest {
	
	public Partita partita = new Partita();
	
	@Before
	public void setUp() {
		
	}
	
	
	@Test
	public void testVinta_inAtrio() {
		assertFalse(this.partita.vinta());
	}
	
	@Test
	public void testVinta_inBiblioteca() {
		this.partita.getLabirinto().setStanzaCorrente(this.partita.getLabirinto().getStanzaVincente());
		assertTrue(this.partita.vinta());
	}
	
	@Test
	public void testIsFinita_nonFinita() {
		assertFalse(this.partita.vinta());
	}
	
	@Test
	public void testIsFinita_Xcfu() {
		this.partita.getGiocatore().setCfu(0);
		assertTrue(this.partita.isFinita());
	}
}
