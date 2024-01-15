<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<sidebar>
	<h3>Menu</h3>
	<ul>
		<li>
			<a href="/WebCatalogProject">
				Accueil
			</a>
		</li>
		<li>
			<a href="/WebCatalogProject/categories">Catégories</a>
		</li>
		<c:if test="${panier != null && panier.size() > 0}">
			<li>
				<a href="/WebCatalogProject/panier">Votre Panier</a>
			</li>
		</c:if>
	</ul>
</sidebar>