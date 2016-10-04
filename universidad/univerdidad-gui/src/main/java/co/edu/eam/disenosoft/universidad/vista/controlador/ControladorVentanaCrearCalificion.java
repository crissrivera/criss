/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.eam.disenosoft.universidad.vista.controlador;

import co.edu.eam.disenosoft.universidad.logica.bos.BOAsignatura;
import co.edu.eam.disenosoft.universidad.logica.bos.BOCurso;
import co.edu.eam.disenosoft.universidad.logica.bos.BOEvaluacion;
import co.edu.eam.disenosoft.universidad.modelo.Asignatura;
import co.edu.eam.disenosoft.universidad.modelo.Curso;
import co.edu.eam.disenosoft.universidad.modelo.Evaluacion;
import java.util.List;

/**
 *
 * @author Cristian Sinisterra
 */
public class ControladorVentanaCrearCalificion {
     public BOEvaluacion boEvaluacion;
    public BOAsignatura boAsignatura;
    public BOCurso boCurso;
    
    public ControladorVentanaCrearCalificion(){
        boEvaluacion = new BOEvaluacion();
        boAsignatura = new BOAsignatura();
        boCurso = new BOCurso();
    }
    
    /**
     * Crear una evaluacion 
     * @param curso
     * @param nombre
     * @param porcentaje
     * @throws Exception 
     */
    public void crearEval(Curso curso, String nombre, double porcentaje)throws Exception{
       Evaluacion evaluacion = new Evaluacion(curso, nombre, porcentaje);
       boEvaluacion.CrearEvalucion(evaluacion);
       
    }
    /**
     * Buscar una asignatura
     * @param codigo, de la asiganatura 
     * @return una asigantura
     * @throws Exception 
     */
    public Asignatura buscarAsignatura(String codigo)throws Exception{
        return boAsignatura.buscar(codigo);
    }
    
    public List<Curso> listarCursosPorAsig(Asignatura asignatura) throws Exception{
        return boCurso.listarCursosPorAsignatura(asignatura.getCodigo());
    }
    
    /**
     * calcula el porsentaje de evaluaciones del curso
     * @param curso, el curso
     * @return el porcentaje de evaluaciones del curso
     * @throws Exception
     */
    public double calcularPorcentaje(Curso curso) throws Exception{
        return boEvaluacion.calcularPorcentaje(curso.getCodigo());
    }
    
    /**
     * lista las evaluaciones por curso
     * @param curso, el curso
     * @return la lista de las evaluaciones del curso
     * @throws Exception 
     */
    public List<Evaluacion> listarPorCurso(Curso curso) throws Exception{
        return boEvaluacion.listarPorCurso(curso.getCodigo());
    }
    
    /**
     * elimina una evaluacion
     * @param evaluacion, la evaluacion a eliminar
     * @throws Exception
     
     */
    public void eliminarEval(Evaluacion evaluacion) throws Exception{
        boEvaluacion.eliminar(evaluacion);
    }
}
