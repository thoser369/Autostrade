package application.model;

public class SceltaClassePedaggio {

	private int id;
	private String nome;
	private int iva;
	
	public SceltaClassePedaggio() {
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
    public int getIva() {
		return this.iva;
	}
	public int setIva(int n) {
		return this.iva=n;
	}	
}
