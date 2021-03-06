package application.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import application.model.SceltaClassePedaggio;

public class ImpleDAOClassePedaggio implements DAOClassePedaggio {
	private static final String GESTIONE_ATTUALE="SELECT * FROM gestione";
	private static final String MODIFICA_GESTIONE="UPDATE gestione SET nome=?";
	private static final String MODIFICA_IVA="UPDATE gestione SET Iva=?";

	@Override
	public SceltaClassePedaggio getGestione() {
		SceltaClassePedaggio gestione= new SceltaClassePedaggio();
		Connection cn=null;
		PreparedStatement pst=null;
		ResultSet rst=null;	
		cn=Connessione.createConnection();
		try {
			pst=cn.prepareStatement(GESTIONE_ATTUALE);
			rst=pst.executeQuery();
			if (rst.next()){
				gestione.setNome(rst.getString("nome"));
				gestione.setIva(rst.getInt("Iva"));
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
		cn=Connessione.createConnection();
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

	@Override
	public boolean modifica_iva(int nuovaiva) {
		int risultato=0;
    	Connection cn=null;
    	PreparedStatement pst=null;
		cn=Connessione.createConnection();
		try {
			pst=cn.prepareStatement(MODIFICA_IVA);
			pst.setInt(1,nuovaiva);
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
