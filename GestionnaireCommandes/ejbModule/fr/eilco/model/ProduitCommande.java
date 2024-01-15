package fr.eilco.model;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(schema = "WebCatalogDB", name = "ligne_commandes")
public class ProduitCommande implements Serializable {
	private int id;
	private String code;
	private int quantite;
	private Commande commande;
	private Produit produit; 
	
	@Id
	@Column(name="pk_ligne_commande")
	@GeneratedValue
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	@Column(name="code")
	public String getNumero() {
		return code;
	}
	
	public void setNumero(String code) {
		this.code= code;
	}
	
	@Column(name="quantite")
	public int getQuantite() {
		return quantite;
	}
	
	public void setQuantite(int quantite) {
		this.quantite= quantite;
	}
	
	
	@ManyToOne(targetEntity = Commande.class, cascade=CascadeType.PERSIST)
	public Commande getCommande() {
		return commande;
	}
	
	public void setCommande(Commande commande) {
		this.commande = commande;
	}
	
	@ManyToOne(targetEntity = Produit.class, cascade=CascadeType.PERSIST)
	public Produit getProduit() {
		return produit;
	}
	
	public void setProduit(Produit produit) {
		this.produit= produit;
	}
	
	public String toString(){
		return "id "+ id + " code " + code;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProduitCommande other = (ProduitCommande) obj;
		return produit.getId() == other.getProduit().getId();
	}
	
	@Override
	public int hashCode() {
		if(produit == null) return Objects.hash(id);
		return Objects.hash(produit.getId());
	}
	
}
