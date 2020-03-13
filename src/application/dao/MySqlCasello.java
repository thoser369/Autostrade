package application.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import application.model.Casello;

public class MySqlCasello implements DAOCasello {
	private static final String DATI_CASELLO= "SELECT * FROM casello WHERE nome=?";
	private static final String AGGIUNGI_CASELLO="insert into casello(ID,ID_autostrada,nome,km) values (null,?,?,?)";
	private static final String ELIMINA_CASELLO= "DELETE FROM casello WHERE nome=?";
	private static final String DATI_CASELLI= "SELECT * FROM casello";

	@Override
	public Casello getCasello(String nome) {
		Casello casello= new Casello();
		Connection cn=null;
		PreparedStatement pst=null;
		ResultSet rst=null;	
		cn=MySqlConnessione.createConnection();
		try {
			pst=cn.prepareStatement(DATI_CASELLO);
			pst.setString(1, nome);
			rst=pst.executeQuery();
			if (rst.next()){
				casello.setId(rst.getInt("ID"));
				casello.setId_autostrada(rst.getInt("ID_autostrada"));
				casello.setNome(rst.getString("nome"));
				casello.setKm(rst.getInt("km"));
		    }  else casello.setNome("");
			cn.close();}catch (SQLException e)	{
			e.printStackTrace();
		} 
		
		return casello;
	}


	@Override
	public boolean aggiungiCasello(int idautostrada, String nome, int km) {
		int risultato=0;
    	Connection cn=null;
    	PreparedStatement pst=null;
		cn=MySqlConnessione.createConnection();
		try {
			pst=cn.prepareStatement(AGGIUNGI_CASELLO);
			pst.setInt(1,idautostrada);
			pst.setString(2,nome);
			pst.setInt(3,km);
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
	public boolean eliminaCasello(String nome) {
		int risultato=0;
    	Connection cn=null;
    	PreparedStatement pst=null;
		cn=MySqlConnessione.createConnection();
		try {
			pst=cn.prepareStatement(ELIMINA_CASELLO);
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
	public ArrayList<String> getAllCaselli() {
		ArrayList<String> caselli= new ArrayList<>();
		Connection cn=null;
		PreparedStatement pst=null;
		ResultSet rst=null;	
		cn=MySqlConnessione.createConnection();
		try {
			pst=cn.prepareStatement(DATI_CASELLI);
			rst=pst.executeQuery();
			while (rst.next()){
				caselli.add(rst.getString("nome"));
		}  
			cn.close();}catch (SQLException e)	{
			e.printStackTrace();
		} 
		
		return caselli;
	}

}
