package Bibliothèque;

public class Livre extends Document {

	private String auteur;
	private int nbPages;

	public Livre(String auteur, int numEnregistrement, int nbPages, String titre) {
		super(numEnregistrement, titre);
		this.auteur = auteur;
		this.nbPages = nbPages;
	}

	public String toString() {
		return super.toString() + 
				"Auteur : " + auteur+ "\n" +
				"Nombre de pages : " + nbPages+ "\n";
	}
	
	public String getAuteur() {
		return auteur;
	}
	
	public int getNbPages() {
		return nbPages;
	}
	
}
