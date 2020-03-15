package application.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import application.model.Autostrada;

public class ImpleDAOAutostrada implements DAOAutostrada {
	
	private static final String DATI_AUTOSTRADA= "SELECT * FROM autostrada WHERE nome=?";
	private static final String AGGIUNGI_AUTOSTRADA="insert into autostrada(ID,nome,tariffa) values (null,?,?)";
	private static final String ELIMINA_AUTOSTRADA= "DELETE FROM autostrada WHERE nome=?";
	private static final String DATI_AUTOSTRADE= "SELECT * FROM autostrada";
	

	@Override
	public Autostrada getAutostrada(String nome) {
		Autostrada autostrada= new Autostrada();
		Connection cn=null;
		PreparedStatement pst=null;
		ResultSet rst=null;	
		cn=Connessione.createConnection();
		try {
			pst=cn.prepareStatement(DATI_AUTOSTRADA);
			pst.setString(1, nome);
			rst=pst.executeQuery();
			if (rst.next()){
				autostrada.setId(rst.getInt("ID"));
				autostrada.setNome(rst.getString("nome"));
				autostrada.setTariffa(rst.getFloat("tariffa"));
		}  else autostrada.setNome("");
			cn.close();}catch (SQLException e)	{
			e.printStackTrace();
		} 
		
		return autostrada;
	}

	@Override
	public boolean aggiungiAutostrada(String nome, float tariffa) {
		int risultato=0;
    	Connection cn=null;
    	PreparedStatement pst=null;
		cn=Connessione.createConnection();
		try {
			pst=cn.prepareStatement(AGGIUNGI_AUTOSTRADA);
			pst.setString(1,nome);
			pst.setFloat(2,tariffa);
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
	public boolean eliminaAutostrada(String nome) {
		int risultato=0;
    	Connection cn=null;
    	PreparedStatement pst=null;
		cn=Connessione.createConnection();
		try {
			pst=cn.prepareStatement(ELIMINA_AUTOSTRADA);
			pst.setString(1,nome);
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
	public boolean verificaAutostrada(String nome) {
		boolean autostrada=false;
		Connection cn=null;
    	PreparedStatement pst=null;
		ResultSet rst=null;
		cn=Connessione.createConnection();
		try {
			pst=cn.prepareStatement(DATI_AUTOSTRADA);
			pst.setString(1, nome);
			rst=pst.executeQuery();
			if (rst.next()) 
				autostrada=true;
			cn.close();
	
	} catch (SQLException e)	{
		e.printStackTrace();
		return false;
	} 
	return autostrada;
	
	}

	@Override
	public ArrayList<String> getAllAutostrade() {
		ArrayList<String> autostrade= new ArrayList<>();
		Connection cn=null;
		PreparedStatement pst=null;
		ResultSet rst=null;	
		cn=Connessione.createConnection();
		try {
			pst=cn.prepareStatement(DATI_AUTOSTRADE);
			rst=pst.executeQuery();
			while (rst.next()){
				autostrade.add(rst.getString("nome"));
		}  
			cn.close();}catch (SQLException e)	{
			e.printStackTrace();
		} 
		
		return autostrade;
	}

}
