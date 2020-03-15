package application.model;

public class Utente {
 
	private int id;
	private String nome;
	private String cognome;
	private String username;
	private String password;
	private String tipo;
	

	public Utente() {
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
    public String getCognome() {
	    return this.cognome;
    }
    public String setCognome(String n) {
	    return this.cognome=n;
    }
    public String getUserName() {
	    return this.username;
    }
    public String setUsername(String n) {
	    return this.username=n;
    }
    public String getPassword() {
	    return this.password;
    }
    public String setPassword(String n) {
	    return this.password=n;
    }
    public String getTipo() {
	    return this.tipo;
    }
    public String setTipo(String n) {
	    return this.tipo=n;
    }

}
