package Bibliothèque;

public class TestDocuments {

	public static void main(String[] args) {
		
		
		Bibliotheque hexagone = new Bibliotheque();
		
		hexagone.ajouter(new Roman(PrixLitteraires.GONCOURT, "Primo Levi", 46851, 250, "Si c'est un homme"));
		hexagone.ajouter(new Manuel(6, "Robert Paxton", 153652, 852, "Histoire du 20e siecle"));
		hexagone.ajouter(new Revue(12, 2019, 6845316, "Utilisation de psychédéliques en psychiatrie"));
		hexagone.ajouter(new Manuel(NiveauxScolaires.CE1, "Jean Dupont", 631568, 456, "Histoire-Geographie"));
		hexagone.ajouter(new Manuel(NiveauxScolaires.CE1, "Jean Dupont", 631568, 456, "Histoire-Geographie"));
		hexagone.ajouter(new Manuel(NiveauxScolaires.CE1, "Jean Dupont", 68451, 456, "Histoire-Geographie"));
		
		System.out.println(hexagone.supprimer(new Roman(PrixLitteraires.GONCOURT, "Primo Levi", 46851, 250, "Si c'est un homme")));
		
		System.out.println(hexagone.document(0));
		
		hexagone.afficherAuteurs();
		hexagone.afficherDocuments();
		
		System.out.println(hexagone.hasDocument(new Manuel(NiveauxScolaires.CE1, "Jean Dupont", 68451, 456, "Histoire-Geographie")));
	
	}

}
