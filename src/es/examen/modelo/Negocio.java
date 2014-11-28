package es.examen.modelo;


import es.examen.integracion.TarjetaCreditoDAO;


public class Negocio {
	private TarjetaCreditoDAO tarjetacreditodao = TarjetaCreditoDAO.getInstance();

	public int DarAlta(String numero, int cupoMaximo, int cupoDisponible,
			String tipo, String numeroComprobacion, String contrasehna) {
		TarjetaCredito tarjetacredito = new TarjetaCredito(numero,cupoMaximo,cupoDisponible,tipo,numeroComprobacion,contrasehna);
		int id = tarjetacreditodao.DarAlta(tarjetacredito);
		// TODO Auto-generated method stub
		return id;
	}
	public TarjetaCredito consultarUno(int id) {
		TarjetaCredito tarjetacredito = tarjetacreditodao.consultarUno(id);
		return tarjetacredito;
	}
	public String actualizar(int id, String numero, int cupoMaximo,
			int cupoDisponible, String tipo, String numeroComprobacion,
			String contrasehna) {
			String msg;
			int tarjetaactualizadas=tarjetacreditodao.actualizar(id,numero,cupoMaximo,cupoDisponible,tipo,numeroComprobacion,contrasehna);
			if(tarjetaactualizadas!=1){
				msg="SE HAN AMPLIADO "+tarjetaactualizadas+" TARJETAS CREDITO";
			}else{
				msg="NO SE HAN AMPLIADO";
			}
			return msg;
	}
	public String pago(String numero, String contrasehna,
			String numeroComprobacion, int cantidad,  int cupoDisponible) {
		String msg="";
		if(cupoDisponible>20){
			TarjetaCredito tarjeracredito = tarjetacreditodao.pago(cupoDisponible);
			msg="PAGO HECHO";
		}else{
			msg="NO HAY DISPONIBLE";
		}
		return msg; 
	}
}
		
			
		
		


