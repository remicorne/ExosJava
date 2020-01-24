package Version3;

import java.util.Objects;
import java.util.TreeSet;

public class Individu {

	private final String nom, prenom;
	private TreeSet sportsPratiques;

	public Individu(String nom, String prenom) {
		this.nom = nom;
		this.prenom = prenom;
		sportsPratiques = new TreeSet();
	}

	public String getPrenom() {
		return prenom;
	}

	public String getNom() {
		return nom;
	}

	public String toString() {
		return getPrenom() + " " + getNom() + " : " + listeSportsPratiques();
	}

	public TreeSet getSportsPratiques() {
		return sportsPratiques;
	}

	public boolean pratique(int sport) {
		return sportsPratiques.contains(sport);
	}

	public void ajouterSport(int sport) {
		sportsPratiques.add(sport);
	}

	public void retirerSport(int sport) {
		sportsPratiques.remove(sport);
	}

	public int nbSportsPratiques() {
		return getSportsPratiques().size();
	}

	
	public String listeSportsPratiques() {
		String res = "(";
		for (Object sport : getSportsPratiques())
			res += Sports.nom((int) sport) + ", ";
		if (getSportsPratiques().size() < 1)
			return "aucun sport";
		return res.substring(0, res.length() - 2) + ")";
	}

	public boolean equalSports(Individu individu) {
		return getSportsPratiques().equals(individu.getSportsPratiques());

	}

	public boolean equals(Object unObjet) {
		Individu unIndividu = (Individu) unObjet;
		return Objects.equals(getPrenom(), unIndividu.getPrenom()) && Objects.equals(getNom(), unIndividu.getNom());
		}

}
