package fr.eilco.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import fr.eilco.remote.RemoteAccess;

/**
 * Servlet implementation class CatalogServlet
 */
@WebServlet("categories")
public class CatalogServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CatalogServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
				
		if(session.getAttribute("categories") == null) {
	        session.setAttribute("categories", RemoteAccess.getAccessCatalogueBeanRemote().getListCategories());
		}
		
        request.getRequestDispatcher("WEB-INF/categories.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
