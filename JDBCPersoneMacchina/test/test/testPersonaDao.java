package test;

import static org.junit.Assert.*;

import java.util.Map;

import model.Macchina;
import model.Persona;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import dao.MacchinaDao;
import dao.PersonaDao;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)//eseguo i test in ordine alfabetico

public class testPersonaDao {

	@Test
	public void Test_1_creaPersonaDao() {
		PersonaDao pDao=new PersonaDao();
		assertNotNull(pDao);
		boolean b=pDao.creaPersona("Viviana", "Vacirca", "vcrvvd3");
		assertTrue(b);
	}
	@Test
	public void Test_2_getPersonaDao() {
		PersonaDao pDao=new PersonaDao();
		assertNotNull(pDao);
		Persona p=pDao.getPersona("Viviana", "Vacirca", "vcrvvd3");
		assertNotNull(p);
	}
	@Test
	public void Test_3_aggiornaPersonaDao() {
		PersonaDao pDao=new PersonaDao();
		assertNotNull(pDao);
		boolean b=pDao.aggiornaPersona(1,"cccc", "kkkk", "vc666d3");
		assertTrue(b);}



		@Test
		public void Test_4_rimuoviPersonaDao() {
			PersonaDao pDao=new PersonaDao();
			assertNotNull(pDao);
			boolean b=pDao.rimuoviPersona("Viviana", "Vacirca", "vcrvvd3");
			assertTrue(b);

		}
		
		@Test
		public void Test_5_getTutteLePersone(){
			
			PersonaDao pDao=new PersonaDao();
			assertNotNull(pDao);
			boolean b=pDao.creaPersona("bbbb", "bbbb","bbbbb");
			assertTrue(b);
			boolean b1=pDao.creaPersona("bdd", "bbddb","pppp");
			assertTrue(b1);
			Map <Integer,Persona> p=pDao.getTutteLePersone();
			assertNotEquals(0,p.size());
			
		}
	}