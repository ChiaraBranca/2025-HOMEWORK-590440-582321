package it.uniroma3.diadia;

import it.uniroma3.diadia.ambienti.*;
import it.uniroma3.diadia.giocatore.*;


/**
 * Questa classe modella una partita del gioco
 *
 * @author  docente di POO
 * @see Stanza
 * @version base
 */

public class Partita {

	private boolean finita;
	private Giocatore giocatore;
	private Labirinto labirinto;
	
	public Partita(){
		this.finita = false;
		this.labirinto= new Labirinto();
		this.giocatore= new Giocatore();
	}
	
	public void setLabirinto(Labirinto labirinto) {
		this.labirinto=labirinto;
	}
	
	public Labirinto getLabirinto() {
		return labirinto;
	}
	
	public void setGiocatore(Giocatore giocatore) {
		this.giocatore=giocatore;
	}
	public Giocatore getGiocatore() {
		return giocatore;
	}


	
	/**
	 * Restituisce vero se e solo se la partita e' stata vinta
	 * @return vero se partita vinta
	 */
	public boolean vinta() {
		return this.labirinto.getStanzaCorrente()== this.labirinto.getStanzaVincente();
	}

	/**
	 * Restituisce vero se e solo se la partita e' finita
	 * @return vero se partita finita
	 */
	public boolean isFinita() {
		return finita || vinta() || (giocatore.getCfu() == 0);
	}

	/**
	 * Imposta la partita come finita
	 *
	 */
	public void setFinita() {
		this.finita = true;
	}

}
