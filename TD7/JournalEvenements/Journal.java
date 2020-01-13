package JournalEvenements;

import java.time.LocalDate;
import java.util.Vector;

public class Journal {
	
	private Vector<Evenement> journal;
	
	public Journal() {
		this.journal = new Vector<Evenement>();
	}
	
	public Vector<Evenement> getJournal() {
		return journal;
	}

	public void ajouter(String unTexte) {
		ajouter(new Evenement(unTexte, LocalDate.now()));
	}
	
	public void ajouter(Evenement unEvent) {
		getJournal().add(unEvent);
	}
	
	public String toString() {
		String result = "";
		for (Evenement evenement : getJournal())
			result += evenement.toString() + "\n";
		return result;	}
	
	public String toString(String uneChaine) {
		Journal result = new Journal();
		for (Evenement evenement : getJournal()) 
			if (evenement.getEvenement().contains(uneChaine))
				result.ajouter(evenement);
		return result.getJournal().size() > 0 ? result.toString() : "Aucune entree ne correspond\n";
	}
	
	

}
