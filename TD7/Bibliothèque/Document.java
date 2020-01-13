package Bibliothèque;

import java.util.Objects;

public class Document {

	private int numEnregistrement;
	private String titre;

	public Document(int numEnregistrement, String titre) {
		this.numEnregistrement = numEnregistrement;
		this.titre = titre;
	}

	public String toString() {
		return "Numéro d'enregistrement : " + numEnregistrement + "\n" + "Titre : " + titre + "\n";
	}

	public String getTitre() {
		return titre;
	}

	public int getNumEnregistrement() {
		return numEnregistrement;
	}

	@Override // J'ai pas fait de methode pour les sousclasses car je pars du principe que si
				// le titre et le num sont le meme c'est bon, mais en principe il faudrait un
				// override qui verifie les propriétés spécifiques aux sous classes en plus

	public boolean equals(Object o) {
		if (o == null || o.getClass() != getClass())
			return false;
		Document doc = (Document) o;
		return Objects.equals(getTitre(), doc.getTitre())
				&& Objects.equals(getNumEnregistrement(), doc.getNumEnregistrement());
	}

}
