package application.model;

public class Veicolo {

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
