package co.edu.eam.disenosoft.universidad.vista.controlador;

import co.edu.eam.disenosoft.universidad.logica.bos.BOEstudiante;
import co.edu.eam.disenosoft.universidad.modelo.Estudiante;

public class ControladorAdminEstudiante {
	
	private BOEstudiante boEstudiante;
	
	
	public ControladorAdminEstudiante(){
		boEstudiante=new BOEstudiante();
	}
	
	public void crear(Estudiante estudiante) throws Exception{
		boEstudiante.crear(estudiante);
	}
	
	public Estudiante buscarEstudiante(String cedula) throws Exception{
		
		return boEstudiante.buscar(cedula);
	}
	
	public void editar(Estudiante estudiante) throws Exception{
		boEstudiante.editar(estudiante);
	}
	
}
