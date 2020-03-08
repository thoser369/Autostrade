package application.dao;

import application.model.Veicolo;

public interface DAOVeicolo {
	
	public Veicolo getVeicolo(String targa);
	
	public boolean verifica_presenza_veicolo(String targa);
	
	public int getIDUtente(String username);
	
	public boolean aggiungi_veicolo(int idutente, String modello, String marca, String targa,
			                        String peso, String anno, int altezza, String assi);

}
