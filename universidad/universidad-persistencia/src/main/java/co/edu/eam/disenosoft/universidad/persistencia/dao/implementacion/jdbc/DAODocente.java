package co.edu.eam.disenosoft.universidad.persistencia.dao.implementacion.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import co.edu.eam.disenosoft.universidad.modelo.Docente;
import co.edu.eam.disenosoft.universidad.modelo.Profesion;
import co.edu.eam.disenosoft.universidad.persistencia.dao.definiciones.IDAODocente;
import co.edu.eam.disenosoft.universidad.persistencia.utilidades.AdministradorConexionJDBC;
/**
 * Esta clase dara solucion al CRUD de un docente
 * @author Cristian Sinisterra
 *
 */
public class DAODocente implements IDAODocente {
	
	/**
	 * Crear docente guarda un docente en la base de datos
	 */
	public void crear(Docente docente) throws Exception {
		
		Connection con = AdministradorConexionJDBC.getConexion();
		//consulta que guardara los datos del docente en la base datos
		String sql = "INSERT INTO tb_persona (cedula_per, apellido_per, correo_per, direccion_per, nombre_per, telefono_per) "
				+ " VALUES(?,?,?,?,?,?)";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, docente.getCedula());
		pstmt.setString(2, docente.getApellido());
		pstmt.setString(3, docente.getCorreo());
		pstmt.setString(4, docente.getDireccion());
		pstmt.setString(5, docente.getNombre());
		pstmt.setString(6, docente.getTelefono());

		// ejecuta culsulta persona
		pstmt.executeUpdate();
		//Consulta que guardara los datos e un docente en al tabla docente	
		String sqle = "INSERT INTO tb_docente(cedula_per, postgrado_doc, profesion_doc)"
				+ " Values(?,?,?)";
		PreparedStatement pstmts = con.prepareStatement(sqle);
		pstmts.setString(1, docente.getCedula());
		pstmts.setBoolean(2, docente.isPostgrado());
		pstmts.setString(3, docente.getProfesion().getCodigo());
		// Ejecuta consulta Docente
		pstmts.executeUpdate();

		

		// 3. cerrar la conexion.
		con.close();

	}
	
	/**
	 * editar, modifica un docente en la base de datos de la universidad
	 */

	public void editar(Docente docente)throws Exception {
		Connection con=AdministradorConexionJDBC.getConexion();
		//consulta para modificar los datos de la universidad
		 String sql="UPDATE tb_persona SET  apellido_per=?, correo_per=?, direccion_per=?, nombre_per=?, telefono_per=? "
		 		+ " WHERE cedula_per=?";
		 
		 	PreparedStatement pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, docente.getApellido());
			pstmt.setString(2, docente.getCorreo());
			pstmt.setString(3, docente.getDireccion());
			pstmt.setString(4, docente.getNombre());
			pstmt.setString(5, docente.getTelefono());
			pstmt.setString(6, docente.getCedula());
			pstmt.executeUpdate();
			
			String sqldocente="UPDATE tb_docente SET  postgrado_doc=?, profesion_doc=? "
					+ " WHERE cedula_per=?";
			
			PreparedStatement pstmts = con.prepareStatement(sqldocente);
			
			pstmts.setBoolean(1, docente.isPostgrado());
			pstmts.setString(2, docente.getProfesion().getCodigo());
			pstmts.setString(3, docente.getCedula());
			// Ejecuta consulta Docente
			pstmts.executeUpdate();
			con.close();
	}

	/**
	 * elimina un docente de la base de datos de la universidad
	 */
	public void elimina(String cedula)throws Exception {
		// TODO Auto-generated method stub
		Connection con=AdministradorConexionJDBC.getConexion();
		String sql="DELETE FROM tb_persona WHERE cedula_per=?";
		String sqldocente="DELETE FROM tb_docente WHERE cedula_per=?";
		
		PreparedStatement pstmt= con.prepareStatement(sql);
		PreparedStatement pstmts= con.prepareStatement(sqldocente);
		
		pstmt.setString(1, cedula);
		pstmts.setString(1, cedula);
		pstmts.executeUpdate();
		pstmt.executeUpdate();
		
		
		con.close();

	}

	public Docente buscar(String cedula) throws Exception {
		Connection con=AdministradorConexionJDBC.getConexion();
		
		String sql= "SELECT  apellido_per, correo_per, direccion_per, nombre_per,"
				+ " telefono_per, postgrado_doc, profesion_doc, s.cedula_per "
				+ "FROM tb_docente s LEFT JOIN tb_persona  o ON s.cedula_per=o.cedula_per "
				+ " LEFT JOIN tb_profesion p on s.profesion_doc=p.codigo_prof"
				+ " WHERE s.cedula_per=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, cedula);
		ResultSet res=pstmt.executeQuery();
		
		if(res.next()){
			String apellido=res.getString(1);
			String correo=res.getString(2);
			String direccion=res.getString(3);
			String nombre=res.getString(4);
			String telefono=res.getString(5);
			String profes= res.getString(7);
			Profesion profesion=new Profesion ();
			profesion.setCodigo(profes);
			boolean postgrado=res.getBoolean(6);
			String cedulaa=res.getString(8);
			
			Docente docente= new Docente(nombre, apellido, cedulaa, correo, direccion, telefono, profesion, postgrado);
			con.close();
			return docente;
		}else{
			con.close();
			return null;
			
		}
		
	
	}

	public List<Docente> listarTodo() {
		// TODO Auto-generated method stub
		return null;
	}

}
