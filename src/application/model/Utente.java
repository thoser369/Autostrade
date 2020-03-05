package application.model;

public class Utente {
 
	String nome;
	String cognome;
	String genere;
	String citta_nascita;
	String data_nascita;
	String username;
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
public String getGenere() {
	return this.genere;
}
public String setGenere(String n) {
	return this.genere=n;
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
