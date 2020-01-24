package Version1;

public class Club {
	
	private String nom;
	private Individu[] membres;
	private int nombreMembres;
	private int maxMembres = 3;
	
	public Club(String nom) {
		this.nom = nom;
		membres = new Individu[maxMembres];
		refreshNombreMembres();
	}
	
	public int getMaxMembres() {
		return maxMembres;
	}
	
	public Individu[] getMembres() {
		return membres;
	}
	
	public Individu getMembre(int membre) {
		return getMembres()[membre];
	}
	
	public int getNombreMembres() {
		return nombreMembres;
	}
	
	public String getNom() {
		return nom;
	}
	
	public String toString() {
		return nom;
	}
	
	public Individu trouverMembre(String nom, String prenom) {
		for (int numero = 0; numero < getNombreMembres(); numero++)
			if (getMembre(numero).getPrenom().equals(prenom) && getMembre(numero).getNom().equals(nom))
				return getMembre(numero);
		return null;
	}
	
	private Individu trouverMembre(Individu membre) {
		trouverMembre(membre.getNom(), membre.getPrenom());
		return null;
		}
	
	public void refreshNombreMembres() {
		int resultat = 0;
		for (int numero = 0; numero < maxMembres; numero++)
			if (membres[numero] != null)
				resultat++;
		nombreMembres = resultat;
		if (getNombreMembres() == getMaxMembres())
			augmenterCapacite();
	}
	
	public void augmenterCapacite() {
		Individu[] membresAugmente = new Individu[getMaxMembres() + 10];
		int num = 0;
		for (Individu membre : getMembres()) {
			membresAugmente[num] = membre;
			num++;
		}
		membres = membresAugmente;
		maxMembres = membres.length;
		refreshNombreMembres();
	}
	
	public Individu ajouterMembre(String nom, String prenom) {
		if (trouverMembre(nom, prenom) == null)
			membres[getNombreMembres()] = new Individu(nom, prenom);
		refreshNombreMembres();
		return membres[getNombreMembres()];
	}
	
	public Individu ajouterMembre(Individu membre) {
		if (trouverMembre(membre) == null)
			membres[getNombreMembres()] = membre;
		refreshNombreMembres();
		return membres[getNombreMembres()];
	}
	
	public void lister() {
		System.out.println(getNom());
		for (int membre = 0; membre < getNombreMembres(); membre++)
			System.out.println(getMembres()[membre]);
	}
	
	
}
