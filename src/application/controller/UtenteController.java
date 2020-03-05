package application.controller;

import application.dao.DAODatabase;
import application.dao.DAOUtente;
import application.dao.MySqlUtente;
import application.model.Utente;

public class UtenteController {
	
	private MySqlUtente daoutente= new MySqlUtente();

	public UtenteController() {
		// TODO Auto-generated constructor stub
	}
	public static UtenteController getInstance() {
		return new UtenteController();
		}
		
		public Utente get(String username, String pwd) {
			return daoutente.getLogin(username, pwd);
		}
		public void a(String username, String pwd) {
			 daoutente.getA(username, pwd);
			 //System.out.print("ciao");
		}
		public boolean reg(String nome, String cognome, String username, String pwd) {
			 return daoutente.getRegistrazione(nome, cognome, username, pwd);
		}
		public boolean verifica_utente(String username) {
			return daoutente.verifica_utente(username);
		}
		public boolean verifica_utente_password(String utente, String password) {
			return daoutente.verifica_utente_password(utente, password);
		}
	
}
