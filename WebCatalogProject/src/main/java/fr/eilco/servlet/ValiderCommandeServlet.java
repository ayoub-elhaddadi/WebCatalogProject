package fr.eilco.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import fr.eilco.ejb.GestionCommandeBeanRemote;
import fr.eilco.model.Client;
import fr.eilco.model.Commande;
import fr.eilco.model.ProduitCommande;
import fr.eilco.remote.RemoteAccess;

/**
 * Servlet implementation class ValiderCommandeServlet
 */
@WebServlet("valider-commande")
public class ValiderCommandeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ValiderCommandeServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		if(session.getAttribute("client") == null) 
			request.getRequestDispatcher("WEB-INF/enregistrement.jsp").forward(request, response);
		
		else {
			GestionCommandeBeanRemote gRemote = RemoteAccess.getGestionCommandeBeanRemote();
			
			Commande c = (Commande) session.getAttribute("commande");
			gRemote.validerCommande(c);
			
			request.setAttribute("numeroCommande", c.getNumero());
			session.setAttribute("panier", null);
			session.setAttribute("commande", null);
			request.getRequestDispatcher("WEB-INF/confirmation.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		
		Client client = new Client();
		
		client.setEmail(request.getParameter("email"));
		client.setPhone(request.getParameter("phone"));
		client.setAdresse(request.getParameter("adresse"));
		client.setPrenom(request.getParameter("prenom"));
		client.setNom(request.getParameter("prenom"));
		client.setMtp(request.getParameter("mtp"));
		
		Set<ProduitCommande> panier = (HashSet<ProduitCommande>) session.getAttribute("panier");
		
		GestionCommandeBeanRemote gRemote = RemoteAccess.getGestionCommandeBeanRemote();
		
		gRemote.createClient(client);
		Commande c = (Commande) session.getAttribute("commande");
		c.setLignesCommandes(panier);
		gRemote.validerCommande(c);
		
		request.setAttribute("numeroCommande", c.getNumero());
		session.setAttribute("panier", null);
		session.setAttribute("commande", null);
		session.setAttribute("client", client);
		request.getRequestDispatcher("WEB-INF/confirmation.jsp").forward(request, response);
	}
	
}
