package Bibliothèque;

public class NiveauxScolaires {

	public static int CP = 11;
	public static int CE1 = 11;
	public static int CE2 = 11;
	public static int CM1 = 11;
	public static int CM2 = 11;
	
	public static String nom(int niveauScolaire) {
		String[] niveauxScolaires = {"CP", "CE1", "CE2", "CM1", "CM2"};
		return niveauxScolaires[niveauScolaire];
	}
}
