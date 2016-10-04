/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.eam.disenosoft.universidad.persistencia.dao.definiciones;

import co.edu.eam.disenosoft.universidad.modelo.Evaluacion;
import co.edu.eam.disenosoft.universidad.modelo.Nota;
import co.edu.eam.disenosoft.universidad.modelo.RegistroCurso;
import java.util.List;

/**
 *
 * @author Cristian Sinisterra
 */
public interface IDAONota {
    /**
     * Crea una nota
     * @param nota, nota a ser creada
     * @throws Exception 
     */
    public void crear (Nota nota)throws Exception;
    
    /**
     * Edita una nota
     * @param nota, que se va editar
     * @throws Exception 
     */
    public void editar(Nota nota)throws Exception;
    
    /**
     * Lista las notas de la evaluacion
     * @param evaluacion, evaluacion que se le va mirar la nota
     * @return lista con todas las notas de la evaluacion
     * @throws Exception 
     */
    public List<Nota> listarNotasPorEvalucion(Evaluacion evaluacion)throws Exception;
    
    /**
     * lista las notas de un registroCurso y la evaluacion
     * @param curso, el curso
     * @param evaluacion, la evaluacion
     * @return la lista de notas
     * @throws Exception 
     */
    public Nota buscarPorCursoYEvaluacio(RegistroCurso curso, Evaluacion evaluacion) throws Exception;
    
    /**
     * lista las notas de un registro curso
     * @param curso, el registro curso
     * @return una lista de notas de un registro curso
     * @throws Exception 
     */
    public List<Nota> listarPorRegistroCurso(RegistroCurso curso) throws Exception;
    
    
    
}
