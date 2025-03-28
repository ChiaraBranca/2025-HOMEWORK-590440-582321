import static org.junit.Assert.*;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;

public class BorsaTest {
	
	Borsa b=new Borsa();
	Attrezzo a1= new Attrezzo("torcia",2);
	Attrezzo a2= new Attrezzo("quaderno",8);
	Attrezzo a3= new Attrezzo("libro",2);
	
	@Test
//provaprova	
	public void testAddAttrezzo() {
		assertTrue(b.addAttrezzo(a1));
		assertTrue(b.addAttrezzo(a2));
		assertFalse(b.addAttrezzo(a3));
	}
	
	public void testGetAttrezzo() {
		//un attrezzo in borsa
		b.addAttrezzo(a1);
		assertEquals(a1.getNome(),b.getAttrezzo(a1.getNome()));
		//dua attrezzi in borsa
		b.addAttrezzo(a2);
		assertEquals(a1.getNome(),b.getAttrezzo(a1.getNome()));
		assertEquals(a2.getNome(),b.getAttrezzo(a2.getNome()));
	}
	
	public void testGetPeso() {
		//un oggetto in borsa
		b.addAttrezzo(a1);
		assertEquals("2",b.getPeso());
		assertEquals(a1.getPeso(),b.getPeso());
		//due oggetti in borsa
		b.addAttrezzo(a2);
		assertEquals("10",b.getPeso());
		assertEquals(a1.getPeso()+a2.getPeso(),b.getPeso());
		//rimuovo un oggetto
		b.removeAttrezzo(a1.getNome());
		assertEquals("8",b.getPeso());
	}
	
	public void testIsEmpty() {
		assertTrue(b.isEmpty());
		b.addAttrezzo(a1);
		assertFalse(b.isEmpty());
	}
	
	
	public void testHasAttrezzo() {
		assertFalse(b.hasAttrezzo(a1.getNome()));
		b.addAttrezzo(a1);
		assertTrue(b.hasAttrezzo(a1.getNome()));
	}
	
	public void testRemoveAttrezzo() {
		b.addAttrezzo(a1);
		b.removeAttrezzo(a1.getNome());
		assertTrue(b.isEmpty());
		//aggiungo due oggetti e ne rimuovo uno
		b.addAttrezzo(a1);
		b.addAttrezzo(a2);
		b.removeAttrezzo(a1.getNome());
		assertEquals("8",b.getPeso());
		assertFalse(b.hasAttrezzo(a1.getNome()));
		
	}
	

}
