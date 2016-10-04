package co.edu.eam.disenosoft.universidad.persistencia.dao.implementacion.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;


import co.edu.eam.disenosoft.universidad.modelo.Profesion;
import co.edu.eam.disenosoft.universidad.persistencia.dao.definiciones.IDAOProfesion;
import co.edu.eam.disenosoft.universidad.persistencia.utilidades.AdministradorEntetyManager;



public class DAOProfesionJPA implements IDAOProfesion {

	public List<Profesion> listarDocente() throws Exception {
		EntityManager em= AdministradorEntetyManager.getEntityManager();
		String sql="SELECT profesion from Profesion profesion";
		Query q= em.createQuery(sql);
		List<Profesion> lista= q.getResultList();
		System.out.println(lista.size());
		return lista;
	}

}
