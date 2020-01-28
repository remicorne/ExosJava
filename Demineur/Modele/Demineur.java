package Modele;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Vector;

public class Demineur {

	private int nbLignes;
	private int nbColonnes;
	private Vector<Cellule> demineur;
	private double probaBombe;

	public Demineur(int nbLignes, int nbColonnes, double probaBombe) {
		init(nbLignes, nbColonnes, probaBombe);
	}

	private void init(int nbLignes, int nbColonnes, double probaBombe) {
		this.nbLignes = nbLignes;
		this.nbColonnes = nbColonnes;
		this.probaBombe = probaBombe;
		this.demineur = initDemineur();
		initBombe();
	}

	private Vector<Cellule> initDemineur() {
		Vector<Cellule> demineur = new Vector<Cellule>();
		for (int l = 0; l < getNbLignes(); l++)
			for (int c = 0; c < getNbColonnes(); c++)
				demineur.add(new Cellule(new Position(l, c)));
		return demineur;
	}

	private void initBombe() {
		Random random = new Random();
		int bombesPlacees = 0;
		do {
			int cellule = random.nextInt(getDemineur().size());
			if (!getDemineur().get(cellule).isBomb()) {
				getDemineur().get(cellule).setBomb();
				bombesPlacees += 1;
			}
		} while (bombesPlacees < getNbBombes());
	}

	public Vector<Cellule> getDemineur() {
		return demineur;
	}

	private int getNbColonnes() {
		return nbColonnes;
	}

	private int getNbLignes() {
		return nbLignes;
	}

	private int nbCellules() {
		return getNbColonnes() * getNbLignes();
	}

	private double getProbaBombe() {
		return probaBombe;
	}

	private void print() {
		for (Cellule cellule : getDemineur()) {
			afficherCellule(cellule);
			if (cellule.getPosition().getColonne() == getNbColonnes() - 1)
				System.out.println();
		}
	}

	private void afficherCellule(Cellule cellule) {
		if (cellule.isVisible()) {
			if (cellule.isBomb()) {
				System.out.print("B");
			} else
				System.out.print(nbBombesVoisines(cellule));
		} else
			System.out.print("-");
	}

	private boolean finDuJeu() {
		if (clickedOnBomb()) {
			System.out.println("Vous avez perdu");
			return true;
		} else if (allPositionsDiscovered()) {
			System.out.println("Vous avez gagné");
			return true;
		}
		return false;

	}

	private boolean allPositionsDiscovered() {
		for (Cellule cellule : getDemineur())
			if (!cellule.isVisible() && !cellule.isBomb())
				return false;
		return true;
	}

	private boolean clickedOnBomb() {
		for (Cellule cellule: getDemineur())
			if (cellule.isVisible() && cellule.isBomb())
				return true;
		return false;
	}

	private int nbBombesVoisines(Cellule cellule) {
		int result = 0;
		for (Cellule voisine : neighboorCellules(cellule))
			if (voisine.isBomb())
				result++;
		return result;
	}

	private boolean isOutOfRange(Position position) {
		return position.getLigne() < 0 || position.getColonne() < 0
				|| position.getLigne() > getNbLignes() - 1
				|| position.getColonne() > getNbColonnes() - 1;
	}

	private int getNbBombes() {
		return (int) (nbCellules() * getProbaBombe());
	}

	private void decouvrirVoisines(Cellule tentative) {
		for (Cellule voisine : neighboorCellules(tentative))
			if (!voisine.isVisible())
				decouvre(voisine);
	}
	
	private int indexFromPos(Position position) {
		return position.getLigne() * getNbColonnes() + position.getColonne();
	}
	
	private void decouvre(Position position) {
		decouvre(getDemineur().get(indexFromPos(position)));
	}


	private void decouvre(Cellule cellule) {
		cellule.makeVisible();
		if (nbBombesVoisines(cellule) == 0) {
			decouvrirVoisines(cellule);
		}
	}

	//retaper cette methode qui est quand meme bien moche et incompréhensible
	private List<Cellule> neighboorCellules(Cellule tentative) {

		List<Cellule> res = new ArrayList<Cellule>();
		int ligneTentative = tentative.getPosition().getLigne();
		int colonneTentative = tentative.getPosition().getColonne();

		for (int l = ligneTentative - 1; l < ligneTentative + 2; l++)
			for (int c = colonneTentative - 1; c < colonneTentative + 2; c++)
				if (!isOutOfRange(new Position(l, c)))
					res.add(getDemineur().get(indexFromPos(new Position(l, c))));
		return res;
	}

	public void play() {

		Scanner scanner = new Scanner(System.in);

		int ligne;
		int colonne;

		do {
			print();

			System.out.println("ligne?");
			ligne = scanner.nextInt();

			System.out.println("colonne?");
			colonne = scanner.nextInt();

			Position position = new Position(ligne - 1, colonne - 1);

			if (isOutOfRange(position)) {
				System.out.println("position invalide\n");
				continue;
			}

			decouvre(position);

		} while (!finDuJeu());

		print();

		System.out.println("Partie terminée");

		scanner.close();
	}


}
