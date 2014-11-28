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
 * Servlet implementation class ProcesarServlet
 */
@WebServlet("/Procesar")
public class ProcesarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProcesarServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String numero = request.getParameter("numero");
		int cupoMaximo=Integer.parseInt(request.getParameter("cupoMaximo"));
		int cupoDisponible=Integer.parseInt(request.getParameter("cupoDisponible"));
		String tipo = request.getParameter("tipo");
		String numeroComprobacion = request.getParameter("numeroComprobacion");
		String contrasehna = request.getParameter("contrasehna");
		String actualizar=request.getParameter("actualizar");
		Negocio negocio = new Negocio();
		String n="";
		if(actualizar!=null){
			n=negocio.actualizar(id,numero,cupoMaximo,cupoDisponible,tipo,numeroComprobacion,contrasehna);
		}
		String mensaje=negocio.actualizar(id,numero,cupoMaximo,cupoDisponible,tipo,numeroComprobacion,contrasehna);
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
