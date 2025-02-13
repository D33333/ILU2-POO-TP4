package village;

import personnages.Gaulois;
import produit.Produit;
import villagegaulois.Etal;
import villagegaulois.IEtal;
import villagegauloisold.DepenseMarchand;

public interface IVillage {	
	public <P extends Produit> boolean installerVendeur(Etal<P> etal, Gaulois vendeur, P[] produit, int prix);
	
	public DepenseMarchand[] acheterProduit(String produit, int quantiteSouhaitee);
}
