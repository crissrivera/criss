/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.eam.disenosoft.universidad.persistencia.dao.implementacion.jpa;

import co.edu.eam.disenosoft.universidad.modelo.Evaluacion;
import co.edu.eam.disenosoft.universidad.modelo.Nota;
import co.edu.eam.disenosoft.universidad.modelo.RegistroCurso;
import co.edu.eam.disenosoft.universidad.persistencia.dao.definiciones.IDAONota;
import co.edu.eam.disenosoft.universidad.persistencia.utilidades.AdministradorEntetyManager;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Cristian Sinisterra
 */
public class DAONota implements IDAONota{

    public void crear(Nota nota) throws Exception {
        EntityManager em= AdministradorEntetyManager.getEntityManager();
        em.getTransaction().begin();
        em.persist(nota);
         em.getTransaction().commit();
    }

    public void editar(Nota nota) throws Exception {
        EntityManager em= AdministradorEntetyManager.getEntityManager();
        em.getTransaction().begin();
        em.merge(nota);
         em.getTransaction().commit();
    }

    public List<Nota> listarNotasPorEvalucion(Evaluacion evaluacion) throws Exception {
        EntityManager em= AdministradorEntetyManager.getEntityManager();
        Query query= em.createNamedQuery(Nota.CONSULTA_POR_EVAL);
        query.setParameter(1, evaluacion);
        return query.getResultList();
    }

    public Nota buscarPorCursoYEvaluacio(RegistroCurso curso, Evaluacion evaluacion) throws Exception {
          EntityManager em= AdministradorEntetyManager.getEntityManager();
          Query query = em.createNamedQuery(Nota.CONSULTA_POR_REGCUR_EVAL);
          query.setParameter(1, curso);
        query.setParameter(2, evaluacion);
        List<Nota> lista = query.getResultList();
        for (int i = 0; i < lista.size(); i++) {
            return lista.get(i);
        }
        return null;
    }

    public List<Nota> listarPorRegistroCurso(RegistroCurso curso) throws Exception {
        EntityManager em= AdministradorEntetyManager.getEntityManager();
        Query query=em.createNamedQuery(Nota.CONSULTA_POR_REGISTROCURSO);
        query.setParameter("curso", curso);
        return query.getResultList();
    }
    
}
