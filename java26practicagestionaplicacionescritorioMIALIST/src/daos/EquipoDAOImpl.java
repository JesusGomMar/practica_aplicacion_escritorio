package daos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.Equipo;

public class EquipoDAOImpl implements EquipoDAO{

	
	private Connection miConexion = null;
	
	public EquipoDAOImpl() {
		// TODO Auto-generated constructor stub
		//preparo driver y conexion
		try {
			Class.forName("com.mysql.jdbc.Driver");
			miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/practica_escritorio", "root", "jeveris");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("No se encuentra la libreria de mysql");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("error de conexion o la sql esta mal");
		}
		
		
		
	}// en clientesdaoimpl
	
	@Override
	public void registrarEquipo(Equipo c) {
		// TODO Auto-generated method stub
		
		
		PreparedStatement ps;
		try {
			ps = miConexion.prepareStatement(ConstantesSQL.sqlInsercionEquipo);
			ps.setString(1, c.getNombre());
			ps.setString(2, c.getNombrequipo());
			ps.setString(3, c.getFecha());
			ps.setBoolean(4, c.isLegendario());
//			ps.setString(4, c.getCp());
//			ps.setString(5, c.getTelefono());
			
			ps.execute();
			ps.close();
			System.out.println("cliente insertado correctamente");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("fallo en la sql");
		}
		

		
	}//fin registrarcliente

	@Override
	public void borrarEquipo(int id) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement ps = miConexion.prepareStatement(ConstantesSQL.sqlBorradoEquipo);
			System.out.println(id);
			ps.setInt(1, id);
			ps.execute();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("el sql de borrado esta mal");
			System.out.println(e.getMessage());
		}
		
	}

	@Override
	public Equipo[] obtenerEquipo() {
		// TODO Auto-generated method stub
		
		Equipo[] equipo = null;
		try {
			PreparedStatement ps = miConexion.prepareStatement(ConstantesSQL.sqlSeleccionEquipo);
			
			// para sql tipo select debo usar el metodo executequery
			ResultSet resultado = ps.executeQuery();
			
			List<Equipo> listEquipo = new ArrayList<Equipo>();
			// next pasa al siguiente resultado de la db q aun no hemos procesado, si no hay 
			// resultado, devuelve false
			while (resultado.next()) {
				
				Equipo c = new Equipo();
				c.setNombre(resultado.getString("nombre"));
				c.setNombrequipo(resultado.getString("nombre_equipo"));
				c.setFecha(resultado.getString("fecha"));
				c.setLegendario(resultado.getBoolean("legendario"));
				c.setId(resultado.getInt("id"));
//				c.setTelefono(resultado.getString("telefono"));
				listEquipo.add(c);
				
				
			}// end while
			
			//transformar de list a array
			equipo = listEquipo.toArray(new Equipo[listEquipo.size()]);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("fallo en la sql de seleccion clientes");
		}
		return equipo;
	}
	

}
