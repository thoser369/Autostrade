package application.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import application.model.Autostrada;
import application.model.Tariffa;

public class ImpleDAOPedaggio implements DAOPedaggio {
	
	private static final String DATI_TARGHE= "SELECT * FROM veicolo WHERE ID_utente=?";
	private static final String DATI_TARIFFA_VEICOLO= "SELECT * FROM classe_veicolo WHERE ID=?";
	private static final String DATI_TARIFFA_AMBIENTALE= "SELECT * FROM classe_ambientale WHERE ID=?";
	private static final String DATI_TARIFFA_AUTOSTRADA= "SELECT * FROM autostrada WHERE ID=?";

	@Override
	public ArrayList<String> getAllTarghe(int idutente) {
		ArrayList<String> targhe= new ArrayList<>();
		Connection cn=null;
		PreparedStatement pst=null;
		ResultSet rst=null;	
		cn=Connessione.createConnection();
		try {
			pst=cn.prepareStatement(DATI_TARGHE);
			pst.setInt(1, idutente);
			rst=pst.executeQuery();
			while (rst.next()){
				targhe.add(rst.getString("targa"));
		}  
			cn.close();}catch (SQLException e)	{
			e.printStackTrace();
		} 
		
		return targhe;
	}

	@Override
	public Tariffa getTariffaVeicolo(int idtariffa) {
		Tariffa tariffa= new Tariffa();
		Connection cn=null;
		PreparedStatement pst=null;
		ResultSet rst=null;	
		cn=Connessione.createConnection();
		try {
			pst=cn.prepareStatement(DATI_TARIFFA_VEICOLO);
			pst.setInt(1, idtariffa);
			rst=pst.executeQuery();
			if (rst.next()){
				tariffa.setNome(rst.getString("nome"));
				tariffa.setTariffa(rst.getFloat("tariffa"));
		}  
			cn.close();}catch (SQLException e)	{
			e.printStackTrace();
		} 
		
		return tariffa;
		
	}

	@Override
	public Tariffa getTariffaAmbientale(int idtariffa) {
		Tariffa tariffa= new Tariffa();
		Connection cn=null;
		PreparedStatement pst=null;
		ResultSet rst=null;	
		cn=Connessione.createConnection();
		try {
			pst=cn.prepareStatement(DATI_TARIFFA_AMBIENTALE);
			pst.setInt(1, idtariffa);
			rst=pst.executeQuery();
			if (rst.next()){
				tariffa.setNome(rst.getString("nome"));
				tariffa.setTariffa(rst.getFloat("tariffa"));
		}  
			cn.close();}catch (SQLException e)	{
			e.printStackTrace();
		} 
		
		return tariffa;
	}

	@Override
	public Autostrada getTariffaAutostrada(int idautostrada) {
		Autostrada autostrada= new Autostrada();
		Connection cn=null;
		PreparedStatement pst=null;
		ResultSet rst=null;	
		cn=Connessione.createConnection();
		try {
			pst=cn.prepareStatement(DATI_TARIFFA_AUTOSTRADA);
			pst.setInt(1, idautostrada);
			rst=pst.executeQuery();
			if (rst.next()){
				autostrada.setNome(rst.getString("nome"));
				autostrada.setTariffa(rst.getFloat("tariffa"));
		}  
			cn.close();}catch (SQLException e)	{
			e.printStackTrace();
		} 
		
		return autostrada;
	}


}
