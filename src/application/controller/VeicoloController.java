package application.controller;

import application.dao.MySqlVeicolo;
import application.model.Veicolo;

public class VeicoloController {
	
	private MySqlVeicolo daoveicolo= new MySqlVeicolo();

	public VeicoloController() {
		// TODO Auto-generated constructor stub
	}
	public static VeicoloController getInstance() {
		return new VeicoloController();
    }
		
		public Veicolo getVeicolo(String targa) {
			return daoveicolo.getVeicolo(targa);
		}
		
		public boolean aggiungi_veicolo(int idutente, String modello, String marca, String targa, String peso, String anno,
				int altezza, String assi) {
			 return daoveicolo.aggiungi_veicolo(idutente,modello,marca,targa,peso,anno,altezza,assi);
		}
		public int getIDUtente(String username) {
			return daoveicolo.getIDUtente(username);
		}
		public boolean verifica_presenza_veicolo(String targa) {
			return daoveicolo.verifica_presenza_veicolo(targa);
		}

}
