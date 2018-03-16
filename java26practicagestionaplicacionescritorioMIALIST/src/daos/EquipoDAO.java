package daos;

import modelo.Equipo;

//en entorno corporativo, lo mas normal es definir las operaciones q se van a poder hacer
//sobre db en un interfaz

//en este caso, para el interfaz actial, cada metodo dirá q se puede hacer en db, de cara a clientes
//

public interface EquipoDAO {
	
	void registrarEquipo( Equipo c);
	void borrarEquipo(int id);
	Equipo[] obtenerEquipo();
	// un array es un cjto de datos del mismo tipo
	
	
	

}
