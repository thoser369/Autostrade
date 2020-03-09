package application.dao;

import application.model.Utente;

public interface DAOUtente {
	
	public Utente Login(String username, String pwd);
	
	public void getA(String username, String pwd);
	
	public boolean Registrazione(String nome, String cognome, String username, String pwd);
	
	public boolean verifica_utente(String username);
	
	public boolean verifica_utente_password(String utente, String passowrd);
	
	//public boolean verifica_admin(String username);

}
