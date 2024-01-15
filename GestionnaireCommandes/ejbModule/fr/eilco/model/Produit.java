package fr.eilco.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(schema = "WebCatalogDB", name = "produit")
public class Produit implements Serializable {	
	private Integer id;
	private String nom;
	private Float prix;
	private String description;
	private Date dernier_maj;	
	private Categorie categorie;

	@Id
	@Column(name = "pk_produit")
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(length = 45)
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@Column(name = "prix")
	public float getPrix() {
		return prix;
	}

	public void setPrix(Float prix) {
		this.prix = prix;
	}
	
	@Column(length = 250)
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "dernier_maj")
	public Date getDernier_maj() {
		return dernier_maj;
	}

	public void setDernier_maj(Date dernier_maj) {
		this.dernier_maj = dernier_maj;
	}

	@ManyToOne(targetEntity = Categorie.class, cascade = CascadeType.PERSIST)
	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
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
		Produit other = (Produit) obj;
		return Objects.equals(id, other.id);
	}

}
