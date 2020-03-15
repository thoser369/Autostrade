package application.model;

public class Pedaggio {
    
	private int id;
	private int id_utente;
	private int id_autostrada;
	private int id_casellopartenza;
	private int id_caselloarrivo;
	
	public Pedaggio() {
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return this.id;
	}
	public int setId(int n) {
		return this.id=n;
	}	
	public int getId_utente() {
		return this.id_utente;
	}
	public int setId_utente(int n) {
		return this.id_utente=n;
	}	
	public int getId_autostrada() {
		return this.id_autostrada;
	}
	public int setId_autostrada(int n) {
		return this.id_autostrada=n;
	}	
	public int getId_casello_partenza() {
		return this.id_casellopartenza;
	}
	public int setId_casello_partenza(int n) {
		return this.id_casellopartenza=n;
	}
	public int getId_casello_arrivo() {
		return this.id_caselloarrivo;
	}
	public int setId_casello_arrivo(int n) {
		return this.id_caselloarrivo=n;
	}

}
