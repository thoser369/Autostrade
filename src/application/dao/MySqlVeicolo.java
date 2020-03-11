package application.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import application.model.Utente;
import application.model.Veicolo;

public class MySqlVeicolo implements DAOVeicolo {
	
	private static final String ID_UTENTE= "SELECT ID FROM utente WHERE username=?";
	private static final String ID_CLASSE_VEICOLO= "SELECT ID FROM classe_veicolo WHERE nome=?";
	private static final String ID_CLASSE_AMBIENTALE= "SELECT ID FROM classe_ambientale WHERE nome=?";
	private static final String DATI_VEICOLO= "SELECT * FROM veicolo WHERE targa=?";
	private static final String AGGIUNGI_VEICOLO= "insert into veicolo(ID,ID_utente,ID_classe_veicolo,ID_classe_ambientale,modello,marca,targa,peso,anno,altezza,assi) values (null,?,?,?,?,?,?,?,?,?,?);";

	@Override
	public Veicolo getVeicolo(String targa) {
		Veicolo veicolo=new Veicolo();
		Connection cn=null;
		PreparedStatement pst=null;
		ResultSet rst=null;	
		cn=MySqlConnessione.createConnection();
		try {
			pst=cn.prepareStatement(DATI_VEICOLO);
			pst.setString(1, targa);
			rst=pst.executeQuery();
			if (rst.next()){
				veicolo.setTarga(rst.getString("targa"));
		} 
			cn.close();}catch (SQLException e)	{
			e.printStackTrace();
		} 
		
		return veicolo;
	}

	@Override
	public boolean verifica_presenza_veicolo(String targa) {
		boolean veicolo_registrato=false;
		Connection cn=null;
    	PreparedStatement pst=null;
		ResultSet rst=null;
		cn=MySqlConnessione.createConnection();
		try {
			pst=cn.prepareStatement(DATI_VEICOLO);
			pst.setString(1, targa);
			rst=pst.executeQuery();
			if (rst.next()) 
				veicolo_registrato=true;
			cn.close();
	
	} catch (SQLException e)	{
		e.printStackTrace();
		return false;
	} 
	return veicolo_registrato;
	}

	@Override
	public int getIDUtente(String username) {
		Utente utente=new Utente();
		Connection cn=null;
		PreparedStatement pst=null;
		ResultSet rst=null;	
		cn=MySqlConnessione.createConnection();
		try {
			pst=cn.prepareStatement(ID_UTENTE);
			pst.setString(1, username);
			rst=pst.executeQuery();
			if (rst.next()){
				utente.setId(rst.getInt("id"));
		} 
			cn.close();
			}catch (SQLException e)	{
			e.printStackTrace();
		} 
		
		return utente.getId();
	}

	@Override
	public boolean aggiungi_veicolo(int idutente, int idclasseveicolo, int idclasseambientale, 
			String modello, String marca, String targa, String peso, String anno,
			int altezza, String assi) {
		int risultato=0;
    	Connection cn=null;
    	PreparedStatement pst=null;
		cn=MySqlConnessione.createConnection();
		try {
			pst=cn.prepareStatement(AGGIUNGI_VEICOLO);
			pst.setInt(1,idutente);
			pst.setInt(2,idclasseveicolo);
			pst.setInt(3,idclasseambientale);
			pst.setString(4,modello);
			pst.setString(5, marca);
			pst.setString(6, targa);
			pst.setString(7, peso);
			pst.setString(8, anno);
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
	public int getIDclasseveicolo(String classev) {
		int id=0;
		Connection cn=null;
		PreparedStatement pst=null;
		ResultSet rst=null;	
		cn=MySqlConnessione.createConnection();
		try {
			pst=cn.prepareStatement(ID_CLASSE_VEICOLO);
			pst.setString(1, classev);
			rst=pst.executeQuery();
			if (rst.next()){
				id= (rst.getInt("id"));
		} 
			cn.close();
			}catch (SQLException e)	{
			e.printStackTrace();
		} 
		
		return id;
	}

	@Override
	public int getIDclasseambientale(String classea) {
		int id=0;
		Connection cn=null;
		PreparedStatement pst=null;
		ResultSet rst=null;	
		cn=MySqlConnessione.createConnection();
		try {
			pst=cn.prepareStatement(ID_CLASSE_AMBIENTALE);
			pst.setString(1, classea);
			rst=pst.executeQuery();
			if (rst.next()){
				id= (rst.getInt("id"));
		} 
			cn.close();
			}catch (SQLException e)	{
			e.printStackTrace();
		} 
		
		return id;
	}

}
