package co.edu.eam.disenosoft.universidad.logica.bos;

import co.edu.eam.disenosoft.universidad.modelo.Estudiante;
import co.edu.eam.disenosoft.universidad.persistencia.dao.definiciones.IDAOEstudiante;
import co.edu.eam.disenosoft.universidad.persistencia.dao.implementacion.jpa.DAOEstudianteJPA;

public class BOEstudiante {

	private IDAOEstudiante daoEstudiante;
	
	public BOEstudiante(){
		daoEstudiante=new DAOEstudianteJPA();
	}
	
	public void crear(Estudiante estudiante) throws Exception{
		daoEstudiante.crear(estudiante);
	}
	
	public void editar(Estudiante estudiante) throws Exception{
		daoEstudiante.editar(estudiante);
	}
	
	public Estudiante buscar(String cedula) throws Exception{
		return daoEstudiante.buscar(cedula);
	}
}
