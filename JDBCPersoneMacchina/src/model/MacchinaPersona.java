package model;

public class MacchinaPersona {
	
	
	private int id_presona;
	private int id_macchina;
	
	
	public MacchinaPersona() {
		super();
	}
	
	
	public MacchinaPersona(int id_presona, int id_macchina) {
		super();
		this.id_presona = id_presona;
		this.id_macchina = id_macchina;
	}


	public int getId_presona() {
		return id_presona;
	}


	public void setId_presona(int id_presona) {
		this.id_presona = id_presona;
	}


	public int getId_macchina() {
		return id_macchina;
	}


	public void setId_macchina(int id_macchina) {
		this.id_macchina = id_macchina;
	}
	
	
}
