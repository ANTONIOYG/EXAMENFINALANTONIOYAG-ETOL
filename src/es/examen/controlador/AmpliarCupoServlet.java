package es.examen.controlador;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import es.examen.modelo.Negocio;
import es.examen.modelo.TarjetaCredito;

/**
 * Servlet implementation class AmpliarCupoServlet
 */
@WebServlet("/AmpliarCupo")
public class AmpliarCupoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AmpliarCupoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		   
	    Negocio negocio = new Negocio();
	    TarjetaCredito tarjetacredito =negocio.consultarUno(id);
	    
	    // meter el pais en el request.. uso el metodo setAttribute
	    request.setAttribute("tarjetacredito", tarjetacredito);
	    // Redirigir hacia la pagina jsp que muestra los datos del pais.
	    RequestDispatcher rd;
	    rd=request.getRequestDispatcher("vistaIndividual.jsp");
	    rd.forward(request, response);
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
