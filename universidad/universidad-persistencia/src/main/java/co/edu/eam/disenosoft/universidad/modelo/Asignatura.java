/**
 * 
 */
package co.edu.eam.disenosoft.universidad.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

import co.edu.eam.disenosoft.universidad.modelo.enumeraciones.TipoAsignaturaEnum;

/**
 * Clase que representa a una asignatura.
 * @author user
 *
 */
@Entity
@Table (name="tb_asignatura")
public class Asignatura implements Serializable{

	/**
	 * Nombre de la asignatura-
	 */
	@Column (name="nombre_asig", nullable=false)
	private String nombre;
	/**
	 * Codigo de la asignatura
	 */
	@Id
	@Column (name="codigo_asig")
	private String codigo;
	
	/**
	 * Tipo de asignatura
	 */
	@Column (name="tipo_asig")
	@Enumerated (EnumType.STRING)
	private TipoAsignaturaEnum tipo;
	
	/**
	 * Numoer de creditos asignatura.
	 */
	@Column (name="numerocreditos_asig")
	private int numeroCreditos;
	
	@Column (name="semestre_asig")
	private int semestre;
	
	
	public Asignatura() {
	
	}
	/**
	 * @param nombre
	 * @param codigo
	 * @param tipo
	 * @param numeroCreditos
	 * @param semestre
	 */
	public Asignatura(String nombre, String codigo, TipoAsignaturaEnum tipo,
			int numeroCreditos, int semestre) {
		super();
		this.nombre = nombre;
		this.codigo = codigo;
		this.tipo = tipo;
		this.numeroCreditos = numeroCreditos;
		this.semestre= semestre;
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
	 * @return the codigo
	 */
	public String getCodigo() {
		return codigo;
	}
	/**
	 * @param codigo the codigo to set
	 */
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	/**
	 * @return the tipo
	 */
	public TipoAsignaturaEnum getTipo() {
		return tipo;
	}
	/**
	 * @param tipo the tipo to set
	 */
	public void setTipo(TipoAsignaturaEnum tipo) {
		this.tipo = tipo;
	}
	/**
	 * @return the numeroCreditos
	 */
	public int getNumeroCreditos() {
		return numeroCreditos;
	}
	/**
	 * @param numeroCreditos the numeroCreditos to set
	 */
	public void setNumeroCreditos(int numeroCreditos) {
		this.numeroCreditos = numeroCreditos;
	}
	
	public int getSemestre() {
		return semestre;
	}
	public void setSemestre(int semestre) {
		this.semestre = semestre;
	}
	
	

	@Override
	public boolean equals(Object arg0) {
		if (arg0 instanceof Asignatura) {
			Asignatura prof = (Asignatura) arg0;
			if (prof.codigo.equals(codigo)) {
				return true;
			}
		}
		return false;
	}

}
