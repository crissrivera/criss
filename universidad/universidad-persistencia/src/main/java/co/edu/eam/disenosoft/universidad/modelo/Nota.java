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
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * Clase que representa una calificacion de una evaluacion de un curso.
 * 
 * @author Camilo Andres Ferrer Bustos.
 * 
 */
@Entity
@Table(name = "tb_nota")
@NamedQueries({
@NamedQuery(name = Nota.CONSULTA_POR_EVAL,query= "SELECT nota FROM Nota nota"
            + " where nota.evaluacion=?1"),
    @NamedQuery(name = Nota.CONSULTA_POR_REGISTROCURSO,query= "SELECT nota FROM Nota"
            + " nota where nota.registroCurso=:curso"),
    @NamedQuery(name = Nota.CONSULTA_POR_REGCUR_EVAL,query = "SELECT nota FROM "
            + "Nota nota where nota.registroCurso=?1 AND nota.evaluacion=?2")
})
public class Nota implements Serializable {
    public static final String CONSULTA_POR_EVAL = "Nota.listarPorEvaluacione";
    public static final String CONSULTA_POR_REGISTROCURSO = "Nota.listarPorRegCur";
    public static final String CONSULTA_POR_REGCUR_EVAL = "Nota.listarPorCursoEval";
    
    @Id
    @Column(name = "ID", nullable=false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
        
	/**
	 * Evaluacion a la que pertenece esta nota.
	 */
    @ManyToOne
    @JoinColumn(name = "id_evaluacion", nullable = false)
	private Evaluacion evaluacion;
    
    
	

	/**
     * Curso y estudiante al que pertenece esta nota.
     */
    
    //@Id
	@ManyToOne(cascade={})
	@JoinColumns({
		
		@JoinColumn(name="cedula_estudiante", referencedColumnName="cedula_estudiante", nullable=false),
		@JoinColumn(name="codigo_curso", referencedColumnName="codigo_curso", nullable=false)
	})
	private RegistroCurso registroCurso;
    
    
    @Column(name = "valor_nota", nullable = false)
    private double valor;

    /**
     * bandera que indica si la nota ya fue modificada para no dejar que lo sea
     * una vez mas.
     */
    @Column(name = "editada_nota", nullable = false)
    private boolean editada;
	
	

	/**
	 * Constructor
	 */
	public Nota() {
		super();
	}
	
	public Nota(Evaluacion evaluacion, RegistroCurso registroCurso, double valor, boolean editada) {
		super();
		this.evaluacion = evaluacion;
		this.registroCurso = registroCurso;
		this.valor = valor;
		this.editada = editada;
	}
	
	public long getId() {
		return id;
	}



	public void setId(long id) {
		this.id = id;
	}



	public Evaluacion getEvaluacion() {
		return evaluacion;
	}



	public void setEvaluacion(Evaluacion evaluacion) {
		this.evaluacion = evaluacion;
	}



	public RegistroCurso getRegistroCurso() {
		return registroCurso;
	}



	public void setRegistroCurso(RegistroCurso registroCurso) {
		this.registroCurso = registroCurso;
	}



	public double getValor() {
		return valor;
	}



	public void setValor(double valor) {
		this.valor = valor;
	}



	public boolean isEditada() {
		return editada;
	}



	public void setEditada(boolean editada) {
		this.editada = editada;
	}


	

}
