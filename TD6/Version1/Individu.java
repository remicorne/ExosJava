package Version1;

public class Individu {

	private String nom, prenom;
	private boolean[] sportsPratiques;

	public Individu(String nom, String prenom) {
		this.nom = nom;
		this.prenom = prenom;
		sportsPratiques = new boolean[Sports.taille];
	}

	public String getPrenom() {
		return prenom;
	}

	public String getNom() {
		return nom;
	}

	public String toString() {
		return getPrenom() + " " + getNom() + " : " + listSportsPratiques(listeSportsPratiques());
	}

	public boolean[] getSportsPratiques() {
		return sportsPratiques;
	}

	public boolean pratique(int sport) {
		return sportsPratiques[sport];
	}

	public void ajouterSport(int sport) {
		sportsPratiques[sport] = true;
	}

	public void retirerSport(int sport) {
		sportsPratiques[sport] = false;
	}

	public int nbSportsPratiques() {
		int resultat = 0;
		for (int sport = 0; sport < getSportsPratiques().length; sport++)
			if (pratique(sport))
				resultat++;
		return resultat;
	}

	public int[] listeSportsPratiques() {
		int[] res = new int[nbSportsPratiques()];
		int numSport = 0;
		for (int sport = 0; sport < getSportsPratiques().length; sport++)
			if (pratique(sport)) {
				res[numSport] = sport;
				numSport++;
			}
		return res;
	}

	public String listSportsPratiques(int[] listeSportsPratiques) {
		String res = "(";
		for (int sport : listeSportsPratiques)
			res += Sports.nom(sport) + ", ";
		if (listeSportsPratiques.length < 1)
			return "aucun sport";
		return res.substring(0, res.length() - 2) + ")";
	}
	
	public boolean equalSports(Individu individu) {
		if (listeSportsPratiques().length != sportsPratiques.length)
			return false;
		for (int sport = 0; sport < sportsPratiques.length; sport++)
			if (pratique(sport) != individu.pratique(sport))
				return false;
		return true;
	}

	public boolean equals(Individu m) {
		return getPrenom().equals(m.getPrenom()) && getNom().equals(m.getNom());
	}

}
