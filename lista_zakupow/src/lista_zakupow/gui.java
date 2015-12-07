package lista_zakupow;

import javax.swing.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;


public class gui {
	JTextField polenazwy = new JTextField(20);
	JTextField poleceny = new JTextField(7);
	JTextField polesztuk = new JTextField(3);
	JTextField suma = new JTextField(7);
	lista x = new lista();
	JTextArea tekst = new JTextArea(10,15);
	JFrame ramka = new JFrame();
	int l = 0;
	
	
	public static void main(String[] args) {
		gui interfejs = new gui();
		interfejs.start();// TODO Auto-generated method stub
	}
	public void start() {
		
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(10, 1));
		//panel.setPreferredSize(new Dimension(150, 100));
	    //panel.setMaximumSize(new Dimension(150, 100));
		JPanel panelt = new JPanel();
		JPanel panelp = new JPanel();
		panel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		JButton wczytaj = new JButton("wczytaj liste");
		wczytaj.addActionListener(new WczytajListener());
		JButton zapisz = new JButton("zapisz liste");
		zapisz.addActionListener(new ZapiszListener());
		JButton dodaj = new JButton("dodaj produkt");
		dodaj.addActionListener(new DodajListener());
		JButton usun = new JButton("usuñ liste");
		usun.addActionListener(new WyczyscListener());
		JLabel nazw = new JLabel("Nazwa produktu/listy");
		JLabel cen = new JLabel("Cena");
		JLabel szt = new JLabel("Iloœæ");
		panel.add(wczytaj);
		panel.add(zapisz);
		panel.add(dodaj);
		panel.add(usun);
		panelp.add(nazw);
		panelp.add(cen);
		panelp.add(szt);
		panelp.add(polenazwy);
		panelp.add(poleceny);
		panelp.add(polesztuk);
		panelp.setLayout(new GridLayout(2,3));
				
		tekst.setLineWrap(true);
		tekst.setEditable(false);
		suma.setEditable(false);
		JScrollPane przewijanie = new JScrollPane(tekst);
		przewijanie.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		przewijanie.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		panelt.add(przewijanie); 
		panelt.add(suma);
		panelt.setLayout(new BoxLayout(panelt, BoxLayout.Y_AXIS));
		ramka.getContentPane().add(BorderLayout.EAST, panelt);
		ramka.getContentPane().add(BorderLayout.WEST, panel);
		ramka.getContentPane().add(BorderLayout.SOUTH, panelp);
		ramka.setSize(380, 280);
				
		ramka.setVisible(true);
	}
	
	public class WczytajListener implements ActionListener {
		public void actionPerformed(ActionEvent a) {
			//wczytanie pliku listy i zapisanie do x;
			JFileChooser plik = new JFileChooser();
			plik.showOpenDialog(ramka);
			tekst.setText(null);
			l = x.getSize();
			for (int k=l;k>0;k--){
				x.usunProdukt(k);
			}
			try {
				FileReader czytelnik = new FileReader(plik.getSelectedFile());
				BufferedReader czyt = new BufferedReader(czytelnik);
				String wiersz = null;
				while ((wiersz = czyt.readLine()) != null) {
					//wiersz na produkt i do listy
					x.dodajN(wiersz);	
				}
				czyt.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
			
			l = x.getSize();
			for (int c = 0; c<l;c++) {
				produkt p = x.getProdukt(c);				
				tekst.append(c+1 + ". " +p.getNazwa()+" "+ p.getCena()+ " z³ "+ p.getIlosc()+ " szt.\n");
			}
			String sum = x.oblicz_sume();
			suma.setText(sum);
			polenazwy.setText(null);
			poleceny.setText(null);
			polesztuk.setText(null);
		}
	}
	public class ZapiszListener implements ActionListener {
		public void actionPerformed(ActionEvent a) {
			String wiersz = polenazwy.getText();
			x.setNazw(wiersz);
			try {
				x.zapisz_liste();
			} catch (FileNotFoundException | UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
			polenazwy.setText(null);
			poleceny.setText(null);
			polesztuk.setText(null);
		}	
	}
	public class DodajListener implements ActionListener {
		public void actionPerformed(ActionEvent a) {
			String wiersz = polenazwy.getText();
			String cena = poleceny.getText();
			String sztuk = polesztuk.getText();
			x.dodajNowy(wiersz,cena,sztuk);
			
			l=x.getSize();
			produkt p = x.getProdukt(l-1);
			tekst.append(l++ + ". " +p.getNazwa()+" "+ p.getCena()+ " z³ "+ p.getIlosc()+ " szt.\n");
			String sum = x.oblicz_sume();
			suma.setText(sum);
			polenazwy.setText(null);
			poleceny.setText(null);
			polesztuk.setText(null);
		}
	}
	
	public class WyczyscListener implements ActionListener {
		public void actionPerformed(ActionEvent a) {
			//wczytanie pliku listy i zapisanie do x;
			tekst.setText(null);
			polenazwy.setText(null);
			poleceny.setText(null);
			polesztuk.setText(null);
			suma.setText(null);
					
		}
	}
}
