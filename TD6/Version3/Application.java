package Version3;

import java.util.Random;

public class Application {

	public static void main(String[] args) {

		Club club = new Club("les fumeurs repentis");
		
		Random random = new Random();
		
		for (int membre = 0; membre < 5; membre++) {
			club.ajouterMembre(new Individu(String.valueOf(membre), String.valueOf(membre)));
		}
		
		for (int membre = 0; membre < 5; membre++) {
			for (int nbSports = 0; nbSports < random.nextInt(6); nbSports++)
				club.getMembres().get(membre).ajouterSport(random.nextInt(5));
		}
		
		Individu a = new Individu("1", "1");
		Individu b = new Individu("1", "1");
		System.out.println(a.equals(b));
		club.ajouterMembre(a);
		club.ajouterMembre("1", "1");
		club.ajouterMembre("1", "1");

		club.ajouterMembre(club.getMembres().get(club.getNombreMembres() - 1));
		
		System.out.println(club.trouverMembre("1", "1").equalSports(club.trouverMembre(a)));
		
		club.lister();
		
		for (Individu membre : club.getMembres()) {
			membre.ajouterSport(Sports.natation);
			System.out.println(membre.pratique(Sports.natation));
		}
			

		
		
		
	}

}
