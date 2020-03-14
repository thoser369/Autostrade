package application.controller;

import java.util.ArrayList;

import application.dao.ImpleDAOPedaggio;
import application.model.Autostrada;
import application.model.Tariffa;

public class PedaggioController {
	
	private ImpleDAOPedaggio daopedaggio= new ImpleDAOPedaggio();

	public PedaggioController() {
		// TODO Auto-generated constructor stub
	}
	
	public static PedaggioController getInstance() {
		return new PedaggioController();
    }
	
	public ArrayList<String> getAllTarghe(int idutente) {
		return daopedaggio.getAllTarghe(idutente);
	}
	public Tariffa getTariffaVeicolo(int idtariffa) {
		return daopedaggio.getTariffaVeicolo(idtariffa);
	}
	public Tariffa getTariffaAmbientale(int idtariffa) {
		return daopedaggio.getTariffaAmbientale(idtariffa);
	}
	public Autostrada getTariffaAutostrada(int idautostrada) {
		return daopedaggio.getTariffaAutostrada(idautostrada);
	}


}
