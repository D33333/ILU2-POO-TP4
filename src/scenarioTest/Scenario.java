package scenarioTest;

import personnages.Gaulois;
import produit.Poisson;
import produit.Produit;
import produit.Sanglier;
import village.IVillage;
import villagegaulois.Etal;
import villagegaulois.IEtal;
import villagegauloisold.DepenseMarchand;

public class Scenario {
	public static void main(String[] args) {

		// TODO Partie 4 : creer de la classe anonyme Village
		IVillage village = new IVillage() {
			
			public static int nbEtalsNonVides = 0;
			public static final IEtal[] MARCHE = new IEtal[3];
			
			@Override
			public DepenseMarchand[] acheterProduit(String produit, int quantiteSouhaitee) {
				DepenseMarchand[] depensesTots = new DepenseMarchand[3];
				int nbAchats = 0;
				int numEtalVu = 0;
				while (numEtalVu != MARCHE.length && (quantiteSouhaitee-nbAchats > 0) && MARCHE[numEtalVu] != null) {
					int qDispo = MARCHE[numEtalVu].contientProduit(produit, quantiteSouhaitee-nbAchats);
					double prix = MARCHE[numEtalVu].acheterProduit(qDispo);
					nbAchats += qDispo;
					depensesTots[numEtalVu] = new DepenseMarchand(MARCHE[numEtalVu].getVendeur(), qDispo, produit, prix);
					numEtalVu +=1;
				}
				return depensesTots;
			}

			@Override
			public <P extends Produit> boolean installerVendeur(Etal<P> etal, Gaulois vendeur,
					P[] produit, int prix) {
				etal.installerVendeur(vendeur, produit, prix);
				MARCHE[nbEtalsNonVides] = etal;
				nbEtalsNonVides++;
				return true;
			}
			
			public String toString() {
				StringBuilder afficherMarche = new StringBuilder();
				for(IEtal etal : MARCHE) {
					if (etal != null) {
						afficherMarche.append(etal.etatEtal());
					}
				}
				return afficherMarche.toString();
			}
		};
		// fin

		Gaulois ordralfabetix = new Gaulois("Ordralfabétix", 9);
		Gaulois obelix = new Gaulois("Obélix", 20);
		Gaulois asterix = new Gaulois("Astérix", 6);

		Etal<Sanglier> etalSanglierObelix = new Etal<>();
		Etal<Sanglier> etalSanglierAsterix = new Etal<>();
		Etal<Poisson> etalPoisson = new Etal<>();

		Sanglier sanglier1 = new Sanglier(2000, obelix);
		Sanglier sanglier2 = new Sanglier(1500, obelix);
		Sanglier sanglier3 = new Sanglier(1000, asterix);
		Sanglier sanglier4 = new Sanglier(500, asterix);

		Sanglier[] sangliersObelix = { sanglier1, sanglier2 };
		Sanglier[] sangliersAsterix = { sanglier3, sanglier4 };

		Poisson poisson1 = new Poisson("lundi");
		Poisson[] poissons = { poisson1 };

		village.installerVendeur(etalSanglierAsterix, asterix, sangliersAsterix, 10);
		village.installerVendeur(etalSanglierObelix, obelix, sangliersObelix, 8);
		village.installerVendeur(etalPoisson, ordralfabetix, poissons, 5);

		System.out.println(village);

		DepenseMarchand[] depense = village.acheterProduit("sanglier", 3);

		for (int i = 0; i < depense.length && depense[i] != null; i++) {
			System.out.println(depense[i]);
		}

		System.out.println(village);

	}

}
