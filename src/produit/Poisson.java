package produit;

public class Poisson extends Produit{
	private String datePeche;
	
	public Poisson(Unite unite, String datePeche) {
		super("poisson", unite);
		this.datePeche = datePeche;
	}
	
	@Override
	public String descriptionPdt() {
		return super.getNomPdt()+" pêchés "+datePeche+'.';
	}
}
