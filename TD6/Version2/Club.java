package Version2;

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
		 if (getMembres().indexOf(new Individu(nom, prenom)) != -1) 
		 	return getMembres().get(getMembres().indexOf(new Individu(nom, prenom)));
		 return null;
	}
	
	public Individu trouverMembre(Individu membre) {
		return trouverMembre(membre.getNom(), membre.getPrenom());
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
