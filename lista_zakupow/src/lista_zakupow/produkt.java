package lista_zakupow;

public class produkt {

	private String Nazwa;
	private double cena;
	private int ilosc;
	
	public void setNazwa (String Nazwa){
		this.Nazwa = Nazwa;
	}
	public String getNazwa(){
		return Nazwa;
	}
	public void setCena (double cena){
		this.cena = cena;
	}
	public double getCena(){
		return cena;
	}
	
	public void setIlosc (int ilosc){
		this.ilosc = ilosc;
	}
	public int getIlosc(){
		return ilosc;
	}
	
	public produkt (){}
	
	public produkt (String Nazwa){
        this.Nazwa = Nazwa;
	}
	
	public produkt (double cena){
        this.cena = cena;
	}
	
	public produkt (int ilosc){
		this.ilosc = ilosc;
	}
}
	
