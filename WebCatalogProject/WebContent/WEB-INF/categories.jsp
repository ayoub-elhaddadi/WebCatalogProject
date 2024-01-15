<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:useBean id="categories" class="java.util.ArrayList" scope="session" />
   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Catégories</title>
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
	    	
	    	<div class="text-categories">
		    	<h4>Sélectionnez une catégorie de produits</h4>
	    	</div>
    	</div>
    </main>
	<jsp:include page="../views/Footer.jsp"></jsp:include>
