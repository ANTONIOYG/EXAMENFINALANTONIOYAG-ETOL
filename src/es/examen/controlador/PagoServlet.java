package es.examen.controlador;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.examen.modelo.Negocio;

/**
 * Servlet implementation class PagoServlet
 */
@WebServlet("/Pago")
public class PagoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PagoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String numero = request.getParameter("numero");
		String contrasehna = request.getParameter("contrasehna");
		String numeroComprobacion = request.getParameter("numeroComprobacion");
		int cantidad = Integer.parseInt(request.getParameter("cantidad"));
		int cupoDisponible = Integer.parseInt(request.getParameter("cupoDisponible"));
		Negocio negocio = new Negocio();
		String mensaje = negocio.pago(numero,contrasehna,numeroComprobacion,cantidad,cupoDisponible);
		request.setAttribute("mensaje", mensaje);
		RequestDispatcher rd=request.getRequestDispatcher("vistaMensaje.jsp");
		rd.forward(request, response);

	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
