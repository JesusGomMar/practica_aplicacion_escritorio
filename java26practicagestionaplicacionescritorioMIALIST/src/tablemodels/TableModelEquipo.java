package tablemodels;

import javax.swing.table.AbstractTableModel;

import modelo.Equipo;

public class TableModelEquipo extends AbstractTableModel{
	
	private String[] columnas = {"nombre", "nombrequipo", "fecha", "legendario"} ;
	
	private Object[][] datos = null;
	
	public TableModelEquipo(Equipo[] equipo) {
		// TODO Auto-generated constructor stub
		
		// datos va a ser tantos arrays de strings como clientes a listar
		//cada uno de esos arrays debera tener tantos elementos como queramos mostrar por cada columna
		datos = new String[equipo.length][columnas.length];
		
		for (int i = 0; i < equipo.length; i++) {
			Equipo c = equipo[i];
			datos[i][0] = c.getNombre();
			datos[i][1] = c.getNombrequipo();
			datos[i][2] = c.getFecha();
			datos[i][3] = "yes"+c.isLegendario();
		}
		
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return columnas.length;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return datos.length;
	}

	@Override
	public Object getValueAt(int indiceFila, int indiceColumna) {
		// TODO Auto-generated method stub
		return datos[indiceFila][indiceColumna];
	}

}
