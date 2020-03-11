package application.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import application.model.Tariffa;

public class MySqlTariffa implements DAOTariffa{
	
	private static final String DATI_TARIFFA= "SELECT * FROM classe_ambientale WHERE nome=?";
	private static final String MODIFICA_TARIFFA="UPDATE classe_ambientale SET tariffa=? WHERE nome=?";
	private static final String GESTIONE_ATTUALE="SELECT nome FROM gestione";
	private static final String MODIFICA_GESTIONE="UPDATE gestione SET nome=?";

	@Override
	public Tariffa getTariffa(String nome) {
		Tariffa tariffa= new Tariffa();
		Connection cn=null;
		PreparedStatement pst=null;
		ResultSet rst=null;	
		cn=MySqlConnessione.createConnection();
		try {
			pst=cn.prepareStatement(DATI_TARIFFA);
			pst.setString(1, nome);
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
	public boolean modifica_tariffa(String nome, float tariffa) {
		int risultato=0;
    	Connection cn=null;
    	PreparedStatement pst=null;
		cn=MySqlConnessione.createConnection();
		try {
			pst=cn.prepareStatement(MODIFICA_TARIFFA);
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
	public String getGestione() {
		String gestione= "";
		Connection cn=null;
		PreparedStatement pst=null;
		ResultSet rst=null;	
		cn=MySqlConnessione.createConnection();
		try {
			pst=cn.prepareStatement(GESTIONE_ATTUALE);
			rst=pst.executeQuery();
			if (rst.next()){
				gestione= (rst.getString("nome"));
		}  
			cn.close();}catch (SQLException e)	{
			e.printStackTrace();
		} 
		
		return gestione;
	}

	@Override
	public boolean modifica_gestione(String gestione) {
		int risultato=0;
    	Connection cn=null;
    	PreparedStatement pst=null;
		cn=MySqlConnessione.createConnection();
		try {
			pst=cn.prepareStatement(MODIFICA_GESTIONE);
			pst.setString(1,gestione);
			risultato=pst.executeUpdate();
		
		cn.close();
		
		} catch (SQLException e)	{
			e.printStackTrace();
			return false;
		} 
		if(risultato==1) return true;
		return false;
	}

}
