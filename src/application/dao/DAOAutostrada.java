package application.dao;

import java.util.ArrayList;

import application.model.Autostrada;

public interface DAOAutostrada {

	public Autostrada getAutostrada(String nome);
	
	public boolean verificaAutostrada(String nome);
	
	public boolean aggiungiAutostrada(String nome, float tariffa);
	
	public boolean eliminaAutostrada(String nome);
	
	public ArrayList<String> getAllAutostrade();
}
