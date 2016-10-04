package co.edu.eam.disenosoft.universidad.vista.controlador;

import co.edu.eam.disenosoft.universidad.logica.bos.BOCurso;
import co.edu.eam.disenosoft.universidad.logica.bos.BOSesionCurso;
import co.edu.eam.disenosoft.universidad.modelo.Asignatura;
import co.edu.eam.disenosoft.universidad.modelo.Curso;
import co.edu.eam.disenosoft.universidad.modelo.Docente;
import co.edu.eam.disenosoft.universidad.modelo.SesionCurso;

public class ControladorVentanaCrearCurso {

	private BOCurso boCurso;
	private BOSesionCurso boSesionCurso;
	
	public ControladorVentanaCrearCurso(){
		boCurso=new BOCurso();
		boSesionCurso=new BOSesionCurso();
	}
	public void crearSesion(SesionCurso sesion) throws Exception {
		boSesionCurso.crearSesion(sesion);
	}
	
	public Asignatura buscarAsignatura(String codigo)throws Exception{
		return boCurso.buscarAsignatura(codigo);
	}
	
	public Docente buscarDocente(String cedula)throws Exception{
		return boCurso.buscarDocente(cedula);
	}
	
	public void crearCurso(Curso curso)throws Exception{
		boCurso.crearCurso(curso);
	}
	
	public Curso buscarCurso(String codigo)throws Exception{
		return boCurso.buscarCurso(codigo);
	}
	
	/**
      public Curso buscarCursoPorAsignaturaDocente(String codigo, String cedula) throws Exception{
          return boCurso.buscarCursoPorAsignaturaDocente(codigo, cedula);
      }
      */
    
}
