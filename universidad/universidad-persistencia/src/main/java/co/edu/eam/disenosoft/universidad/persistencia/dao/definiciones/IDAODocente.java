package co.edu.eam.disenosoft.universidad.persistencia.dao.definiciones;

import java.util.List;

import co.edu.eam.disenosoft.universidad.modelo.Docente;
/**
 * Esta interfaz tendra los metodos abstrato del CRUD Docente
 * @author Cristian Sinisterra
 *
 */
public interface IDAODocente {
	
	/**
     * Metodo para crear un docente
     * @param docente, docente a crear
     */
	public void crear(Docente docente)throws Exception;
	
	/**
     * Metodo para editar un docente
     * @param docente, docente a editar
     */
	public void editar(Docente docente)throws Exception;
	
	/**
     * Metodo para eliminar un docente
     * @param persona, persona a eliminar 
     */
	public void elimina(String cedula)throws Exception;
	
	/**
     * Metodo para buscar un docente
     * @param cedula, identificacion  del docente a buscar
     * @return 
     */
	public Docente buscar(String cedula)throws Exception;
	
	public List<Docente> listarTodo();
	
}
