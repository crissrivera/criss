package co.edu.eam.disenosoft.universidad.modelo;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Clase que presenta un Docente.
 * 
 * @author Camilo Andres Ferrer Bustos.
 * 
 */
@Entity
@Table (name="tb_docente")
public class Docente extends Persona {

	/**
	 * Profesion del docente.
	 */
	@ManyToOne
  	@JoinColumn(name = "profesion_doc")
	private Profesion profesion;

	/**
	 * indica si el docente tiene postgrado.
	 */
	@Column(name= "postgrado_doc")
	private boolean postgrado;
	

	/**
	 * Constructo.
	 */
	public Docente() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Constructor.
	 * 
	 * @param nombre
	 * @param apellido
	 * @param cedula
	 * @param correo
	 * @param direccion
	 * @param telefono
	 */
	public Docente(String nombre, String apellido, String cedula,
			String correo, String direccion, String telefono,
			Profesion profesion, boolean postgrado) {
		super(nombre, apellido, cedula, correo, direccion, telefono);
		this.postgrado = postgrado;
		this.profesion = profesion;
	}

	/**
	 * @return the profesion
	 */
	public Profesion getProfesion() {
		return profesion;
	}

	/**
	 * @param profesion
	 *            the profesion to set
	 */
	public void setProfesion(Profesion profesion) {
		this.profesion = profesion;
	}

	/**
	 * @return the postgrado
	 */
	public boolean isPostgrado() {
		return postgrado;
	}

	/**
	 * @param postgrado
	 *            the postgrado to set
	 */
	public void setPostgrado(boolean postgrado) {
		this.postgrado = postgrado;
	}


}
