package application.dao;

import application.model.Utente;

public interface DAOUtente {
	
	public Utente utente(String username);
	
	public boolean Registrazione(String nome, String cognome, String username, String pwd);
	
	public boolean verifica_utente_password(String utente, String passowrd);
	
	public boolean verifica_utente(String username);
	

}
