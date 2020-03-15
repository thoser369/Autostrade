package application.dao;

import java.util.ArrayList;

import application.model.Autostrada;
import application.model.Tariffa;

public interface DAOPedaggio {
	
	public ArrayList<String> getAllTarghe(int idutente);
	
    public Tariffa getTariffaVeicolo(int idtariffa);
    
    public Tariffa getTariffaAmbientale(int idtariffa);
    
    public Autostrada getTariffaAutostrada(int idautostrada);
    
    public boolean aggiungi_pedaggio_utente_casello(int idutente, int idcasellopartenza, int idcaselloarrivo);
    
    public boolean aggiungi_pedaggio_utente_autostrada(int idutente, int idautostrada);
}
