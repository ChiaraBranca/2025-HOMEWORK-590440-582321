package it.uniroma3.diadia.giocatore;

import it.uniroma3.diadia.attrezzi.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

import it.uniroma3.diadia.ambienti.*;

public class Borsa {
	public final static int DEFAULT_PESO_MAX_BORSA = 10;
	private Map<String,Attrezzo> nome2attrezzi;
	private int numeroAttrezzi;
	private int pesoMax;
	private int pesoAttuale;

	public Borsa() {
		this(DEFAULT_PESO_MAX_BORSA);
	}

	public Borsa(int pesoMax) {
		this.pesoMax = pesoMax;
		this.nome2attrezzi = new TreeMap<>() ; // speriamo bastino...
		this.numeroAttrezzi = 0;
		this.pesoAttuale = 0;
	}

	public boolean addAttrezzo(Attrezzo attrezzo) {
		if (this.getPeso() + attrezzo.getPeso() > this.getPesoMax())
			return false;
		if (this.numeroAttrezzi == 10)
			return false;
		this.nome2attrezzi.put(attrezzo.getNome(), attrezzo);
		this.numeroAttrezzi++;
		this.pesoAttuale+= attrezzo.getPeso();
		return true;
	}

	public int getPesoMax() {
		return pesoMax;
	}

	public Attrezzo getAttrezzo(String nomeAttrezzo) {
		Attrezzo a = null;
		if(nomeAttrezzo != null && this.nome2attrezzi.containsKey(nomeAttrezzo))
			a = this.nome2attrezzi.get(nomeAttrezzo);
		return a;
	}

	public int getPeso() {
		return pesoAttuale;
	}

	public boolean isEmpty() {
		return this.numeroAttrezzi == 0;
	}

	public boolean hasAttrezzo(String nomeAttrezzo) {
		return this.getAttrezzo(nomeAttrezzo) != null;
	}

	public Attrezzo removeAttrezzo(String nomeAttrezzo) {

		/*for (int i = 0; i < this.numeroAttrezzi; i++) {
			if (attrezzi[i].getNome().equals(nomeAttrezzo)) {
				Attrezzo rimosso = this.attrezzi[i];
				// sposto i puntatori
				for (int j = 1; j < this.numeroAttrezzi - 1; j++) {
					this.attrezzi[j] = this.attrezzi[j + 1];
				}
				this.attrezzi[this.numeroAttrezzi - 1] = null;
				this.numeroAttrezzi--;
				return rimosso;

			}

		}
		return null;*/
		if(this.nome2attrezzi.containsKey(nomeAttrezzo)) {
			Attrezzo a= this.nome2attrezzi.get(nomeAttrezzo);
			this.nome2attrezzi.remove(nomeAttrezzo);
			this.pesoAttuale-= a.getPeso();
			return a;
			
		}
		return null;
	}
	
	public List<Attrezzo> getContenutoOrdinatoPerPeso(){
		List<Attrezzo> attrezziOrdinati= new ArrayList<>();
		attrezziOrdinati.addAll(nome2attrezzi.values());
		Collections.sort(attrezziOrdinati,new ComparatoreAttrezziPerPeso());
		return attrezziOrdinati;
	}
	public SortedSet<Attrezzo> getContenutoOrdinatoPerNome(){
		SortedSet<Attrezzo> attrezziOrdinati= new TreeSet<>(nome2attrezzi.values());
		return attrezziOrdinati;
	}
	public Map<Integer,Set<Attrezzo>> getContenutoRaggruppatoPerPeso(){
		Map<Integer,Set<Attrezzo>> peso2attrezzi= new TreeMap<>();
		for(Attrezzo a: nome2attrezzi.values() ) {
			int peso= a.getPeso();
			//se il peso non è nella mappa
			if(!peso2attrezzi.containsKey(peso)) {
				peso2attrezzi.put(peso, new HashSet<Attrezzo>());
			}
			//se il peso è nella mappa
				peso2attrezzi.get(peso).add(a);
			
		}
		return peso2attrezzi;
	}
	
	public SortedSet<Attrezzo> getSortedSetOrdinatoPerPeso(){
		SortedSet<Attrezzo> attrezziOrdinati= new TreeSet<Attrezzo>(new ComparatoreAttrezziPerPeso());
		attrezziOrdinati.addAll(nome2attrezzi.values());
		return attrezziOrdinati;
	}

	public String toString() {
		StringBuilder s = new StringBuilder();

		if (!this.isEmpty()) {
			s.append("Contenuto borsa (" + this.getPeso() + "kg/" + this.getPesoMax() + "kg): ");
			/*for (int i = 0; i < this.numeroAttrezzi; i++)
				s.append(attrezzi[i].toString() + " ");*/
			/*for (Attrezzo attrezzo : this.nome2attrezzi.values()) {
				s.append(attrezzo.toString()).append(" ");
			}*/
			s.append("\n");
			s.append(this.getContenutoOrdinatoPerNome().toString());
			s.append("\n");
			s.append(this.getContenutoRaggruppatoPerPeso().toString());
			s.append("\n");
			s.append(this.getSortedSetOrdinatoPerPeso().toString());
		} else
			s.append("Borsa vuota");
		return s.toString();
	}
	
	public boolean getPesoRimanente(Attrezzo a) {
		if(a != null && this.getPesoMax()-this.getPeso()>=a.getPeso())
			return true;
		return false; 
	}
}
