package application.controller;

import application.dao.ImpleDAOClassePedaggio;
import application.model.SceltaClassePedaggio;

public class SceltaClassePedaggioController {
	
	private ImpleDAOClassePedaggio daoclassepedaggio= new ImpleDAOClassePedaggio();

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
