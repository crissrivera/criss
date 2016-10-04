package co.edu.eam.disenosoft.universidad.persistencia.dao.implementacion.jpa;

import javax.persistence.EntityManager;

import co.edu.eam.disenosoft.universidad.modelo.Asignatura;
import co.edu.eam.disenosoft.universidad.modelo.Docente;
import co.edu.eam.disenosoft.universidad.persistencia.dao.definiciones.IDAOAsignatura;
import co.edu.eam.disenosoft.universidad.persistencia.utilidades.AdministradorEntetyManager;
/**
 * Esta clas se encargara de darle solucion al DAO de asignatura 
 * forma JPA
 * @author Cristian Sinisterra
 *
 */

public class DAOAsignaturaJPA implements IDAOAsignatura{
	
	/*
	 * crear, este guarda una asignatura en la base de datos
	 */
	public void crear(Asignatura asignatura) throws Exception {
		EntityManager em= AdministradorEntetyManager.getEntityManager();
		em.getTransaction().begin();
		em.persist(asignatura);
		em.getTransaction().commit();
		
	}
	
	/*
	 * editar, este metodo edita una asignatura ya creada en la base de datos
	 */
	public void editar(Asignatura asignatura) throws Exception {
		// TODO Auto-generated method stub
		EntityManager em= AdministradorEntetyManager.getEntityManager();
		em.getTransaction().begin();
		em.merge(asignatura);
		em.getTransaction().commit();
		
	}
	/*
	 * buscar, este metodo encuentra una asignatura 
	 * ya guardada en al base de dato
	 * @param codigo, identificacion de la asignatura
	 */
	public Asignatura buscar(String codigo) throws Exception {
		EntityManager em= AdministradorEntetyManager.getEntityManager();
		return em.find(Asignatura.class, codigo);
	}
	
	/*
	 * eliminar, este metodo eliminara una asiganutraque que se desea 
	 * en la base de datos
	 * @param codigo, identificacion de la asignatura
	 */
	public void eliminar(String codigo) throws Exception {
		// TODO Auto-generated method stub
		EntityManager em= AdministradorEntetyManager.getEntityManager();
		em.getTransaction().begin();
		Asignatura e= buscar(codigo);
		if(e!= null){
		em.remove(e);
		}
		em.getTransaction().commit();
		
	}

}
