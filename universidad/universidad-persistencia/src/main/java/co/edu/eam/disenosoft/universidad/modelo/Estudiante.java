/**
 * 
 */
package co.edu.eam.disenosoft.universidad.modelo;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Clase que representa un estudiante.
 * @author Camilo Andres Ferrer Bustos.
 * 
 */
@Entity
@Table(name = "tb_estudiante")
public class Estudiante extends Persona {

	
	/**
	 * Fecha nacimiento estudiante.
	 */
	@Column(name = "fechanacimiento_est")
	@Temporal(TemporalType.DATE)
	private Date fechaNacimiento;
	
    @OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, orphanRemoval=true, mappedBy="estudiante")
    private List<RegistroCurso> registro;

    
		
	/**
	 * Constructor.
	 */
	public Estudiante() {
		super();
	}

	/**
	 * Constructor.
	 * @param nombre
	 * @param apellido
	 * @param cedula
	 * @param correo
	 * @param direccion
	 * @param telefono
	 */
	public Estudiante(String nombre, String apellido, String cedula,
			String correo, String direccion, String telefono,Date fechaNacimiento) {
		super(nombre, apellido, cedula, correo, direccion, telefono);
		this.fechaNacimiento=fechaNacimiento;
	}

	/**
	 * @return the fechaNacimiento
	 */
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	/**
	 * @param fechaNacimiento the fechaNacimiento to set
	 */
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	
	public List<RegistroCurso> getRegistro() {
        return registro;
    }

    public void setRegistro(List<RegistroCurso> registro) {
        this.registro = registro;
    }

	
	

}
