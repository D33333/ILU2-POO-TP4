package produit;

public class Poisson extends Produit{
	private String datePeche;
	
	public Poisson(String datePeche) {
		super("poisson", Unite.PARPIECE);
		this.datePeche = datePeche;
	}
	
	@Override
	public String descriptionPdt() {
		return super.getNomPdt()+" pêchés "+datePeche+'.';
	}
}