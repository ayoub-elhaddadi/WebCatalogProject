<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="total" value="0" />
   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Panier</title>
<link rel="stylesheet" type="text/css" href="styles/main.css">
</head>
<body>

	<jsp:include page="../views/Header.jsp"></jsp:include>

    	<jsp:include page="../views/SideBar.jsp"></jsp:include>

    
    <main>
	    <h4>Votre panier</h4>
    	<table class="produits">
    		<thead>
    			<tr>
    				<th>Article</th>
    				<th>Quantité</th>
    				<th>Prix</th>
    				<th></th>
    			</tr>
    		</thead>
	    	<tbody>
		    	<c:forEach var="item" items="${panier}">
					<tr>
						<td>${item.produit.nom}</td>
						<td class="change-quantity">
				           	<a class="btn" href="/WebCatalogProject/diminuerQuantite?idProduit=${item.produit.id}">-</a>
				            <span class="quantity-indicator">${item.quantite}</span>
				            <a class="btn" href="/WebCatalogProject/augmenterQuantite?idProduit=${item.produit.id}">+</a>
				        </td>
						<td>${item.produit.prix * item.quantite}&euro;</td>
						<td width="20%">
							<a href="/WebCatalogProject/supprimer?idProduit=${item.produit.id}">Supprimer du panier</a>
						</td>
					</tr>
					<c:set var="total" value="${total + item.produit.prix * item.quantite}" />
				</c:forEach>
			</tbody>
			<tfoot>
				<tr>
    				<th>Total</th>
    				<th></th>
    				<th>${total}&euro;</th>
    			</tr>
			</tfoot>
		</table>
		<h4>
			<a href="/WebCatalogProject/valider-commande">Valider la commande</a>
		</h4>
    </main>
	<jsp:include page="../views/Footer.jsp"></jsp:include>
	
