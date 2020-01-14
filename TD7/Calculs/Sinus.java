package Calculs;

public class Sinus extends OperationUnaire {

	public Sinus(Expression membre1) {
		super(membre1);
	}
	
	@Override
	public double valeur(Double x) {
		return Math.sin(getMembre1().valeur(x));
	}

}
