package lista_zakupow;

import java.io.*; 
import java.util.ArrayList; 
import java.util.Collections; 
import java.util.List; 
import java.util.Scanner; 


public class main {

	public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
		// TODO Auto-generated method stub
		//produkt m = new produkt();
		//m.setNazwa("maka");
		//m.setCena(4.34);
		
		lista x = new lista();
		x.setNazw("pierwsza");
		//x.dodaj_produkt(m);
		//x.dodajNowy();
		//x.dodajNowy();
		//x.dodajNowy();
		x.wyswietl_liste();
		x.zapisz_liste();
		x.oblicz_sume();
		
	}

}
