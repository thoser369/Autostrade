package application.model;

public class Casello {
   
	private int id;
	private int Id_autostrada;
	private String nome;
	private int km;

	public Casello() {
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return this.id;
	}
	public int setId(int n) {
		return this.id=n;
	}	
	public int getId_autostrada() {
		return this.Id_autostrada;
	}
	
	public int setId_autostrada(int n) {
		return this.Id_autostrada=n;
	}	
	public String getNome() {
		return this.nome;
	}
	public String setNome(String n) {
		return this.nome=n;
	}
	public int getKm() {
		return this.km;
	}
	public int setKm(int n) {
		return this.km=n;
	}

}
