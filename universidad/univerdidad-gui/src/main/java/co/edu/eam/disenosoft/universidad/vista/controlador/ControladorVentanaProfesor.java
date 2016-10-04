package co.edu.eam.disenosoft.universidad.vista.controlador;

import co.edu.eam.disenosoft.universidad.logica.bos.BODocente;
import co.edu.eam.disenosoft.universidad.modelo.Docente;


public class ControladorVentanaProfesor {
 private BODocente boDOcente;
 
 public ControladorVentanaProfesor(){
	 boDOcente= new BODocente();
 }
 
 public void crear(Docente docente) throws Exception{
	 boDOcente.crear(docente);
	}
	
	public Docente buscarDocente(String cedula) throws Exception{
		
		return boDOcente.buscar(cedula);
	}
	
	public void editar(Docente docente) throws Exception{
		boDOcente.editar(docente);
	}
	
	public void eliminar(String cedula) throws Exception{
		boDOcente.eliminar(cedula);
	}
}
