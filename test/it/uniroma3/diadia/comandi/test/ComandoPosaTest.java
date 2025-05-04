package it.uniroma3.diadia.comandi.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.comandi.ComandoPosa;

public class ComandoPosaTest {
    private ComandoPosa comandoPosa;
    private Partita partita;
    private IO io;
    private Attrezzo attrezzo;

    @Before
    public void setUp() {
        this.comandoPosa = new ComandoPosa();
        this.partita = new Partita();
        this.io = new IOConsole();  // puoi sostituirla con una IO mockata se vuoi verificare l'output
        this.comandoPosa.setIO(io);
        this.attrezzo = new Attrezzo("chiave", 1);
    }

    @Test
    public void testPosaAttrezzoPresenteInBorsa() {
        partita.getGiocatore().getBorsa().addAttrezzo(attrezzo);
        comandoPosa.setParametro("chiave");
        comandoPosa.esegui(partita);

        
             
        assertTrue(partita.getLabirinto().getStanzaCorrente().hasAttrezzo("chiave"));
    }

    @Test
    public void testPosaAttrezzoNonPresenteInBorsa() {
        comandoPosa.setParametro("martello");
        comandoPosa.esegui(partita);

        assertFalse(partita.getLabirinto().getStanzaCorrente().hasAttrezzo("martello"));
    }

}
