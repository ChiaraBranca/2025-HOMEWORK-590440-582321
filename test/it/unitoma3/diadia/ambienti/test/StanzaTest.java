package it.unitoma3.diadia.ambienti.test;

import static org.junit.Assert.*;



import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaTest {
	
	private Stanza stanza;
	private Attrezzo spada;
	
	@Before
	public void setUp() {
		this.stanza = new Stanza("n11");
		this.spada = new Attrezzo("spada",10);
	}
	
	@Test
	public void testAddAttrezzo_stanzaVuota() {
		assertTrue(stanza.addAttrezzo(spada));
	}
	
	@Test
	public void testAddAttrezzo_stanzaConUnAttrezzo() {
		stanza.addAttrezzo(spada);
		Attrezzo zappa = new Attrezzo("zappa", 5);
		assertTrue(stanza.addAttrezzo(zappa));
	}
	
	@Test
	public void testGetAttrezzo_unicoAttrezzoInStanza() {
		stanza.addAttrezzo(spada);
		assertEquals(stanza.getAttrezzo("spada"), spada);
	}
	
	@Test
	public void testGetAttrezzo_stanzaConPiuAttrezzi() {
		stanza.addAttrezzo(spada);
		Attrezzo zappa = new Attrezzo("zappa",5);
		stanza.addAttrezzo(zappa);
		assertEquals(stanza.getAttrezzo("zappa"), zappa);;
	}
	
	@Test
	public void testGetAttrezzo_stanzaVuota() {
		assertNull(stanza.getAttrezzo("katana"));
	}
	
	@Test
	public void testRemoveAttrezzo_unaVolta() {
		stanza.addAttrezzo(spada);
		assertTrue(stanza.removeAttrezzo(spada));
	}
	
	@Test
	public void testRemoveAttrezzo_AttrezzoNonPresente() {
		assertFalse(stanza.removeAttrezzo(spada));
	}
	
	
	
	public void testRemoveAttrezzo() {
		stanza.addAttrezzo(spada);
	    
	    stanza.removeAttrezzo(spada);
	   
	    assertFalse(stanza.hasAttrezzo(spada.getNome()));
		
	}
	

}
