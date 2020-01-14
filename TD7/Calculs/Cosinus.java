package Calculs;

public class Cosinus extends OperationUnaire {

	public Cosinus(Expression membre1) {
		super(membre1);
	}
	
	@Override
	public double valeur(Double x) {
		return Math.cos(getMembre1().valeur(x));
	}

}
