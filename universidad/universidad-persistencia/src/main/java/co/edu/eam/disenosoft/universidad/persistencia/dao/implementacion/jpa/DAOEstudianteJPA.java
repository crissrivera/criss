package co.edu.eam.disenosoft.universidad.persistencia.dao.implementacion.jpa;

import java.util.List;

import javax.persistence.EntityManager;

import co.edu.eam.disenosoft.universidad.modelo.Estudiante;
import co.edu.eam.disenosoft.universidad.persistencia.dao.definiciones.IDAOEstudiante;
import co.edu.eam.disenosoft.universidad.persistencia.utilidades.AdministradorEntetyManager;
/**
 * Clase responsable del DAO de estudiante implementando JPA
 * @author Cristian Sinisterra
 *@data 15/08/2016
 *@version 1.0
 */
public class DAOEstudianteJPA implements IDAOEstudiante {

	
	
	public void crear(Estudiante estudiante) throws Exception {
		// TODO Auto-generated method stub
		EntityManager em= AdministradorEntetyManager.getEntityManager();
		em.getTransaction().begin();
		em.persist(estudiante);
		em.getTransaction().commit();
		
	}

	public void editar(Estudiante estudiante) throws Exception {
		// TODO Auto-generated method stub
		EntityManager em= AdministradorEntetyManager.getEntityManager();
		em.getTransaction().begin();
		em.merge(estudiante);
		em.getTransaction().commit();
	}

	public void eliminar(String cedula) throws Exception {
		// TODO Auto-generated method stub
		EntityManager em= AdministradorEntetyManager.getEntityManager();
		em.getTransaction().begin();
		Estudiante e= buscar(cedula);
		if(e!= null){
		em.remove(e);
		}
		em.getTransaction().commit();
	}

	public Estudiante buscar(String cedula) throws Exception {
		EntityManager em= AdministradorEntetyManager.getEntityManager();
		return em.find(Estudiante.class, cedula);
	}

	public List<Estudiante> listarTodo() {
		// TODO Auto-generated method stub
		return null;
	}

}
