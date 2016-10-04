package co.edu.eam.disenosoft.universidad.persistencia.dao.implementacion.jpa;

import co.edu.eam.disenosoft.universidad.modelo.Curso;
import co.edu.eam.disenosoft.universidad.modelo.Estudiante;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import co.edu.eam.disenosoft.universidad.modelo.RegistroCurso;
import co.edu.eam.disenosoft.universidad.persistencia.dao.definiciones.IDAORegistroCurso;
import co.edu.eam.disenosoft.universidad.persistencia.utilidades.AdministradorEntetyManager;
import javax.persistence.TemporalType;

public class DAORegistroCurso implements IDAORegistroCurso {

	public List<RegistroCurso> listarCursos(String codigo) throws Exception {
		EntityManager em= AdministradorEntetyManager.getEntityManager();
                Query query=em.createNamedQuery(RegistroCurso.CONSULTA_LISTAESTUDIANTEPOR_CURSO);
                query.setParameter(1, codigo);
                return query.getResultList();
	}

	
        
	public List<RegistroCurso> listartodoslosregistrodecursoEstu(String cedula) throws Exception {
		EntityManager em= AdministradorEntetyManager.getEntityManager();
		//Debo cambiarlar prueba
		Query query= em.createNamedQuery(RegistroCurso.CONSULTA_LISTAESTUDIANTEPOR_CURSO);
		query.setParameter(1, cedula);
		return query.getResultList();
	}



	public void crear(RegistroCurso Rcurso) throws Exception {
		EntityManager em= AdministradorEntetyManager.getEntityManager();
		em.getTransaction().begin();
		em.persist(Rcurso);
		em.getTransaction().commit();
		
	}

    public List<Long> calcularCreditos(Estudiante estudiante) throws Exception {
       EntityManager em= AdministradorEntetyManager.getEntityManager();
       Query query= em.createNamedQuery(RegistroCurso.Numero_Creditos_Registrados);
       query.setParameter(1, estudiante);
       return query.getResultList();
               
    }

    public void eliminar(RegistroCurso curso) throws Exception {
         EntityManager em= AdministradorEntetyManager.getEntityManager();
         em.getTransaction().begin();
         em.remove(curso);
         em.getTransaction().commit();
    }

    public RegistroCurso buscar(Curso curso, Estudiante estudiante) throws Exception {
      EntityManager em= AdministradorEntetyManager.getEntityManager();
        Query query= em.createNamedQuery(RegistroCurso.CONSULTA_POR_CURSO_EST);
        query.setParameter("curso", curso);
        query.setParameter("estudiante", estudiante);
        List<RegistroCurso> lista = query.getResultList();
        for (RegistroCurso rc : lista) {
            return rc;
        }
        return null;
    }

}
