package co.edu.eam.disenosoft.universidad.persistencia.dao.implementacion.jpa;

import java.util.List;

import javax.persistence.EntityManager;

import co.edu.eam.disenosoft.universidad.modelo.Docente;
import co.edu.eam.disenosoft.universidad.modelo.Estudiante;
import co.edu.eam.disenosoft.universidad.persistencia.dao.definiciones.IDAODocente;
import co.edu.eam.disenosoft.universidad.persistencia.utilidades.AdministradorEntetyManager;

/**
 * Esta clase dara solucion al DAO docente de forma JPA
 * @author Cristian Sinisterra
 *
 */
public class DAODocenteJPA implements IDAODocente {
	
	/*
	 *crear este guarda un docente en la base de datos
	 */
	public void crear(Docente docente) throws Exception {
		// TODO Auto-generated method stub
		EntityManager em= AdministradorEntetyManager.getEntityManager();
		em.getTransaction().begin();
		em.persist(docente);
		em.getTransaction().commit();
	}
	
	/*
	 * editar, este metododo edita un docente ya guardado en la base de datos
	 */
	public void editar(Docente docente) throws Exception {
		// TODO Auto-generated method stub
		EntityManager em= AdministradorEntetyManager.getEntityManager();
		em.getTransaction().begin();
		em.merge(docente);
		em.getTransaction().commit();
	}
	
	/*
	 * elimina, este metodo elimina un docente ya creado en la base de datos
	 * @param cedula, identificacion del docente que se desea eliminar	 
	 */
	public void elimina(String cedula) throws Exception {
		// TODO Auto-generated method stub
		EntityManager em= AdministradorEntetyManager.getEntityManager();
		em.getTransaction().begin();
		Docente e= buscar(cedula);
		if(e!= null){
		em.remove(e);
		}
		em.getTransaction().commit();
	}
	
	/*
	 * buscar, este metodo encuentra un docente ya creado e la base de datos
	 * @param cedula, identificacion del docente a buscar	 
	 */
	public Docente buscar(String cedula) throws Exception {
		EntityManager em= AdministradorEntetyManager.getEntityManager();
		return em.find(Docente.class, cedula);
	}

	public List<Docente> listarTodo() {
		// TODO Auto-generated method stub
		return null;
	}

}
