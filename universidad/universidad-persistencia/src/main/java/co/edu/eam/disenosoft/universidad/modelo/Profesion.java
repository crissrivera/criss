package co.edu.eam.disenosoft.universidad.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Clase que representa una profesion docente.
 * 
 * @author Camilo Andres FErrer Butsos.
 *
 */
@Entity
@Table (name = "tb_profesion")
public class Profesion implements Serializable {

	/**
	 * codigo de la profesion.
	 */
	@Id
	
	@Column(name="codigo_prof")
	private String codigo;
	/**
	 * Nombre de la profesion.
	 */
	
	@Column(name="nombre_prof")
	private String nombre;

	/**
	 * COnstructor.
	 */
	public Profesion() {
		super();
	}

	/**
	 * @param codigo
	 * @param nombre
	 */
	public Profesion(String codigo, String nombre) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
	}

	/**
	 * @return the codigo
	 */
	public String getCodigo() {
		return codigo;
	}

	/**
	 * @param codigo
	 *            the codigo to set
	 */
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre
	 *            the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return nombre;
	}

	@Override
	public boolean equals(Object arg0) {
		if (arg0 instanceof Profesion) {
			Profesion prof = (Profesion) arg0;
			if (prof.codigo.equals(codigo)) {
				return true;
			}
		}
		return false;
	}

}
