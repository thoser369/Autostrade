package application.model;

public class Veicolo {

	String modello;
	String marca;
	String targa;
	String assi;
	String peso;
	String anno;
    int altezza;
	float tariffa_unitaria;

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
	public String getPeso() {
		return this.peso;
	}
	public String setPeso(String n) {
		return this.peso=n;
	}
	public String getAnno() {
		return this.anno;
	}
	public String seAnno(String n) {
		return this.anno=n;
	}
	public int getAltezza() {
		return this.altezza;
	}
	public int setAltezza(int n) {
		return this.altezza=n;
	}
	public float getTariffaUnitaria() {
		return this.tariffa_unitaria;
	}
	public float setTariffaUnitaria(float n) {
		return this.tariffa_unitaria=n;
	}
	
}
