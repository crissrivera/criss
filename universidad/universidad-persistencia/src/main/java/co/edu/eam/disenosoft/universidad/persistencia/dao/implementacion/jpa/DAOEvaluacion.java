/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.eam.disenosoft.universidad.persistencia.dao.implementacion.jpa;

import co.edu.eam.disenosoft.universidad.modelo.Evaluacion;
import co.edu.eam.disenosoft.universidad.persistencia.dao.definiciones.IDAOEvalucion;
import co.edu.eam.disenosoft.universidad.persistencia.utilidades.AdministradorEntetyManager;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Cristian Sinisterra
 */
public class DAOEvaluacion implements IDAOEvalucion{

    public void crear(Evaluacion evaluacion) throws Exception {
        EntityManager em= AdministradorEntetyManager.getEntityManager();
		em.getTransaction().begin();
		em.persist(evaluacion);
		em.getTransaction().commit();
    }

    public void Editar(Evaluacion evaluacion) throws Exception {
        EntityManager em= AdministradorEntetyManager.getEntityManager();
		em.getTransaction().begin();
		em.merge(evaluacion);
		em.getTransaction().commit();
    }

    public Evaluacion buscar(String nombre, String codigo) throws Exception {
        EntityManager em= AdministradorEntetyManager.getEntityManager();
        Query query = em.createNamedQuery(Evaluacion.CONSULTA_POR_NOM_CURSO);
        query.setParameter(1, nombre);
        query.setParameter(2, codigo);
        List<Evaluacion> lista = query.getResultList();
        for (int i = 0; i < lista.size(); i++) {
            return lista.get(i);
        }
        return null;
    
    }

    public void eliminar(Evaluacion evaluacion) throws Exception {
        EntityManager em= AdministradorEntetyManager.getEntityManager();
		em.getTransaction().begin();
		em.remove(evaluacion);
		em.getTransaction().commit();
    }

    public List<Evaluacion> listarEvaluacionPorCurso(String codigo) throws Exception {
       EntityManager em= AdministradorEntetyManager.getEntityManager();
       Query query = em.createNamedQuery(Evaluacion.CONSULTA_POR_CODIGO);
       query.setParameter(1, codigo);
        return query.getResultList();
    }
    
}
