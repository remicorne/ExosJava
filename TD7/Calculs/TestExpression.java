package Calculs;

public class TestExpression {

	public static void main(String[] args) {
		
		/* codage de la fonction f(x) = 2 * sin(x) + 3 * cos(x) */
		Expression f =
		new Addition(
		new Multiplication(new Constante(2),new Sinus(new Variable())),
		new Multiplication(new Constante(3),new Cosinus(new Variable()))
		);
		/* calcul de la valeur de f(x) pour quelques valeurs de x */
		double[] tab = { 0, 0.5, 1, 1.5, 2, 2.5 };
		for (int i = 0; i < tab.length; i++) {
		double x = tab[i];
		System.out.println("f(" + x + ") = " + f.valeur(x));
		}

		
	}

}
