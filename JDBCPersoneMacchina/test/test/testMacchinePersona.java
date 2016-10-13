package test;

import static org.junit.Assert.*;
import model.Macchina;
import model.MacchinaPersona;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import dao.MacchinaDao;
import dao.MacchinaPersonaDao;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class testMacchinePersona {


	@Test
	public void Test_1_creaMacchinaPersonaDao() {
		MacchinaPersonaDao mpDao=new MacchinaPersonaDao();
		assertNotNull(mpDao);
		boolean b=mpDao.creaMacchinaPersona(1, 3);
		assertTrue(b);
	}
	@Test
	public void Test_2_getDaMacchinaPersonaDao() {
		MacchinaPersonaDao mpDao=new MacchinaPersonaDao();
		assertNotNull(mpDao);
		MacchinaPersona mp=mpDao.getDaMacchinaPersona(3);
		assertNotNull(mp);
	}
	@Test
	public void Test_3_getMacchinaDaPersonaDao() {
		MacchinaPersonaDao mpDao=new MacchinaPersonaDao();
		assertNotNull(mpDao);
		MacchinaPersona mp=mpDao.getMacchinaDaPersona(1);
		assertNotNull(mp);
	}
	@Test
	public void Test_4_aggiornaMacchinaDiPesonaDao() {
		MacchinaPersonaDao mpDao=new MacchinaPersonaDao();
		assertNotNull(mpDao);
		boolean mp=mpDao.aggiornaMacchinaDiPersona(4, 1);
		assertTrue(mp);
	}
	@Test
	public void Test_5_aggiornaPesonaMacchinaDao() {
		MacchinaPersonaDao mpDao=new MacchinaPersonaDao();
		assertNotNull(mpDao);
		boolean mp=mpDao.aggiornaPersonaMacchina(4,21);
		assertTrue(mp);
	}

	@Test
		public void Test_6_rimuoviMacchinaPersonaDao() {
		MacchinaPersonaDao mpDao=new MacchinaPersonaDao();
		assertNotNull(mpDao);
		boolean mp=mpDao.rimuoviMacchinaDiPersona(21);
		assertTrue(mp);

		}
	@Test
		public void Test_7_rimuoviMacchinaDiPersonaDao() {
		MacchinaPersonaDao mpDao=new MacchinaPersonaDao();
		assertNotNull(mpDao);
		boolean b=mpDao.creaMacchinaPersona(21, 4);
		assertTrue(b);
		boolean mp=mpDao.rimuoviMacchinaPersona(4);
		assertTrue(mp);


		}
}


