package co.edu.eam.disenosoft.universidad.persistencia.dao.implementacion.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import co.edu.eam.disenosoft.universidad.modelo.Asignatura;
import co.edu.eam.disenosoft.universidad.modelo.Curso;
import co.edu.eam.disenosoft.universidad.modelo.Docente;
import co.edu.eam.disenosoft.universidad.modelo.Estudiante;
import co.edu.eam.disenosoft.universidad.persistencia.dao.definiciones.IDAOCurso;
import co.edu.eam.disenosoft.universidad.persistencia.utilidades.AdministradorEntetyManager;

public class DAOCursoJPA implements IDAOCurso{

	public Asignatura buscarAsignatura(String codigo) throws Exception {
		EntityManager em= AdministradorEntetyManager.getEntityManager();
		return em.find(Asignatura.class, codigo);
	}

	public Docente buscarDocente(String cedula) throws Exception {
		EntityManager em= AdministradorEntetyManager.getEntityManager();
		return em.find(Docente.class, cedula);
	}

	public Estudiante buscarEstudiante(String cedula) throws Exception {
		EntityManager em= AdministradorEntetyManager.getEntityManager();
		return em.find(Estudiante.class, cedula);
	}
	
	public void crearCurso(Curso curso){
		EntityManager em= AdministradorEntetyManager.getEntityManager();
		em.getTransaction().begin();
		em.persist(curso);
		em.getTransaction().commit();
	}

	public Curso buscarCurso(String codigo) throws Exception {
		 EntityManager em= AdministradorEntetyManager.getEntityManager();
         return em.find(Curso.class, codigo);
	}

	public List<Curso> ListarCursoPorAsignatura(String codigo) throws Exception {
		EntityManager em= AdministradorEntetyManager.getEntityManager();
		Query query= em.createNamedQuery(Curso.LISTARCURSOPORASIGNATURA);
		query.setParameter(1, codigo);
		return query.getResultList();
	}

    public List<Curso> listarCursoPorDocente(String cedula) throws Exception {
        EntityManager em= AdministradorEntetyManager.getEntityManager();
        Query query= em.createNamedQuery(Curso.CONSULTA_DOCENTE_LISTA_CURSO);
        query.setParameter(1, cedula);
        List<Curso> lista = query.getResultList();
        return lista;
    }
        
	/**
	public Curso buscarCursoPorAsignaturaDocente(String codigo, String cedula) throws Exception{
            EntityManager em= AdministradorEntetyManager.getEntityManager();
            Query query= em.createNamedQuery(Curso.BUSCARCURSOPORASIGNATURAYDOCENTE);
            query.setParameter(1, cedula);
            query.setParameter(2, codigo);
            List<Curso> lista=query.getResultList();
            for(int i=0; i<lista.size(); i++){
                Curso curso=lista.get(i);
                return curso;
            }
            return null;
        }
	*/
}
