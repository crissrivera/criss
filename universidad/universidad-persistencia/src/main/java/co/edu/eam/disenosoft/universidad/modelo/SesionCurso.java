package co.edu.eam.disenosoft.universidad.modelo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import co.edu.eam.disenosoft.universidad.modelo.enumeraciones.DiaEnum;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

/**
 * Clase que representa una sesion de un curso.
 * @author Camilo Andres Ferrer Bustos.
 *
 */
@Entity
@Table(name="tb_sesioncurso")
public class SesionCurso implements Serializable{
	/**
	 * sesion curso.
	 */
	@Id
	@Column(name="ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int sesionCurso;
	
	

	/**
	 * Curso de la sesion.
	 */
	@ManyToOne
	@JoinColumn(name="codigo_curso", nullable=false)
	private Curso curso;

	/**
	 * Dia de la sesion.
	 */
	@Column(name="dia_sesion")
	@Enumerated (EnumType.STRING)
	private DiaEnum dia;

	/**
	 * Hora en que empieza una sesion.
	 */
	
	@Column(name="horalinicio_sesion")
	private int horaInicio;

	/**
	 * Hora en que termina la sesion.
	 */
	@Column(name="horalfinal_sesion")
	private int horaFinal;

	/**
	 * Cosntructor.
	 */
	public SesionCurso() {
		super();
	}
	
	/**
	 * Constructor.
	 * @param curso
	 * @param dia
	 * @param horaInicio
	 * @param horaFinal
	 */
	public SesionCurso( Curso curso, DiaEnum dia, int horaInicio, int horaFinal) {
		super();
		
		this.curso = curso;
		this.dia = dia;
		this.horaInicio = horaInicio;
		this.horaFinal = horaFinal;
	}
	
	public int getSesionCurso() {
		return sesionCurso;
	}

	public void setSesionCurso(int sesionCurso) {
		this.sesionCurso = sesionCurso;
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
	 * @return the dia
	 */
	public DiaEnum getDia() {
		return dia;
	}

	/**
	 * @param dia the dia to set
	 */
	public void setDia(DiaEnum dia) {
		this.dia = dia;
	}

	/**
	 * @return the horaInicio
	 */
	public int getHoraInicio() {
		return horaInicio;
	}

	/**
	 * @param horaInicio the horaInicio to set
	 */
	public void setHoraInicio(int horaInicio) {
		this.horaInicio = horaInicio;
	}

	/**
	 * @return the horaFinal
	 */
	public int getHoraFinal() {
		return horaFinal;
	}

	/**
	 * @param horaFinal the horaFinal to set
	 */
	public void setHoraFinal(int horaFinal) {
		this.horaFinal = horaFinal;
	}
	
	

}
