package DisquesAnneaux;

public class TestDisque {

	public static void main(String[] args) {

		Disque disque = new Disque(4, 5, 12);
		Disque disque2 = new Disque(4, 5, 12);
		System.out.println(disque);
		
//		disque2.translate(1, 1);
		System.out.println(disque.equals(disque2));
		
		disque.translate(5, 4);
		System.out.println(disque);
		System.out.println(disque.aire());
		

		Couronne couronne = new Couronne(4, 5, 12, 6);
		Couronne couronne2 = null;
		Couronne couronne3 = new Couronne(4, 5, 12, 6);
		

		
		System.out.println(couronne.equals(couronne2));
		System.out.println(couronne.equals(couronne3));
		
		Disque disque4 = (Disque) couronne;
		System.out.println(disque4.getClass());
	
		System.out.println(couronne);
		couronne.translate(5, 5);
		System.out.println(couronne);
		
		System.out.println(couronne.aire() == new Disque(0, 0, 12).aire() - new Disque(0, 0, 6).aire());
	
	}

}
