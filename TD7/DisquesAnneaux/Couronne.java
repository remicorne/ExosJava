package DisquesAnneaux;

public class Couronne extends Disque {
	
	private double r2;
	
	public Couronne(double x, double y, double r, double r2) {
		super(x, y, r);
		this.r2 = r2;
	}
	
	public double getR2() {
		return r2;
	}
	
	public String toString() {
		return super.toString() + ", rayon trou = " + getR2();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Couronne) {
			Couronne courone = (Couronne) obj;
			return super.equals(obj) && getR2() == courone.getR2();
			}
		return false;
	}
	
	@Override
	public double aire() {	
		return super.aire() - new Disque(getX(), getY(), getR2()).aire();
	}
	
	
}
