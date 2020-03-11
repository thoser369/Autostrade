package application.dao;

import application.model.Tariffa;

public interface DAOTariffa {
	
    public Tariffa getTariffa(String nome);
	
	public boolean modifica_tariffa(String nome, float tariffa);

}
