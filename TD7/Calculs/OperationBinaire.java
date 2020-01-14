package Calculs;

public abstract class OperationBinaire implements Expression{
	
	private Expression membre1;
	private Expression membre2;
	
	public OperationBinaire(Expression membre1, Expression membre2) {
		this.membre1 = membre1;
		this.membre2 = membre2;
	}
	
	public Expression getMembre1() {
		return membre1;
	}
	
	public Expression getMembre2() {
		return membre2;
	}
	
	@Override
	public abstract double valeur(Double x);
	

}
