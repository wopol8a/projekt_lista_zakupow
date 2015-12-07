package lista_zakupow;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class listaTest extends junit.framework.TestCase {
	
	lista lista1;
	lista lista2;

    protected void setUp(){
        lista1 = new lista();
        lista2 = new lista();
        lista1.dodajNowy("mleko", "2", "3");
        lista1.dodajNowy("jajka", "5.50", "2");
        lista1.dodajNowy("cukier", "2.99", "10");
        lista1.dodajNowy("ziemniaki", "2.0", "50");
       
    }
	
	protected void tearDown() {

    }
	
	
	@Test
	   public void testDodajNowy() throws Exception {
		produkt p1 = new produkt();
		produkt p2 = new produkt();
		produkt p3 = new produkt();
		produkt p4 = new produkt();
		p1 = lista1.getProdukt(0);
		p2 = lista1.getProdukt(1);
		p3 = lista1.getProdukt(2);
		p4 = lista1.getProdukt(3);
		assertEquals("mleko",p1.getNazwa());
		assertEquals(2.0,p1.getCena());
		assertEquals(3,p1.getIlosc());
		assertEquals("jajka",p2.getNazwa());
		assertEquals(5.5,p2.getCena());
		assertEquals(2,p2.getIlosc());
		assertEquals("cukier",p3.getNazwa());
		assertEquals(2.99,p3.getCena());
		assertEquals(10,p3.getIlosc());
		assertEquals("ziemniaki",p4.getNazwa());
		assertEquals(2.0,p4.getCena());
		assertEquals(50,p4.getIlosc());
    }

	
}
