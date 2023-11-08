package produit;

import personnages.Gaulois;

public class Sanglier extends Produit {
	private int poids;
	private Gaulois chasseur;
	
	public Sanglier(Unite unite, int poids, Gaulois chasseur) {
		super("sanglier", unite);
		this.poids = poids;
		this.chasseur = chasseur;
	}
	
	@Override
	public String descriptionPdt() {
		return super.getNomPdt()+" de "+poids+' '+super.getUnite()+" chassé par "+chasseur.getNom();
	}
}