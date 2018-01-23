import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

/**
 * Diese KLasse erstellt eine Hash Map. Danach werden die Schüler nach Klasse, Nachnamen und Vornamen sortiert.
 * Schließlich werden die Schüler sortiert mit den dazugehörigen Zeugnissen ausgegeben.
 * 
 * @author afesl
 * @version 10.12.2017
 */
public class KlassenHashTabelle {
	
	HashMap<Schueler, Zeugnis> m = new HashMap<>();
	
	ArrayList<String> vornamen = new ArrayList<>(20);
	ArrayList<String> nachnamen = new ArrayList<>(20);
	Schueler s;
	
	/**
	 * Diese Methode erstellt eine Namensliste
	 */
	private void erstelleNamensListe() {
		for(int i = 0;i<5;i++) {
			vornamen.add("Charlie");			
			nachnamen.add("Fesl");
		}
		for(int i = 5;i<10;i++) {
			vornamen.add("David");
			nachnamen.add("wolverin");
		}
		for(int i = 10;i<15;i++) {
			vornamen.add("Alexander");
			nachnamen.add("Goldman");
		}
		for(int i = 15;i<20;i++) {
			vornamen.add("Tom");
			nachnamen.add("Hanks");
		}
		
	}
	public KlassenHashTabelle() {
		super();
	}
	
	/**
	 * Diese Methode definiert eine Schuelerliste
	 * @return ArrayList der Klasse Schueler wird zurückgegeben
	 */
	private ArrayList<Schueler> defineSchuelerList() {
		ArrayList<Schueler> list = new ArrayList<Schueler>();
		for(int i = 0; i<20; i++) {
			int zufallsKlasse = (int)(Math.random()*5+1);
			String vorname = vornamen.get((int)(Math.random()*20));
			String nachname = nachnamen.get((int)(Math.random()*5+1));
			s = new Schueler(vorname,nachname,zufallsKlasse+"CHIT");
			list.add(s);			
			
			//System.out.println(s.toString() +" : "+m.get(s));
		}
		return list;
	}
	
	/**
	 * Diese Methode definiert die Hash Map. Es werden also 20 Schueler mit deren Zeugnissen erstellt.
	 * @param schuelerList
	 */
	private void defineHashMap(ArrayList<Schueler> schuelerList) {
		
		for(int i = 0;i<20;i++) {
			s= schuelerList.get(i);
			m.put(s,new Zeugnis((int)(Math.random()*5+1),(int)(Math.random()*5+1),(int)(Math.random()*5+1),(int)(Math.random()*5+1)));
		}
		
	}
	
	private ArrayList<Schueler> hashMapToArrayList() {
		Set<Schueler> s = m.keySet();
		ArrayList<Schueler> list = new ArrayList<Schueler>(s);
		return list;
	}
	
	/**
	 * Diese Methode sortiert die Klasse Schueler nach Nachnamen und Vornamen und Klasse
	 */
	private ArrayList<Schueler> sortSchueler(ArrayList<Schueler> list) {
		
		/**Set<Schueler> s = m.keySet();
		ArrayList<Schueler> list = new ArrayList<Schueler>(s);*/
		
		Collections.sort(list, new Comparator<Schueler>() {

			@Override
			public int compare(Schueler schueler1, Schueler schueler2) {
				
				int x = schueler1.getKlasse().compareTo(schueler2.getKlasse());
				if (x != 0) {
					return x;
				}
				x = schueler1.getNachName().compareTo(schueler2.getNachName());
				if (x != 0) {
					return x;
				}
				return schueler1.getVorName().compareTo(schueler2.getVorName());
			}			
			
		});
				
		return list;
	
	}
	
	/**
	 * Diese Methode gibt die Hash Map aus
	 */
	private void showHashMap() {
		System.out.println("");
		System.out.println("Ausgabe der unsortierten Hash Map:");
		System.out.println("");
		for(Schueler key: m.keySet()) {
			//System.out.println(""+key+" "+m.get(key));
			System.out.println("\nKlasse "+key.getKlasse()+
					":\n------------\n"+
			key.getVorName()+" "+key.getNachName()+"\n"+m.get(key));
		}
		
	}
	
	/**
	 * Diese Methode gibt eine ArrayList aus
	 * @param list 
	 */
	private void showArrayList(ArrayList<Schueler> list) {
		
		System.out.println("");
		System.out.println("Ausgabe der sortierten ArrayList:");
		System.out.println("");
		
		/** for each Möglischkeit
		for(Schueler s: list) {
			System.out.println(s);
		}*/
		
		// Zweite Möglischkeit mithilfe Iterator
		Iterator<Schueler> li = list.iterator();
		while(li.hasNext()) {
			System.out.println(li.next());
		}
	}
	
	/**
	 * Diese Methode gibt die sortierte Schuelerliste mit deren Zeugnissen aus
	 * @param list ist eine ArrayList von der Klasse Schueler
	 */
	private void synchronizeOutput(ArrayList<Schueler> list) {
		System.out.println("");
		System.out.println("Sortierte Ausgabe nach Klasse und Nachnamen");
		System.out.println("");
		for(int i = 0;i<list.size();i++) {
			
			System.out.println("\nKlasse "+list.get(i).getKlasse()+
					":\n------------\n"+
					list.get(i).getVorName()+" "+list.get(i).getNachName()+"\n"+m.get(list.get(i)));
		}		
		
	}
	
	/**
	 * Diese Methode überprüft ob das üerbegeben Objekt von der Klasse Schüler ist
	 * @param o Ein Object
	 */
	@Override
	public boolean equals(Object o) {
		if(!(o instanceof Schueler)) {
			return false;
		}else{
			return true;
		}
	}
	
	/**
	 * Die Funktion der Main Methode ist es die Methoden der Klasse auszugeben
	 * @param args
	 */
	public static void main(String[] args) {
		KlassenHashTabelle m = new KlassenHashTabelle();
		// Es wird eine Namensliste erzeugt aus verschiedenen Vorn- und Nachnamen und Klassen
		m.erstelleNamensListe();
		
		ArrayList<Schueler> schuelerList = new ArrayList<Schueler>();
		schuelerList = m.defineSchuelerList();
		
		// Defniert er mal die Hash Map und vergibt Keys und Values
		m.defineHashMap(schuelerList);	
		
		/**Gibt die Hash Map aus
		m.showHashMap();*/
		
		ArrayList<Schueler> list = new ArrayList<Schueler>();
		
		// Die Werte in der Hash Map werden in eine Array List definiert
		list = m.hashMapToArrayList();
		//Sortiert die Schueler nach Klasse , Nachname und Vornamen
		list = m.sortSchueler(list);
		
		/** Diese Methode gibt die sortierte ArrayList aus.
		m.showArrayList(list);*/
		
		// Diese Methode gibt die sortierte Liste richtig aus
		m.synchronizeOutput(list);
		
		
	}
}




