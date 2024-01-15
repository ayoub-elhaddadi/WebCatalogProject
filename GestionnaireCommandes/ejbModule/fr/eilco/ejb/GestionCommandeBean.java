package fr.eilco.ejb;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import fr.eilco.model.Client;
import fr.eilco.model.Commande;
import fr.eilco.model.ProduitCommande;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

/**
 * Session Bean implementation class GestionCommandeBean
 */
@Stateless(name = "GestionCommandeBean")
public class GestionCommandeBean implements GestionCommandeBeanRemote {

	  @PersistenceContext(unitName="managerBoutique") EntityManager em;
	  
	  @Override 
	  public Commande createCommande() { 
		  Commande c = new Commande();
		  String numero = UUID.randomUUID().toString().substring(0, 8);
		  c.setNumero(numero.toUpperCase());
		  return c;
	  }
	  
	  @Override
	  public Set<ProduitCommande> createLignesCommande() {
		  return new HashSet<ProduitCommande>();
	  }

	  @Override
	  public void validerCommande(Commande c) {
		  String numero = UUID.randomUUID().toString().substring(0, 8);
	      c.setNumero(numero);
	      System.out.println("Commande enregistré : " + c);
	  }
	  
	  @Override
	  public void createClient(Client c) {
		  em.persist(c);
	  }
	  		

}