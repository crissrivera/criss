/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.eam.disenosoft.universidad.vista.controlador;

import co.edu.eam.disenosoft.universidad.logica.bos.BOCurso;
import co.edu.eam.disenosoft.universidad.logica.bos.BOEstudiante;
import co.edu.eam.disenosoft.universidad.logica.bos.BORegistrarCurso;
import co.edu.eam.disenosoft.universidad.modelo.Curso;
import co.edu.eam.disenosoft.universidad.modelo.Estudiante;
import co.edu.eam.disenosoft.universidad.modelo.RegistroCurso;
import java.util.List;

/**
 *
 * @author Cristian Sinisterra
 */
public class ControladorVerRegistroEstudiante {
    private BOEstudiante boestudiante;
    private BORegistrarCurso boRegistro;
    private BOCurso boCurso;
    
    public ControladorVerRegistroEstudiante(){
        boestudiante=new BOEstudiante();
        boRegistro=new BORegistrarCurso();
        boCurso= new BOCurso();
                
    }
    
    /**
     * Busca un  estudiante
     * @param cedula, del estudiante a buscar
     * @return un estudiante si exite
     * @throws Exception 
     */
    public Estudiante buscar(String cedula)throws Exception{
        return boestudiante.buscar(cedula);
    }
    
    /**
     * Calcula la cantidad de numeros de creditos registrado por el estudiante
     * @param estudiante, que se le van a calcular los creditos
     * @return la cantidad de creditos registrado
     * @throws Exception 
     */
    public List<Long> creditosRegistradoEstu(Estudiante estudiante)throws Exception{
        return boRegistro.calcularCreditos(estudiante);
    }
    
    public List<RegistroCurso> listarCursosDelEstudinte(Estudiante estudiante)throws Exception{
        return boRegistro.listartodoslosregistrodecursoEstu(estudiante.getCedula());
    }
    
    public Curso buscarCurso(String codigo) throws Exception{
       return boCurso.buscarCurso(codigo);
    }
    
     /**
     * busca un registro curso por cu curso y su estudiante
     * @param curso, curso del registro curso
     * @param estudiante, estudiante del registro curso
     * @return un registro curso o null
     * @throws Exception
     */
    public RegistroCurso buscarRegCur(Curso curso, Estudiante estudiante) throws Exception{
        return boRegistro.buscar(curso, estudiante);
    }
    
    /**
     * Eliminar un registro curso
     * @param rc, el registro curso a eliminar
     * @throws Exception
     */
    public void eliminar(RegistroCurso rC)throws Exception{
        boRegistro.Eliminar(rC);
    }
}
