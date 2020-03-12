package application.dao;

import application.model.Tariffa;

public interface DAOTariffa {
	
    public Tariffa getTariffa(String nome);
	
	public boolean modifica_tariffa(String nome, float tariffa);
	
	public Tariffa getIDclasseveicolo(String classev);
	
	public Tariffa getIDclasseambientale(String classea);

}
