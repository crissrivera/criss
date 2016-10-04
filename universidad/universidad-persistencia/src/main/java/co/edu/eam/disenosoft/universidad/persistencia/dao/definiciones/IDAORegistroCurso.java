package co.edu.eam.disenosoft.universidad.persistencia.dao.definiciones;

import co.edu.eam.disenosoft.universidad.modelo.Curso;
import co.edu.eam.disenosoft.universidad.modelo.Estudiante;
import java.util.List;

import co.edu.eam.disenosoft.universidad.modelo.RegistroCurso;

public interface IDAORegistroCurso {

public List<RegistroCurso> listarCursos(String codigo)throws Exception;
    
/**
 * lista todos los registros curso de un estudiante
 * @param cedula, cedula del estudiante
 * @return una lista de registros cursos de un estudiante
 */
 public List<RegistroCurso> listartodoslosregistrodecursoEstu(String cedula)throws Exception;
 
 /**
  * crea un registro curso
  * @param curso, el registroCurso, el curso con sus estudiantes
  * @throws PersistenciaException 
  */
     public void crear(RegistroCurso curso)throws Exception;
 
    public List<Long> calcularCreditos(Estudiante estudiante)throws  Exception;
    
    /**
     * elimina un registro curso
     * @param curso, el registro curso a eliminar
     * @throws Exception 
     */
    public void eliminar(RegistroCurso curso) throws Exception;
    
    /**
     * busca un registro curso por su curso y su estudiante
     * @param curso, el curso del registro curso
     * @param estudiante, el estudiante del registro curso
     * @return un registro curso o null
     * @throws Exception 
     */
    public RegistroCurso buscar(Curso curso, Estudiante estudiante) throws Exception;
}
