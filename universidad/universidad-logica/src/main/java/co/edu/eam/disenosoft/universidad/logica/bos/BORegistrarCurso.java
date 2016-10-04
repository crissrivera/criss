package co.edu.eam.disenosoft.universidad.logica.bos;

import java.util.List;

import co.edu.eam.disenosoft.universidad.logica.Excepcion.ExcepcionNegocio;
import co.edu.eam.disenosoft.universidad.modelo.Curso;
import co.edu.eam.disenosoft.universidad.modelo.Estudiante;
import co.edu.eam.disenosoft.universidad.modelo.Nota;
import co.edu.eam.disenosoft.universidad.modelo.RegistroCurso;
import co.edu.eam.disenosoft.universidad.persistencia.dao.definiciones.IDAOCurso;
import co.edu.eam.disenosoft.universidad.persistencia.dao.definiciones.IDAONota;
import co.edu.eam.disenosoft.universidad.persistencia.dao.definiciones.IDAORegistroCurso;
import co.edu.eam.disenosoft.universidad.persistencia.dao.implementacion.jpa.DAOCursoJPA;
import co.edu.eam.disenosoft.universidad.persistencia.dao.implementacion.jpa.DAONota;
import co.edu.eam.disenosoft.universidad.persistencia.dao.implementacion.jpa.DAORegistroCurso;

public class BORegistrarCurso {
	private IDAORegistroCurso boRegistrarCurso;
	private IDAOCurso boCurso;
        private IDAONota boNota;

	public BORegistrarCurso() {
                boNota= new DAONota();
		boRegistrarCurso = new DAORegistroCurso();
		boCurso = new DAOCursoJPA();
	}

	public List<RegistroCurso> listarPorEstudiante(String cedula) throws Exception {
		return boRegistrarCurso.listartodoslosregistrodecursoEstu(cedula);
	}

	public List<Long> calcularCreditos(Estudiante estudiante) throws Exception{
		
		List<Long> credito = boRegistrarCurso.calcularCreditos(estudiante);
		if(credito.get(0)!=null){
                    return credito;
                }else{
                    credito.add(0, Long.parseLong(Integer.toString(0)));
                    return credito;
                }
	}
	
	/**
	 * Crear curso
	 * @param curso en el que se va registrar el estudian
	 * @param estudiante, estudiante que se va registrar
	 * @throws Exception
	 */
	public void CrearCurso(Curso curso, Estudiante estudiante) throws Exception {
		
		if (calcularCreditos(estudiante).get(0)+curso.getAsignatura().getNumeroCreditos()>12) {
			
			throw new ExcepcionNegocio("El estudiante solo puede registrar " + "un maximo de 12 creditos");
		}
		
		if (boCurso.buscarCurso(curso.getCodigo()).getEstudiantes().size() >= 10) {
			
			throw new ExcepcionNegocio("El curso alcanzo su capacidad maxima de estudiante");
		}

		List<RegistroCurso> lista = listarPorEstudiante(estudiante.getCedula());
		for (RegistroCurso rC : lista) {
			if ((rC.getCurso().getAsignatura().getCodigo()).equals(curso.getAsignatura().getCodigo())) {
				
				throw new ExcepcionNegocio("El estudiante ya tiene registrada esta asiganuta" + " en otro curso");
				
			}
		}
		
		RegistroCurso registrarCurso = new RegistroCurso();
		registrarCurso.setCurso(curso);
		registrarCurso.setEstudiante(estudiante);
		boRegistrarCurso.crear(registrarCurso);
		
	}
        
        /**
         * Logica para listar todos los estudiante que tiene un curso
         * @param codigo, codigo del curso en el cual se van a listar los estudiante
         * que tengan
         * @return lista de los estudiantes registrados en el curso
         * @throws Exception 
         */
        public List<RegistroCurso>listartodoslosregistrodecursoEstu(String codigo)throws  Exception{
            return boRegistrarCurso.listartodoslosregistrodecursoEstu(codigo);
        }
        
     /**
     * logica para buscar un registroCurso por el curso y por el estudiante
     * @param c, el curso del registro curso
     * @param e, estudiante del registro curso
     * @return un registro curso o null
     * @throws Exception 
     */
    public RegistroCurso buscar(Curso curso, Estudiante estudiante) throws Exception{
        return boRegistrarCurso.buscar(curso, estudiante);
    }
    
    public void Eliminar(RegistroCurso rc)throws Exception{
        List<Nota> notas=boNota.listarPorRegistroCurso(rc);
       if(notas.isEmpty()){
           boRegistrarCurso.eliminar(rc);
       } else{
          throw new ExcepcionNegocio("No se puede eliminar el registro del curso"
                   + " por que ya tiene una nota");
       }
    }
    
    public List<RegistroCurso>listarCursos(String codigo)throws Exception{
        return boRegistrarCurso.listarCursos(codigo);
    }
}
