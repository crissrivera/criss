package co.edu.eam.disenosoft.universidad.logica.bos;

import co.edu.eam.disenosoft.universidad.modelo.SesionCurso;
import co.edu.eam.disenosoft.universidad.persistencia.dao.definiciones.IDAOSesionCurso;
import co.edu.eam.disenosoft.universidad.persistencia.dao.implementacion.jpa.DAOSesionCursoJPA;

public class BOSesionCurso {

	private IDAOSesionCurso daoSesionCurso;
	
	public BOSesionCurso(){
		daoSesionCurso= new DAOSesionCursoJPA();
	}
	
	public void crearSesion(SesionCurso sesion) throws Exception {
		daoSesionCurso.crearSesion(sesion);
	}
}
