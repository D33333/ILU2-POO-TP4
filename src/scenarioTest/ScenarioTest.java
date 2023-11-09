package scenarioTest;

import personnages.Gaulois;
import produit.Poisson;
import produit.Produit;
import produit.Sanglier;
import produit.Unite;
import villagegaulois.Etal;
import villagegaulois.IEtal;

public class ScenarioTest {
	public static void main(String[] args) {
		//Création des Gaulois
		Gaulois ordralfabetix = new Gaulois("Ordralfabétix",9);
		Gaulois obelix = new Gaulois("Obélix",20);
		Gaulois asterix = new Gaulois("Asterix", 6);
		
		//Création des tableaux de produits
		Sanglier sanglier1 = new Sanglier(2000, obelix);
		Sanglier sanglier2 = new Sanglier(1500, obelix);
		Sanglier sanglier3 = new Sanglier(1000, asterix);
		Sanglier sanglier4 = new Sanglier(500, asterix);
		
		Sanglier[] sangliersObelix = {sanglier1, sanglier2};
		Sanglier[] sangliersAsterix = {sanglier3, sanglier4};
		
		Poisson poisson1 = new Poisson("lundi");
		Poisson[] poissons = {poisson1};
		
		//Création du marché
		IEtal[] marche = new IEtal[3];
		
		Etal<Sanglier> etalSanglier1 = new Etal();
		Etal<Sanglier> etalSanglier2 = new Etal();
		
		Etal<Poisson> etalPoisson = new Etal();
		
		marche[0] = etalSanglier1;
        marche[1] = etalSanglier2;
        marche[2] = etalPoisson;
		
		//Installation des vendeurs sur le marché
		etalSanglier1.installerVendeur(asterix, sangliersAsterix, 10);
		etalSanglier2.installerVendeur(obelix, sangliersObelix, 8);
		
		etalPoisson.installerVendeur(ordralfabetix, poissons, 7);
		
		//Affichage du marché
		System.out.println("ETAT MARCHE");
		for(IEtal etal : marche) {
			System.out.println(etal.etatEtal());
		}
		
		int nbAchats = 0;
		int numEtalVu = 0;
		while (3-nbAchats > 0 || numEtalVu != 3) {
			int qDispo = marche[numEtalVu].contientProduit("sanglier", 3-nbAchats);
			if (qDispo == 0){
				numEtalVu+=1;
			} else {
				double prix = marche[numEtalVu].acheterProduit(qDispo);
				nbAchats += qDispo;
				System.out.println("À l'étal "+numEtalVu+" je paye "+prix+" sous.");
			}
		}
		System.out.println("Je voulais acheter 3 sangliers, j'en ai acheté "+nbAchats);
		
		System.out.println("ETAT MARCHE");
		for(IEtal etal : marche) {
			System.out.println(etal.etatEtal());
		}
	}
}
