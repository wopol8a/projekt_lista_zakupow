package lista_zakupow;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class produktTest extends junit.framework.TestCase{

	produkt produkt1;
	@Before
	public void setUp() throws Exception {
		produkt1 = new produkt("mleko");
		produkt1.setCena(2.2);
		produkt1.setIlosc(4);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testsetNazwa() {
		assertEquals("mleko",produkt1.getNazwa());
	}
	public void testgetNazwa() {
	}
	
	public void testsetCena() {
		assertEquals(2.2,produkt1.getCena());
	}
	public void testgetaCen() {
	}
	
	public void testsetIlosc() {
		assertEquals(4,produkt1.getIlosc());
	}
	public void testgetIlosc() {
	}
}
