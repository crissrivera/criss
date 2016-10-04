package co.edu.eam.disenosoft.universidad.modelo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Clase que reprenta un curso registrado por un estudiante.
 * 
 * @author Camilo Andres Ferrer Bustos.
 * 
 */
@Entity
@Table(name="tb_registrocurso")
@IdClass(RegistroCursoPK.class)
@NamedQueries({ @NamedQuery(name= RegistroCurso.CONSULTA_CursosEstudiante,query = "SELECT registroCur FROM RegistroCurso registroCur "
        + "where registroCur.estudiante.cedula=?1"),
@NamedQuery(name=RegistroCurso.CONSULTA_LISTAESTUDIANTEPOR_CURSO, query="SELECT regCurso FROM RegistroCurso regCurso"
        + " WHERE regCurso.curso.codigo=?1"),
@NamedQuery(name=RegistroCurso.Numero_Creditos_Registrados, query="SELECT SUM(regCurso.curso.asignatura.numeroCreditos)FROM RegistroCurso regCurso"
        + " WHERE regCurso.estudiante=?1"),
@NamedQuery(name = RegistroCurso.CONSULTA_POR_CURSO_EST,query = "SELECT regCur FROM RegistroCurso regCur "
        + "WHERE regCur.curso=:curso AND regCur.estudiante=:estudiante")
})
public class RegistroCurso implements Serializable {
         
    public static final String CONSULTA_LISTAESTUDIANTEPOR_CURSO="RegistroCurso.listarEstudiantePorCurso";
	 public static final String CONSULTA_CursosEstudiante = "RegistroCurso.listarCursosEstudiantes";
	 public static final String Numero_Creditos_Registrados="Registro.Curso.NumeroCreditos";
          public static final String CONSULTA_POR_CURSO_EST = "ResgistroCurso.listarPorCursoYEst";
	/**
	 * Estudiante que registro el curso.
	 */
	@Id
	@ManyToOne
	@JoinColumn(name="cedula_estudiante", nullable=false)
	private Estudiante estudiante;

	/**
	 * Curso que registro el estudiante.
	 */
	@Id
	@ManyToOne
	@JoinColumn(name="codigo_curso", nullable=false )
	private Curso curso;

	/**
	 * Notas que el estudiante tiene registradas en este curso.
	 */
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, orphanRemoval=true, mappedBy="registroCurso")    
	private List<Nota> notas;

	public RegistroCurso() {
		super();
	}

	/**
	 * Constructor
	 * 
	 * @param estudiante
	 * @param curso
	 * @param notas
	 */
	public RegistroCurso(Estudiante estudiante, Curso curso, List<Nota> notas) {
		super();
		this.estudiante = estudiante;
		this.curso = curso;
		this.notas = notas;
	}

	/**
	 * @return the estudiante
	 */
	public Estudiante getEstudiante() {
		return estudiante;
	}

	/**
	 * @param estudiante
	 *            the estudiante to set
	 */
	public void setEstudiante(Estudiante estudiante) {
		this.estudiante = estudiante;
	}

	/**
	 * @return the curso
	 */
	public Curso getCurso() {
		return curso;
	}

	/**
	 * @param curso
	 *            the curso to set
	 */
	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	/**
	 * @return the notas
	 */
	public List<Nota> getNotas() {
		return notas;
	}

	/**
	 * @param notas
	 *            the notas to set
	*/
	public void setNotas(List<Nota> notas) {
		this.notas = notas;
	} 

}
