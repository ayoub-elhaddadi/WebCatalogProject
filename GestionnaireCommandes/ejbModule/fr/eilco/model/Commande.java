package fr.eilco.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(schema = "WebCatalogDB", name = "commandes")
public class Commande implements Serializable {
	private int id;
	private String numero;
	private Collection<ProduitCommande> lignesCommandes;
	
	@Id
	@Column(name="pk_commande")
	@GeneratedValue
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	@Column(name="numero")
	public String getNumero() {
		return numero;
	}
	
	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	@OneToMany(targetEntity=ProduitCommande.class, mappedBy="commande", cascade=CascadeType.PERSIST)
	public Collection<ProduitCommande> getLignesCommandes() {
		return lignesCommandes;
	}
	
	public void setLignesCommandes(Collection<ProduitCommande> lignesCommandes) {
		this.lignesCommandes = lignesCommandes;
	}
	
	public String toString(){
		return "id "+ id + " numero " + numero;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Commande other = (Commande) obj;
		return id == other.id;
	}
	
}
