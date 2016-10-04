package co.edu.eam.disenosoft.universidad.persistencia.dao.definiciones;

import co.edu.eam.disenosoft.universidad.modelo.Asignatura;

public interface IDAOAsignatura {

	public void crear(Asignatura asignatura)throws Exception;
	
	public void editar(Asignatura asignatura)throws Exception;
	
	public Asignatura buscar(String codigo)throws Exception;
	
	public void eliminar(String codigo)throws Exception;
	
}
