package test;

import static org.junit.Assert.*;

import java.util.Map;

import model.Macchina;
import model.Persona;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import dao.MacchinaDao;
import dao.MacchinaPersonaDao;
import dao.PersonaDao;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class testMacchinaDao {

	@Test
	public void Test_1_creaMacchinaDao() {
		MacchinaDao mDao=new MacchinaDao();
		assertNotNull(mDao);
		boolean b=mDao.creaMacchina("aaaa", "ford");
		assertTrue(b);
	}
	@Test
	public void Test_2_getMacchinaDao() {
		MacchinaDao mDao=new MacchinaDao();
		assertNotNull(mDao);
		Macchina m=mDao.getMacchina("aaaa");
		assertNotNull(m);
	}
	@Test
	public void Test_3_aggiornaMacchinaDao() {
		MacchinaDao mDao=new MacchinaDao();
		assertNotNull(mDao);
		//boolean b=mDao.creaMacchina("xxx", "xxx");
		//assertTrue(b);
		boolean b1=mDao.aggiornaMacchina("xxx", "bbb");
		assertTrue(b1);
	}


		@Test
		public void Test_4_rimuoviMacchinaDao() {
			MacchinaDao mDao=new MacchinaDao();
			assertNotNull(mDao);
			boolean b=mDao.rimuoviMacchina("aaaa", "ford");
			assertTrue(b);

		}
		@Test
		public void Test_5_getTutteLeMacchineDiUnaPersona(){
			
			MacchinaDao mDao=new MacchinaDao();
			assertNotNull(mDao);
			int b=mDao.creaMacchinaId("bbbb", "bbbb");
			int b1=mDao.creaMacchinaId("bdd", "bbddb");
			PersonaDao pDao=new PersonaDao();
			int b3=pDao.creaPersonaId("ggg", "gggg", "HHHHHH");
			MacchinaPersonaDao mpDao=new MacchinaPersonaDao();
			mpDao.creaMacchinaPersona(b3, b);
			mpDao.creaMacchinaPersona(b3, b1);
			Map <Integer,Macchina> m=mDao.getTutteLeMacchineDiUnaPersona(b3);
			assertNotEquals(0,m.size());
			
		}
		
		@Test
		public void Test_6_getTutteLeMacchine(){
			
			MacchinaDao mDao=new MacchinaDao();
			assertNotNull(mDao);
			boolean b=mDao.creaMacchina("bbbb", "bbbb");
			assertTrue(b);
			boolean b1=mDao.creaMacchina("bdd", "bbddb");
			assertTrue(b1);
			Map <Integer,Macchina> m=mDao.getTutteLeMacchine();
			assertNotEquals(0,m.size());
			
		}

}
