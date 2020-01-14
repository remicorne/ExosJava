package Calculs;

public class Constante implements Expression {

	private double valeur;
	
	public Constante(double valeur) {
		this.valeur = valeur;
	}
	
	@Override
	public double valeur(Double x) {
		return valeur;
	}

}
