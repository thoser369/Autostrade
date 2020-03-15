package application.controller;

import application.dao.ImpleDAOVeicolo;
import application.model.Veicolo;

public class VeicoloController {
	
	private ImpleDAOVeicolo daoveicolo= new ImpleDAOVeicolo();

	public VeicoloController() {
		// TODO Auto-generated constructor stub
	}
	public static VeicoloController getInstance() {
		return new VeicoloController();
    }
		
		public Veicolo getVeicolo(String targa) {
			return daoveicolo.getVeicolo(targa);
		}
		
		public boolean aggiungi_veicolo(int idutente, int idclasseveicolo, int idclasseambientale,
				String modello, String marca, String targa, int peso, int anno,
				int altezza, String assi) {
			 return daoveicolo.aggiungi_veicolo(idutente,idclasseveicolo,idclasseambientale,modello,
					 marca,targa,peso,anno,altezza,assi);
		}
		
		public boolean verifica_veicolo(String targa) {
			return daoveicolo.verifica_veicolo(targa);
		}

}
