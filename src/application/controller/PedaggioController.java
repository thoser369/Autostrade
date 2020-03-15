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
    
	public float calcolo_pedaggio(String casellopartenza, String caselloarrivo, String classe, String targa) {
    	
    	int distanza, iva=0;
    	float tariffaunitaria, tariffaautostrada, tariffaambientale, pedaggio=0;
    	
    	distanza=(CaselloController.getInstance().getCasello(casellopartenza).getKm()) - 
				 (CaselloController.getInstance().getCasello(caselloarrivo).getKm());
    	if (distanza<0) distanza = distanza * (-1);
    	iva= SceltaClassePedaggioController.getInstance().getGestione().getIva();
    	tariffaunitaria=this.getTariffaVeicolo(VeicoloController.getInstance().getVeicolo(targa).getId_classeveicolo()).getTariffa();
    	if(classe.equals("Classe Unitaria")) {
    		tariffaautostrada=this.getTariffaAutostrada(CaselloController.getInstance().getCasello(casellopartenza).getId_autostrada()).getTariffa();
    		pedaggio= distanza * ( tariffaunitaria + tariffaautostrada);
    		//aggiunta iva
    		pedaggio= pedaggio + (pedaggio *iva / 100);
    		//arrotondamento
    		pedaggio = (float) (Math.round(pedaggio * 100) / 100.0);
        }else {
        	tariffaambientale=this.getTariffaAmbientale(VeicoloController.getInstance().getVeicolo(targa).getId_classeambientale()).getTariffa();
        	pedaggio= distanza * ( tariffaunitaria + tariffaambientale);
        	pedaggio= pedaggio + (pedaggio *iva / 100);
        	pedaggio = (float) (Math.round(pedaggio * 100) / 100.0);
        }
    	return pedaggio;
    }
	
	public boolean aggiungi_pedaggio_utente_casello(int idutente, int idcasellopartenza, int idcaselloarrivo) {
		return daopedaggio.aggiungi_pedaggio_utente_casello(idutente, idcasellopartenza, idcaselloarrivo);
	}
	
	public boolean aggiungi_pedaggio_utente_autostrada(int idutente, int idautostrada) {
		return daopedaggio.aggiungi_pedaggio_utente_autostrada(idutente, idautostrada);
	}
	
}
