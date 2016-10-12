package test;

import static org.junit.Assert.*;
import model.Macchina;
import model.Persona;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import servizi.ServiziNoleggio;
import dao.MacchinaDao;
import dao.PersonaDao;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class testServizi {

@Test
	
		public void Test_1_aggiungiMacchina() {
			Macchina m=null;
			ServiziNoleggio s=new ServiziNoleggio();
			assertNotNull(s);
			m=s.aggiungiMacchina("aaa", "aaaa");
			assertNotNull(m);
		}

	
	@Test
	
	public void Test_2_aggiungiPersona() {
		Persona p=null;
		ServiziNoleggio s=new ServiziNoleggio();
		assertNotNull(s);
		p=s.aggiungiPersona("VV", "vvv", "886bhh");
		assertNotNull(p);
	}
	
	
@Test
	
	public void Test_3_assegnaPersonaMacchina() {
	
	MacchinaDao mDao=new MacchinaDao();
	assertNotNull(mDao);
	Macchina m=mDao.getMacchina("aaa");
	assertNotNull(m);
	
	
	PersonaDao pDao=new PersonaDao();
	assertNotNull(pDao);
	Persona p=pDao.getPersona("VV", "vvv", "886bhh");
	assertNotNull(p);
	
		ServiziNoleggio s=new ServiziNoleggio();
		assertNotNull(s);
		boolean b=s.assegnaPersonaMacchina(p, m);
		assertTrue(b);
	}
}
