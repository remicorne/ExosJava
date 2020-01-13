package Bibliothèque;

public class Manuel extends Livre {
	
	private int niveauScolaire;

	public Manuel(int niveauScolaire, String auteur, int numEnregistrement, int nbPages, String titre) {
		super(auteur, numEnregistrement, nbPages, titre);
		this.niveauScolaire = niveauScolaire;
	}
	
	public String toString() {
		return super.toString() + 
				"Niveau scolaire: " + niveauScolaire+ "\n";
	}
	
	public int getNiveauScolaire() {
		return niveauScolaire;
	}
}
