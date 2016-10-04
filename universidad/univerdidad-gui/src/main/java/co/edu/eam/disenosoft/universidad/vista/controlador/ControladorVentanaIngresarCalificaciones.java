/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.eam.disenosoft.universidad.vista.controlador;

import co.edu.eam.disenosoft.universidad.logica.bos.BOCurso;
import co.edu.eam.disenosoft.universidad.logica.bos.BODocente;
import co.edu.eam.disenosoft.universidad.logica.bos.BOEstudiante;
import co.edu.eam.disenosoft.universidad.logica.bos.BOEvaluacion;
import co.edu.eam.disenosoft.universidad.logica.bos.BONota;
import co.edu.eam.disenosoft.universidad.logica.bos.BORegistrarCurso;
import co.edu.eam.disenosoft.universidad.modelo.Curso;
import co.edu.eam.disenosoft.universidad.modelo.Docente;
import co.edu.eam.disenosoft.universidad.modelo.Estudiante;
import co.edu.eam.disenosoft.universidad.modelo.Evaluacion;
import co.edu.eam.disenosoft.universidad.modelo.Nota;
import co.edu.eam.disenosoft.universidad.modelo.RegistroCurso;
import java.util.List;

/**
 *
 * @author Cristian Sinisterra
 */
public class ControladorVentanaIngresarCalificaciones {
    private BONota boNota;
    private BODocente boDocente;
    private BOCurso boCurso;
    private BOEvaluacion boEvaluacion;
    private BORegistrarCurso boRegistro;
    private BOEstudiante boEstudiante;
    
    public ControladorVentanaIngresarCalificaciones(){
        boNota= new BONota();
        boDocente= new BODocente();
        boCurso= new BOCurso();
        boEvaluacion= new BOEvaluacion();
        boRegistro= new BORegistrarCurso();
        boEstudiante= new BOEstudiante();
        
    }
    
    /**
     * Busca un docente
     * @param cedula, del estudiante a buscar
     * @return un estudiante o null
     * @throws Exception 
     */
    public Docente buscDocente(String cedula)throws Exception{
        return boDocente.buscar(cedula);
    }
    
    public List<Curso> listarCursoPorDocente(Docente docente)throws Exception{
        return boCurso.listaCursoPorDocente(docente.getCedula());
    }
    /**
     * Lista todas las evaluaciones del curso
     * @param curso, 
     * @return una lista de evaluciones de curso
     * @throws Exception 
     */
    public List<Evaluacion> listaEvaluacionPorCurso(Curso curso)throws Exception{
        return boEvaluacion.listarPorCurso(curso.getCodigo());
    }
    
    /**
     * Lita todos los registroCurso de un curso
     * @param curso, el curso
     * @return una lista de registroCurso del curso
     * @throws Exception 
     */
    public List<RegistroCurso>listaRegistroCursoPorCurso(Curso curso)throws Exception{
        return boRegistro.listartodoslosregistrodecursoEstu(curso.getCodigo());
    }
    
    /**
     * Busca una nota por el registro curso y por la evalucion
     * @param rC, el registro curso
     * @param evalucion, la evaluacion
     * @return una nota o null
     * @throws Exception 
     */
    public Nota buscarNotaPorRegCurEval(RegistroCurso rC, Evaluacion evalucion) throws Exception{
        return boNota.buscar(rC, evalucion);
    }
    
    public Curso buscarCurso(String codigo) throws Exception{
        return boCurso.buscarCurso(codigo);
    }
    
    /**
     * Busca una evaluacion por su nombre y el codigo del curso
     * @param nombre, nombre de la evaluacion
     * @param codigo, codigo del curso de la evaluacion
     * @return una evaluacion o null
     * @throws Exception 
     */
    public Evaluacion buscarEval(String nombre, String codigo)throws Exception{
        return boEvaluacion.buscarEvalucion(nombre, codigo);
    }
    
    /**
     * Crear una nota con sus atributos
     * @param rc, un registro curso para la nota
     * @param valor, un valor para la nota
     * @param evaluacion, una evaluacion para la nota
     * @throws Exception 
     */
    public void crearNota(RegistroCurso rc, double  valor, Evaluacion evaluacion)throws Exception{
        Nota nota= new Nota();
        nota.setRegistroCurso(rc);
        nota.setEvaluacion(evaluacion);
        nota.setValor(valor);
        boNota.crearNota(nota);
        
    }
    
    /**
     * Buscar un estudiante por su cedula
     * @param cedula, del estudian
     * @return un estudiante o null
     * @throws Exception 
     */
    public Estudiante buscarEstudiante(String cedula)throws Exception{
        return boEstudiante.buscar(cedula);
    }
    
    /**
     * Busca un RegistroCuros por su curso y estudiante
     * @param curso, curso del registro curso
     * @param estudiante, estudiante del registro curso
     * @return un registroCurso
     * @throws Exception 
     */
    public RegistroCurso buscarRegistroCurso(Curso curso, Estudiante estudiante)throws Exception{
        return boRegistro.buscar(curso, estudiante);
    }
}
