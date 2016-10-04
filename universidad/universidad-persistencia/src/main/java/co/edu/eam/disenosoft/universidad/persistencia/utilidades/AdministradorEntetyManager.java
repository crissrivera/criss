package co.edu.eam.disenosoft.universidad.persistencia.utilidades;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AdministradorEntetyManager {

	private static EntityManager em;

	public static EntityManager getEntityManager() {

		if (em == null) {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa_pu");

			em = emf.createEntityManager();
		}
		return em;

	}
}
