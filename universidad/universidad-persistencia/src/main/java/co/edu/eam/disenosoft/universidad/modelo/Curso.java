package co.edu.eam.disenosoft.universidad.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Clase que representa a un curso.
 * 
 * @author Cmilo Andres Ferrer Bustso.
 * 
 */
@Entity
@Table(name="tb_curso")
@NamedQueries({
    @NamedQuery(name=Curso.LISTARCURSOPORASIGNATURA,query= "SELECT cur FROM Curso cur"
            + " where cur.asignatura.codigo=?1"),
     @NamedQuery(name = Curso.CONSULTA_DOCENTE_LISTA_CURSO, query = "SELECT cur FROM Curso cur "
            + "WHERE cur.docente.cedula=?1")
        
})
public class Curso implements Serializable {
	 public static final String CONSULTA_DOCENTE_LISTA_CURSO = "Cursos.listarPorDocente";
	public static final String LISTARCURSOPORASIGNATURA= "Curso.listarPorAsignatura";

	/**
	 * Codigo del curso. el codigo se forma con el codigo de la
	 * asignatura+a�o+semestre del a�o (I o II)
	 */
	@Id
	@Column(name="codigo_curso")
	private String codigo;

	/**
	 * Docente que imparte la asignatura.
	 */
	@ManyToOne
	@JoinColumn(name="cedula_docente")
	private Docente docente;

	/**
	 * Asignatura de este curso.
	 */
	@ManyToOne
	@JoinColumn(name="codigo_asignatura")
	private Asignatura asignatura;

	/**
	 * Sesiones del curso. las sesiones son los dias en que los estudiantes y el
	 * profesor se encuentran para la clase.
	 */
    @OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, orphanRemoval=true, mappedBy="curso")
	private List<SesionCurso> sesiones;
	
	/**
	 * Estudiantes registrados en este curso.
	 */
    @OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, orphanRemoval=true, mappedBy="curso")
    private List<RegistroCurso> estudiantes;
	
	/**
	 * Evaluaciones del curso.
	 */
    @OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, orphanRemoval=true, mappedBy="curso")
	private List<Evaluacion> evaluaciones;
	
	/**
	 * Constructor.
	 */
	public Curso() {
		super();
		//sesiones= new ArrayList<SesionCurso>();
	}

	public Curso(String codigo, Docente docente, Asignatura asignatura) {
		super();
		this.codigo = codigo;
		this.docente = docente;
		this.asignatura = asignatura;
		
	}

	public String getCodigo() {
		return codigo;
	}
	
	

	public List<RegistroCurso> getEstudiantes() {
		return estudiantes;
	}

	public void setEstudiantes(List<RegistroCurso> estudiantes) {
		this.estudiantes = estudiantes;
	}

	public List<Evaluacion> getEvaluaciones() {
		return evaluaciones;
	}

	public void setEvaluaciones(List<Evaluacion> evaluaciones) {
		this.evaluaciones = evaluaciones;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Docente getDocente() {
		return docente;
	}

	public void setDocente(Docente docente) {
		this.docente = docente;
	}

	public Asignatura getAsignatura() {
		return asignatura;
	}

	public void setAsignatura(Asignatura asignatura) {
		this.asignatura = asignatura;
	}

	public List<SesionCurso> getSesiones() {
		return sesiones;
	}

	public void setSesiones(List<SesionCurso> sesiones) {
		this.sesiones = sesiones;
	}
	
	
}
