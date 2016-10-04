package co.edu.eam.disenosoft.universidad.logica.bos;

import java.util.List;

import co.edu.eam.disenosoft.universidad.modelo.Asignatura;
import co.edu.eam.disenosoft.universidad.modelo.Curso;
import co.edu.eam.disenosoft.universidad.modelo.Docente;
import co.edu.eam.disenosoft.universidad.modelo.Estudiante;
import co.edu.eam.disenosoft.universidad.persistencia.dao.definiciones.IDAOCurso;
import co.edu.eam.disenosoft.universidad.persistencia.dao.implementacion.jpa.DAOCursoJPA;

public class BOCurso {
	IDAOCurso daoCurso;
	 
	
	public BOCurso(){
		daoCurso= new DAOCursoJPA();
	}
	
	public Asignatura buscarAsignatura(String codigo)throws Exception{
		return daoCurso.buscarAsignatura(codigo);
	}
	
	public Docente buscarDocente(String cedula)throws Exception{
		return daoCurso.buscarDocente(cedula);
	}
	
	public Estudiante buscarEstudiante(String cedula)throws Exception{
		return daoCurso.buscarEstudiante(cedula);
	}
	
	public void crearCurso(Curso curso)throws Exception{
		daoCurso.crearCurso(curso);
	}
	
	public Curso buscarCurso(String codigo)throws Exception{
		return daoCurso.buscarCurso(codigo);
	}
	
	public List<Curso> listarCursosPorAsignatura(String codigo) throws Exception{
        return daoCurso.ListarCursoPorAsignatura(codigo);
    }
        
        /**
     * logica para buscar el curso por su asignatura y su docente
     *
     * @param codigo, código de la asignatura
     * @param cedula, cedula del docente
     * @return un curso o null
     * @throws Exception
     * */
	/**
        public Curso buscarCursoPorAsignaturaDocente(String codigo, String cedula)throws Exception{
            return daoCurso.buscarCursoPorAsignaturaDocente(codigo, cedula);
        }
        */
        
        public List<Curso> listaCursoPorDocente(String cedula)throws Exception{
            return daoCurso.listarCursoPorDocente(cedula);
        }
}
