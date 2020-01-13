package ZeroFonctions;

public class TestDichotomie {


	/*
	 * la méthode elle-même (on suppose que f(a) et f(b) sont de signes distincts)
	 */
	static double zero(Fonction f, double a, double b, double epsilon) {
		/* si on n’a pas f(a) < 0 on échange a et b */
		if (f.appel(a) > 0) {
			double w = a;
			a = b;
			b = w;
		}
		/* iterations jusqu’à avoir |a - b| <= epsilon */
		while (Math.abs(b - a) > epsilon) {
			double c = (a + b) / 2;
			if (f.appel(c) < 0)
				a = c;
			else
				b = c;
		}
		/*
		 * lorsque |a - b| <= epsilon, n’importe quelle valeur comprise entre a et b
		 * convient
		 */
		return (a + b) / 2;
	}
}