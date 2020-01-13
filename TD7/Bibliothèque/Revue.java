package Bibliothèque;

public class Revue extends Document {
	
	private int mois;
	private int annee;
	
	public Revue(int mois, int annee, int numEnregistrement, String titre) {
		super(numEnregistrement, titre);
		this.annee = annee;
		this.mois = mois;
	}
	
	public String toString() {
		return super.toString() + 
				"Date : " + mois + "/" + annee + "\n";
	}
	public int getAnnee() {
		return annee;
	}
	
	public int getMois() {
		return mois;
	}
	
	
	
}
