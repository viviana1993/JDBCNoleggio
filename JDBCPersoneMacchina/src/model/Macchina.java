package model;

public class Macchina {
	
	private int id_macchina;
	private String targa;
	private String modello;
	
	
	public Macchina() {
		super();
	}

	
	

	public Macchina(String targa, String modello) {
		super();
		
		this.targa = targa;
		this.modello = modello;
	}




	public Macchina(int id_macchina, String targa, String modello) {
		super();
		this.id_macchina = id_macchina;
		this.targa = targa;
		this.modello = modello;
	}







	public String getTarga() {
		return targa;
	}


	public void setTarga(String targa) {
		this.targa = targa;
	}


	public String getModello() {
		return modello;
	}


	public void setModello(String modello) {
		this.modello = modello;
	}




	public int getId_macchina() {
		return id_macchina;
	}




	public void setId_macchina(int id_macchina) {
		this.id_macchina = id_macchina;
	}
	
	
	
}
