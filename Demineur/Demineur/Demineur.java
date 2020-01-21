package Demineur;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Demineur {

	private int nbLignes;
	private int nbColonnes;
	private boolean bombe[][];
	private boolean visible[][];
	private double probaBombe;

	public Demineur(int nbLignes, int nbColonnes, double probaBombe) {
		init(nbLignes, nbColonnes, probaBombe);
	}

	public void init(int nbLignes, int nbColonnes, double probaBombe) {
		this.nbLignes = nbLignes;
		this.nbColonnes = nbColonnes;
		this.bombe = new boolean[nbLignes][nbColonnes];
		this.visible = new boolean[nbLignes][nbColonnes];
		this.probaBombe = probaBombe;
		initBombe();
	}

	public int getNbColonnes() {
		return nbColonnes;
	}

	public int getNbLignes() {
		return nbLignes;
	}

	public int nbCellules() {
		return getNbColonnes() * getNbLignes();
	}

	public double getProbaBombe() {
		return probaBombe;
	}

	public void afficherLigne(int ligne) {
		for (int colonne = 0; colonne < getNbColonnes(); colonne++)
			afficherCellule(ligne, colonne);
		System.out.println();
	}

	private void afficherCellule(int ligne, int colonne) {
		if (visible[ligne][colonne]) {
			if (bombe[ligne][colonne]) {
				System.out.print("B");
			}
			else
				System.out.print(nbBombesVoisines(new Position(ligne, colonne)));
		} else
			System.out.print("-");
	}

	public boolean isVisible(Position position) {
		return visible[position.ligne][position.colonne];
	}
	
	private boolean finDuJeu(int ligne, int colonne) {
		return bombe(new Position(ligne, colonne));
	}

	private int nbBombesVoisines(Position tentative) {
		int result = 0;

		for (Position position : neighboorPositions(tentative))
			if (bombe(position))
				result += 1;
		
		return result;
	}

	private boolean bombe(Position position) {
		return !isOutOfRange(position) && bombe[position.ligne][position.colonne];
	}

	private boolean isOutOfRange(Position position) {
		return isOutOfRange(position.ligne, position.colonne);
	}

	private boolean isOutOfRange(int ligne, int colonne) {
		return ligne < 0 || colonne < 0 || ligne > getNbLignes() - 1 || colonne > getNbColonnes() - 1;
	}

	public void print() {
		for (int ligne = 0; ligne < getNbLignes(); ligne++)
			afficherLigne(ligne);
	}

	private void initBombe() {
		Random random = new Random();
		int nbBombe = (int) (nbCellules() * getProbaBombe());
		do {
			int ligne = random.nextInt(getNbLignes());
			int colonne = random.nextInt(getNbColonnes());
			if (!bombe[ligne][colonne]) {
				bombe[ligne][colonne] = true;
				nbBombe -= 1;
			}
		} while (nbBombe > 0);
	}

	private void decouvrirVoisines(Position tentative) {
		for (Position position : neighboorPositions(tentative))
			if (!isVisible(position))
				decouvre(position);
	}

	private void decouvre(Position position) {
		visible[position.ligne][position.colonne] = true;
		if (nbBombesVoisines(position) == 0) {
			decouvrirVoisines(position);
		}
	}
	
	public List<Position> allPositions() {
		List<Position> res = new ArrayList<Position>();

		for (int ligne = 0; ligne < getNbLignes(); ligne++)
			for (int colonne = 0; colonne < getNbColonnes(); colonne++)
				res.add(new Position(ligne, colonne));

		return res;
	}

	public List<Position> neighboorPositions(Position tentative) {
		
		List<Position> res = new ArrayList<Position>();

		for (int ligne = tentative.ligne - 1; ligne <= tentative.ligne + 1; ligne++)
			for (int colonne = tentative.colonne - 1; colonne <= tentative.colonne + 1; colonne++)
				if (!isOutOfRange(ligne, colonne) && !(tentative.ligne == ligne && tentative.colonne == colonne))
					res.add(new Position(ligne, colonne));
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
			
			decouvre(position);
			
		}
		while (!finDuJeu(ligne - 1, colonne - 1));
		
		print();
		
		System.out.println("Vous avez perdu");
		
		scanner.close();
	}

}
