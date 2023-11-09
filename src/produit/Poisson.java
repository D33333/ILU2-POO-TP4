package produit;

public class Poisson extends Produit implements IProduit{
	private String datePeche;
	
	public Poisson(String datePeche) {
		super("poisson", Unite.PARPIECE);
		this.datePeche = datePeche;
	}
	
	@Override
	public String description() {
		return super.getNom()+" pêché "+datePeche;
	}
}