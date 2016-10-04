package co.edu.eam.disenosoft.universidad.persistencia.dao.definiciones;

import java.util.List;

import co.edu.eam.disenosoft.universidad.modelo.Docente;
import co.edu.eam.disenosoft.universidad.modelo.Estudiante;

/**
 * Esta interfaz tendra los metodos abstrato del CRUD Estudiante
 * @author Cristian Sinisterra
 *
 */
public interface IDAOEstudiante {
	
	
	/**
     * Metodo para crear un estudiante
     * @param estudiante, estudiante a crear
     * @throws Exception, captura las exception
     */
	
	
	public void crear(Estudiante estudiante)throws Exception;
	
	/**
     * Metodo para editar un estudiante
     * @param estudiante, estudiante a editar
     */
	public void editar(Estudiante estudiante) throws Exception;

	/**
     * Metodo para eliminar un estudiante
     * @param cedula, identificacion del estudiante a eliminar
     */
	public void eliminar(String cedula)throws Exception;
	
	/**
     * Metodo para editar un docente
     * @param cedula, del docente que se desea buscar
     * return estudiante
     */
	public Estudiante buscar(String cedula) throws Exception;
	
	
	public List<Estudiante> listarTodo();
}
