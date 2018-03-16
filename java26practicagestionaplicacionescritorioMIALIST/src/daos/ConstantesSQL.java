package daos;

public class ConstantesSQL {
	
	final static String sqlInsercionCliente = "insert into tabla_equipo (nombre, nombre_equipo, fecha, legendario) values (?,?,?,?)";
	final static String sqlSeleccionCliente = "select * from tabla_equipo";

}
