package application.dao;
import java.sql.SQLException;

import application.model.Utente;

public interface DAOUtente {
	
	public Utente getLogin(String username, String pwd);
	
	public void getA(String username, String pwd);
	
	public boolean getRegistrazione(String nome, String cognome, String username, String pwd);
	
	public boolean verifica_utente(String username);
	
	public boolean verifica_utente_password(String utente, String passowrd);

	//public boolean controllologin(String username1, String pwd1) throws SQLException;

}
