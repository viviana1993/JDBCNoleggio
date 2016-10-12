package servizi;

import java.util.HashMap;
import java.util.Map;

import model.Macchina;
import model.MacchinaPersona;
import model.Persona;
import dao.MacchinaDao;
import dao.MacchinaPersonaDao;
import dao.PersonaDao;

public class ServiziNoleggio {



	public Macchina aggiungiMacchina(String targa,String modello){
		Macchina m=null;
		MacchinaDao mDao=new MacchinaDao();
		
		boolean bool=mDao.creaMacchina(targa, modello);
		if(bool){
			
			m=new Macchina(targa,modello);
		}
		return m;

	}


	public Persona aggiungiPersona(String nome, String cognome, String cf){
		Persona p=null;
		PersonaDao pDao=new PersonaDao();
		boolean bool=pDao.creaPersona(nome, cognome, cf);
		if(bool){
			
			p=new Persona(nome,cognome,cf);
		}
		return p;
		
	}
	

	public boolean assegnaPersonaMacchina(Persona p,Macchina m){
		MacchinaPersonaDao mpDao=new MacchinaPersonaDao();
		boolean bool=false;
		bool=mpDao.creaMacchinaPersona(p.getId_persona(), m.getId_macchina());
		return bool;
	}
	
	
	

}
