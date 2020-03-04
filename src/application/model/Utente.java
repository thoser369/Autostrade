package application.model;

public class Utente {
 
	String nome;
	String cognome;
	String citta_nascita;
	String data_nascita;
	String email;
	String password;
	String tipo;
	

	public Utente() {
		// TODO Auto-generated constructor stub
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
public String getCittaNascita() {
	return this.citta_nascita;
}
public String setCittaNascita(String n) {
	return this.citta_nascita=n;
}
public String getDataNascita() {
	return this.data_nascita;
}
public String setDataNascita(String n) {
	return this.data_nascita=n;
}
public String getEmail() {
	return this.email;
}
public String setEmail(String n) {
	return this.email=n;
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
