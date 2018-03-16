package daos;

public class ConstantesSQL {
	
	final static String sqlInsercionEquipo = "insert into tabla_equipo (nombre, nombre_equipo, fecha, legendario) values (?,?,?,?)";
	final static String sqlSeleccionEquipo = "select * from tabla_equipo";
	public static String sqlBorradoEquipo = "delete from tabla_equipo where id=?";
}
