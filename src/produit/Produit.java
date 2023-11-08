package produit;


public abstract class Produit {
	private String nom;
	private Unite unite;
	
	public Produit(String nom, Unite unite) {
		this.nom = nom;
		this.unite = unite;
	}

	public String getNomPdt() {
		return nom;
	}
	
	public Unite getUnite() {
		return unite;
	}
	
	public abstract String descriptionPdt();
}
