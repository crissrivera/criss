package co.edu.eam.disenosoft.universidad.persistencia.utilidades;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 * 
 * @author Cristian Sinisterra
 *
 */
public class AdministradorConexionJDBC {

	public static Connection getConexion() throws SQLException{
		System.out.println("conectandose....");
		String url="jdbc:mysql://localhost:3306/universidadMapeada";
		String user="root";
		String pass="1234";
		
		
			Connection con=DriverManager.getConnection(url, user, pass);
			return con;
	}
	
}
