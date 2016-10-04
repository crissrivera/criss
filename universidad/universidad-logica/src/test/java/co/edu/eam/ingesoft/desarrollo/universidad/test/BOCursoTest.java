package co.edu.eam.ingesoft.desarrollo.universidad.test;

import java.util.ArrayList;
import java.util.List;

import org.caferrer.testdata.junit.TestDataUtil;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import co.edu.eam.disenosoft.universidad.logica.bos.BOCurso;
import co.edu.eam.disenosoft.universidad.modelo.Asignatura;
import co.edu.eam.disenosoft.universidad.modelo.Curso;
import co.edu.eam.disenosoft.universidad.modelo.Docente;
import co.edu.eam.disenosoft.universidad.modelo.SesionCurso;
import co.edu.eam.disenosoft.universidad.modelo.enumeraciones.DiaEnum;

public class BOCursoTest {
	private BOCurso boCurso;
	
	@Before
	public void setUp(){
		boCurso= new BOCurso();
	}
	
	@Test
	public void testCrear() {
		Curso curso= new Curso();
		curso.setCodigo("6");
		//Docente
		Docente doc=new Docente();
		doc.setCedula("4679438");
		curso.setDocente(doc);
		//Asignatura
		Asignatura asig= new Asignatura();
		asig.setCodigo("1");
		curso.setAsignatura(asig);
		
		try {
			boCurso.crearCurso(curso);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Assert.assertNotNull(curso);
		
		
		
		
	}
	
	@AfterClass
	public static void afterClass() {

		TestDataUtil.ejecutarSQL("sqltest/BOCursoTest-del.sql");
		
	}

}
