package application.controller;

import application.dao.MySqlClassePedaggio;
import application.model.SceltaClassePedaggio;

public class SceltaClassePedaggioController {
	
	private MySqlClassePedaggio daoclassepedaggio= new MySqlClassePedaggio();

	public SceltaClassePedaggioController() {
		// TODO Auto-generated constructor stub
	}
	
	public static SceltaClassePedaggioController getInstance() {
		return new SceltaClassePedaggioController();
    }
	
	public SceltaClassePedaggio getGestione() {
		return daoclassepedaggio.getGestione();
	}
	
	public boolean modifica_gestione(String gestione) {
		return daoclassepedaggio.modifica_gestione(gestione);
	}

}
