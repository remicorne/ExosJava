package JournalEvenements;

import java.util.Scanner;

public class TestJournal {

	static boolean correctStart(String entree) {
		return entree.startsWith("+") || entree.startsWith("?");
	}
	
	static boolean firstCharIsSpace(String entree) {
		return entree.startsWith(" ");
	}

	static String retrieveText(String entree) {
		entree = entree.substring(1);
		if (firstCharIsSpace(entree))
			entree = entree.substring(1);
		return entree;
	}

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		String entree;

		Journal journal = new Journal();

		String prompt = "+ texte : ajout de l'evenement en question\n? : lister tous les évenements\n? chaine : lister evenements contenant chaine\n* : fin du programme";
		
		
		do {
			System.out.println(prompt);
			entree = scanner.nextLine();
			
			if (!TestJournal.correctStart(entree))
				continue;
			
			if (entree.startsWith("+")) {
				entree = TestJournal.retrieveText(entree);
				if (entree.length() > 0)
					journal.ajouter(entree);
				else
					System.out.println("ajoutez du texte après le +\n");
			}
			if (entree.startsWith("?")) {
				if (entree.length() == 1)
					System.out.println(journal);
				else {
					entree = TestJournal.retrieveText(entree);
					if (entree.length() > 0)
						System.out.println(journal.toString(entree));
					else
						System.out.println("ajoutez du texte après le ?\n");
				}
			}
		} while (!entree.startsWith("*"));

		System.out.println("fin du programme");

		scanner.close();
	}

}
