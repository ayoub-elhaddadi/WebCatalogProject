<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Produits</title>
<link rel="stylesheet" type="text/css" href="styles/main.css">
</head>
<body>

	<jsp:include page="../views/Header.jsp"></jsp:include>

    <jsp:include page="../views/SideBar.jsp"></jsp:include>

    
    <main>
    	<div class="section-categories">
	    	<div class="categories">
		    	<h4>Catégories</h4>
		  		<ul>
			    	<c:forEach var="categorie" items="${categories}">
						<li class="categorie">
							<a href="/WebCatalogProject/produits?idCategorie=${categorie.id}">${categorie.nom}</a>
						</li>
					</c:forEach>
				</ul>
	    	</div>
	    	
	    	<div class="section-produits">
		    	<h4>${nomCategorie}</h4>
		    	<table class="produits">
			    	<tbody>
				    	<c:forEach var="produit" items="${produits}">
							<tr>
								<td>${produit.nom}</td>
								<td>
									<a href="/WebCatalogProject/panier?idProduit=${produit.id}">
										<c:choose>
										<c:when test="${panier != null and panier.stream().anyMatch(p -> produit.id == p.getProduit().id)}">
										        Supprimer du panier
										    </c:when>
										    <c:otherwise>
										        Ajouter au panier
										    </c:otherwise>
										</c:choose>
									</a>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
	    	</div>
    	</div>
    </main>
	<jsp:include page="../views/Footer.jsp"></jsp:include>
