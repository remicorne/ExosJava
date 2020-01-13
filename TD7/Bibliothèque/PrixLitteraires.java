package Bibliothèque;

public class PrixLitteraires {

	public static int GONCOURT = 0;
	public static int MEDICIS = 1;
	public static int INTERALLIES = 2;
	public static int NOBEL = 3;
	
	public static String nom(int prix) {
		String[] listePrix = {"Goncourt", "Medicis", "Interallies", "Nobel"};
		return listePrix[prix];
	}
	
	
	
}
