package fr.eilco.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import fr.eilco.ejb.GestionCommandeBeanRemote;
import fr.eilco.model.ProduitCommande;
import fr.eilco.remote.RemoteAccess;
import fr.eilco.model.Produit;

/**
 * Servlet implementation class BasketServlet
 */
@WebServlet("/panier")
public class AddToBasketServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddToBasketServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		HttpSession session = request.getSession(true);

		if(session.getAttribute("panier") == null)  {
			GestionCommandeBeanRemote gRemote = RemoteAccess.getGestionCommandeBeanRemote();
			session.setAttribute("commande", gRemote.createCommande());
			session.setAttribute("panier", new HashSet<ProduitCommande>());
		}
		
		
		String idProduit = request.getParameter("idProduit");
		Set<ProduitCommande> panier = (Set<ProduitCommande>)session.getAttribute("panier");
		
		if(idProduit == null && panier != null && panier.size() > 0) {
			request.getRequestDispatcher("WEB-INF/panier.jsp").forward(request, response);
			return;
		} else if(idProduit == null) {
			response.sendRedirect("categories");
			return;
		}
				
		int id;
		
		try {
			id = Integer.valueOf(idProduit);
		} catch(NumberFormatException e) {
			// Si id n'est pas un nombre, on redirige vers la page 404
			response.sendRedirect("404.jsp");
			return;
		}
		
		List<Produit> produits = (List<Produit>)session.getAttribute("produits");
		Produit produit = produits.stream().filter(p -> p.getId() == id).findFirst().orElse(null);
		
		if(produit == null) {
			// Si le produit est null, alors le produit n'existe pas dans la liste de produits,
			// Donc, on redirige vers la page 404
			response.sendRedirect("404.jsp");
			return;
		}
		
		ProduitCommande p = new ProduitCommande();
		p.setProduit(produit);
		if(panier.contains(p)) {
			panier.remove(p);
		} else {
			p.setQuantite(1);
			p.setNumero(UUID.randomUUID().toString());
			panier.add(p);
		}
		
		request.getRequestDispatcher("WEB-INF/produits.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
