package Version3;

import java.util.Vector;

public class Club {

	private String nom;
	private Vector<Individu> membres;

	public Club(String nom) {
		this.nom = nom;
		membres = new Vector<Individu>();
	}

	public Vector<Individu> getMembres() {
		return membres;
	}

	public int getNombreMembres() {
		return getMembres().size();
	}

	public String getNom() {
		return nom;
	}

	public String toString() {
		return nom;
	}

	public Individu trouverMembre(String nom, String prenom) {
		return trouverMembre(new Individu(nom, prenom));
	}

	public Individu trouverMembre(Individu membre) {
		if (getMembres().indexOf(membre) != -1)
			return getMembres().get(getMembres().indexOf(membre));
		return null;
	}

	public Individu ajouterMembre(String nom, String prenom) {
		ajouterMembre(new Individu(nom, prenom));
		return null;
	}

	public Individu ajouterMembre(Individu membre) {
		if (trouverMembre(membre) == null)
			getMembres().add(membre);
		return getMembres().get(getNombreMembres() - 1);
	}

	public void lister() {
		System.out.println(getNom());
		for (int membre = 0; membre < getNombreMembres(); membre++)
			System.out.println(getMembres().get(membre));
	}

}
