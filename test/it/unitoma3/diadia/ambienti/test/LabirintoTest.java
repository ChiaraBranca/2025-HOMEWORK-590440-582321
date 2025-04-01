package it.unitoma3.diadia.ambienti.test;
import static org.junit.Assert.*;

import org.junit.Test;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;

public class LabirintoTest {

   
    private Labirinto labirinto=new Labirinto();
    private Stanza atrio=labirinto.getStanzaCorrente();
    private Stanza biblioteca=labirinto.getStanzaVincente();



    @Test
    public void testGetStanzaVincente() {
        assertNotNull(labirinto.getStanzaVincente());
    }

    @Test
    public void testSetStanzaCorrente() {
    	assertEquals(atrio, labirinto.getStanzaCorrente());
        Stanza stanza = new Stanza("Test");
        labirinto.setStanzaCorrente(stanza);
        assertEquals(stanza, labirinto.getStanzaCorrente());
    }

}
