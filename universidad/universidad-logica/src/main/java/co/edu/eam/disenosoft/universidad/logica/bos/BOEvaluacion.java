/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.eam.disenosoft.universidad.logica.bos;

import co.edu.eam.disenosoft.universidad.logica.Excepcion.ExcepcionNegocio;
import co.edu.eam.disenosoft.universidad.modelo.Evaluacion;
import co.edu.eam.disenosoft.universidad.modelo.Nota;
import co.edu.eam.disenosoft.universidad.persistencia.dao.definiciones.IDAOEvalucion;
import co.edu.eam.disenosoft.universidad.persistencia.dao.definiciones.IDAONota;
import co.edu.eam.disenosoft.universidad.persistencia.dao.implementacion.jpa.DAOEvaluacion;
import co.edu.eam.disenosoft.universidad.persistencia.dao.implementacion.jpa.DAONota;
import java.util.List;

/**
 *
 * @author Cristian Sinisterra
 */
public class BOEvaluacion {
    private IDAONota daoNota;
    private IDAOEvalucion daoEvaluacion;
    
    public BOEvaluacion(){
    daoEvaluacion= new DAOEvaluacion();
    daoNota =new DAONota();
}
    /**
     * Logica para listar las evaluciones por curso
     * @param codigo, del curso
     * @return la lista de evaluaciones que tiene ese curso
     * @throws Exception 
     */
    public List<Evaluacion> listarPorCurso(String codigo)throws Exception{
        return daoEvaluacion.listarEvaluacionPorCurso(codigo);
    }
    
    /**
     * Cacula el porcentaje de evaluciones del curso
     * @param codigo, codigo del curso
     * @return el porcentaje de evaluciones del curso
     * @throws Exception 
     */
    public double calcularPorcentaje(String codigo)throws Exception{
        double porcentaje=0;
        List<Evaluacion> lista= listarPorCurso(codigo);
        for (Evaluacion eval : lista) {
            porcentaje = porcentaje + eval.getPorcentaje();
        }
        return porcentaje;
    }
    
    /**
     * Logica para buscar una evalucion por su nombre y el codigo
     * @param nombre, de la evalucion
     * @param codigo, codigo del curso de la evalucion
     * @return
     * @throws Exception 
     */
    public Evaluacion buscarEvalucion(String nombre, String codigo)throws Exception{
        return daoEvaluacion.buscar(nombre, codigo);
    }
    
    public void eliminar(Evaluacion evaluacion)throws Exception{
        List<Nota> notas=daoNota.listarNotasPorEvalucion(evaluacion);
        if(notas.isEmpty()){
            daoEvaluacion.eliminar(evaluacion);
        }else{
            throw new ExcepcionNegocio("No se puede eliminar la evalucion por que"
                    + " el estudiante ya tiene notas");
        }
    }
    
    /**
     * Logica para crear evaluacion
     * @param evaluacion, evalucion que sera creada
     * @throws Exception 
     */
    public void CrearEvalucion(Evaluacion evaluacion)throws Exception{
        if(calcularPorcentaje(evaluacion.getCurso().getCodigo())==100){
            throw new ExcepcionNegocio("El curso ya tiene el 100% de las evaluaciones permitidas");
        }if(calcularPorcentaje(evaluacion.getCurso().getCodigo())+ 
                evaluacion.getPorcentaje()>100){
            throw new ExcepcionNegocio("El curso no puede superar el 100% de las evalucoones");
        }if(buscarEvalucion(evaluacion.getNombre(), evaluacion.getCurso().getCodigo()) != null) {
            throw new ExcepcionNegocio("Ya hay una evaluación para ese curso "
                    + "con el mismo nombre");
        }
        daoEvaluacion.crear(evaluacion);
    }
}
