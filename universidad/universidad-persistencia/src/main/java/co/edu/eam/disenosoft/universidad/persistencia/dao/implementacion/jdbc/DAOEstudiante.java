package co.edu.eam.disenosoft.universidad.persistencia.dao.implementacion.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import co.edu.eam.disenosoft.universidad.modelo.Estudiante;
import co.edu.eam.disenosoft.universidad.persistencia.dao.definiciones.IDAOEstudiante;
import co.edu.eam.disenosoft.universidad.persistencia.utilidades.AdministradorConexionJDBC;

/**
 * Clase que da solucion al CRUD de un estudiante
 * @author Cristian Sinisterra
 *
 */
public class DAOEstudiante implements IDAOEstudiante {

	/**
	 *Crear estudiante, guarda un estudiante en l base de datos
	 * 
	 */
	public void crear(Estudiante estudiante) throws Exception {
		//conexion a la base de datos
		Connection con = AdministradorConexionJDBC.getConexion();
		
		//consulta para insertar datos en una tabla
		String sql = "INSERT INTO tb_persona (cedula_per, apellido_per, correo_per, direccion_per, nombre_per, telefono_per) "
				+ " VALUES(?,?,?,?,?,?)";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, estudiante.getCedula());
		pstmt.setString(2, estudiante.getApellido());
		pstmt.setString(3, estudiante.getCorreo());
		pstmt.setString(4, estudiante.getDireccion());
		pstmt.setString(5, estudiante.getNombre());
		pstmt.setString(6, estudiante.getTelefono());

		// ejecuta culsulta persona
		pstmt.executeUpdate();
		
		//consulta para insertar datos en una tabla
		String sqle = "INSERT INTO tb_estudiante(cedula_per, fechanacimiento_est)"
				+ " Values(?,?)";
		java.sql.Date dates= new java.sql.Date(estudiante.getFechaNacimiento().getTime());
		PreparedStatement pstmts = con.prepareStatement(sqle);
		
		pstmts.setString(1, estudiante.getCedula());
		pstmts.setDate(2, dates);
		
		// Ejecuta consulta Estudiante
		pstmts.executeUpdate();
		

		

		// 3. cerrar la conexion.
		con.close();
		
	}

	public void editar(Estudiante estudiante) throws Exception {
		// TODO Auto-generated method stub
		Connection con=AdministradorConexionJDBC.getConexion();
		//consulta para editar los campos de una tabla
		 String sql="UPDATE tb_persona SET  apellido_per=?, correo_per=?, direccion_per=?, nombre_per=?, telefono_per=? "
		 		+ " WHERE cedula_per=?";
		 
		 	PreparedStatement pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, estudiante.getApellido());
			pstmt.setString(2, estudiante.getCorreo());
			pstmt.setString(3, estudiante.getDireccion());
			pstmt.setString(4, estudiante.getNombre());
			pstmt.setString(5, estudiante.getTelefono());
			pstmt.setString(6, estudiante.getCedula());
			pstmt.executeUpdate();
			
			String sqlestudiante="UPDATE tb_estudiante SET fechanacimiento_est=? "
					+ " WHERE cedula_per=?";
			
			PreparedStatement pstmts = con.prepareStatement(sqlestudiante);
			java.sql.Date dates= new java.sql.Date(estudiante.getFechaNacimiento().getTime());
			pstmts.setDate(1, dates);
			pstmts.setString(2, estudiante.getCedula());
			// Ejecuta consulta Estudiante
			pstmts.executeUpdate();
			//cierra consulta
			con.close();
		
		
	}
	
	/**
	 * Eliminar un estudiante de la base de datos
	 * @param cedula, que identifica al estudiante que va ser eliminado
	 */
	public void eliminar(String cedula)throws Exception {
		Connection con=AdministradorConexionJDBC.getConexion();
		String sql="DELETE FROM tb_persona WHERE cedula_per=?";
		String sqlestudiante="DELETE FROM tb_estudiante WHERE cedula_per=?";
		
		PreparedStatement pstmt= con.prepareStatement(sql);
		PreparedStatement pstmts= con.prepareStatement(sqlestudiante);
		
		pstmt.setString(1, cedula);
		pstmts.setString(1, cedula);
		pstmts.executeUpdate();
		pstmt.executeUpdate();
		
		
		con.close();
		
	}
	/**
	 * Buscar  un estudiante de la base de datos
	 * @param cedula, que identifica al estudiante que va ser buscado
	 * return, retorna el estudiante que es buscado si no se encuentra retorna null
	 */
	public Estudiante buscar(String cedula) throws Exception {
		Connection con=AdministradorConexionJDBC.getConexion();
		String sql="SELECT apellido_per, correo_per, direccion_per, nombre_per, telefono_per, "
				+ "fechanacimiento_est  FROM tb_estudiante est JOIN tb_persona p ON est.cedula_per=p.cedula_per=? ";
		PreparedStatement pstmt= con.prepareStatement(sql);
		pstmt.setString(1, cedula);
		ResultSet res=pstmt.executeQuery();
		
		if(res.next()){
			String apellido=res.getString(1);
			String correo=res.getString(2);
			String direccion=res.getString(3);
			String nombre=res.getString(4);
			String telefono=res.getString(5);
			Date fechaNacimiento= res.getDate(6);
			
			Estudiante estu= new Estudiante(nombre, apellido, cedula, correo, direccion, telefono, fechaNacimiento);
			con.close();
			return estu;
		}else{
			con.close();
		return null;
		}
		}
		

	public List<Estudiante> listarTodo() {
		// TODO Auto-generated method stub
		return null;
	}

}
