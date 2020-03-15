package application.dao;

import application.model.Tariffa;

public interface DAOTariffa {
	
    public Tariffa getTariffaAmbientale(String classea);
	
	public boolean modifica_tariffa(String nome, float tariffa);
	
	public Tariffa getTariffaVeicolo(String classev);
	

}
