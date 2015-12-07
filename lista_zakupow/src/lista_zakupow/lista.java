package lista_zakupow;

import java.util.ArrayList;
//import java.util.Scanner;
//import java.util.Collections;
import java.io.*;

public class lista extends junit.framework.TestCase{

	private String nazwa_listy;
	private ArrayList<produkt> list = new ArrayList<produkt>();
	
	int ilosc;

	public void setNazw(String nazz){
		nazwa_listy = nazz;
	}
	//public lista(String nazz){
	//	nazwa_listy = nazz;
	//}
	public String getNazw(){
		return nazwa_listy;
	}
		
	public void dodaj_produkt(produkt p){
		
		p.getNazwa();
		p.getCena();
		//if (true){
		//	int pobrana = 2;
		//	p.setIlosc(pobrana);
		//}
		list.add(p);
	}
	public void dodajNowy(String naz, String ce, String sz){
		/*//podaj nazwe:
		System.out.println("Wpisz nazwe produktu i nacisnij ENTER.");
		String nazw; 
		Scanner nazwa = new Scanner(System.in); 
		nazw = nazwa.nextLine();
		produkt n = new produkt();
		n.setNazwa(nazw);
		//podaj cene:
		System.out.println("Wpisz cene produktu i nacisnij ENTER.");
		double cen;
		String ce;
		ce = nazwa.nextLine();
		cen = Double.parseDouble(ce);
		//nazwa.close();
		n.setCena(cen);
		System.out.println("Wpisz ilosc produktu i nacisnij ENTER.");
		String ilos;
		ilos = nazwa.nextLine();
		int ilo = Integer.parseInt(ilos);
		n.setIlosc(ilo);
		nazwa.reset();
		list.add(n);*/
		//dodanie do bazy produktow?
		//String[] nazwa = wiersz.split("/");
		produkt n = new produkt();
		n.setNazwa(naz);
		n.setCena(Double.parseDouble(ce));
		n.setIlosc(Integer.parseInt(sz));
		list.add(n);
		//return n;
	}
	public void dodajN(String w){
		String[] nazwa = w.split("/");
		produkt n = new produkt();
		n.setNazwa(nazwa[0]);
		n.setCena(Double.parseDouble(nazwa[1]));
		n.setIlosc(Integer.parseInt(nazwa[2]));
		list.add(n);
	}
	
	public produkt getProdukt(int indeks){
		produkt p = new produkt();
		p = list.get(indeks);
		return p;
	}
	public int getSize(){
		int i = list.size();
		return i;
	}
	public void usunProdukt (int k) {
		list.remove(k-1);
	}
		
	public void zapisz_liste() throws FileNotFoundException, UnsupportedEncodingException {
		// //zapisywanie w konkretnym folderze: 
		String katalog = "C:/Users/Wojtus/workspace/lista_zakupow";
		PrintWriter ListaTxt = new PrintWriter(new OutputStreamWriter(new FileOutputStream(katalog + nazwa_listy + ".txt"), "UTF-8")); 
		//PrintWriter ListaTxt = new PrintWriter(NazwaListy+".txt", "UTF-8"); 
		for (produkt a : list) { 
		       ListaTxt.println(a.getNazwa()+"/"+ a.getCena()+ "/"+ a.getIlosc()); 
		}  
		ListaTxt.close(); 
	}
	public void wyswietl_liste(){
		System.out.println("Lista produktów: "); 
		for (produkt a : list) { 
		     System.out.println(a.getNazwa()+" "+ a.getCena()+ " z³ "+ a.getIlosc()+ " szt."); 
		} 
	}
	public String oblicz_sume(){
		double suma = 0;
		for (produkt a : list) { 
			suma = suma + a.getCena()*a.getIlosc();
		} 
		String result = String.format("%.2f", suma);
		result = "suma: "+ result + " z³";
		return result;
	}	
}
