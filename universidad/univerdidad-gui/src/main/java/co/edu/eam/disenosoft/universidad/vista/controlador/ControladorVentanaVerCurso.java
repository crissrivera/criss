package co.edu.eam.disenosoft.universidad.vista.controlador;

import co.edu.eam.disenosoft.universidad.logica.bos.BOAsignatura;
import co.edu.eam.disenosoft.universidad.logica.bos.BOCurso;
import co.edu.eam.disenosoft.universidad.logica.bos.BOEstudiante;
import co.edu.eam.disenosoft.universidad.logica.bos.BONota;
import co.edu.eam.disenosoft.universidad.logica.bos.BORegistrarCurso;
import co.edu.eam.disenosoft.universidad.modelo.Asignatura;
import co.edu.eam.disenosoft.universidad.modelo.Curso;
import co.edu.eam.disenosoft.universidad.modelo.Estudiante;
import co.edu.eam.disenosoft.universidad.modelo.Nota;
import co.edu.eam.disenosoft.universidad.modelo.RegistroCurso;
import java.util.List;

public class ControladorVentanaVerCurso {
    private BOAsignatura boAsignatura;
    private BOCurso bocurso;
    private BORegistrarCurso boRegistroCurso;
    private BOEstudiante boEstudiante;
    private BONota boNota;
    
    
    public ControladorVentanaVerCurso(){
        boAsignatura=new BOAsignatura();
        bocurso=new BOCurso();
        boRegistroCurso=new BORegistrarCurso();
        boEstudiante= new BOEstudiante();
        boNota=new BONota();
    }
    
    public Estudiante buscarEstudiante(String cedula)throws Exception{
        return boEstudiante.buscar(cedula);
    }
    
    /**
     * Cantidad de creditos que tiene un estudiante registrado
     * @param estudiante, que se le van a culacular los creditos registrado
     * @return la cantidad de creditos registrados
     * @throws Exception 
     */
    public List<Long> creditosEstudiante(Estudiante estudiante)throws Exception{
        return boRegistroCurso.calcularCreditos(estudiante);
    }
    /**
     * busca asignatura
     * @param codigo, de la asignatura
     * @return
     * @throws Exception 
     */
    public Asignatura buscarAsignatura (String codigo) throws Exception{
        return boAsignatura.buscar(codigo);
    }
    
    /**
     * busca un curso por su código
     * @param curso, código del curso
     * @return un curso o null
     * @throws PersistenciaException 
     */
    public Curso buscarCurso(String codigo)throws Exception{
        return bocurso.buscarCurso(codigo);
    }
    
    public List<Curso> listarCursosPorAsignatura(Asignatura asignatura)throws Exception{
        return bocurso.listarCursosPorAsignatura(asignatura.getCodigo());
    }
    
    public List<Nota> listarNotasPorRegCurso(RegistroCurso rc) throws Exception{
        return boNota.listarPorRegistroCurso(rc);
    }
    
    public List<RegistroCurso> listartodoslosregistrodecursoEstu(Curso curso)throws Exception{
        return boRegistroCurso.listartodoslosregistrodecursoEstu(curso.getCodigo());
    }
    
    public RegistroCurso buscarRegistroCurso(Curso c, Estudiante e) throws Exception{
        return boRegistroCurso.buscar(c, e);
    }
    
    
}
