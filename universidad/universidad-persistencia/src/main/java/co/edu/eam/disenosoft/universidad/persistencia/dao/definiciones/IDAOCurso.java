package co.edu.eam.disenosoft.universidad.persistencia.dao.definiciones;

import java.util.List;

import co.edu.eam.disenosoft.universidad.modelo.Asignatura;
import co.edu.eam.disenosoft.universidad.modelo.Curso;
import co.edu.eam.disenosoft.universidad.modelo.Docente;
import co.edu.eam.disenosoft.universidad.modelo.Estudiante;
import co.edu.eam.disenosoft.universidad.modelo.Profesion;
import co.edu.eam.disenosoft.universidad.modelo.RegistroCurso;

public interface IDAOCurso {
	
	public Asignatura buscarAsignatura(String codigo)throws Exception;
	
	public Docente buscarDocente(String cedula)throws Exception;
	
	public Estudiante buscarEstudiante(String cedula)throws Exception;
	
	public void crearCurso(Curso curso)throws Exception;
	
        public Curso buscarCurso(String codigo)throws Exception;
    
      public List<Curso> ListarCursoPorAsignatura(String codigo) throws Exception;
    
      /**
     * busca un curso por el codigo asignatura y la cedula del docente
     * @param cod, código de la asignatura del curso
     * @param ced, cedula del docente del curso
     * @return un curso o null
     * @throws Exception 
     */
    //public Curso buscarCursoPorAsignaturaDocente(String codigo, String cedula) throws Exception;
      
      public List<Curso> listarCursoPorDocente(String cedula)throws Exception;
}
