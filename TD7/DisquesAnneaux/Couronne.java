package DisquesAnneaux;

public class Couronne extends Disque {
	
	private Disque disqueInterieur;
	
	/**
	 * 
	 * @param x abscisse du centre
	 * @param y ordonnée du centre
	 * @param r rayon ext
	 * @param r2 rayon int
	 */
	public Couronne(double x, double y, double r1, double r2) {
		super(x, y, r1);
		this.disqueInterieur = new Disque(x, y, r2);
	}

	public Disque getDisqueInterieur() {
		return disqueInterieur;
	}
	
	public String toString() {
		return super.toString() + ", rayon trou = " + getDisqueInterieur().getR();
	}
	
	@Override
	public boolean equals(Object unObj) {
		if (unObj instanceof Couronne) {
			Couronne uneCourone = (Couronne) unObj;
			return super.equals(unObj) && getDisqueInterieur().equals(uneCourone.getDisqueInterieur()); // checker que ca marche encore
			}
		return false;
	}
	
	@Override
	public double aire() {	
		return super.aire() - getDisqueInterieur().aire();
	}
	
	
}
