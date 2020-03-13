package application.dao;

import java.util.ArrayList;

import application.model.Casello;

public interface DAOCasello {

	public Casello getCasello(String nome);
	
	public boolean aggiungiCasello(int idautostrada, String nome, int km);
	
	public boolean eliminaCasello(String nome);
	
	public boolean eliminaCaselli(int idautostrada);
	
	public ArrayList<String> getAllCaselli();

}
