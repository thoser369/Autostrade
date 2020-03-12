package application.controller;

import application.dao.MySqlTariffa;
import application.model.Tariffa;

public class ModificaTariffaController {
	
	private MySqlTariffa daotariffa= new MySqlTariffa();

	public ModificaTariffaController() {
		// TODO Auto-generated constructor stub
	}
	
	public static ModificaTariffaController getInstance() {
		return new ModificaTariffaController();
    }
		
		public Tariffa getTariffa(String nome) {
			return daotariffa.getTariffa(nome);
		}
		public boolean modifica_tariffa(String nome, float tariffa) {
			return daotariffa.modifica_tariffa(nome, tariffa);
		}
		public Tariffa getIDclasseveicolo(String classev) {
			return daotariffa.getIDclasseveicolo(classev);
		}
		public Tariffa getIDclasseambientale(String classea) {
			return daotariffa.getIDclasseambientale(classea);
		}
		
		
}
