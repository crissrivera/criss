package co.edu.eam.disenosoft.universidad.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="tb_falla")
public class Falla implements Serializable{

	/**
	 * Llava primaria de la entidad
	 */
	@Id
	@Column(name="id_falla")
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idFalla;
	
	/**
	 * Numero de fallas
	 */
	@Column(name="numero_fallas", nullable=false)
	private int numeroFallas;
	
	/**
	 * Curso y estudiante al que pertenece esta falla
	 */
	//@Id
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="codigo_curso",referencedColumnName="codigo_curso", nullable=false),
		@JoinColumn(name="cedula_estudiante", referencedColumnName="cedula_estudiante", nullable=false)
	})
	private RegistroCurso registroCurso;
	
	/**
	 * Constructor
	 */
	public Falla(){
		
	}

	/**
	 * Constructor
	 * @param idFalla
	 * @param numeroFallas
	 * @param registroCurso
	 */
	public Falla( int numeroFallas, RegistroCurso registroCurso) {
		super();
	
		this.numeroFallas = numeroFallas;
		this.registroCurso = registroCurso;
	}

	/**
	 * @return El atributo idFalla
	 */
	public long getIdFalla() {
		return idFalla;
	}

	/**
	 * Establece el valor del atributo idFalla
	 * @param idFalla: EL idFalla a establecer
	 */
	public void setIdFalla(long idFalla) {
		this.idFalla = idFalla;
	}

	/**
	 * @return El atributo numeroFallas
	 */
	public int getNumeroFallas() {
		return numeroFallas;
	}

	/**
	 * Establece el valor del atributo numeroFallas
	 * @param numeroFallas: EL numeroFallas a establecer
	 */
	public void setNumeroFallas(int numeroFallas) {
		this.numeroFallas = numeroFallas;
	}

	/**
	 * @return El atributo registroCurso
	 */
	public RegistroCurso getRegistroCurso() {
		return registroCurso;
	}

	/**
	 * Establece el valor del atributo registroCurso
	 * @param registroCurso: EL registroCurso a establecer
	 */
	public void setRegistroCurso(RegistroCurso registroCurso) {
		this.registroCurso = registroCurso;
	}
	
}
