/**
 * 
 */
package co.edu.eam.disenosoft.universidad.modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * Clase que representa la evaluacion de un curso.
 * 
 * @author Camilo Andres Ferrer Bustos.
 * 
 */
@Entity
@Table(name = "tb_evaluacion")
@NamedQueries({
    @NamedQuery(name=Evaluacion.CONSULTA_POR_CODIGO,query= "SELECT eval FROM Evaluacion eval"
            + " where eval.curso.codigo=?1"),
    @NamedQuery(name = Evaluacion.CONSULTA_POR_NOM_CURSO,query = "SELECT eval FROM "
            + "Evaluacion eval where eval.nombre=?1 AND eval.curso.codigo=?2")
})
public class Evaluacion implements Serializable{
    public static final String CONSULTA_POR_CODIGO = "evaluacion.listarPorCodigo";
    public static final String CONSULTA_POR_NOM_CURSO = "evaluacion.buscarPorNomYCur";
    @Id
    @Column(name="ID")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
	/**
	 * Curso al que pertenece esta evaluacion.
	 */
	@ManyToOne
    @JoinColumn(name = "codigo_cur", nullable = false)
    private Curso curso;

	/**
	 * Nombre de la evaluacion;
	 */
    @Column(name = "nombre_eval",  nullable = false)
	private String nombre;

	/**
	 * Porcentaje que vale esta evaluacion dentro del curso.
	 */
    @Column(name = "porcentaje_eval", nullable = false)
	private double porcentaje;

	/**
	 * Constructor.
	 */
	public Evaluacion() {
		super();
	}
	
	

	/**
	 * Constructor de la clase.
	 * @param curso
	 * @param nombre
	 * @param porcentaje
	 */
	public Evaluacion(Curso curso, String nombre, double porcentaje) {
		super();
		this.curso = curso;
		this.nombre = nombre;
		this.porcentaje = porcentaje;
	}



	/**
	 * @return the curso
	 */
	public Curso getCurso() {
		return curso;
	}

	/**
	 * @param curso the curso to set
	 */
	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the porcentaje
	 */
	public double getPorcentaje() {
		return porcentaje;
	}

	/**
	 * @param porcentaje the porcentaje to set
	 */
	public void setPorcentaje(double porcentaje) {
		this.porcentaje = porcentaje;
	}
	
	

	
	
}
