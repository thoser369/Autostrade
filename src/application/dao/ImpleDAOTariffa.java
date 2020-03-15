package application.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import application.model.Tariffa;

public class ImpleDAOTariffa implements DAOTariffa{
	
	private static final String DATI_TARIFFA_AMBIENTALE= "SELECT * FROM classe_ambientale WHERE nome=?";
	private static final String MODIFICA_TARIFFA_AMBIENTALE="UPDATE classe_ambientale SET tariffa=? WHERE nome=?";
	private static final String DATI_TARIFFA_VEICOLO= "SELECT * FROM classe_veicolo WHERE nome=?";

	@Override
	public Tariffa getTariffaAmbientale(String classea) {
		Tariffa tariffa= new Tariffa();
		Connection cn=null;
		PreparedStatement pst=null;
		ResultSet rst=null;	
		cn=Connessione.createConnection();
		try {
			pst=cn.prepareStatement(DATI_TARIFFA_AMBIENTALE);
			pst.setString(1, classea);
			rst=pst.executeQuery();
			if (rst.next()){
				tariffa.setId(rst.getInt("ID"));
				tariffa.setNome(rst.getString("nome"));
				tariffa.setTariffa(rst.getFloat("tariffa"));
		}  
			cn.close();}catch (SQLException e)	{
			e.printStackTrace();
		} 
		
		return tariffa;
		
	}

	@Override
	public boolean modifica_tariffa(String nome, float tariffa) {
		int risultato=0;
    	Connection cn=null;
    	PreparedStatement pst=null;
		cn=Connessione.createConnection();
		try {
			pst=cn.prepareStatement(MODIFICA_TARIFFA_AMBIENTALE);
			pst.setFloat(1,tariffa);
			pst.setString(2,nome);
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
	public Tariffa getTariffaVeicolo(String classev) {
		Tariffa tariffa= new Tariffa();
		Connection cn=null;
		PreparedStatement pst=null;
		ResultSet rst=null;	
		cn=Connessione.createConnection();
		try {
			pst=cn.prepareStatement(DATI_TARIFFA_VEICOLO);
			pst.setString(1, classev);
			rst=pst.executeQuery();
			if (rst.next()){
				tariffa.setId(rst.getInt("ID"));
				tariffa.setNome(rst.getString("nome"));
				tariffa.setTariffa(rst.getFloat("tariffa"));
		}  
			cn.close();}catch (SQLException e)	{
			e.printStackTrace();
		} 
		
		return tariffa;
	}
}
