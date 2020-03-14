package application.model;

public class Veicolo {
    
	int id;
	int id_classeveicolo;
	int id_classeambientale;
	String modello;
	String marca;
	String targa;
	String assi;
	int peso;
	int anno;
    int altezza;

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
