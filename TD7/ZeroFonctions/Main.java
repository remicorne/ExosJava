package ZeroFonctions;

public class Main {

	public static void main(String[] args) {
		
		/* essai de la méthode zero */
		
		Fonction cosinus = new Cosinus();
		Fonction xCarreMoins4 = new xCarreMoins4();

		System.out.println(TestDichotomie.zero(xCarreMoins4, 4, 0, 1e-12));
		System.out.println(TestDichotomie.zero(cosinus, 0, Math.PI, 1e-10));
		

		
	}

}
