package application.controller;

import application.dao.ImpleDAOUtente;
import application.model.Utente;

public class UtenteController {
	
	private ImpleDAOUtente daoutente= new ImpleDAOUtente();

	public UtenteController() {
		// TODO Auto-generated constructor stub
	}
	public static UtenteController getInstance() {
		return new UtenteController();
		}
		
		public Utente utente(String username) {
			return daoutente.utente(username);
		}
		public boolean registrazione(String nome, String cognome, String username, String pwd) {
			 return daoutente.Registrazione(nome, cognome, username, pwd);
		}
		public boolean verifica_utente_password(String utente, String password) {
			return daoutente.verifica_utente_password(utente, password);
		}
		public boolean verifica_utente(String username) {
			return daoutente.verifica_utente(username);
		}

	
}
