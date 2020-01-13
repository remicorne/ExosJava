package JournalEvenements;

import java.time.LocalDate;

public class Evenement {
	
	private String evenement;
	private LocalDate date;
	
	public Evenement(String evenement, LocalDate date) {
		this.evenement = evenement;
		this.date = date;
	}
	
	public String getEvenement() {
		return evenement;
	}
	
	public LocalDate getDate() {
		return date;
	}
	
	@Override
	public String toString() {
		return getDate().toString() + " : " + getEvenement();
	}

}
