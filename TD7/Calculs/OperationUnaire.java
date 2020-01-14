package Calculs;

public abstract class OperationUnaire implements Expression {
	
	private Expression membre1;
	
	public OperationUnaire(Expression membre1) {
		this.membre1 = membre1;
	}

	public Expression getMembre1() {
		return membre1;
	}
	
	@Override
	public abstract double valeur(Double x);
	
}
