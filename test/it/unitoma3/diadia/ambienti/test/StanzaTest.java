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
		assertEquals(spada, stanza.getAttrezzo("spada"));
	}

	@Test
	public void testGetAttrezzo_stanzaConPiuAttrezzi() {
		stanza.addAttrezzo(spada);
		Attrezzo zappa = new Attrezzo("zappa",5);
		stanza.addAttrezzo(zappa);
		assertEquals(zappa, stanza.getAttrezzo("zappa"));
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

	@Test
	public void testRemoveAttrezzo() {
		stanza.addAttrezzo(spada);
	    stanza.removeAttrezzo(spada);
	    assertFalse(stanza.hasAttrezzo(spada.getNome()));
	}

	@Test
	public void testHasAttrezzo_presente() {
		stanza.addAttrezzo(spada);
		assertTrue(stanza.hasAttrezzo("spada"));
	}

	@Test
	public void testHasAttrezzo_nonPresente() {
		assertFalse(stanza.hasAttrezzo("scudo"));
	}

	@Test
	public void testGetStanzaAdiacente_direzionePresente() {
		Stanza nord = new Stanza("nord");
		stanza.impostaStanzaAdiacente("nord", nord);
		assertEquals(nord, stanza.getStanzaAdiacente("nord"));
	}

	@Test
	public void testGetStanzaAdiacente_direzioneAssente() {
		assertNull(stanza.getStanzaAdiacente("sud"));
	}

	@Test
	public void testGetDirezioni_conUnaDirezione() {
		Stanza est = new Stanza("est");
		stanza.impostaStanzaAdiacente("est", est);
		assertTrue(stanza.getDirezioni().contains("est"));
	}

	@Test
	public void testGetDirezioni_vuoto() {
		assertTrue(stanza.getDirezioni().isEmpty());
	}

}
