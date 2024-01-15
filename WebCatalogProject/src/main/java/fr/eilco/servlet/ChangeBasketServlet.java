package fr.eilco.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.Set;

import fr.eilco.model.ProduitCommande;

/**
 * Servlet implementation class ChangeQuantityServlet
 */
@WebServlet(urlPatterns = { "supprimer" ,"augmenterQuantite" ,"diminuerQuantite" })
public class ChangeBasketServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangeBasketServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		Set<ProduitCommande> produits = (Set<ProduitCommande>) session.getAttribute("panier");
		
		if(produits == null || produits.size() == 0) {
			response.sendRedirect("/categories");
			return;
		}
				
		String idProduit = request.getParameter("idProduit");
		int id;
		
		try {
			id = Integer.valueOf(idProduit);
		} catch(NumberFormatException e) {
			response.sendRedirect("/404.jsp");
			return;
		}
		
		ProduitCommande produit = produits.stream().filter(p -> p.getProduit().getId() == id).findFirst().orElse(null);
		
		if(produit == null) {
			response.sendRedirect("/404.jsp");
			return;
		}
		
		if("/augmenterQuantite".equals(request.getServletPath()))
			produit.setQuantite(produit.getQuantite() + 1);				
		else if("/diminuerQuantite".equals(request.getServletPath()) && produit.getQuantite() > 1)
			produit.setQuantite(produit.getQuantite() - 1);
		else if("/supprimer".equals(request.getServletPath()))
			produits.remove(produit);
		
		if(produits.size() == 0) {
			response.sendRedirect("/WebCatalogProject/categories");
		}
		
		request.setAttribute("idProduit", null);
		request.getRequestDispatcher("/WEB-INF/panier.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
