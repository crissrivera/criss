/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.eam.disenosoft.universidad.persistencia.dao.definiciones;

import co.edu.eam.disenosoft.universidad.modelo.Evaluacion;
import java.util.List;

/**
 *
 * @author Cristian Sinisterra
 */
public interface IDAOEvalucion {
    
    /**
     * Crea una evaluacion
     * @param evaluacion
     * @throws Exception 
     */
    public void crear(Evaluacion evaluacion) throws Exception;
    
    /**
     * Edita una evaluacion
     * @param evaluacion, a editar
     * @throws Exception 
     */
    public void Editar(Evaluacion evaluacion) throws Exception; 
    
    /**
     * Busca una evaluacion por su nombre y por el codigo del curso
     * @param nombre, de la evalucion
     * @param codigo, coigo del curso
     * @return la evalucion 
     * @throws Exception 
     */
    public Evaluacion buscar(String nombre, String codigo) throws Exception;
    
    /**
     * Elimina una evalucion
     * @param evaluacion, que se va eliminar
     * @throws Exception 
     */
    public void eliminar(Evaluacion evaluacion) throws Exception;
    
    public List<Evaluacion> listarEvaluacionPorCurso(String codigo)throws Exception;
}
