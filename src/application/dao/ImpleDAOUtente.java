package application.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import application.model.Utente;

public class ImpleDAOUtente implements DAOUtente {
	
	private static final String ID_UTENTE= "SELECT ID FROM utente WHERE username=?";
	private static final String DATI_LOGIN= "SELECT * FROM utente WHERE username=? and password=?";
	private static final String DATI_REGISTRAZIONE="insert into utente(ID,nome,cognome,username,password,tipo) values (null,?,?,?,?,?);";
	private static final String VERIFICA_UTENTE="SELECT * FROM utente WHERE username=?";
	
	@Override
    public Utente Login(String username, String pwd){
		Utente nuovoutente= new Utente();
		Connection cn=null;
		PreparedStatement pst=null;
		ResultSet rst=null;	
		cn=Connessione.createConnection();
		try {
			pst=cn.prepareStatement(DATI_LOGIN);
			pst.setString(1, username);
			pst.setString(2, pwd);
			rst=pst.executeQuery();
			if (rst.next()){
				nuovoutente.setId(rst.getInt("ID"));
				nuovoutente.setUsername(rst.getString("username"));
				nuovoutente.setPassword(rst.getString("password"));	
				nuovoutente.setTipo(rst.getString("tipo"));
		}  
			cn.close();}catch (SQLException e)	{
			e.printStackTrace();
		} 
		
		return nuovoutente;
    }
	@Override
	public boolean Registrazione(String nome, String cognome, String username, String pwd){
		int risultato=0;
    	Connection cn=null;
    	PreparedStatement pst=null;
		cn=Connessione.createConnection();
		try {
			pst=cn.prepareStatement(DATI_REGISTRAZIONE);
			pst.setString(1,nome);
			pst.setString(2,cognome);
			pst.setString(3, username);
			pst.setString(4, pwd);
			pst.setString(5, "utente");
			risultato=pst.executeUpdate();
		
		cn.close();
		
		} catch (SQLException e)	{
			e.printStackTrace();
			return false;
		} 
		if(risultato==1) return true;
		return false;
	}
	public boolean verifica_utente(String username) {
		boolean utente_registrato=false;
		Connection cn=null;
    	PreparedStatement pst=null;
		ResultSet rst=null;
		cn=Connessione.createConnection();
		try {
			pst=cn.prepareStatement(VERIFICA_UTENTE);
			pst.setString(1, username);
			rst=pst.executeQuery();
			if (rst.next()) 
				utente_registrato=true;
			cn.close();
	
	} catch (SQLException e)	{
		e.printStackTrace();
		return false;
	} 
	return utente_registrato;
	}
	public boolean verifica_utente_password(String utente, String password) {
		boolean login=false;
		Connection cn=null;
    	PreparedStatement pst=null;
		ResultSet rst=null;
		cn=Connessione.createConnection();
		try {
			pst=cn.prepareStatement(DATI_LOGIN);
			pst.setString(1, utente);
			pst.setString(2, password);
			rst=pst.executeQuery();
			if (rst.next()) 
				login=true;
			cn.close();
	
	} catch (SQLException e)	{
		e.printStackTrace();
		return false;
	} 
	return login;
	}
	@Override
	public Utente getIDUtente(String username) {
		Utente utente=new Utente();
		Connection cn=null;
		PreparedStatement pst=null;
		ResultSet rst=null;	
		cn=Connessione.createConnection();
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
		
		return utente;
	}
}
