package co.edu.eam.disenosoft.universidad.vista.controlador;

import co.edu.eam.disenosoft.universidad.logica.bos.BOAsignatura;
import co.edu.eam.disenosoft.universidad.modelo.Asignatura;

public class ControladorVentanaAsignatura {
	
	private BOAsignatura boAsignatura;
	
	public ControladorVentanaAsignatura(){
		boAsignatura=new BOAsignatura();
	}
	
	public void crear(Asignatura asignatura)throws Exception{
		boAsignatura.crear(asignatura);
	}
	
	public void editar(Asignatura asignatura)throws Exception{
		boAsignatura.editar(asignatura);
	}
	
	public Asignatura buscar(String codigo)throws Exception{
		return boAsignatura.buscar(codigo);
	}
	
	public void eliminar(String codigo)throws Exception{
		boAsignatura.eliminar(codigo);
	}
}
