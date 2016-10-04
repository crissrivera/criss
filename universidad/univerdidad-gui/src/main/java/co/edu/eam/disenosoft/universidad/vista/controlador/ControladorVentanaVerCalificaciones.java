/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.eam.disenosoft.universidad.vista.controlador;

import co.edu.eam.disenosoft.universidad.logica.bos.BOAsignatura;
import co.edu.eam.disenosoft.universidad.logica.bos.BOCurso;
import co.edu.eam.disenosoft.universidad.logica.bos.BOEvaluacion;
import co.edu.eam.disenosoft.universidad.logica.bos.BONota;
import co.edu.eam.disenosoft.universidad.logica.bos.BORegistrarCurso;
import co.edu.eam.disenosoft.universidad.modelo.Asignatura;
import co.edu.eam.disenosoft.universidad.modelo.Curso;
import co.edu.eam.disenosoft.universidad.modelo.Evaluacion;
import co.edu.eam.disenosoft.universidad.modelo.Nota;
import co.edu.eam.disenosoft.universidad.modelo.RegistroCurso;
import java.util.List;

/**
 *Esta clase controla la Ventana donde se ven las calificaciones
 * @author Cristian Sinisterra
 */
public class ControladorVentanaVerCalificaciones {
    public BOAsignatura boAsignatura;
    public BOCurso boCurso;
    public BORegistrarCurso boRegistro;
    public BONota boNota;
    private BOEvaluacion boEvaluacion;
    
    public ControladorVentanaVerCalificaciones(){
        boAsignatura = new BOAsignatura();
        boCurso = new BOCurso();
        boRegistro = new BORegistrarCurso();
        boNota = new BONota();
        boEvaluacion = new BOEvaluacion();
    }
    
    /**
     * Busca una asignatura
     * @param codigo, de la asignatura
     * @return una asignatura o null
     * @throws Exception 
     */
    public Asignatura buscarAsignatura(String codigo)throws Exception{
        return boAsignatura.buscar(codigo);
    }
    
    /**
     * Lista todos los cursos de una asignatura
     * @param asignatura, la asignatura
     * @return la lista de cursos de la asignatura
     * @throws Exception 
     */
    public List<Curso> listaCursoPorAsig(Asignatura asignatura)throws Exception{
        return boCurso.listarCursosPorAsignatura(asignatura.getCodigo());
    }
    
    /**
     * Busca un curso por su codigo
     * @param codigo, del curso a buscar
     * @return un curso o null
     * @throws Exception 
     */
    public Curso buscCurso(String codigo)throws Exception{
        return boCurso.buscarCurso(codigo);
        
    }
    
    /**
     * lista los registros curso por el curso
     * @param curso el curso
     * @return la lista de los registrosCurso del curso
     * @throws Exception 
     */
    public List<RegistroCurso> listarRegistroCursoPorCurso(Curso curso)throws Exception{
        return boRegistro.listarCursos(curso.getCodigo());
    }
            
    /**
     * lista las notas de un registroCurso
     * @param rC, el registro curso
     * @return una lista de notas del registroCurso
     * @throws Exception 
     */
    public List<Nota> listarPorRegistroCurso(RegistroCurso rC)throws Exception{
        return boNota.listarPorRegistroCurso(rC);
    }
    
    public Nota buscarNota(RegistroCurso rC, Evaluacion evaluacion) throws Exception{
        return boNota.buscar(rC, evaluacion);
    }
    
    /**
     * Lista las evaluciones de un curso
     * @param curso, el curso de las evaluciones
     * @return una lista de evalucion
     * @throws Exception 
     */
    public List<Evaluacion> listarEvaluacionPorCurso(Curso curso)throws Exception{
        return boEvaluacion.listarPorCurso(curso.getCodigo());
    }
    
    /**
     * Lista las notas de dicha evaluacion
     * @param evalucion, evaluacion
     * @return una lista de notas
     * @throws Exception 
     */
    public List<Nota> listarNotaPorEvalucion(Evaluacion evalucion)throws Exception{
        return boNota.listarPorEvaluacion(evalucion);
    }
}
