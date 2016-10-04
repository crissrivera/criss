package co.edu.eam.disenosoft.universidad.persistencia.dao.definiciones;

import java.util.List;

import co.edu.eam.disenosoft.universidad.modelo.Profesion;
/**
 * Esta interfaz tendra el metodo abstrato de listar profesion
 * @author Cristian Sinisterra
 *
 */
public interface IDAOProfesion {

	/**
	 * listarDocente lista las profesiones de un docente
	 * @return la lista de las profesiones
	 * @throws Exception
	 */
	public List<Profesion> listarDocente()throws Exception;
}
