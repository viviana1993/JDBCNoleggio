package model;

public class Persona {
	private int id_persona;
	private String nome;
	private String cognome;
	private String cf;
	
	
	
	public Persona() {
		super();
	}



	public Persona(int id_persona, String nome, String cognome, String cf) {
		super();
		this.id_persona = id_persona;
		this.nome = nome;
		this.cognome = cognome;
		this.cf = cf;
	}



	public Persona(String nome, String cognome, String cf) {
		this.nome = nome;
		this.cognome = cognome;
		this.cf = cf;
	}



	public int getId_persona() {
		return id_persona;
	}



	public void setId_persona(int id_persona) {
		this.id_persona = id_persona;
	}



	public String getNome() {
		return nome;
	}



	public void setNome(String nome) {
		this.nome = nome;
	}



	public String getCognome() {
		return cognome;
	}



	public void setCognome(String cognome) {
		this.cognome = cognome;
	}



	public String getCf() {
		return cf;
	}



	public void setCf(String cf) {
		this.cf = cf;
	}
	
	
	
	
	
}
