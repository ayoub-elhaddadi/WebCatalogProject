package fr.eilco.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;

import fr.eilco.ejb.AccessCatalogueBeanRemote;
import fr.eilco.model.Categorie;
import fr.eilco.model.Produit;
import fr.eilco.remote.RemoteAccess;

/**
 * Servlet implementation class ProductServlet
 */
@WebServlet("/produits")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ProductServlet() { super(); }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		String idCategorie = request.getParameter("idCategorie");
		ArrayList<Produit> produits = new ArrayList<>();
		int id;
		
		try {
            id = Integer.parseInt(idCategorie);
		} catch(NumberFormatException e) {
			response.sendRedirect("404.jsp");
			return;
		} 
            
		AccessCatalogueBeanRemote remote = RemoteAccess.getAccessCatalogueBeanRemote();
		
        List<Categorie> categories = (ArrayList<Categorie>) session.getAttribute("categories");
		if(categories == null) categories = remote.getListCategories();
		Categorie categorie = categories.stream().filter(c -> c.getId() == id).findFirst().orElse(null);
		
		if(categorie == null) {
			response.sendRedirect("404.jsp");
			return;
		}
		
		session.setAttribute("nomCategorie", categorie.getNom());
        produits.addAll(remote.getListProduits(id));
		
		session.setAttribute("produits", produits);
        request.getRequestDispatcher("WEB-INF/produits.jsp").forward(request, response);
        return;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
