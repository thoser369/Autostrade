package application.dao;

import application.model.SceltaClassePedaggio;

public interface DAOClassePedaggio {

	
	public SceltaClassePedaggio getGestione();
	
	public boolean modifica_gestione(String gestione);

}
