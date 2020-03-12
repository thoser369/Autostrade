package application.model;

import java.util.ArrayList;

public class Autostrada {
	
	int id;
	String nome;
	float tariffa;
	 ArrayList<Casello> autostrada;
	   
		public Autostrada() {
			// TODO Auto-generated constructor stub
		}
		public int getId() {
			return this.id;
		}
		public int setId(int n) {
			return this.id=n;
		}	
	    public String getNome() {
		    return this.nome;
	    }
	    public String setNome(String n) {
		    return this.nome=n;
	    }
	    public float getTariffa() {
		    return this.tariffa;
	    }
	    public float setTariffa(float n) {
		    return this.tariffa=n;
	    }
		public ArrayList<Casello> getAutostrada() {
			return this.autostrada;
		}
		public ArrayList<Casello> setAutostrada(ArrayList<Casello> n) {
			return this.autostrada=n;
		}

	}
