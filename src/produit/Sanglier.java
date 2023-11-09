package produit;

import personnages.Gaulois;

public class Sanglier extends Produit {
	private int poids;
	private Gaulois chasseur;
	
	public Sanglier(int poids, Gaulois chasseur) {
		super("sanglier", Unite.KILOGRAMME);
		this.poids = poids;
		this.chasseur = chasseur;
	}
	
	@Override
	public String description() {
		return super.getNom()+" de "+poids+' '+super.getUnite()+" chassé par "+chasseur.getNom();
	}
	
	@Override
	public double calculerPrix(int prix) {
		return prix*poids/1000; //à la tonne
	}
}