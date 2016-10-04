package co.edu.eam.disenosoft.universidad.persistencia.dao.implementacion.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;



import co.edu.eam.disenosoft.universidad.modelo.Profesion;
import co.edu.eam.disenosoft.universidad.persistencia.dao.definiciones.IDAOProfesion;
import co.edu.eam.disenosoft.universidad.persistencia.utilidades.AdministradorConexionJDBC;

public class DAOProfesion implements IDAOProfesion {

	public List<Profesion> listarDocente() throws Exception {
		Connection con= AdministradorConexionJDBC.getConexion();
		List <Profesion> lista= new ArrayList<Profesion>();
		String sql= "SELECT codigo_prof, nombre_prof From tb_profesion";
		PreparedStatement pstmt=con.prepareStatement(sql);
		
		ResultSet res=pstmt.executeQuery();
		
		while(res.next()){
			String codigo=res.getString(1);
			String nombre=res.getString(2);
			Profesion p= new Profesion(codigo, nombre);
			lista.add(p);
		}
		con.close();
		return lista;
		

	}

}
