package application.controller;

import java.util.ArrayList;

import application.dao.Imple_DAOAutostrada;
import application.model.Autostrada;

public class AutostradaController {

	private Imple_DAOAutostrada daoautostrada= new Imple_DAOAutostrada();
	
	public AutostradaController() {
		// TODO Auto-generated constructor stub
	}
    
	public static AutostradaController getInstance() {
		return new AutostradaController();
    }
	
	public Autostrada getAutostrada(String nome) {
		return daoautostrada.getAutostrada(nome);
	}
	public boolean aggiungiAutostrada(String nome, float tariffa) {
		return daoautostrada.aggiungiAutostrada(nome, tariffa);
	}
	public boolean eliminaAutostrada(String nome) {
		return daoautostrada.eliminaAutostrada(nome);
	}
	public boolean verificaAutostrada(String nome) {
		return daoautostrada.verificaAutostrada(nome);
	}
	public ArrayList<String> getAllAutostrade() {
		return daoautostrada.getAllAutostrade();
	}
}
