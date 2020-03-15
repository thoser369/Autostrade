package application.model;

public class Veicolo {
    
	private int id;
	private int id_classeveicolo;
	private int id_classeambientale;
	private String modello;
	private String marca;
	private String targa;
	private String assi;
	private int peso;
	private int anno;
	private int altezza;

	public Veicolo() {
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return this.id;
	}
	public int setId(int n) {
		return this.id=n;
	}	
	public int getId_classeveicolo() {
		return this.id_classeveicolo;
	}
	public int setId_classeveicolo(int n) {
		return this.id_classeveicolo=n;
	}	
	public int getId_classeambientale() {
		return this.id_classeambientale;
	}
	public int setId_classeambientale(int n) {
		return this.id_classeambientale=n;
	}	
	public String getModello() {
		return this.modello;
	}
	public String setModello(String n) {
		return this.modello=n;
	}
	public String getMarca() {
		return this.marca;
	}
	public String setMarca(String n) {
		return this.marca=n;
	}
	public String getTarga() {
		return this.targa;
	}
	public String setTarga(String n) {
		return this.targa=n;
	}
	public String getAssi() {
		return this.assi;
	}
	public String setAssi(String n) {
		return this.assi=n;
	}
	public int getPeso() {
		return this.peso;
	}
	public int setPeso(int n) {
		return this.peso=n;
	}
	public int getAnno() {
		return this.anno;
	}
	public int seAnno(int n) {
		return this.anno=n;
	}
	public int getAltezza() {
		return this.altezza;
	}
	public int setAltezza(int n) {
		return this.altezza=n;
	}

	
}
