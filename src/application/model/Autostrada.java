package application.model;

public class Autostrada {
	
    private	int id;
    private String nome;
    private float tariffa;
	   
		public Autostrada() {
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
	    public float getTariffa() {
		    return this.tariffa;
	    }
	    public float setTariffa(float n) {
		    return this.tariffa=n;
	    }

	}
