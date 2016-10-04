/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.eam.disenosoft.universidad.logica.bos;

import co.edu.eam.disenosoft.universidad.logica.Excepcion.ExcepcionNegocio;
import co.edu.eam.disenosoft.universidad.modelo.Evaluacion;
import co.edu.eam.disenosoft.universidad.modelo.Nota;
import co.edu.eam.disenosoft.universidad.modelo.RegistroCurso;
import co.edu.eam.disenosoft.universidad.persistencia.dao.definiciones.IDAONota;
import co.edu.eam.disenosoft.universidad.persistencia.dao.implementacion.jpa.DAONota;
import java.util.List;

/**
 *
 * @author Cristian Sinisterra
 */
public class BONota {
    private IDAONota dAONota;
    
    public BONota(){
        dAONota= new DAONota();
    }
    
   /**
     * logica para crear una nota
     *
     * @param nota, la nota a ser creada
     * @throws Exception
     * 
     */
    public void crearNota(Nota nota) throws Exception {
        Nota n = buscar(nota.getRegistroCurso(), nota.getEvaluacion());
        if (n == null) {
            dAONota.crear(nota);
        } else {
            if (n.isEditada() == true) {
                throw new ExcepcionNegocio("La nota no puede ser editada otra vez");
            }
            n.setEditada(true);
            n.setValor(nota.getValor());
            dAONota.editar(n);
        }

    }

    /**
     * logica para listar las notas de la evaluacion
     *
     * @param eval, la evaluacion
     * @return una lista de notas
     * @throws Exception
     */
    public List<Nota> listarPorEvaluacion(Evaluacion eval) throws Exception {
        return dAONota.listarNotasPorEvalucion(eval);
    }

    /**
     * logica para buscar una nota por un registroCurso y por una evaluación
     *
     * @param rc, el registro curso
     * @param e, la evaluación
     * @return una nota o null
     * @throws PersistenciaException
     */
    public Nota buscar(RegistroCurso rc, Evaluacion e) throws Exception {
        return dAONota.buscarPorCursoYEvaluacio(rc, e);
    }
    
    /**
     * logica para listar las notas de un registroCurso 
     * @param rc, el registro curso
     * @return una lista de notas del registroCurso
     * @throws PersistenciaException 
     */
    public List<Nota> listarPorRegistroCurso(RegistroCurso rc) throws Exception{
        return dAONota.listarPorRegistroCurso(rc);
    }
}
