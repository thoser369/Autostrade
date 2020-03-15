package application.controller;

import application.dao.ImpleDAOTariffa;
import application.model.Tariffa;

public class ModificaTariffaController {
	
	private ImpleDAOTariffa daotariffa= new ImpleDAOTariffa();

	public ModificaTariffaController() {
		// TODO Auto-generated constructor stub
	}
	
	public static ModificaTariffaController getInstance() {
		return new ModificaTariffaController();
    }
		
		public Tariffa getTariffaAmbientale(String classea) {
			return daotariffa.getTariffaAmbientale(classea);
		}
		public boolean modifica_tariffa(String nome, float tariffa) {
			return daotariffa.modifica_tariffa(nome, tariffa);
		}
		public Tariffa getTariffaVeicolo(String classev) {
			return daotariffa.getTariffaVeicolo(classev);
		}
}
