package co.edu.eam.disenosoft.universidad.vista.controlador;

import java.util.List;

import co.edu.eam.disenosoft.universidad.logica.bos.BOAsignatura;
import co.edu.eam.disenosoft.universidad.logica.bos.BOCurso;
import co.edu.eam.disenosoft.universidad.logica.bos.BOEstudiante;
import co.edu.eam.disenosoft.universidad.logica.bos.BORegistrarCurso;
import co.edu.eam.disenosoft.universidad.modelo.Asignatura;
import co.edu.eam.disenosoft.universidad.modelo.Curso;
import co.edu.eam.disenosoft.universidad.modelo.Estudiante;

public class ControladorVentanaRegistrarCurso {
	private BOAsignatura boAsignatura;
    private BOEstudiante boEstudiante;
    private BOCurso boCurso;
    private BORegistrarCurso boRegistro;
    
    
    public ControladorVentanaRegistrarCurso(){
        boRegistro = new BORegistrarCurso();
        boAsignatura = new BOAsignatura();
        boEstudiante = new BOEstudiante();
        boCurso = new BOCurso();
    }
    
    /**
     * busca un estudiante por su cedula    
     * @param cedula, cedula del estudiante a buscar
     * @return un estudiante o null si no funciona
     */
    public Estudiante buscarEstudiante(String cedula) throws Exception{
        return boEstudiante.buscar(cedula);
    }
    
    /**
     * busca una asignatura por su código
     * @param codigo, código de la asignatura a buscar
     * @return una asignatura o null si no se encuentra
     */
    public Asignatura buscarAsignatura(String codigo) throws Exception{
        return boAsignatura.buscar(codigo);
    }
    
    /**
     * Calcula la cantidad  de creditos registrados por el estudiante
     * @param estudiante, cedula del estudiante que se le calculan los creditos
     * @return la cantidad de creditos registrados
     * @throws PersistenciaException 
     */
    public List<Long> creditosDelEstudiante(Estudiante estudiante) throws Exception{
        return boRegistro.calcularCreditos(estudiante);
    }
    
    public List<Curso> listarCursosPorAsignatura(Asignatura asignatura) throws Exception{
        return boCurso.listarCursosPorAsignatura(asignatura.getCodigo());
    }
    
    public Curso buscarCurso(String codigo) throws Exception{
    	return boCurso.buscarCurso(codigo);
    }
    
    public void crearCurso(Curso curso, Estudiante estudiante) throws Exception{
    	boRegistro.CrearCurso(curso, estudiante);
    	
    }
}
