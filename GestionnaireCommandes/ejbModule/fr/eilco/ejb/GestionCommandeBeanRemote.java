package fr.eilco.ejb;

import java.util.Set;

import fr.eilco.model.Client;
import fr.eilco.model.Commande;
import fr.eilco.model.ProduitCommande;
import jakarta.ejb.Remote;

@Remote
public interface GestionCommandeBeanRemote {
	public Commande createCommande();
	public Set<ProduitCommande> createLignesCommande();
	public void validerCommande(Commande c);
	public void createClient(Client client);
}
