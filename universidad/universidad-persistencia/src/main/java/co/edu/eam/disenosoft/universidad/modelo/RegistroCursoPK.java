package co.edu.eam.disenosoft.universidad.modelo;

import java.io.Serializable;



public class RegistroCursoPK implements Serializable {

	private String curso;
	

	private String estudiante;
	
	public RegistroCursoPK(){
		
	}
	
	public RegistroCursoPK(String curso, String estudiante) {
	
		this.curso = curso;
		this.estudiante = estudiante;
	}
	
	
	public String getCurso() {
		return curso;
	}
	public void setCurso(String curso) {
		this.curso = curso;
	}
	public String getEstudiante() {
		return estudiante;
	}
	public void setEstudiante(String estudiante) {
		this.estudiante = estudiante;
	}
	
		
	
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RegistroCursoPK other = (RegistroCursoPK) obj;
		if (curso != other.curso)
			return false;
		if (estudiante != other.estudiante)
			return false;
		return true;
	}
}