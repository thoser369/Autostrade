package application.dao;

import application.model.Veicolo;

public interface DAOVeicolo {
	
	public Veicolo getVeicolo(String targa);
	
	public boolean aggiungi_veicolo(int idutente, int idclasseveicolo, int idclasseambientale,
			String modello, String marca, String targa,
			int peso, int anno, int altezza, String assi);
	
	public boolean verifica_veicolo(String targa);

}
