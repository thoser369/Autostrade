package application.controller;

import java.util.ArrayList;

import application.dao.MySqlCasello;
import application.model.Casello;

public class CaselloController {
	
	private MySqlCasello daocasello= new MySqlCasello();

	public CaselloController() {
		// TODO Auto-generated constructor stub
	}
	
	public static CaselloController getInstance() {
		return new CaselloController();
    }
	
	public Casello getCasello(String nome) {
		return daocasello.getCasello(nome);
	}
	public boolean aggiungiCasello(int idautostrada, String nome, int km) {
		return daocasello.aggiungiCasello(idautostrada, nome, km);
	}
	public boolean eliminaCasello(String nome) {
		return daocasello.eliminaCasello(nome);
	}
	public boolean eliminaCaselli(int idautostrada) {
		return daocasello.eliminaCaselli(idautostrada);
	}
	public ArrayList<String> getAllCaselli() {
		return daocasello.getAllCaselli();
	}

}
