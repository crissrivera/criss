package co.edu.eam.disenosoft.universidad.persistencia.dao.implementacion.jpa;

import javax.persistence.EntityManager;

import co.edu.eam.disenosoft.universidad.modelo.SesionCurso;
import co.edu.eam.disenosoft.universidad.persistencia.dao.definiciones.IDAOSesionCurso;
import co.edu.eam.disenosoft.universidad.persistencia.utilidades.AdministradorEntetyManager;

public class DAOSesionCursoJPA implements IDAOSesionCurso {

	public void crearSesion(SesionCurso sesion) throws Exception {
		EntityManager em= AdministradorEntetyManager.getEntityManager();
		em.getTransaction().begin();
		em.persist(sesion);
		em.getTransaction().commit();
		
	}
        
        

    

}
