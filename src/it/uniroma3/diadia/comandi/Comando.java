package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Direzione;


public interface Comando {
	 public void esegui(Partita partita);
	 
	 public void setParametro(String parametro);
	 
	 public String getParametro() ;
	 
	 public void setIO( IO io);
	 
	 public String getNome();
}
