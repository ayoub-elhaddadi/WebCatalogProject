package fr.eilco.ejb;

import java.util.List;

import fr.eilco.model.Categorie;
import fr.eilco.model.Produit;
import jakarta.ejb.Remote;

@Remote
public interface AccessCatalogueBeanRemote {
	public List<Categorie> getListCategories();
	public List<Produit> getListProduits(int id);
}
