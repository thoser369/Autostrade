package application.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import application.model.Veicolo;

public class ImpleDAOVeicolo implements DAOVeicolo {
	
	private static final String DATI_VEICOLO= "SELECT * FROM veicolo WHERE targa=?";
	private static final String AGGIUNGI_VEICOLO= "insert into veicolo(ID,ID_utente,ID_classe_veicolo,ID_classe_ambientale,modello,marca,targa,peso,anno,altezza,assi) values (null,?,?,?,?,?,?,?,?,?,?);";

	@Override
	public Veicolo getVeicolo(String targa) {
		Veicolo veicolo=new Veicolo();
		Connection cn=null;
		PreparedStatement pst=null;
		ResultSet rst=null;	
		cn=Connessione.createConnection();
		try {
			pst=cn.prepareStatement(DATI_VEICOLO);
			pst.setString(1, targa);
			rst=pst.executeQuery();
			if (rst.next()){
				veicolo.setId(rst.getInt("ID"));
				veicolo.setId_classeveicolo(rst.getInt("ID_classe_veicolo"));
				veicolo.setId_classeambientale(rst.getInt("ID_classe_ambientale"));
				veicolo.setTarga(rst.getString("modello"));
				veicolo.setTarga(rst.getString("marca"));
				veicolo.setTarga(rst.getString("targa"));
				veicolo.setTarga(rst.getString("assi"));
				veicolo.setPeso(rst.getInt("peso"));
				veicolo.setPeso(rst.getInt("anno"));
				veicolo.setPeso(rst.getInt("altezza"));
		}
			cn.close();}catch (SQLException e)	{
			e.printStackTrace();
		} 
		
		return veicolo;
	}
	
	@Override
	public boolean aggiungi_veicolo(int idutente, int idclasseveicolo, int idclasseambientale, 
			String modello, String marca, String targa, int peso, int anno,
			int altezza, String assi) {
		int risultato=0;
    	Connection cn=null;
    	PreparedStatement pst=null;
		cn=Connessione.createConnection();
		try {
			pst=cn.prepareStatement(AGGIUNGI_VEICOLO);
			pst.setInt(1,idutente);
			pst.setInt(2,idclasseveicolo);
			pst.setInt(3,idclasseambientale);
			pst.setString(4,modello);
			pst.setString(5, marca);
			pst.setString(6, targa);
			pst.setInt(7, peso);
			pst.setInt(8, anno);
			pst.setInt(9, altezza);
			pst.setString(10, assi);
			risultato=pst.executeUpdate();
		
		cn.close();
		
		} catch (SQLException e)	{
			e.printStackTrace();
			return false;
		} 
		if(risultato==1) return true;
		return false;
	}

	@Override
	public boolean verifica_veicolo(String targa) {
		boolean veicolo=false;
		Connection cn=null;
    	PreparedStatement pst=null;
		ResultSet rst=null;
		cn=Connessione.createConnection();
		try {
			pst=cn.prepareStatement(DATI_VEICOLO);
			pst.setString(1, targa);
			rst=pst.executeQuery();
			if (rst.next()) 
				veicolo=true;
			cn.close();
	
	} catch (SQLException e)	{
		e.printStackTrace();
		return false;
	} 
	return veicolo;
	}
}
