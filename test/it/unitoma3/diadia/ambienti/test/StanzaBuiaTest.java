package it.unitoma3.diadia.ambienti.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.ambienti.StanzaBuia;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaBuiaTest {
	
	private StanzaBuia stanzaBuia;
	private Attrezzo a1;
	private Attrezzo a2;
	
	@Before
	
	public void setUp() {
		this.a1= new Attrezzo("torcia",2);
		this.a2= new Attrezzo("martello", 5);
		this.stanzaBuia= new StanzaBuia("n11", "torcia");
	}
	
	@Test
	
	public void getDescrizioneTest() {
		//nella stanza non ci sono attrezzi
		assertEquals("qui c'è un buio pesto", stanzaBuia.getDescrizione());
		assertFalse(stanzaBuia.hasAttrezzo("torcia"));
		//nella stanza ci sono attrezzi ma non quella che la illumina
		stanzaBuia.addAttrezzo(a2);
		assertEquals("qui c'è un buio pesto", stanzaBuia.getDescrizione());
		assertFalse(stanzaBuia.hasAttrezzo("torcia"));
		assertTrue(stanzaBuia.hasAttrezzo("martello"));
		//nella stanza c'è la torcia 
		stanzaBuia.addAttrezzo(a1);
		assertTrue(stanzaBuia.hasAttrezzo("torcia"));
		String descrizioneAttesa = stanzaBuia.toString(); 
		assertEquals(descrizioneAttesa, stanzaBuia.getDescrizione());
	}

}
