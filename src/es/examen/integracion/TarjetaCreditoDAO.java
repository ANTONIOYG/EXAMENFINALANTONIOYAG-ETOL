package es.examen.integracion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import es.examen.modelo.TarjetaCredito;

public class TarjetaCreditoDAO {
	private Connection cx;
    private static TarjetaCreditoDAO tarjetaDao=null;
    
    private TarjetaCreditoDAO(){
    }
    public static TarjetaCreditoDAO getInstance(){
   	 if(TarjetaCreditoDAO.tarjetaDao==null)
   		 TarjetaCreditoDAO.tarjetaDao= new TarjetaCreditoDAO();
   	 return TarjetaCreditoDAO.tarjetaDao;
    }
  
    private void conectar() {
    try {
           Class.forName("com.mysql.jdbc.Driver");
           cx= DriverManager.getConnection("jdbc:mysql://localhost:3306/BANCO","root","root");
           cx.setAutoCommit(false);
    }
catch(SQLException e) {
       
  Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "Error en SQL ", e);
   }
    catch(ClassNotFoundException e) {
        Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "No se encuentra lib mySQL ", e);
   }
    }
    private void desconectar() {
        try {
            if(cx!=null)
               cx.close();
       } catch (SQLException e) {
          
           Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "Error al cerrar conexión ", e);
       }
    }
    public int DarAlta(TarjetaCredito tarjetacredito) {
    	int id=0;
    	try{
    		conectar();
    		PreparedStatement ps =cx.prepareStatement("INSERT INTO TARJETACREDITO VALUES(?,?,?,?,?,?,?)"); 
    		 ps.setInt(1, 0);
             ps.setString(2, tarjetacredito.getNumero());
             ps.setInt(3, tarjetacredito.getCupoMaximo());
             ps.setInt(4, tarjetacredito.getCupoDisponible());
             ps.setString(5, tarjetacredito.getTipo());
             ps.setString(6, tarjetacredito.getNumeroComprobacion());
             ps.setString(7, tarjetacredito.getContrasehna());
             int filasAfectadas =ps.executeUpdate();
             cx.commit();
             if(filasAfectadas>=1) {
                 id= ultimoId();    
           }
        } catch (SQLException e) {
        	 Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "Error al cerrar conexión ", e);
        }
        finally{
        	 //.5.cerrar la conexión	
        desconectar();
        }
    	return id;
    }
    public int  ultimoId() {
    	int  idM=90;
    	try {
    		//1. conectar
    		conectar();
    		//2. preparar la sentencia
    		PreparedStatement ps = cx.prepareStatement("SELECT MAX(ID) AS ULTIMO FROM TARJETACREDITO");
    		//3. ejecutar la consulta
    		ResultSet consulta = ps.executeQuery();
    		//4. bajar el resultado de la consulta y ponerlo en el arrayList
    		if(consulta.next()) {
    			idM=consulta.getInt("ULTIMO");
    		}
    		//5. desconectar
    		desconectar();
    	} catch (SQLException e) {
    		 Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "Error al cerrar conexión ", e);
    	}
    	return idM;
    }
    public int actualizar(int id, String numero, int cupoMaximo, int cupoDisponible,
    		String tipo, String numeroComprobacion, String contrasehna) {
    	int filasAfectada=0;
    	try {
    		conectar();
    		PreparedStatement ps = cx.prepareStatement("UPDATE TARJETACREDITO SET NUMERO=?,CUPOMAXIMO=?,CUPODISPONIBLE=?,TIPO=?"
    				+ "NUMEROCOMPROBACION=?,CONTRASEHNA=? WHERE ID=?");
    		ps.setString(1, numero);
    		ps.setInt(2, cupoMaximo);
    		ps.setInt(3, cupoDisponible);
    		ps.setString(4, tipo);
    		ps.setString(5, numeroComprobacion);
    		ps.setString(6, contrasehna);
    		ps.setInt(7, id);
    		filasAfectada=ps.executeUpdate();
    		cx.commit();
    		desconectar();
    	} catch (SQLException e) {
    		 Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "Error al cerrar conexión ", e);
    	}       
    	return filasAfectada;
    }
	public TarjetaCredito consultarUno(int id) {
		TarjetaCredito t = new TarjetaCredito();
		try{
			conectar();
			PreparedStatement ps;
            ps = cx.prepareStatement("SELECT * FROM TARJETACREDITO WHERE ID=?");
            	ps.setInt(1, id);
            	ResultSet rs =ps.executeQuery();
            	if(rs.next()) {
 	                 t.setId(rs.getInt("id"));
 	                 t.setNumero(rs.getString("numero"));
 	                 t.setCupoMaximo(rs.getInt("cupoMaximo"));
 	                 t.setCupoDisponible(rs.getInt("cupoDisponible"));
 	                 t.setTipo(rs.getString("tipo"));
 	                 t.setNumeroComprobacion(rs.getString("numeroComprobacion"));
 	                 t.setContrasehna(rs.getString("contrasehna"));
            	}
 	           desconectar();
 	        } catch (SQLException e) {
 	        	 Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "Error al cerrar conexión ", e);
 	        }
 	      return t;
 	}
	public TarjetaCredito pago(int id) {
		TarjetaCredito t = new TarjetaCredito();
		try{
			conectar();
			PreparedStatement ps;
            ps = cx.prepareStatement("SELECT * FROM TARJETACREDITO WHERE ID=?");
            	ps.setInt(1, id);
            	ResultSet rs =ps.executeQuery();
            	if(rs.next()) {
 	                 t.setId(rs.getInt("id"));
 	                 t.setNumero(rs.getString("numero"));
 	                 t.setCupoMaximo(rs.getInt("cupoMaximo"));
 	                 t.setCupoDisponible(rs.getInt("cupoDisponible"));
 	                 t.setTipo(rs.getString("tipo"));
 	                 t.setNumeroComprobacion(rs.getString("numeroComprobacion"));
 	                 t.setContrasehna(rs.getString("contrasehna"));
            	}
 	           desconectar();
 	        } catch (SQLException e) {
 	        	 Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "Error al cerrar conexión ", e);
 	        }
 	      return t;
 	}
}
