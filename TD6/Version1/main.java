package Version1;

public class main {

	public static void main(String[] args) {
		
		Individu n = new Individu("remi", "corne");
		Individu m = new Individu("rems", "norc");
		Club club = new Club("Marseille");

		n.ajouterSport(1);
		m.ajouterSport(1);
		m.ajouterSport(2);
		
		club.ajouterMembre(n);
		club.ajouterMembre(m);
		
		club.lister();
		
		
	}

}
