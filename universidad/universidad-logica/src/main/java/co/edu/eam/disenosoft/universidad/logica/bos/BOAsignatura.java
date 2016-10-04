package co.edu.eam.disenosoft.universidad.logica.bos;

import co.edu.eam.disenosoft.universidad.modelo.Asignatura;
import co.edu.eam.disenosoft.universidad.persistencia.dao.definiciones.IDAOAsignatura;
import co.edu.eam.disenosoft.universidad.persistencia.dao.implementacion.jpa.DAOAsignaturaJPA;

public class BOAsignatura {

	IDAOAsignatura daoAsignatura;
	
	public BOAsignatura(){
		daoAsignatura=new DAOAsignaturaJPA();
	}
	public void crear(Asignatura asignatura)throws Exception{
		daoAsignatura.crear(asignatura);
	}
	
	public void editar(Asignatura asignatura)throws Exception{
		daoAsignatura.editar(asignatura);
	}
	
	public Asignatura buscar(String codigo)throws Exception{
		return daoAsignatura.buscar(codigo);
	}
	
	public void eliminar(String codigo)throws Exception{
		daoAsignatura.eliminar(codigo);
	}
}
