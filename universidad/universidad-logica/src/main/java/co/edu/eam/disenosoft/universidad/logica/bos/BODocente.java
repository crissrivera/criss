package co.edu.eam.disenosoft.universidad.logica.bos;

import co.edu.eam.disenosoft.universidad.modelo.Docente;
import co.edu.eam.disenosoft.universidad.modelo.Estudiante;
import co.edu.eam.disenosoft.universidad.persistencia.dao.definiciones.IDAODocente;
import co.edu.eam.disenosoft.universidad.persistencia.dao.implementacion.jpa.DAODocenteJPA;

public class BODocente {

	private IDAODocente daoDOcente;
	
	public BODocente(){
		daoDOcente=new DAODocenteJPA();
	}
	
	public void crear(Docente docente) throws Exception{
		daoDOcente.crear(docente);
	}
	
	public void editar(Docente docente) throws Exception{
		daoDOcente.editar(docente);
	}
	
	public Docente buscar(String cedula) throws Exception{
		return daoDOcente.buscar(cedula);
	}
	
	public void eliminar(String cedula) throws Exception{
		daoDOcente.elimina(cedula);
	}
}
