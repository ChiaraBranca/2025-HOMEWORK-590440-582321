package it.uniroma3.diadia.giocatore.test;

import static org.junit.Assert.*;

import java.util.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.attrezzi.ComparatoreAttrezziPerPeso;
import it.uniroma3.diadia.giocatore.Borsa;

public class BorsaTest {

	Borsa borsa;
	Attrezzo a1;
	Attrezzo a2;
	Attrezzo a3;
	Attrezzo a4;

	@Before
	public void setUp() {
		borsa = new Borsa();
		a1 = new Attrezzo("torcia", 2);
		a2 = new Attrezzo("quaderno", 8);
		a3 = new Attrezzo("libro", 2);
		a4= new Attrezzo("astuccio", 4);
	}
	


	@Test
	public void testAddAttrezzo() {
		assertTrue(borsa.addAttrezzo(a1));
		assertTrue(borsa.addAttrezzo(a2));
		assertFalse(borsa.addAttrezzo(a3)); // peso max raggiunto (2+8=10)
	}

	@Test
	public void testGetAttrezzo() {
		borsa.addAttrezzo(a1);
		assertEquals(a1, borsa.getAttrezzo(a1.getNome()));
		borsa.addAttrezzo(a2);
		assertEquals(a2, borsa.getAttrezzo(a2.getNome()));
	}

	@Test
	public void testGetPeso() {
		borsa.addAttrezzo(a1);
		assertEquals(2, borsa.getPeso());
		borsa.addAttrezzo(a2);
		assertEquals(10, borsa.getPeso());
		borsa.removeAttrezzo(a1.getNome());
		assertEquals(8, borsa.getPeso());
	}

	@Test
	public void testIsEmpty() {
		assertTrue(borsa.isEmpty());
		borsa.addAttrezzo(a1);
		assertFalse(borsa.isEmpty());
	}

	@Test
	public void testHasAttrezzo() {
		assertFalse(borsa.hasAttrezzo(a1.getNome()));
		borsa.addAttrezzo(a1);
		assertTrue(borsa.hasAttrezzo(a1.getNome()));
	}



	@Test
	public void testGetSortedSetOrdinatoPerPesoAttrezziStessoPeso() {
		borsa.addAttrezzo(a1);
		borsa.addAttrezzo(a3);

		TreeSet<Attrezzo> expected = new TreeSet<>(new ComparatoreAttrezziPerPeso());
		expected.add(a1);
		expected.add(a3);

		assertEquals(expected, borsa.getSortedSetOrdinatoPerPeso());
	}

	@Test
	public void testGetContenutoOrdinatoPerNome() {
		borsa.addAttrezzo(a2); // quaderno
		borsa.addAttrezzo(a1); // torcia

		List<Attrezzo> ordinatiPerNome = new ArrayList<>();
		ordinatiPerNome.add(a2);
		ordinatiPerNome.add(a1);
		Collections.sort(ordinatiPerNome); // usa compareTo su nome

		assertEquals(new TreeSet<>(ordinatiPerNome), borsa.getContenutoOrdinatoPerNome());
	}

	@Test
	public void testGetContenutoOrdinatoPerPeso() {
		borsa.addAttrezzo(a2); // peso 8
		borsa.addAttrezzo(a1); // peso 2

		List<Attrezzo> expected = Arrays.asList(a1, a2);
		assertEquals(expected, borsa.getContenutoOrdinatoPerPeso());
	}
	
	@Test
	public void testGetContenutoRaggruppatoPerPeso() {
	    borsa.addAttrezzo(a1); // torcia (2)
	    borsa.addAttrezzo(a4); // astuccio (4)
	    borsa.addAttrezzo(a3); // libro (2)

	    Map<Integer, Set<Attrezzo>> aspettato = new TreeMap<>();
		Set<Attrezzo> sing1 = new HashSet<>();//2
		Set<Attrezzo> sing2 = new HashSet<>();//8
		
		sing1.add(a1);
		sing1.add(a3);
		sing2.add(a4);
		
		aspettato.put(2,sing1);
		aspettato.put(4, sing2);
		

	    assertEquals(aspettato,borsa.getContenutoRaggruppatoPerPeso());
	}


}

