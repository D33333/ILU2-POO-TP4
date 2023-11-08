package produit;

public enum Unite {
	LITRE("l"), GRAMME("g"), KILOGRAMME("kg"), CENTILITRE("cl"), MILLILITRE("ml"), PARPIECE("par pièce");
	
	private String nom;
	
	private Unite(String nom) {
		this.nom = nom;
	}
	
	@Override
	public String toString() {
		return nom;
	}
}
