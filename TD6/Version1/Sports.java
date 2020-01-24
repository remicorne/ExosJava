 package Version1;

public class Sports {

	public static final int tennis = 0;
	public static final int natation = 1;
	public static final int athletisme = 2;
	public static final int volley = 3;
	public static final int rugby = 4;
	public static final int randonnee = 5;
	public static final int taille = 6;

	public static String nom(int sport) {
		String[] sports = { "Tennis", "Natation", "Athletisme", "Volley", "Rugby", "Randonnee" };
		return sports[sport];
	}
}
