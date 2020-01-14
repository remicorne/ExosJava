package Calculs;

public class Addition extends OperationBinaire  {

	public Addition(Expression membre1, Expression membre2) {
		super(membre1, membre2);
	}

	@Override
	public double valeur(Double x) {
		return getMembre1().valeur(x) + getMembre2().valeur(x);
	}

	
	
}
