package fr.eilco.ejb;

import java.util.List;

import fr.eilco.model.Categorie;
import fr.eilco.model.Produit;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.Root;

/**
 * Session Bean implementation class AccessCatalogueBean
 */
@Stateless(name = "WebCatalogJNDI")
public class AccesCatalogueBean implements AccessCatalogueBeanRemote {

	@PersistenceContext(unitName="managerBoutique")
	EntityManager em;
    
	CriteriaBuilder cb;
    
    @Override
    public List<Categorie> getListCategories() {
    	cb = em.getCriteriaBuilder();
    	CriteriaQuery<Categorie> cq = cb.createQuery(Categorie.class);
    	Root<Categorie> root = cq.from(Categorie.class);

    	return em.createQuery(cq.select(root)).getResultList();

    	
    }
	
	@Override
	public List<Produit> getListProduits(int id) {
		cb = em.getCriteriaBuilder();
		CriteriaQuery<Produit> cq = cb.createQuery(Produit.class);
		Root<Produit> root = cq.from(Produit.class);

		Join<Produit, Categorie> categorieJoin = root.join("categorie");
		cq.where(cb.equal(categorieJoin.get("id"), id)).select(root);

		return em.createQuery(cq).getResultList();
	}

}
