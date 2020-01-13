package Biblioth�que;

public class Roman extends Livre{
	
	private int prixLitteraire;
	
	public Roman(int prixLitteraire, String auteur, int numEnregistrement, int nbPages, String titre) {
		super(auteur, numEnregistrement, nbPages, titre);
		this.prixLitteraire = prixLitteraire;
	}

	public String toString() {
		return super.toString() +
				"Prix litt�raire : " + PrixLitteraires.nom(prixLitteraire) + "\n";
	}
	
	public int getPrixLitteraire() {
		return prixLitteraire;
	}
	
}
